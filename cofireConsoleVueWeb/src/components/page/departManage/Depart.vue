<template>
  <el-row
    v-loading="uploading"
    element-loading-text="loading"
  >
    <el-row class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-calendar"></i> {{this.$t('depart.depart')}}
        </el-breadcrumb-item>
        <el-breadcrumb-item>{{this.$t('depart.departInfo')}}</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-row class="table-operations">
      <el-col :span="14">
        <el-button type="primary" icon="el-icon-lx-roundadd" @click="addDepart()">{{this.$t('common.button.add')}}</el-button>
        <el-button type="primary" icon="el-icon-lx-edit" @click="editDepart()">{{this.$t('common.button.edit')}}</el-button>
        <el-button type="primary" icon="el-icon-lx-delete" @click="deleteDepart()">{{this.$t('common.button.delete')}}</el-button>
        <el-button type="primary" icon="el-icon-download" @click="exportDepart()">{{this.$t('depart.mes.exportDepart')}}</el-button>
        <el-button type="primary" icon="el-icon-upload2" @click="importDepar()">{{this.$t('depart.mes.importDepart')}}</el-button>
        <el-button type="primary" icon="el-icon-download" @click="exportUser()">{{this.$t('depart.mes.exportUser')}}</el-button>
        <el-button type="primary" icon="el-icon-upload2" @click="importUser()">{{this.$t('depart.mes.importUser')}}</el-button>
        <el-button type="primary" icon="el-icon-lx-refresh" @click="refresh()">{{this.$t('common.button.reset')}}</el-button>
      </el-col>
      <el-col :span="10">
        <el-button type="primary" icon="el-icon-lx-roundadd" @click="addCheckerPer()">{{this.$t('common.button.add')+this.$t('depart.checker')}}
        </el-button>
        <el-button type="primary" icon="el-icon-lx-delete" @click="delChecker()">{{this.$t('common.button.delete')+this.$t('depart.checker')}}
        </el-button>
      </el-col>
    </el-row>
    <el-row>
      <!-- <p>树形展开</p> -->
      <el-col :span="14">
        <el-tree v-loading="loading" :data="dataTree" @node-click="handleNodeClick" :props="defaultProps" ref="dataTree" node-key="id"
                 style="min-height: 450px;"
                 highlight-current></el-tree>
      </el-col>
      <!-- <p>部门审核人表格</p> -->
      <el-col :span="10">
        <el-table v-loading="checkerLoading" ref="queryDepartChecker" border :data="queryDepartChecker" @selection-change="handleSelectionChange">
          <el-table-column type="selection" width="40"></el-table-column>
          <el-table-column type="index" :label="$t('common.label.index')" width="80"></el-table-column>
          <el-table-column property="userId" :label="this.$t('depart.table.userId')"></el-table-column>
          <el-table-column property="userName" :label="this.$t('depart.table.userName')"></el-table-column>
          <el-table-column property="phone" :label="this.$t('depart.table.phone')"></el-table-column>
        </el-table>
      </el-col>
    </el-row>
    <!-- <p>导入部门Excel文件</p> -->
    <el-row>
      <el-dialog :visible.sync="importVisible" width="30%" :title="title" :close-on-click-modal="false">
        <el-form ref="uploadForm" :model="importFile" :rules="fileRules" label-width="100px">
          <el-row>
          <el-col :span="20">
            <el-form-item :label="this.$t('depart.label.fileName')" prop="fileName">
              <el-input v-model="importFile.fileName" readonly></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="2">
          <el-upload ref="upload" :drag="false" accept=".xlsx,.xls" :action="UploadUrl()" :show-file-list="false"
                     :multiple='false' :with-credentials='true' :before-upload="beforeUpload" :auto-upload="false"
                     :on-change="handleChange" :on-success="handleSuc" :file-list="fileList">
            <el-button type="primary" >{{this.$t('common.button.selectFile')}}</el-button>
          </el-upload>
