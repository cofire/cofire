<template>
  <el-row>
    <el-row class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-calendar">{{$t('dictMaintain.item.System Management')}}</i>
        </el-breadcrumb-item>
        <el-breadcrumb-item>{{$t('dictMaintain.item.Data Dictionary Maintenance')}}</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-row class="query-form">
      <el-form :inline="true" :model="queryDict" ref="queryForm">
      
          <el-form-item :label="$t('dictMaintain.label.groupId')" prop="groupId" class='queryCondition'>
            <el-input v-model="queryDict.groupId"  :placeholder="$t('dictMaintain.label.groupId')"  ></el-input>
          </el-form-item>
 
          <el-form-item :label="$t('dictMaintain.label.dictValue')" prop="dictValue" class='queryCondition'>
            <el-input v-model="queryDict.dictValue" :placeholder="$t('dictMaintain.label.dictValue')" ></el-input>
          </el-form-item>

          <el-form-item :label="$t('dictMaintain.table.dictName')" prop="dictName" class='queryCondition'>
            <el-input v-model="queryDict.dictName" :placeholder="$t('dictMaintain.table.dictName')" ></el-input>
          </el-form-item>

      </el-form>
    </el-row>
    <el-row class="table-operations">
      <el-button type="primary" icon="el-icon-lx-search" @click="submitSearch()">{{this.$t('common.button.query')}}</el-button>
      <el-button type="primary" icon="el-icon-lx-roundadd" @click="add()">{{this.$t('common.button.add')}}</el-button>
      <el-button type="primary" icon="el-icon-lx-edit" @click="edit()">{{this.$t('common.button.edit')}}</el-button>
      <el-button type="primary" icon="el-icon-lx-delete" @click="deleteDict()">{{this.$t('common.button.delete')}}</el-button>
      <el-button type="primary" icon="el-icon-lx-refresh" @click="reset('queryForm')">{{this.$t('common.button.reset')}}</el-button>
    </el-row>
    <el-row class="table-result">
      <el-table
        v-loading="loading"
        ref="singleTable"
        border
        highlight-current-row
        :data="tableData"
        @current-change="handleCurrentChange"
        @row-dblclick= "handleDblclick"
        style="width: 100%"
      >
        <el-table-column type="index" :label="this.$t('dictMaintain.table.index')" width="50"></el-table-column>
        <el-table-column property="groupId" :label="this.$t('dictMaintain.table.groupId')" width="200"></el-table-column>
        <el-table-column property="groupName" :label="this.$t('dictMaintain.table.groupName')" width="200"></el-table-column>
        <el-table-column property="dictValue" :label="this.$t('dictMaintain.table.dictValue')" width="200"></el-table-column>
        <el-table-column property="dictName" :label="this.$t('dictMaintain.table.dictName')" width="200"></el-table-column>
        <el-table-column property="modifyUser" :label="this.$t('dictMaintain.table.modifyUser')" width="200"></el-table-column>
        <el-table-column property="modifyTime" :label="this.$t('dictMaintain.table.modifyTime')" width="200" :formatter="formatmodifyTime"></el-table-column>

      </el-table>
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryDict.page"
        :page-sizes="pageSizes"
        :page-size="queryDict.length"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </el-row>
    <!-- 编辑弹出框 -->
    <el-row>
      <el-dialog :title="title" :visible.sync="editVisible" width="30%" :close-on-click-modal="false">
        <el-form ref="editForm" :rules="rules" :model="saveDict" label-width="100px" :disabled="formDisabled">
          <el-form-item :label="this.$t('dictMaintain.table.groupId')" prop="groupId">
            <el-input v-model="saveDict.groupId" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('dictMaintain.table.groupName')" prop="groupName">
            <el-input v-model="saveDict.groupName" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('dictMaintain.table.dictValue')" prop="dictValue">
            <el-input v-model="saveDict.dictValue" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('dictMaintain.table.dictName')" prop="dictName">
            <el-input v-model="saveDict.dictName"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="editVisible = false">{{this.$t('common.button.cancel')}}</el-button>
          <el-button type="primary" @click="save('editForm')">{{this.$t('dictMaintain.common.confirm')}}</el-button>
        </span>
      </el-dialog>
    </el-row>
  </el-row>
