<template>
  <el-row>
    <el-row class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-calendar"></i> {{ $t('common.route.R1') }}
        </el-breadcrumb-item>
        <el-breadcrumb-item>{{ $t('common.route.R11') }}</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-row class="query-form">
      <el-form :inline="true" :model="queryUser" ref="queryForm" >

          <el-form-item :label="this.$t('user.label.userId')" prop="userId" class='queryCondition'>
            <el-input v-model="queryUser.userId" :placeholder="this.$t('user.label.userId')"></el-input>
          </el-form-item>

          <el-form-item :label="this.$t('user.label.userName')" prop="userName" class='queryCondition'>
            <el-input v-model="queryUser.userName" :placeholder="this.$t('user.label.userName')"></el-input>
          </el-form-item>

          <el-form-item :label="this.$t('user.label.deptName')" prop="treeSelectValue" class='queryCondition'>
            <treeselect v-model="treeSelectValue"
                        :placeholder="this.$t('user.label.deptName')"
                        :disable-branch-nodes="true"
                        :multiple="false" :options="departTree"
                        style="width:200px"
            />
          </el-form-item>

      </el-form>
    </el-row>
    <el-row class="table-operations">
      <el-button
        type="primary"
        icon="el-icon-lx-search"
        @click="submitQuery()"
      >{{this.$t('common.button.query')}}
      </el-button>
       <el-button
        type="primary"
        icon="el-icon-lx-attention"
        @click="viewDetails()"
      >{{this.$t('user.button.detail')}}
      </el-button>
      <el-button
        type="primary"
        icon="el-icon-lx-roundadd"
        @click="add()"
      >{{this.$t('common.button.add')}}
      </el-button>
      <el-button
        type="primary"
        icon="el-icon-lx-edit"
        @click="edit()"
      >{{this.$t('common.button.edit')}}
      </el-button>
      <el-button
        type="primary"
        icon="el-icon-lx-delete"
        @click="delUser()"
      >{{this.$t('common.button.delete')}}
      </el-button>
      <el-button
        type="primary"
        icon="el-icon-lx-settings"
        @click="roleSet()"
      >{{this.$t('user.button.roleSet')}}
      </el-button>
      <el-button
        type="primary"
        icon="el-icon-key"
        @click="resetPassword()"
      >{{this.$t('user.button.resetPassword')}}
      </el-button>
      <el-button type="primary" icon="el-icon-bottom"  @click="userSynchronize()">{{this.$t('user.button.sync')}}</el-button>
      <el-button
        type="primary"
        icon="el-icon-lx-refresh"
        @click="resetForm('queryForm')"
      >{{this.$t('common.button.reset')}}
      </el-button>
    </el-row>
    <el-row class="table-result">
      <el-table
        ref="singleTable"
        v-loading="loading"
        border
        highlight-current-row
        :data="tableData"
        @current-change="handleCurrentChange"
        @row-dblclick="handleDblclick"
        style="width: 100%"
      >
        <el-table-column type="index" :label="this.$t('common.label.index')" width="60"></el-table-column>
        <el-table-column property="userId" :label="this.$t('user.label.userId')" width="100"></el-table-column>
        <el-table-column property="userName" :label="this.$t('user.label.userName')" width="150"></el-table-column>
        <el-table-column property="phone" :label="this.$t('user.label.phone')" width="150"></el-table-column>
        <el-table-column property="deptCode" :label="this.$t('user.label.deptName')" width="150"
                         :formatter="formatDept"></el-table-column>
        <el-table-column property="creator" :label="this.$t('user.label.creator')" width="100"></el-table-column>
        <el-table-column
          property="createTime"
          :label="this.$t('user.label.createTime')"
          width="200"
          :formatter="formatCreateTime"
        ></el-table-column>
        <el-table-column property="auditor" :label="this.$t('user.label.auditor')" width="100"></el-table-column>
        <el-table-column
          property="auditTime"
          :label="this.$t('user.label.auditTime')"
          width="200"
          :formatter="formatAuditTime"
        ></el-table-column>
      </el-table>
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryUser.page"
        :page-sizes="pageSizes"
        :page-size="queryUser.length"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </el-row>
    <!-- 新增/编辑弹出框 -->
    <el-row>
      <el-dialog :title="title" :visible.sync="editVisible" :close-on-click-modal="false" width="30%">
        <el-form
          ref="editForm"
          :rules="rules"
          :model="editUser"
          label-width="100px"
          :disabled="formDisabled"
        >
          <el-form-item :label="this.$t('user.label.userId')" prop="userId">
            <el-input v-model="editUser.userId" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('user.label.userName')" prop="userName">
            <el-input v-model="editUser.userName"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('user.label.deptName')" prop="deptCode">
            <!--            <el-input v-model="editUser.deptCode"></el-input>-->
            <treeselect v-model="editDeptCode"
                        placeholder=""
                        :disable-branch-nodes="true"
                        :multiple="false" :options="departTree"
            />
          </el-form-item>
          <el-form-item :label="this.$t('user.label.phone')" prop="phone">
            <el-input v-model="editUser.phone"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="editVisible = false">{{this.$t('common.button.cancel')}}</el-button>
          <el-button type="primary" @click="editAudit('editForm')">{{this.$t('common.button.save')}}</el-button>
          <!-- <el-button type="primary" @click="save('editForm')">{{this.$t('common.button.save')}}</el-button> -->
        </span>
      </el-dialog>
    </el-row>
    <!-- 审核弹出框 -->
    <el-row>
      <el-dialog :title="title" :visible.sync="auditVisible" :close-on-click-modal="false" width="30%">
        <el-form ref="auditForm" :rules="rules" :model="auditForm" label-width="100px">
          <el-form-item :label="this.$t('user.label.userId')" prop="userId">
            <el-input v-model="auditForm.userId"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('user.label.password')" prop="passwd">
            <el-input type="password" v-model="auditForm.passwd"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="auditVisible = false">{{this.$t('common.button.cancel')}}</el-button>
          <el-button type="primary" @click="checkAudit('auditForm')">{{this.$t('user.button.pass')}}</el-button>
        </span>
      </el-dialog>
    </el-row>
    <!-- 查看详情弹出框 -->
    <el-row>
      <el-dialog :title="title" :visible.sync="viewVisible" :close-on-click-modal="false" width="60%">
        <el-card class="box-card" model="viewUser">
          <el-row :gutter="12">
            <el-col :span="12">
              <el-card shadow="hover">{{this.$t('user.label.userId')}}：{{viewUser.userId}}</el-card>
            </el-col>
            <el-col :span="12">
              <el-card shadow="hover">{{this.$t('user.label.userName')}}： {{viewUser.userName}}</el-card>
            </el-col>
          </el-row>
          <el-row :gutter="12">
            <el-col :span="12">
              <el-card shadow="hover">{{this.$t('user.label.phone')}}: {{viewUser.phone}}</el-card>
            </el-col>
            <el-col :span="12">
              <el-card shadow="hover">{{this.$t('user.label.deptName')}}: {{viewUser.deptCode}}</el-card>
            </el-col>
          </el-row>
          <el-row :gutter="12">
            <el-col :span="12">
              <el-card shadow="hover">{{this.$t('user.label.creator')}}: {{viewUser.creator}}</el-card>
            </el-col>
            <el-col :span="12">
              <el-card shadow="hover">{{this.$t('user.label.createTime')}}: {{viewUser.createTime}}</el-card>
            </el-col>
          </el-row>
          <el-row :gutter="12">
            <el-col :span="12">
              <el-card shadow="hover">{{this.$t('user.label.auditor')}}: {{viewUser.auditor}}</el-card>
            </el-col>
            <el-col :span="12">
              <el-card shadow="hover">{{this.$t('user.label.auditTime')}}: {{viewUser.auditTime}}</el-card>
            </el-col>
            <el-col :span = "24">

                <el-row class="table-result">
                  <el-card shadow="hover">{{this.$t('user.label.role')}}:</el-card>
                  <el-table
                    ref="viewTable"
                    border
                    highlight-current-row
                    :data="viewTableData"
                    style="width: 100%"
                  >
                    <el-table-column property="roleId" :label="$t('role.label.roleId')" width="250"></el-table-column>
                    <el-table-column property="roleName" :label="$t('role.label.roleName')" width="250"></el-table-column>
                    <el-table-column property="descr" :label="$t('role.label.descr')" width="270"></el-table-column>
                  </el-table>
                </el-row>
            </el-col>
          </el-row>
        </el-card>
        <span slot="footer" class="dialog-footer">
          <el-button type="primary" @click="viewVisible = false">{{this.$t('user.button.back')}}</el-button>
        </span>
      </el-dialog>
    </el-row>

    <!-- 角色设置弹出框 -->
    <el-row>
      <el-dialog :title="title" :visible.sync="roleSetVisible" :close-on-click-modal="false" width="60%">
        <el-row class="query-form">
          <el-form :inline="true" :model="queryRole">
            <el-col :span="12">
              <el-form-item :label="$t('role.label.roleId')" prop="roleId">
                <el-input v-model="queryRole.roleId" :placeholder="$t('role.label.roleId')"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item :label="$t('role.label.roleName')">
                <el-input v-model="queryRole.roleName" :placeholder="$t('role.label.roleName')"></el-input>
              </el-form-item>
            </el-col>
          </el-form>
        </el-row>
        <!-- 角色列表 -->
        <el-row class="table-operations">
          <el-button type="primary" @click="submitQueryRole()">{{$t('common.button.query')}}</el-button>
          <el-button
            type="primary"
            @click="roleSetVisible = false"
          >{{this.$t('common.button.cancel')}}
          </el-button>
          <el-button type="primary" @click="roleSetAudit()">{{this.$t('common.button.save')}}</el-button>
        </el-row>
        <el-row class="table-result">


          <!--<el-table-->
            <!--ref="userRoleTable"-->
            <!--border-->
            <!--highlight-current-row-->
            <!--:data="roleTableData"-->
            <!--@selection-change="handleSelectionChange"-->
            <!--style="width: 100%"-->
          <!--&gt;-->
            <!--<el-table-column  type="selection" property="checked" width="55"></el-table-column>-->
            <!--<el-table-column property="roleId" :label="$t('role.label.roleId')" width="200"></el-table-column>-->
            <!--<el-table-column property="roleName" :label="$t('role.label.roleName')" width="200"></el-table-column>-->
            <!--<el-table-column property="descr" :label="$t('role.label.descr')" width="200"></el-table-column>-->
          <!--</el-table>-->
          <el-table
            ref="userRoleTable"
            :data="roleTableData"
            tooltip-effect="dark"
            style="width: 100%"
            height="400"
            border
            @selection-change="handleSelectionChange">

            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column prop="roleId" :label="$t('role.label.roleId')" width="200"></el-table-column>
            <el-table-column prop="roleName" :label="$t('role.label.roleName')" width="200"></el-table-column>
            <el-table-column prop="descr" :label="$t('role.label.descr')" show-overflow-tooltip></el-table-column>

          </el-table>


        </el-row>
      </el-dialog>
    </el-row>
  </el-row>