</el-col>
</el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
					<el-button @click="importVisible = false">{{this.$t('common.button.cancel')}}</el-button>
					 <el-button type="primary" @click="uploadFile('uploadForm')">{{this.$t('depart.upload')}}</el-button>
				</span>
      </el-dialog>
    </el-row>
    <!-- <p>修改弹出框  只能修改部门名称</p> -->
    <el-row>
      <el-dialog :visible.sync="editVisible" width="30%" :title="title" :close-on-click-modal="false">
        <el-form ref="editForm" :model="saveDepartEntity" :rules="rules" label-width="100px">
          <el-form-item :label="this.$t('depart.label.branchNo')" prop="branchNo">
            <el-input v-model="saveDepartEntity.branchNo" :disabled="isAdd"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('depart.label.branchName')" prop="branchName">
            <el-input v-model="saveDepartEntity.branchName"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
					<el-button @click="editVisible = false">{{this.$t('common.button.cancel')}}</el-button>
					<el-button type="primary" @click="save('editForm')">{{this.$t('common.button.save')}}</el-button>
				</span>
      </el-dialog>
    </el-row>
    <!-- <p>添加审核人弹窗</p> -->
    <el-row>
      <el-dialog :visible.sync="addVisible" width="50%" :title="title" :close-on-click-modal="false" :before-close="handleClose">
        <el-row>
          <el-form :inline="true" :model="departChecker" ref="departForm">
            <el-row>
              <el-col :span="12">
                <el-form-item :label="this.$t('depart.label.userId')" prop='userId'>
                  <el-input v-model.trim="departChecker.userId"
                            :placeholder="this.$t('depart.placeholder.userId')"></el-input>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item :label="this.$t('depart.label.userName')" prop='userName'>
                  <el-input v-model.trim="departChecker.userName"
                            :placeholder="this.$t('depart.placeholder.userName')"></el-input>
                </el-form-item>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="12">
                <el-form-item :label="this.$t('depart.label.checker')" prop='checker'>
                  <el-select v-model.trim="departChecker.checker" clearable>
                    <el-option v-for="item in this.checkerOptions" :key="item.DICT_VALUE"
                               :label="item.DICT_NAME" :value="item.DICT_VALUE"></el-option>
                  </el-select>
                </el-form-item>
              </el-col>
            </el-row>
          </el-form>
        </el-row>
        <el-row class="table-operations">
          <el-button type="primary" @click="queryUserPer()">
            {{this.$t('common.button.query')}}
          </el-button>
          <el-button type="primary" @click="resetForm('departForm')">{{this.$t('common.button.reset')}}</el-button>
					<el-button type="primary" @click="addChecker()">{{this.$t('common.button.save')}}</el-button>
        </el-row>
        <el-row>
          <el-table ref="addDepartChecker" border :data="addDepartChecker" @selection-change="handleSelectionChangeAdd">
            <el-table-column type="selection" width="40"></el-table-column>
            <el-table-column type="index" :label="$t('common.label.index')" width="80"></el-table-column>
            <el-table-column property="userId" :label="this.$t('depart.table.userId')"></el-table-column>
            <el-table-column property="userName" :label="this.$t('depart.table.userName')"></el-table-column>
            <el-table-column property="phone" :label="this.$t('depart.table.phone')"></el-table-column>
            <el-table-column property="checker" :label="this.$t('depart.table.checker')"
                             :formatter="formatChecker"></el-table-column>
          </el-table>
        </el-row>
        <el-row>
          <el-pagination background @size-change="handleSizeChange" @current-change="handlePageChange"
                         :current-page="departChecker.page"
                         :page-sizes="pageSizes" :page-size="departChecker.length"
                         layout="total, sizes, prev, pager, next, jumper" :total="total">
          </el-pagination>
        </el-row>
      </el-dialog>
    </el-row>
  </el-row>
</template>

