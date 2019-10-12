<template>
  <!-- 这里曾将犯错 模版中只能有一个总的el-row，然后在子标签下面写多个el-row标签 -->
  <el-row>
    <!--  第一个el-row: 页面头部显示  -->      <!-- 这里的类选择器在assets下面 -->
    <el-row class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><!-- 传入数据方式 -->
          <i class="el-icon-lx-calendar"></i> {{ $t('common.route.R2') }}
        </el-breadcrumb-item>
        <el-breadcrumb-item> {{ $t('common.route.R21') }}</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <!--  第二个el-row：输入项查询:   -->
    <el-row class="query-form">
      <!--  写一个el-表单  这里两个属性代表什么意思 还有引入方式，这里引入一个queryForm,把这个引入内容传入到你想要的方法里面，实现绑定 -->
      <!--   参数组号和参数号需要前台校验，只能为数字；参数名需要后台校验，不可包含非法字符   -->
      <el-form :inline="true" :model="queryParams" ref="queryForm" >
        <!-- 这里如果定义校验数字 一定要写v-model.number -->
          <el-form-item :label="$t('param.label.groupId')" prop="groupId" class='queryCondition'>
            <el-input :placeholder="$t('param.label.groupId')" v-model="queryParams.groupId"></el-input>
          </el-form-item>
          <el-form-item :label="$t('param.label.paramId')" prop="paramId" class='queryCondition'>
            <el-input :placeholder="$t('param.label.paramId')" v-model="queryParams.paramId"></el-input>
          </el-form-item>
  <!-- 需要后端校验 这该如何实现呢？待解决 -->
          <el-form-item :label="$t('param.label.paramName')" prop="paramName" class='queryCondition'>
            <el-input :placeholder="$t('param.label.paramName')" v-model="queryParams.paramName"></el-input>
          </el-form-item>
      
      </el-form>
    </el-row>
    <!--  第三个el-row：功能按钮查询  -->
    <el-row class="table-operations">
      <el-button type="primary" icon="el-icon-lx-search" @click="submitQuery()">{{ this.$t('common.button.query')}}</el-button>
      <el-button type="primary" icon="el-icon-lx-roundadd" @click="add()">{{ this.$t('common.button.add') }}</el-button>
      <el-button type="primary" icon="el-icon-lx-edit" @click="edit()">{{ this.$t('common.button.edit') }}</el-button>
      <el-button type="primary" icon="el-icon-lx-delete" @click="delParamsConfirm()">{{this.$t('common.button.delete')}}</el-button>
      <el-button type="primary" icon="el-icon-lx-refresh" @click="reset('queryForm')">{{this.$t('common.button.reset')}}</el-button>
    </el-row>
    <!--  第四个el-row：数据表：not ok  -->
    <el-row class="table-result">
      <el-table
        v-loading="loading"
        ref="singleTable"
        border
        highlight-current-row
        :data="tableData"
        @current-change="handleCurrentChange"
        @row-dblclick="handleDblclick"
        style="width: 100%"
      >
        <el-table-column type="index" :label="$t('common.label.index')" width="60"></el-table-column>
        <el-table-column property="groupId" :label="$t('param.table.groupId')" width="200"></el-table-column>
        <el-table-column property="paramId" :label="$t('param.table.paramId')" width="200"></el-table-column>
        <el-table-column property="paramName" :label="$t('param.table.paramName')" width="200"></el-table-column>
        <el-table-column property="paramVal" :label="$t('param.table.paramVal')" width="200" :show-overflow-tooltip="true"></el-table-column>
        <el-table-column property="remark" :label="$t('param.table.remark')" width="200" :show-overflow-tooltip="true"></el-table-column>
      </el-table>
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryParams.page"
        :page-sizes="pageSizes"
        :page-size="queryParams.length"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </el-row>
    <!--  编辑弹出框  -->
    <!--  参数组号和参数号需要前台校验 只能为数字；参数名、参数值、备注需要后台校验 不可包含非法字符  -->
    <el-row>
      <el-dialog :title="title" :visible.sync="editVisible" width="30%" :close-on-click-modal="false">
        <el-form ref="editForm" :rules="rules" :model="editParams" label-width="100px" :disabled="formDisabled">
          <el-form-item :label="$t('param.label.groupId')" prop="groupId">
            <el-input v-model="editParams.groupId" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('param.label.paramId')" prop="paramId">
            <el-input v-model="editParams.paramId" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="$t('param.label.paramName')" prop="paramName">
            <el-input v-model="editParams.paramName"></el-input>
          </el-form-item>
          <el-form-item :label="$t('param.label.paramVal')" prop="paramVal">
            <el-input v-model="editParams.paramVal"></el-input>
          </el-form-item>
          <el-form-item :label="$t('param.label.remark')" prop="remark">
            <el-input v-model="editParams.remark"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="editVisible = false">{{ $t('common.button.cancel') }}</el-button>
          <el-button type="primary" @click="save('editForm')">{{ $t('param.common.confirm') }}</el-button>
        </span>
      </el-dialog>
    </el-row>
  </el-row>
