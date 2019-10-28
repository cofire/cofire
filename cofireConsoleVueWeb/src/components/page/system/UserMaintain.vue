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
      <el-button
        type="primary"
        icon="el-icon-lx-search"
        @click="query('click')"
      >{{$t('common.button.query')}}</el-button>
      <el-button
        type="primary"
        icon="el-icon-lx-roundadd"
        @click="add()"
      >{{$t('common.button.add')}}</el-button>
      <el-button type="primary" icon="el-icon-lx-edit" @click="edit()">{{$t('common.button.edit')}}</el-button>
      <el-button
        type="primary"
        icon="el-icon-lx-delete"
        @click="deleteUser()"
      >{{this.$t('common.button.delete')}}</el-button>
      <el-button
        type="primary"
        icon="el-icon-lx-settings"
        @click="roleSet()"
      >{{$t('common.button.roleSet')}}</el-button>
      <el-button
        type="primary"
        icon="el-icon-lx-refresh"
        @click="confirmRestPassWord()"
      >{{$t('common.button.confirmRestPassWord')}}</el-button>
      <el-button
        type="primary"
        icon="el-icon-lx-refresh"
        @click="resetForm($refs['queryForm'])"
      >{{$t('common.button.reset')}}</el-button>
    </el-row>
    <el-row class="table-result">
      <el-table
        ref="singleTable"
        highlight-current-row
        :data="userTable.data"
        @current-change="handleCurrentChange"
        @row-dblclick="handleDblclick"
        style="width: 100%"
        v-loading="userRoleTable.loading"
        :element-loading-text="userRoleTable.text"
        :element-loading-spinner="userRoleTable.spinner"
        :element-loading-background="userRoleTable.background"
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
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryUser.page"
        :page-sizes="userTable.pageSizes"
        :page-size="queryUser.limit"
        :layout="userTable.layout"
        :total="userTable.total"
      ></el-pagination>
    </el-row>
    <!-- 编辑弹出框 -->
    <el-row>
      <el-dialog
        :title="editDialog.title"
        :visible.sync="editDialog.visible"
        :close-on-click-modal="editDialog.close_on_click_modal"
        width="30%"
      >
        <el-form
          ref="editForm"
          :rules="rules"
          :model="editUser"
          label-width="100px"
          :disabled="editDialog.formDisabled"
        >
          <el-form-item :label="$t('user.label.userId')" prop="userId">
            <el-input v-model="editUser.userId" :disabled="editDialog.disabled"></el-input>
          </el-form-item>
          <el-form-item :label="$t('user.label.userName')" prop="userName">
            <el-input v-model="editUser.userName"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="editDialog.visible = false">{{$t("common.button.cancel")}}</el-button>
          <el-button v-if="editDialog.isDetail == false" type="primary" @click="save('editForm')">{{$t("common.button.save")}}</el-button>
        </span>
      </el-dialog>
    </el-row>
    <!-- 角色设置 -->
    <el-row>
      <el-dialog
        :title="$t('user.title.roleSet')"
        :visible.sync="roleSetDialog.visible"
        :close-on-click-modal="roleSetDialog.close_on_click_modal"
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
            @click="roleSetDialog.visible = false"
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
            :data="userRoleTable.data"
            @selection-change="handleSelectionChange"
            v-loading="userRoleTable.loading"
            :element-loading-text="userRoleTable.text"
            :element-loading-spinner="userRoleTable.spinner"
            :element-loading-background="userRoleTable.background"
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
import {
  queryUser,
  saveUser,
  queryRole,
  queryUserRoleList,
  saveUserRole,
  restPassWord,
  deleteUser
} from "../../../api/getData";
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
      userTable: new this.TableModel(),
      userRoleTable: new this.TableModel(),
      editDialog: new this.DialogModel(),
      roleSetDialog: new this.DialogModel(),
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
      this.query();
    },
    handlePageChange(val) {
      this.queryUser.page = val;
      this.query();
    },
    handleDblclick(val) {
      this.detail();
    },
    handleSelectionChange(val) {
      this.userRoleList = val;
    },
    query(type) {
      this.userRoleTable.loading = true;
      if (!this.isBlank(type)) {
        this.queryUser.page = 1;
      }
      this.userTable.loading = true;
      queryUser(this.queryUser).then(res => {
        if (res.success || res.success == "true") {
          this.userTable.total = res.total;
          this.userTable.data = res.data;
        } else {
          this.$message.error(res.msg);
        }
        this.userRoleTable.loading = false;
      });
    },
    add() {
      this.editUser = new SysUserModel();
      this.editUser.saveFlag = "add";
      this.editDialog.title = this.$t("user.title.add");
      this.editDialog.formDisabled = false;
      this.editDialog.isDetail = false;
      this.editDialog.disabled = false;
      this.editDialog.visible = true;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
    },
    edit() {
      if (this.isBlank(this.currentRow)) {
        this.$message.warning(this.$t("user.message.edit"));
        return;
      }
      this.editUser = this.copyObject(this.currentRow, this.editUser);
      this.editUser.saveFlag = "update";
      this.editDialog.title = this.$t("user.title.edit");
      this.editDialog.formDisabled = false;
      this.editDialog.isDetail = false;
      this.editDialog.disabled = true;
      this.editDialog.visible = true;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
    },
    detail() {
      this.editUser = this.currentRow;
      this.editDialog.title = this.$t("user.title.detail");
      this.editDialog.formDisabled = true;
      this.editDialog.isDetail = true;
      this.editDialog.visible = true;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
    },
    save(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          saveUser(this.editUser).then(res => {
            if (res.success || res.success == "true") {
              this.editDialog.visible = false;
              this.$message.success(this.$t("code." + res.code));
              this.query();
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
      if (this.isBlank(this.currentRow)) {
        this.$message.warning(this.$t("user.message.roleSet"));
        return;
      }
      this.roleSetUser = this.copyObject(this.currentRow, this.roleSetUser);
      this.roleSetDialog.title = this.$t("user.title.roleSet");
      this.roleSetDialog.visible = true;
      this.queryRole();
    },
    queryRole() {
      queryRole(this.queryRoleModel).then(res => {
        if (res.success || res.success == "true") {
          this.userRoleTable.data = res.data;
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
          this.userRoleTable.data.forEach(data1 => {
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
          this.roleSetDialog.visible = false;
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
          this.$message.info(this.$t("user.message.cancelDeletePrompt"));
        });
    }
  },
  mounted() {
    this.query();
  }
};
</script>