</template>
<script>
import { dictModel } from "../../model/dict/dictModel";
import { pageSizes, pageSize } from "../../common/global";
import { queryDict, saveDict, deleteDict } from "@/api/getData";
import { copyObject, formatDate } from "../../common/util";
export default {
  name: "dictMaintain",
  data() {
    //校验groupId，字母或数字组合，最多4位
    var checkgroupId = (rule, value, callback) => {
      var text = /^[A-Z|a-z|0-9]{1,4}$/; //groupId字母和数字组合，最多4位，
      if (value != "" && text.test(value)) {
        callback();
      } else {
        callback(new Error(this.$t('dictMaintain.rule.groupId2')));
      }
    };
   
    //校验checkdictValue，字母或数字组合，最多30位
    var checkdictValue = (rule, value, callback) => {
      var text = /^[A-Z|a-z|0-9]{1,30}$/; //字母或数字组合，最多30位
      if (value != "" && text.test(value)) {
        callback();
      } else {
        callback(new Error(this.$t('dictMaintain.rule.dictValue2')));
      }
    };
    
    
    return {
      queryDict: new dictModel(),
      saveDict: new dictModel(),
      deleteDictModel: new dictModel(),
      pageSizes: pageSizes,
      total: 0,
      tableData: [],
      editVisible: false,
      title: '',
      formDisabled: false,  /** 为true时，整个表单不可编辑 */
      disabled: false, /** 为true时，编辑时某些字段不可编辑 */
      loading: false,
      rules: {/* 表单里的rules，前端校验 blur使得标签前面有红色的*  */
        groupId: [
          { required: true, message:this.$t('dictMaintain.rule.groupId'),trigger: "blur",},
          {validator: checkgroupId, trigger: "blur"}
        ],
        groupName: [
          { required: true, message:this.$t('dictMaintain.rule.groupName'), trigger: "blur" },
          {min:1,max:100,message:this.$t('dictMaintain.rule.groupName2'),trigger: "blur",},
          ],
        dictValue: [
          { required: true, message:this.$t('dictMaintain.rule.dictValue'), trigger: "blur" },
          {validator: checkdictValue, trigger: "blur"}
          ],
        dictName: [
          { required: true, message:this.$t('dictMaintain.rule.dictName'), trigger: "blur" },
          {min:1,max:100,message:this.$t('dictMaintain.rule.dictName2'),trigger: "blur",},
        ],
      },

    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentRow = val;
    },
    handleSizeChange(val) {//更改页面的记录大小，10,20,30,40
      this.queryDict.length = val;
      this.search();
    },
    handlePageChange(val) {//点击分页数查询
      this.queryDict.page = val;
      this.search();
    },
    handleDblclick(val) {//行双击进行编辑
      this.edit();
    },
    submitSearch(){
      this.queryDict.page = 1;//查询时要将页面的page置为1
      this.search();
    },
    search() {//查询
      this.loading = true;
      queryDict(this.queryDict).then(res => {
        if (res.success || res.success == "true") {
          
          if (res.total > 0 && res.data.length == 0){//如果返回结果中的页面数大于0,且点击分页 查询返回的结果为0，说明此页无数据，page数-1
              this.queryDict.page--;
              this.search()
            }else{
              this.total = res.total
              this.tableData = res.data
            }
        } else {
          this.$message({
            type: "error",
            message: this.$t('common.code.'+res.code),
          });
        }
        this.loading = false;
      });
    },
    reset(formName){
      this.$refs[formName].resetFields();
      this.search();
    },
    add() {//新增数据字典
      this.saveDict =  new dictModel();
      this.saveDict.flag = "add";
      this.title = this.$t('dictMaintain.title.addtitle');
      this.editVisible = true;
      this.disabled = false;
      if(this.$refs['editForm'] != undefined){
        this.$refs['editForm'].clearValidate();
      }
    },
    edit() {//编辑数据字典
      if(this.currentRow == undefined || this.currentRow == null) {
        this.$message({
          type: "warning",
          message:this.$t('dictMaintain.message.editmes'),
        });
        return;
      }
      this.disabled = true;
      this.saveDict = copyObject(this.currentRow, this.saveDict);
      this.saveDict.flag = "mod";
      this.title = this.$t('dictMaintain.title.edittitle');
      this.editVisible = true;
      if(this.$refs['editForm'] != undefined){
        this.$refs['editForm'].clearValidate();
      }
    },

  
  deleteDict() {//删除数据字典
    if (this.currentRow == undefined || this.currentRow == null) {
      this.$message({
        type: "warning",
        message: this.$t('dictMaintain.message.deletemes')
      });
      return;
    }
    this.$confirm(this.$t('dictMaintain.message.deleteask'), this.$t('dictMaintain.message.deletetip'), {
      confirmButtonText:this.$t('dictMaintain.common.confirm') ,
      cancelButtonText: this.$t('dictMaintain.common.cancel'),
      type: 'warning'
      }).then(() => {
    this.deleteDictModel = copyObject(this.currentRow, this.deleteDictModel);
    deleteDict(this.deleteDictModel).then(res => {
          if (res.success || res.success == "true") {
            this.$message({
              type: "success",
              message: this.$t('common.code.'+res.code)
            });
            this.search();
          } else {
            this.$message({
              type: "error",
              message: this.$t('common.code.'+res.code)
            });
          }
        });
      }).catch(() => {
          this.$message({
            type: 'info',
            message:this.$t('dictMaintain.message.deleteConfirmmes'),
          });
        });
  },

    save(formName) {//对新增和编辑的数据字典进行保存
      this.$refs[formName].validate(valid => {
        if (valid) {
          saveDict(this.saveDict).then(res => {
            if (res.success || res.success == "true") {
              this.editVisible = false;
              this.$message({
                type: "success",
                message: this.$t('common.code.'+res.code),
              });
              this.search();
            } else {
              this.$message({
                type: "error",
                message: this.$t('common.code.'+res.code)
              });
            }
          });
        }else{
          
        }
      });
    },

    formatmodifyTime(row,column){
      return formatDate(row.modifyTime);
    },
  },
  mounted() {//渲染
    this.search();
  }
};
</script>