</template>
<!--
  1、前台输入校验 包含哪些是不能被更改的  这里已经搞定了数据不能更改的问题 disabled是一个全局变量 会在每一个方法中给出相应的改变
  2、重置功能 重置表单中的数据 （这里犯了一个错误，方法没有写在methods中 真的纸张）
  3、中英文切换 --待做
-->
<script>
  import {paramsModel} from '../../model/params/paramsModel'
  import {pageSizes, pageSize} from '../../common/global'
  import {queryParams, saveParams, deleteParams} from '../../../api/getData'
  import {copyObject} from '../../common/util'

  export default {
    name: 'ParamsMaintain',
    //data：接收从后端返回的数据 相当于一个容器
    data () {
      //正则校验数字  [A-Za-z0-9]{0,4}$
      var checkGroupId = (rule, value, callback) => {
          // var reg = /^[A-Za-z0-9]{0,4}$/;//这个写法是可以 可以同时校验字符和长度 但是这里更合适把二者分开
          var reg = /^[A-Za-z0-9]+$/;
          if(!reg.test(value)){
            callback(new Error(this.$t('param.message.alertAboutNumAndChar')));
          }else if (value.length > 4) {
            callback(new Error(this.$t('param.message.alertAboutGroupIdLength')));
          } else {
            callback();
          }
      };
      var checkParamId = (rule, value, callback) => {
        var reg = /^[A-Za-z0-9]+$/;
        if(!reg.test(value)){
          callback(new Error(this.$t('param.message.alertAboutNumAndChar')));
        }else if (value.length > 10) {
          callback(new Error(this.$t('param.message.alertAboutParamIdLength')));
        } else {
          callback();
        }
      };
      var checkName = (rule, value, callback) => {
        // var pattern = /[`~!#$%^&()_+<>?"{},\/'[\]]/im;
        var pattern = /[+$&]/im;
        if(pattern.test(value)){
          callback(new Error(this.$t('param.message.alertAboutParamName')));
        } else {
          callback();
        }
      };
      var checkVal = (rule, value, callback) => {
        // var pattern = /[`~!#$%^&()_+<>?"{},\/'[\]]/im;
        var pattern = /[+$&]/im;
        if(pattern.test(value)){
          callback(new Error(this.$t('param.message.alertAboutParamVal')));
        } else {
          callback();
        }
      };
      var checkRemark = (rule, value, callback) => {
        // var pattern = /[`~!#$%^&()_+<>?"{},\/'[\]]/im;
        var pattern = /[+$&]/im;
        if(pattern.test(value)){
          callback(new Error(this.$t('param.message.alertAboutRemark')));
        } else {
          callback();
        }
      };
      return {
        queryParams: new paramsModel(),//定义一个模型对象 自己用自己的东西
        editParams: new paramsModel(),
        deleteParams: new paramsModel(),
        pageSizes: pageSizes,
        total: 0,
        tableData: [],
        editVisible: false,
        title: this.$t('param.title.addTitle'),
        formDisabled: false,//为true时 整个表单不可编辑
        disabled: false,// 为 true时 编辑时某些字段不可编辑
        loading: false,
        resetInputForm: {
          groupId: '',
          paramId: '',
          paramName: ''
        },

        rules: {
          groupId: [
            {required: true, message: this.$t('param.message.inputGroupId'), trigger: 'blur'},
            { validator: checkGroupId , trigger: 'blur'}

          ],
          paramId: [
            {required: true, message: this.$t('param.message.inputParamId'), trigger: 'blur'},
            { validator: checkParamId , trigger: 'blur'}
          ],
          paramVal: [
            {required: true, message: this.$t('param.message.inputParamVal'), trigger: 'blur'},
            { validator: checkVal , trigger: 'blur'}
          ],
          paramName: [
            {required: true, message: this.$t('param.message.inputParamName'), trigger: 'blur'},
            { validator: checkName , trigger: 'blur'}
          ],
          remark:[
            // { validator: checkRemark , trigger: 'blur'}
          ]
        },
        //我这里重新定义一个专门为查询表单验证的校验规则
        queryFormRules:{
          groupId: [
            { validator: checkGroupId , trigger: 'blur'}
          ],
          paramId:[
            { validator: checkParamId , trigger: 'blur'}
          ]
        }
      }
    },
    //这里是script部分中一个固定的方法部件 我们把方法定义在这里
    methods: {
      handleCurrentChange (val) {
        this.currentRow = val
      },
      handleSizeChange (val) {
        this.queryParams.length = val
        this.search()
      },
      handlePageChange (val) {
        this.queryParams.page = val
        this.search()
      },
      handleDblclick (val) {
        this.edit()
      },
      //点就查询，把页码置为1
      submitQuery() {
        this.queryParams.page = 1;
        this.search();
      },
      search () {
        this.loading = true;
        queryParams(this.queryParams).then(res => {
          //判断返回的查询结果的boolean值
          if (res.success) {
            //通过res.total（查询结果数据个数）、res.data.length(当前页面)有没有数据判断是否需要把当前页面减1
            //这里data是指当前页面的数据
            if (res.total > 0 && res.data.length == 0){
              this.queryParams.page--;
              this.search()
            }else{
              this.total = res.total
              this.tableData = res.data
            }
          } else {
            this.$message({
              type: 'error',
              message: this.$t('common.code.' + res.code)
            })
          }
          this.loading = false;
        })
      },
      add () {
        this.editParams = new paramsModel()//每次打开页面的时候 新建一个对象，这样就不会存在页面缓存
        this.editParams.flag = 'add'//用于后台判断是查询还是编辑
        this.title = this.$t('param.title.addTitle')
        this.editVisible = true
        this.disabled = false
        if (this.$refs['editForm'] != undefined) {
          this.$refs['editForm'].clearValidate()
        }
      },
      edit () {
        //判断下用户是否有选中一行数据
        if (this.currentRow == null || this.currentRow == undefined) {
          this.$message({
            type: 'warning',
            message: this.$t('param.message.editMessage')
          })
          return
        }
        this.disabled = true//被disabled标记的输入项 为不可编辑状态，设定为不可编辑状态之后 出现数字校验错误
        this.editParams = copyObject(this.currentRow, this.editParams)
        this.editParams.flag = 'mod'
        this.title = this.$t('param.title.editTitle')
        this.editVisible = true
        if (this.$refs['editForm'] != undefined) {
          this.$refs['editForm'].clearValidate()
        }
      },
      save (formName) {
        this.$refs[formName].validate(valid => {
          if (valid) {
            saveParams(this.editParams).then(res => {
              if (res.success || res.success == 'true') {
                this.editVisible = false
                this.$message({
                  type: 'success',
                  message: this.$t('common.code.' + res.code)
                })
                this.search()
              } else {
                this.$message({
                  type: 'error',
                  message: this.$t('common.code.' + res.code)
                })
              }
            })
          } else {
            console.log(this.$t('param.message.validationFail'))
          }
        })
      },
      // 判断确认删除方法
      delParamsConfirm () {
        //判断是否已选择信息
        if (this.currentRow == null || this.currentRow == undefined) {
          this.$message({
            type: 'warning',
            message: this.$t('param.message.selectDeleteMessage')
          })
          return
        }
        //去数据库查一下 是否有当前选择的信息

        this.$confirm(this.$t('param.message.deleteAsk'), this.$t('param.message.deleteWarn'), {
          confirmButtonText: this.$t('param.common.confirm'),
          cancelButtonText: this.$t('param.common.cancel'),
          type: 'warning'
        }).then(() => {
          this.deleteParams = copyObject(this.currentRow, this.editParams)
          deleteParams(this.deleteParams).then(res => {
            if (res.success || res.success == 'true') {
              this.$message({
                type: 'success',
                message: this.$t('common.code.' + res.code)
              })
              this.search()//你这个方法如果不紧接着写在括号之后 是不会直接执行的，所以这里的执行规则还是需要再学习
            } else {
              this.$message({
                type: 'error',
                message: this.$t('common.code.' + res.code)
              })
            }
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: this.$t('param.message.deleteConfirmMessage')
          })
        })
      },
      reset (formName) {
        this.$refs[formName].resetFields()
      }
    },

    mounted () {
      //页面加载立即渲染
      this.search()
    }

  }
</script>