<script>
  import {
    DepartModel
  } from '../../model/depart/DepartModel'
  import {
    DepartCheckerModel
  } from '../../model/depart/DepartCheckerModel'
  import {
    fileModel
  } from '../../model/common/fileModel'
  import {
    pageSizes,
    pageSize
  } from '../../common/global'
  import {
    getDictByGroup,
    getTree,
    saveDepart,
    deleteDepart,
    queryUserByBranchNo,
    queryCheckersByBranchNo,
    addCheckers,
    delCheckers,
    getDepartExcel,
    getUserExcel
  } from '@/api/getData'
  import {
    copyObject,
    getDictName,
getCurrentTime
  } from '../../common/util'
  import {
    exportDepartUrl,
    exportUserUrl,
    importDepartUrl,
    importUserUrl
  } from '../../../config/env'

  export default {
    inject: ["reload"],
    name: 'Depart', // 页面头部tag数据
    data () {
      return {
        depart: new DepartModel(),
        // 选中的部门
        selectDepart: new DepartModel(),
        saveDepartEntity: new DepartModel(),
        dataTree: [],
        title: '', // 弹出框的title
        editVisible: false, // 是否显示弹出框
        isAdd: true, // 编辑弹出框，部门编号是否可编辑
        loading: false,
        checkerLoading: false,
        uploading:false,
        rules: {
          branchName: [{
            required: true,
            message: this.$t('depart.rules.branchNameRequired'),
            trigger: 'blur'
          },
            {
              min: 2,
              max: 218,
              message: this.$t('depart.rules.branchNameLength'),
              trigger: 'blur'
            }
          ],
          branchNo: [{
            required: true,
            message: this.$t('depart.rules.branchNoRequired'),
            trigger: 'blur'
          },
            {
              pattern: /^[A-Za-z0-9]{1,32}$/,
              message: this.$t('depart.rules.branchNoLength'),
              trigger: 'blur'
            }
          ]
        },
        fileRules: {
          fileName: [{
            required: true,
            message: this.$t('depart.rules.pleSelFile'),
            trigger: 'blur'
          }
          ]
        },
        defaultProps: {
          children: 'children',
          label: 'label',
          id: 'id'
        },
        checkerOptions: [], // 新增审核人弹窗，下拉列表
        departChecker: new DepartCheckerModel(), // 新增审核人时，弹出框表格分页
        pageSizes: pageSizes,
        total: 0,
        queryDepartChecker: [], // 右侧表格
        currentRows: [], // 右侧表格选中的数据
        currentRowsAdd: [], // 弹窗中选中的数据
        addVisible: false, // 添加审核人弹窗
        addDepartChecker: [], // 弹窗表格
        importFile: new fileModel(), // 上传文件的实体类
        importVisible: false, // 导入部门弹出框
        fileList: [],// 文件上传集合
        notAllCheck: false,
      }
    },
    created () {
      this.getTree()
      this.checkerDict()
    },
    methods: {
      refresh(){
        this.reload();
      },
      // 获取员工类型数据字典
      checkerDict () {
        getDictByGroup({'groupCode': '0029'}).then(res => {
          if (res.success) {
            this.checkerOptions = res.data
          } else {
            this.$message({
              type: 'error',
              message: this.$t('common.code.' + res.code)
            })
          }
        })
      },
      // 获取部门树
      getTree () {
        this.loading = true;
        getTree().then(res => {
          if (res.success) {
            this.dataTree = res.data
            console.log(this.dataTree+"获取部门大叔")
          } else {
            this.$message({
              type: 'error',
              message: this.$t('common.code.' + res.code)
            })
          }
          this.loading = false;
        })
      },
      // 点击部门，选中当前部门信息
      handleNodeClick (data) {
        this.selectDepart = data
        // 选中该条数据
        let id = this.selectDepart.id
        this.$refs.dataTree.setCheckedKeys([id])
        // 延迟加载部门内审核人数据
        this.$nextTick(function () {
          this.queryChecker()
        })
      },
      // 添加部门
      addDepart () {
        this.saveDepartEntity = new DepartModel()
        if (this.$refs.dataTree.getCheckedKeys().length > 0) {
          // 把选中的部门复制到修改部门对象内
          this.saveDepartEntity.parDeptCode = this.selectDepart.branchNo
        } else {
          // 新增等级部门 父部门编号为空
          // this.saveDepartEntity.parDeptCode = '';
        }
        // 弹出编辑弹出框
        this.editVisible = true
        this.title = this.$t('depart.mes.addDepart')
        this.isAdd = false
        this.saveDepartEntity.flag = 'add'
        // 清除校验提醒
        if (this.$refs['editForm'] != undefined) {
          this.$refs['editForm'].clearValidate()
          // this.$refs["editForm"].resetFields();
        }
      },
      // 修改部门 把选中部门复制到编辑弹出框的form表单中
      editDepart () {
        if (this.$refs.dataTree.getCheckedKeys().length > 0) {
          // 把选中的部门复制到修改部门对象内
          this.saveDepartEntity = copyObject(this.selectDepart, this.saveDepartEntity)
          this.saveDepartEntity.flag = 'mod'
          // 弹出编辑弹出框
          this.editVisible = true
          this.title = this.$t('depart.mes.editDepart')
          this.isAdd = true
          // 清除校验提醒
          if (this.$refs['editForm'] != undefined) {
            this.$refs['editForm'].clearValidate()
          }
        } else {
          this.$message({
            type: 'warning',
            message: this.$t('depart.mes.pleSelDepart')
          })
        }
      },
      // 修改按钮---------->>>只可以修改部门名称
      save (formName) {
        this.$refs[formName].validate(valid => {
          if (valid) {
            // this.saveDepartEntity.branchName = window.encodeURIComponent(this.saveDepartEntity.branchName);
            saveDepart(this.saveDepartEntity).then(res => {
              if (res.success) {
                // 退出弹出框
                this.editVisible = false
                // 取消选中该条数据
                this.$refs.dataTree.setCheckedKeys([])
                this.getTree()
                this.$message({
                  type: 'success',
                  message: this.$t('common.code.' + res.code)
                })
              } else {
                this.$message({
                  type: 'error',
                  message: this.$t('common.code.' + res.code)
                })
              }
            })
          }
        })
      },
      // 删除部门
      deleteDepart () {
        if (this.$refs.dataTree.getCheckedKeys().length > 0) {
          this.$confirm(this.$t('depart.mes.isDelDepart'), this.$t('depart.mes.tip'), {
            confirmButtonText: this.$t('common.button.confirm'),
            cancelButtonText: this.$t('common.button.cancel'),
            type: 'warning'
          }).then(() => {
            let ids = this.selectDepart.branchNo;
            let params = {ids: ids}
            deleteDepart(params).then(res => {
              if (res.success) {
                // 取消选中该条数据
                this.$refs.dataTree.setCheckedKeys([])
                this.getTree()
                // 清空右侧部门审核人表格数据
                this.queryDepartChecker = []
                this.$message({
                  type: 'success',
                  message: this.$t('common.code.' + res.code)
                })
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
              message: this.$t('depart.mes.cancelDel')
            })
          })
        } else {
          this.$message({
            type: 'warning',
            message: this.$t('depart.mes.pleSelDepart')
          })
        }
      },
      // 查询本部门的审核人
      queryChecker () {
        if (this.$refs.dataTree.getCheckedKeys().length > 0) {
          // 选中的部门branchNo 入参
          let param = {branchNo: this.selectDepart.branchNo}
          this.checkerLoading = true;
          queryCheckersByBranchNo(param).then(res => {
            if (res.success) {
              this.queryDepartChecker = res.data
            } else {
              this.$message({
                type: 'error',
                message: this.$t('common.code.' + res.code)
              })
            }
            this.checkerLoading = false;
          })
        } else {
          this.$message({
            type: 'warning',
            message: this.$t('depart.mes.pleSelDepart')
          })
        }

      },
      // 右侧审核人表格选中
      handleSelectionChange (val) {
        this.currentRows = val
      },
      // 右侧审核人表格选中
      handleSelectionChangeAdd (val) {
        this.currentRowsAdd = val
      },
      // 页码控制
      handleSizeChange (val) {
        this.departChecker.length = val
        this.queryUser()
      },
      handlePageChange (val) {
        this.departChecker.page = val
        this.queryUser()
      },
      handleClose(done){
        this.addVisible = false
         this.resetForm('departForm')
      },
      // 重置按钮
      resetForm (formName) {
        this.$refs[formName].resetFields()
      },
      queryUserPer () {
        this.departChecker.page = 1
        this.queryUser()
      },
      // 查询本部门的所有员工
      queryUser () {
      // // 清除校验提醒
      //   if (this.$refs['departForm'] != undefined) {
      //     this.$refs['departForm'].clearValidate()
      //   }
        this.departChecker.branchNo = this.selectDepart.branchNo
        queryUserByBranchNo(this.departChecker).then(res => {
          if (res.success) {
            this.total = res.total
            this.addDepartChecker = res.data
            this.addVisible = true
            this.title = this.$t('common.button.add') + this.$t('depart.checker')

          } else {
            this.$message({
              type: 'error',
              message: this.$t('common.code.' + res.code)
            })
          }
        })


      },
      // 添加审核人
      addCheckerPer () {

        if (this.$refs.dataTree.getCheckedKeys().length > 0) {
          // 弹框显示部门内所有用户，勾选审核人

          this.queryUserPer()
        } else {
          this.$message({
            type: 'warning',
            message: this.$t('depart.mes.pleSelDepart')
          })
        }
      },
      // 保存添加的审核人
      addChecker () {
        if (this.currentRowsAdd.length == 0) {
          this.$message({
            type: 'warning',
            message: this.$t('depart.mes.pleSelChecker')
          })
          return
        }
        this.notAllcheck=false
         let notAllCheck = []
          let users = this.currentRowsAdd
          users.forEach(function (user) {
            if("0"==user.checker){
              notAllCheck.push(true)
            }
       
          })
          if(''!=notAllCheck){
            console.log("看是否為空")
            this.notAllcheck=true
          }
          console.log(this.notAllcheck+"~~~!!!@@")
        //  弹出确认框  确认将以下人员设置为审核组人员吗？
        this.$confirm(this.$t('depart.mes.isAddChecker'), this.$t('depart.mes.tip'), {
          confirmButtonText: this.$t('common.button.confirm'),
          cancelButtonText: this.$t('common.button.cancel'),
          type: 'warning'
        }).then(() => {
          // 添加审核人
 
          let users = this.currentRowsAdd
          let userIds = []
         
          users.forEach(function (user) {
            userIds.push(user.userId)
          })
          if(!this.notAllcheck ){
         
           console.log("妈的")
            this.$message({
                type: 'error',
                message: this.$t('depart.mes.notAllcheck')
            })
             return

          }else{
                         let params = {
            branchNo: this.selectDepart.branchNo,
            userIds: userIds
          }

          addCheckers(params).then(res => {
                console.log(userIds+"查看所有add")
            if (res.success) {
              // 重新查询部门审核人
              this.queryChecker()
              this.$message({
                type: 'success',
                message: this.$t('common.code.' + res.code)
              })
              // 关闭弹窗，重置表单
              this.addVisible = false
              console.log("关闭弹窗清除校验")
              this.resetForm('departForm')
            } else {
              this.$message({
                type: 'error',
                message: this.$t('common.code.' + res.code)
              })
            }
          })
          }


        }).catch(() => {
          if(this.notAllChekck){
          this.$message({
            type: 'info',
            message: this.$t('depart.mes.cancelAddChecker')
          })
          }
        })
        
      
      },
      // 删除审核人
      delChecker () {
        // 删除后需要重新查询，判断部门是否选中
        if (this.$refs.dataTree.getCheckedKeys().length == 0) {
          this.$message({
            type: 'warning',
            message: this.$t('depart.mes.pleSelDepart')
          })
          return
        }
        if (this.currentRows.length == 0) {
          this.$message({
            type: 'warning',
            message: this.$t('depart.mes.pleSelChecker')
          })
          return
        }
        // 确认将以下人员从审核组中移除吗？
        this.$confirm(this.$t('depart.mes.isDelChecker'), this.$t('depart.mes.tip'), {
          confirmButtonText: this.$t('common.button.confirm'),
          cancelButtonText: this.$t('common.button.cancel'),
          type: 'warning'
        }).then(() => {
          // 删除审核人
          let users = this.currentRows
          let userIds = []
          users.forEach(function (user) {
            userIds.push(user.userId)
          })
          let params = {
            branchNo: this.selectDepart.branchNo,
            userIds: userIds
          }
          delCheckers(params).then(res => {
            if (res.success) {
              // 重新查询部门审核人
              this.queryChecker()
              this.$message({
                type: 'success',
                message: this.$t('common.code.' + res.code)
              })
            } else {
              this.$message({
                type: 'error',
                message: this.$t('common.code.' + res.code)
              })
            }
          })
        }).catch(() => {
          console.log("hello")
          this.$message({
            type: 'info',
            message: this.$t('depart.mes.cancelDel')
          })
        })
      },
      // 0-否； 1-是
      formatChecker (row, column) {
        return getDictName(this.checkerOptions,row.checker)
      },
      //导出部门
      exportDepart () {
        let self = this
        this.uploading = true;
        self.$axios.post(exportDepartUrl, null, {responseType: 'arraybuffer'})
          .then(res => {
            this.uploading = false;
            let downloadA = document.createElement('a')
            let blob = new Blob([res.data], {type: 'application/vnd.ms-excel'})
            downloadA.href = window.URL.createObjectURL(blob)
            downloadA.download = "depart" + getCurrentTime("yyyyMMddHHmmss")
            downloadA.click()
            window.URL.revokeObjectURL(downloadA.href)
          })
      },
      //导出员工
      exportUser () {
        let self = this
        this.uploading = true;
        self.$axios.post(exportUserUrl, null, {responseType: 'arraybuffer'}).then(
          function (res) {
            self.uploading = false;
            let downloadA = document.createElement('a')
            let blob = new Blob([res.data], {type: 'application/vnd.ms-excel'})
            downloadA.href = window.URL.createObjectURL(blob)
            downloadA.download = "user" + getCurrentTime("yyyyMMddHHmmss")
            downloadA.click()
            window.URL.revokeObjectURL(downloadA.href)
          })
      },
      // 导入部门按钮
      importDepar () {
        this.importVisible = true
        this.title = this.$t('depart.mes.importDepart')
        this.importFile = new fileModel()
        this.importFile.url = importDepartUrl
        // 清除校验提醒
        if (this.$refs['uploadForm'] != undefined) {
          this.$refs['uploadForm'].clearValidate()
        }
      },
      // 导入员工按钮
      importUser () {
        this.importVisible = true
        this.title = this.$t('depart.mes.importUser')
        this.importFile = new fileModel()
        this.importFile.url = importUserUrl
        // 清除校验提醒
        if (this.$refs['uploadForm'] != undefined) {
          this.$refs['uploadForm'].clearValidate()
        }
      },
      // 上传请求URL
      UploadUrl () {
        if (this.importFile.url == undefined || this.importFile.url == null || this.importFile.url === '') {

        }else{
          return this.importFile.url
        }
      },
      // 文件状态改变时，添加文件、上传成功和上传失败时都会被调用
      handleChange (file, fileList) {
        // 清空之前的文件集合，确保上传只有一个文件
        this.fileList = []
        this.fileList.push(file)
        fileList = this.fileList
        // 读取上传文件的文件名称
        this.importFile.fileName = file.name
      },
      beforeUpload (file) {
        let filename = file.name
        let index = filename.lastIndexOf('.')
        // 获取上传文件的后缀名
        let suffix = filename.substr(index + 1)
        if (suffix == 'xlsx' || suffix == 'xls') {
          return true
        } else {
          this.$message({
            type: 'error',
            message: this.$t('depart.mes.fileTypeErr')
          })
          return false
        }
      },
      // 上传按钮
      uploadFile (formName) {
        let self = this
        self.$refs[formName].validate(valid => {
          if (valid) {
            this.importVisible = false
            // 校验通过，上传文件
            self.$refs.upload.submit()
            this.uploading = true;
          }
        })
      },
      // 上传成功
      handleSuc (res, file, fileList) {
        this.uploading = false;
        if (res) {
          this.importVisible = false
          if (res.success) {
            this.$message({
              type: 'success',
              message: this.$t('common.code.' + res.code)
            })
            // 导入部门，延迟加载树
            if (this.importFile.fileType == '1') {
              this.$nextTick(function () {
                this.getTree()
              })
            }
          } else {
            this.$message({
              type: 'error',
              message: this.$t('common.code.' + res.code)
            })
          }
        }
      },
    }
  }
</script>
<style>
  .el-upload--text {
    /*width: auto;*/
    height: auto;
    border: none;
    margin-left: 5px;
    width: auto !important
  }
</style>