</template>
<script>
  import {userModel} from '../../model/user/userModel'
  import {roleModel} from '../../model/role/roleModel'
  import {pageSizes, pageSize} from '../../common/global'
  import {encrypt} from '@/components/common/3des'
  // import the component
  import Treeselect from '@riophae/vue-treeselect'
  // import the styles
  import '@riophae/vue-treeselect/dist/vue-treeselect.css'
  import {
    queryUser,
    saveUser,
    deleteUser,
    auditUser,
    getTree,
    resetPassword,
    queryRole,
    saveUserRole,
    queryUserRole,
    viewUserRole,
    userSynchronize
  } from '@/api/getData'
  import {copyObject, formatDate} from '../../common/util'

  export default {
    name: 'userMaintain',
    // register the component
    components: {Treeselect},
    data () {
      //联系方式校验
      var checkPhone = (rule, value, callback) => {
        if(value!= undefined && value != null && value!=''){
          var isPhone = /^1[3|4|5|7|8][0-9]\d{8}$/ //手机号码
          // let reg = /^1[345789]\d{9}$/;
          if (isPhone.test(value)) {
            callback()
          } else {
            callback(new Error(this.$t('user.rule.phoneValidator')))
          }
        }else{
         callback()
        }
      }
      //用户代码校验（字母和数字）
      var checkUserId = (rule, value, callback) => {
        //校验用户代码
        var reg = /^[A-Za-z0-9]{1,32}$/
        if (value != '' && reg.test(value)) {
          callback()
        } else {
          callback(new Error(this.$t('user.rule.userIdValidator')))
        }
      }
      return {
        treeSelectValue: null,
        editDeptCode: null,
        queryUser: new userModel(), //查询对象
        editUser: new userModel(), //新增编辑对象
        deleteUser: new userModel(), //删除对象
        viewUser: new userModel(), //查看详情对象
        auditUser: new userModel(), //审核对象
        resetPawUser: new userModel(), //重置代码对象
        roleSetUser: new userModel(), //角色设置对象
        queryRole: new roleModel(), //角色设置时角色对象
        pageSizes: pageSizes,
        pageSizesRole: pageSizes,
        total: 0,
        totalRole: 0,
        tableData: [],
        roleTableData: [], //角色设置表格数据
        userRoleData:[],//角色表格
        viewTableData:[],//查看详情中的角色表格
        queryUserRoleData: [], //角色设置用户角色对应数据
        viewUserRoleData:[],//查看详情用户角色对应数据
        departTree: [],//部门下拉树
        editVisible: false,
        auditVisible: false,
        viewVisible: false,
        roleSetVisible: false,
        /**用于区分新增/编辑,角色设置和删除的审核操作 */
        isDelete: false ,
        isRoleSet:false,
        isAdd:false,
        title: this.$t('user.label.addUser'),
        formDisabled: false /** 为true时，整个表单不可编辑 */,
        disabled: false /** 为true时，编辑时某些字段不可编辑 */,
        multipleSelection: [] /**获取选中的角色信息 */,
        selectRole: [] /**用于存选中的角色ID*/,
        auditForm: {
          userId: '',
          passwd: ''
        },
        loading: false,
        rules: {
          userId: [
            {
              required: true,
              message: this.$t('user.rule.userId'),
              trigger: 'blur'
            },
            {
              min: 1,
              max: 32,
              message:this.$t('user.rule.userIdLength'),
              trigger: 'blur'
            },
            {
              validator: checkUserId,
              trigger: 'blur'
            }
          ],
          userName: [
            {
              required: true,
              message: this.$t('user.rule.userName'),
              trigger: 'blur'
            },
            {
              min: 1,
              max: 50,
              message: this.$t('user.rule.userNameLength'),
              trigger: 'blur'
            }
          ],
          passwd: [
            {
              required: true,
              message: this.$t('user.rule.password'),
              trigger: 'blur'
            }
          ],
          phone: [
            {
              validator: checkPhone,
              trigger: 'blur'
            }
          ]
        },
      }
    },
    created () {
      this.getTree()
    },
    methods: {
      getRowKeys(row) {
        return row.id
      },

      //角色设置勾选函数
      handleSelectionChange (val) {
        this.multipleSelection = val
      },
      handleCurrentChange (val) {
        this.currentRow = val
      },


      handleSizeChangeRole (val) {
        this.queryRole.length = val
        this.searchRole()
      },
      handleSizeChange (val) {
        this.queryUser.length = val
        this.search()
      },

      handlePageChangeRole (val) {
        this.queryRole.page = val
        this.searchRole()
      },
      handlePageChange (val) {
        this.queryUser.page = val
        this.search()
      },

      handleDblclick (val) {
        this.edit()
      },
      //获取部门树
      getTree () {
        getTree().then(res => {
          if (res.success) {
            this.departTree = res.data
            //去除children为null的属性
            this.recursive(this.departTree)
          } else {
            this.$message({
              type: 'error',
              message: this.$t('common.code.' + res.code)
            })
          }
        })
      },
      //点就查询，把页码置为1
      submitQuery() {
        this.queryUser.page = 1;
        this.search();
      },

      submitQueryRole() {
        this.queryRole.page = 1;
        this.searchRole();
        // this.searchR();
      },

      //查询
      search () {
        this.queryUser.deptCode = this.treeSelectValue
        this.loading = true;
        queryUser(this.queryUser).then(res => {
          if (res.success || res.success == 'true') {
            if(res.total > 0 && res.data.length==0){
               this.queryUser.page--;
               this.search();
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

      // searchR() {
      //   queryRole(this.queryRole).then(res => {
      //     if (res.success || res.success == "true") {
      //       if(res.total>0&&res.data.length == 0){
      //         this.queryRole.page--;
      //         this.searchR();
      //       }else{
      //         this.total = res.total;
      //         this.roleTableData = res.data;
      //       }
      //     } else {
      //       this.$message({
      //         type: "error",
      //         message: res.message
      //       });
      //     }
      //   });
      // },

      //角色设置
      roleSet () {
        if (this.currentRow == null || this.currentRow == undefined) {
          this.$message({
            type: 'warning',
            message: this.$t('user.message.roleSet')
          })
          return
        }
        this.roleSetUser = copyObject(this.currentRow, this.roleSetUser)
        this.title = this.$t('user.label.roleSet')
        this.searchRole()
      },

      //页面加载时就先查询角色，在查看详情时需用到
      preSearchRole () {
        queryRole(this.queryRole).then(res => {
          if (res.success || res.success == 'true') {
            this.userRoleData = res.data
          } else {
            this.$message({
              type: 'error',
              message: this.$t('common.code.' + res.code)
            })
          }
        })
      },
      //角色设置，查询角色
      searchRole () {
        queryRole(this.queryRole).then(res => {
          if (res.success || res.success == 'true'){
            this.totalRole = res.total
            this.roleTableData = res.data
            this.userRoleData = res.data
            this.roleSetVisible = true
            this.queryRole.roleId = ''
            this.queryRole.roleName = ''
            this.queryUserRole()
          } else {
            this.$message({
              type: 'error',
              message: this.$t('common.code.' + res.code)
            })
          }
        })
      },
      //查询选中的用户已经具有的角色
      queryUserRole () {
        queryUserRole(this.roleSetUser).then(res => {
          if (res.success || res.success == 'true') {
            this.queryUserRoleData = res.data
            this.roleTableData.forEach(data1 => {
              this.queryUserRoleData.forEach(data2 => {
                if (data1.roleId == data2.roleId) {
                  this.$refs['userRoleTable'].toggleRowSelection(data1, true)
                }
              })
            })
          } else {
            this.$message({
              type: 'error',
              message: this.$t('common.code.' + res.code)
            })
          }
        })
      },


      //角色设置，弹出审核页面
      roleSetAudit(){
        this.auditVisible = true
        this.isRoleSet = true
        this.title = this.$t('user.label.auditUser')
        if (this.$refs['auditForm'] != undefined) {
          this.$refs['auditForm'].clearValidate()
          this.auditForm.userId = ''
          this.auditForm.passwd = ''
        }
      },
      //保存用户角色信息
      saveUserRole () {
        this.selectRole.push(this.roleSetUser.userId)
        this.multipleSelection.forEach(key => {
          if (key['roleId']) {
            this.selectRole.push(key.roleId)
          }
        })
        saveUserRole(this.selectRole).then(res => {
          //清空数组
          this.selectRole = []
          if (res.success || res.success == 'true') {
            this.roleSetVisible = false
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
      },
      //新增
      add () {
        this.editUser = new userModel()
        this.editUser.flag = 'add'
        this.editDeptCode = null;
        this.title = this.$t('user.label.addUser')
        this.editVisible = true
        this.disabled = false
        if (this.$refs['editForm'] != undefined) {
          this.$refs['editForm'].clearValidate()
        }
      },
      //编辑
      edit () {
        if (this.currentRow == null || this.currentRow == undefined) {
          this.$message({
            type: 'warning',
            message: this.$t('user.message.editSelect')
          })
          return
        }
        this.disabled = true
        this.editUser = copyObject(this.currentRow, this.editUser)
        if (this.editUser.deptCode != '') {
          this.editDeptCode = this.editUser.deptCode
        }
        this.editUser.flag = 'mod'
        this.title = this.$t('user.label.editUser')
        this.editVisible = true
        if (this.$refs['editForm'] != undefined) {
          this.$refs['editForm'].clearValidate()
        }
      },
      //新增、编辑弹出审核页面
      editAudit (formName) {
        this.$refs[formName].validate(valid => {
          if (valid) {
            //  this.editVisible = false;
            this.isAdd = true;
            this.auditVisible = true
            this.title = this.$t('user.label.auditUser')
            if (this.$refs['auditForm'] != undefined) {
              this.$refs['auditForm'].clearValidate()
              this.auditForm.userId = ''
              this.auditForm.passwd = ''
            }
          }
        })
      },
      //删除弹出审核页面
      deleteAudit () {
       /// this.editVisible = false
        this.auditVisible = true
        this.title = this.$t('user.label.auditUser')
        if (this.$refs['auditForm'] != undefined) {
          this.$refs['auditForm'].clearValidate()
          this.auditForm.userId = ''
          this.auditForm.passwd = ''
        }
      },
      //审核人用户代码，密码确认
      checkAudit (formName) {
        this.auditUser.passwd = encrypt(
          this.auditForm.userId,
          this.auditForm.passwd
        )
        this.auditUser.userId = this.auditForm.userId
        this.$refs[formName].validate(valid => {
          if (valid) {
            auditUser(this.auditUser).then(res => {
              if (res.success || res.success == 'true') {
                this.auditVisible = false
                if (this.isDelete) {
                  this.isDelete = false
                  this.deleteUser = copyObject(this.currentRow, this.deleteUser)
                  deleteUser(this.deleteUser).then(res => {
                    if (res.success || res.success == 'true') {
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
                } else if (this.isAdd) {
                  this.save('editForm');
                }else if(this.isRoleSet){
                   this.saveUserRole();
                }
              } else {
                this.$message({
                  type: 'error',
                  message: this.$t('common.code.' + res.code)
                })
              }
            })
          } else {
           // console.log('验证失败')
            return false
          }
        })
      },
      //删除确认框
      delUserConfirm () {
        this.$confirm(
          this.$t('user.label.deleteInfo'),
          this.$t('user.label.tip'),
          {
            confirmButtonText: this.$t('user.button.confirm'),
            cancelButtonText: this.$t('user.button.cancel'),
            type: 'warning'
          }
        )
          .then(() => {
            this.deleteAudit()
          })
          .catch(() => {
            this.$message({
              type: 'info',
              message: this.$t('user.message.cancelDelete')
            })
          })
      },
      //删除用户信息
      delUser () {
        if (this.currentRow == null || this.currentRow == undefined) {
          this.$message({
            type: 'warning',
            message: this.$t('user.message.deleteSelect')
          })
          return
        }
        this.isDelete = true
        this.delUserConfirm()
      },
      //保存信息
      save (formName) {
        this.$refs[formName].validate(valid => {
          if (valid) {
            this.editUser.deptCode = this.editDeptCode
            //this.editUser.userName = encodeURIComponent(this.editUser.userName)
            var tdata = this.editUser
            //var str = encodeURIComponent(JSON.stringify(this.editUser))
            //var data = JSON.parse(str)
            saveUser(tdata).then(res => {
              if (res.success || res.success == 'true') {
                this.editVisible = false
                this.isAdd = false;
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
           // console.log('验证失败')
            return false;
          }
        })
      },

      //查看详情
      viewDetails () {
        this.viewTableData = [];
        if (this.currentRow == null || this.currentRow == undefined) {
          this.$message({
            type: 'warning',
            message: this.$t('user.message.viewSelect')
          })
          return
        }
        this.roleSetUser = copyObject(this.currentRow, this.roleSetUser)
        viewUserRole(this.roleSetUser).then(res => {
          if (res.success || res.success == 'true') {
            this.viewUserRoleData = res.data
            this.userRoleData.forEach(data1 => {
              this.viewUserRoleData.forEach(data2 => {
                if (data1.roleId == data2.roleId) {
                  this.viewTableData.push(data1)
                }
              })
            })
          } else {
            this.$message({
              type: 'error',
              message: this.$t('common.code.'+res.code)
            })
          }
        })
        this.viewUser = copyObject(this.currentRow, this.viewUser)
        this.viewUser.createTime = formatDate(this.viewUser.createTime)
        this.viewUser.auditTime = formatDate(this.viewUser.auditTime)
        this.viewUser.deptCode = this.getDeptName(this.departTree,this.viewUser.deptCode)
        this.title = this.$t('user.label.viewDetail')
        this.viewVisible = true
      },
      //密码重置确认框
      resetPasswordConfirm () {
        this.$confirm(
          this.$t('user.label.resetPasswordInfo'),
          this.$t('user.label.tip'),
          {
            confirmButtonText: this.$t('user.button.confirm'),
            cancelButtonText: this.$t('user.button.cancel'),
            type: 'warning'
          }
        )
          .then(() => {
            this.resetPawUser = copyObject(this.currentRow, this.resetPawUser)
            this.resetPawUser.passwd = this.currentRow.userId
            resetPassword(this.resetPawUser).then(res => {
              if (res.success || res.success == 'true') {
                this.returnNewPassw()
              } else {
                this.$message({
                  type: 'error',
                  message: this.$t('common.code.' + res.code)
                })
              }
            })
          })
          .catch(() => {
            this.$message({
              type: 'info',
              message: this.$t('user.message.cancelResetPaw')
            })
          })
      },
      //密码重置
      resetPassword () {
        if (this.currentRow == null || this.currentRow == undefined) {
          this.$message({
            type: 'warning',
            message: this.$t('user.message.resetPassword')
          })
          return
        }
       this.resetPasswordConfirm();
      },
      //重置密码成功后的显示框
      returnNewPassw () {
        // this.$confirm(
        //    this.$t("user.message.returnNewPasswInfo"),
        //   this.$t("user.label.tip"),
        //   {
        //     confirmButtonText: this.$t("user.button.confirm"),
        //     type: "warning"
        //   }
        // )
        //   .then(() => {
        //     this.search();
        //   })
        this.$alert(
          this.$t('user.message.returnNewPasswInfo') + this.resetPawUser.passwd,
          this.$t('user.label.tip'),
          {
            confirmButtonText: this.$t('user.button.confirm'),
            callback: action => {
              this.search()
            }
          }
        )
      },
      //递归树结构,删除children为null的属性
      recursive (data) {
        var departList = []
        for (var i in data) {
          if (data[i].children == null) {
            delete data[i].children;
          } else {
            this.recursive(data[i].children)
          }
        }
      },
      //重置查询表单
      resetForm (formName) {
        this.$refs[formName].resetFields()
        this.treeSelectValue = null
      },
      //创建时间格式转换
      formatCreateTime (row, column) {
        return formatDate(row.createTime)
      },
      //审核时间格式转换
      formatAuditTime (row, column) {
        return formatDate(row.auditTime)
      },
      //变量部门树，获取对应的部门名称
      getDeptName (data, id) {
        //console.log(id)
        var temp = "";
        for (var i in data) {
            if (data[i].id == id) {
              temp = data[i].label;
              break;
            }
            if (data[i].children != undefined || data[i].children != null) {
             temp = this.getDeptName(data[i].children, id);
             if(temp !=""){
               break;
             }
          }
        }
        return temp;
      },
      //部门代码-> 部门名称
      formatDept (row, column) {
        var deptName = "";
       // console.log(this.departTree.toString());
        if (row.deptCode != null && row.deptCode != '') {
          deptName = this.getDeptName(this.departTree, row.deptCode);
         // console.log("format:"+row.deptCode+"----"+deptName)
          return deptName;
        } else {
          return deptName;
        }
      },
      // 用户信息同步
      userSynchronize(){
        this.loading = true;
        userSynchronize().then(res=>{
          if (res.success || res.success == 'true') {
                this.editVisible = false
                this.isAdd = false;
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
            this.loading = false;
          }
        })
      }
    },
    mounted () {
      this.search();
      this.preSearchRole();
    }
  }
</script>
