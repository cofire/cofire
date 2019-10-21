<template>
  <el-row>
    <el-row class="query-form">
      <el-form :inline="true" :model="queryUser" ref="queryForm">
        <el-col :span="6">
          <el-form-item :label="$t('user.label.userId')" prop="userId">
            <el-input v-model="queryUser.userId" :placeholder="$t('user.label.userId')"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item :label="$t('user.label.userName')" prop="userName">
            <el-input v-model="queryUser.userName" :placeholder="$t('user.label.userName')"></el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row class="table-operations">
      <el-button type="primary" icon="el-icon-lx-search" @click="search()">查询</el-button>
      <el-button type="primary" icon="el-icon-lx-roundadd" @click="add()">新增</el-button>
      <el-button type="primary" icon="el-icon-lx-edit" @click="edit()">修改</el-button>
      <el-button
        type="primary"
        icon="el-icon-lx-delete"
        @click="deleteUser()"
      >{{this.$t('common.button.delete')}}</el-button>
      <el-button type="primary" icon="el-icon-lx-settings" @click="roleSet()">角色设置</el-button>
      <el-button type="primary" icon="el-icon-lx-refresh" @click="confirmRestPassWord()">密码重置</el-button>
      <el-button
        type="primary"
        icon="el-icon-lx-refresh"
        @click="resetForm($refs['queryForm'])"
      >{{$t('common.button.reset')}}</el-button>
    </el-row>
    <el-row class="table-result">
      <el-table
        ref="singleTable"
        border=""
        highlight-current-row
        :data="tableData"
        @current-change="handleCurrentChange"
        @row-dblclick="handleDblclick"
        style="width: 100%"
      >
        <el-table-column type="index" :label="this.$t('common.label.index')" width="60"></el-table-column>
        <el-table-column property="userId" :label="$t('user.label.userId')" width="200"></el-table-column>
        <el-table-column property="userName" :label="$t('user.label.userName')" width="200"></el-table-column>
        <el-table-column property="modifier" :label="$t('user.label.modifier')" width="200"></el-table-column>
        <el-table-column
          property="modifyTime"
          :label="$t('user.label.modifyTime')"
          width="200"
          :formatter="formatTableTime"
        ></el-table-column>
      </el-table>
      <el-pagination
        background=""
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryUser.page"
        :page-sizes="pageSizes"
        :page-size="queryUser.limit"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </el-row>
    <!-- 编辑弹出框 -->
    <el-row>
      <el-dialog :title="title" :visible.sync="editVisible" width="30%">
        <el-form
          ref="editForm"
          :rules="rules"
          :model="editUser"
          label-width="100px"
          :disabled="formDisabled"
        >
          <el-form-item :label="$t('user.label.userId')" prop="userId">
            <el-input v-model="editUser.userId" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="$t('user.label.userName')" prop="userName">
            <el-input v-model="editUser.userName"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="editVisible = false">取 消</el-button>
          <el-button type="primary" @click="save('editForm')">确 定</el-button>
        </span>
      </el-dialog>
    </el-row>
    <!-- 角色设置 -->
    <el-row>
      <el-dialog
        :title="$t('user.title.roleSet')"
        :visible.sync="roleSetVisible"
        :close-on-click-modal="false"
        width="60%"
      >
        <el-row class="query-form">
          <el-form :inline="true" :model="queryRoleModel" ref="queryRoleForm">
            <el-col :span="12">
              <el-form-item :label="$t('role.label.roleId')" prop="roleId">
                <el-input v-model="queryRoleModel.roleId" :placeholder="$t('role.label.roleId')"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item :label="$t('role.label.roleName')" prop="roleName">
                <el-input
                  v-model="queryRoleModel.roleName"
                  :placeholder="$t('role.label.roleName')"
                ></el-input>
              </el-form-item>
            </el-col>
          </el-form>
        </el-row>
        <!-- 角色列表 -->
        <el-row class="table-operations">
          <el-button type="primary" @click="queryRole()">{{$t('common.button.query')}}</el-button>
          <el-button
            type="primary"
            @click="roleSetVisible = false"
          >{{this.$t('common.button.cancel')}}</el-button>
          <el-button type="primary" @click="saveUserRole()">{{this.$t('common.button.save')}}</el-button>
          <el-button
            type="primary"
            @click="resetForm($refs['queryRoleForm'])"
          >{{$t('common.button.reset')}}</el-button>
        </el-row>
        <el-row class="table-result">
          <el-table
            ref="userRoleTable"
            :data="roleTableData"
            tooltip-effect="dark"
            style="width: 100%"
            height="400"
            border=""
            @selection-change="handleSelectionChange"
          >
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column prop="roleId" :label="$t('role.label.roleId')" width="200"></el-table-column>
            <el-table-column prop="roleName" :label="$t('role.label.roleName')" width="200"></el-table-column>
            <el-table-column
              prop="description"
              :label="$t('role.label.description')"
              show-overflow-tooltip
            ></el-table-column>
          </el-table>
        </el-row>
      </el-dialog>
    </el-row>
  </el-row>
</template>
<script>
import { SysUserModel } from "../../model/system/SysUserModel";
import { SysRoleModel } from "../../model/system/SysRoleModel";
import { pageSizes, pageSize } from "../../common/global";
import {
  queryUser,
  saveUser,
  queryRole,
  queryUserRoleList,
  saveUserRole,
  restPassWord,
  deleteUser
} from "../../../api/getData";
import { copyObject } from "../../common/util";
import { Rules } from "../../rules/Rules";
export default {
  name: "UserMaintain",
  data() {
    return {
      queryUser: new SysUserModel(),
      editUser: new SysUserModel(),
      queryRoleModel: new SysRoleModel(),
      roleSetUser: new SysUserModel(),
      userRoleList: [],
      pageSizes: pageSizes,
      total: 0,
      tableData: [],
      roleTableData: [],
      editVisible: false,
      roleSetVisible: false,
      title: "$t('user.title.add')",
      formDisabled: false /** 为true时，整个表单不可编辑 */,
      disabled: false /** 为true时，编辑时某些字段不可编辑 */,
      multipleSelection: [],
      rules: Rules.UserRules
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentRow = val;
    },
    handleSizeChange(val) {
      this.queryUser.limit = val;
      this.search();
    },
    handlePageChange(val) {
      this.queryUser.page = val;
      this.search();
    },
    handleDblclick(val) {
      this.edit();
    },
    handleSelectionChange(val) {
      this.userRoleList = val;
    },
    search() {
      queryUser(this.queryUser).then(res => {
        if (res.success || res.success == "true") {
          this.total = res.total;
          this.tableData = res.data;
        } else {
          this.$message.error(res.msg);
        }
      });
    },
    add() {
      this.editUser = new SysUserModel();
      this.editUser.saveFlag = "add";
      this.title = this.$t("user.title.add");
      this.editVisible = true;
      this.disabled = false;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
    },
    edit() {
      if (this.currentRow == undefined || this.currentRow == null) {
        this.$message.warning(this.$t("user.message.edit"));
        return;
      }
      this.disabled = true;
      this.editUser = copyObject(this.currentRow, this.editUser);
      this.editUser.saveFlag = "update";
      this.title = this.$t("user.title.edit");
      this.editVisible = true;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
    },
    save(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          saveUser(this.editUser).then(res => {
            if (res.success || res.success == "true") {
              this.editVisible = false;
              this.$message.success(this.$t("code." + res.code));
              this.search();
            } else {
              this.$message.error(this.$t("code." + res.code));
            }
          });
        } else {
          this.$message.warning(this.$t("common.message.paramInvalid"));
        }
      });
    },
    roleSet() {
      if (this.currentRow == undefined || this.currentRow == null) {
        this.$message.warning(this.$t("user.message.roleSet"));
        return;
      }
      this.roleSetUser = copyObject(this.currentRow, this.roleSetUser);
      this.title = this.$t("user.label.roleSet");
      this.roleSetVisible = true;
      this.queryRole();
    },
    queryRole() {
      queryRole(this.queryRoleModel).then(res => {
        if (res.success || res.success == "true") {
          this.roleTableData = res.data;
          this.queryUserRole();
        } else {
          this.$message.error(this.$t("code." + res.code));
        }
      });
    },
    queryUserRole() {
      queryUserRoleList(this.roleSetUser).then(res => {
        if (res.success || res.success == "true") {
          var userRoleList = res.data;
          this.roleTableData.forEach(data1 => {
            userRoleList.forEach(data2 => {
              if (data1.roleId == data2.roleId) {
                this.$refs["userRoleTable"].toggleRowSelection(data1, true);
              }
            });
          });
        } else {
          this.$message.error(this.$t("code." + res.code));
        }
      });
    },
    saveUserRole() {
      var roleIdList = [];
      this.userRoleList.forEach(role => {
        roleIdList.push(role.roleId);
      });
      saveUserRole({
        userId: this.roleSetUser.userId,
        roleIds: roleIdList
      }).then(res => {
        if (res.success || res.success == "true") {
          this.roleSetVisible = false;
          this.$message.success(this.$t("code." + res.code));
        } else {
          this.$message.error(this.$t("code." + res.code));
        }
      });
    },
    confirmRestPassWord() {
      var resetPawUser = new SysUserModel();
      if (this.currentRow == undefined || this.currentRow == null) {
        this.$message.warning(this.$t("user.message.restPassWord"));
        return;
      }
      this.$confirm(
        this.$t("user.message.restPassWordPrompt"),
        this.$t("common.label.prompt"),
        {
          confirmButtonText: this.$t("common.button.confirm"),
          cancelButtonText: this.$t("common.button.cancel"),
          type: "warning"
        }
      )
        .then(() => {
          restPassWord({ userId: this.currentRow.userId }).then(res => {
            if (res.success || res.success == "true") {
              this.$alert(
                this.$t("user.message.returnNewPasswInfo") + res.data,
                this.$t("common.label.prompt"),
                {
                  confirmButtonText: this.$t("common.button.confirm"),
                  callback: action => {}
                }
              );
            } else {
              this.$message({
                type: "error",
                message: this.$t("common.code." + res.code)
              });
            }
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: this.$t("user.message.cancelPassWordPrompt")
          });
        });
    },
    deleteUser() {
      if (this.currentRow == undefined || this.currentRow == null) {
        this.$message.warning(this.$t("user.message.delete"));
        return;
      }
      this.$confirm(
        this.$t("user.message.deletePrompt"),
        this.$t("common.label.prompt"),
        {
          confirmButtonText: this.$t("common.button.confirm"),
          cancelButtonText: this.$t("common.button.cancel"),
          type: "warning"
        }
      )
        .then(() => {
          deleteUser({ userId: this.currentRow.userId }).then(res => {
            if (res.success || res.success == "true") {
              this.$message.success(this.$t("code." + res.code));
              this.query();
            } else {
              this.$message.error(this.$t("code." + res.code));
            }
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: this.$t("user.message.cancelDeletePrompt")
          });
        });
    }
  },
  mounted() {
    this.search();
  }
};
</script>
