<template>
  <el-row>
    <el-row class="query-form">
      <el-form :inline="true" :model="queryRole" ref="queryForm">
        <!-- :model="queryRole" ----表单数据对象 -->
        <el-form-item :label="$t('role.label.roleId')" prop="roleId">
          <el-input v-model="queryRole.roleId" :placeholder="$t('role.label.roleId')"></el-input>
        </el-form-item>
        <el-form-item :label="$t('role.label.roleName')" prop="roleName">
          <el-input v-model="queryRole.roleName" :placeholder="$t('role.label.roleName')"></el-input>
        </el-form-item>
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
        @click="deleteRole()"
      >{{$t('common.button.delete')}}</el-button>
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
        :data="roleTable.data"
        @current-change="handleCurrentChange"
        @row-dblclick="handleDblclick"
        :border = "roleTable.border"
        v-loading="roleTable.loading"
        :element-loading-text="roleTable.text"
        :element-loading-spinner="roleTable.spinner"
        :element-loading-background="roleTable.background"
      >
        <el-table-column type="index" :label="this.$t('common.label.index')" width="60"></el-table-column>
        <el-table-column property="roleId" :label="this.$t('role.label.roleId')" width="200"></el-table-column>
        <el-table-column property="roleName" :label="this.$t('role.label.roleName')" width="200"></el-table-column>
        <el-table-column
          property="description"
          :label="this.$t('role.label.description')"
          width="200"
        ></el-table-column>
        <el-table-column property="modifier" :label="this.$t('role.label.modifier')" width="200"></el-table-column>
        <el-table-column
          property="modifyTime"
          :label="this.$t('role.label.modifyTime')"
          width="200"
          :formatter="formatTableTime"
        ></el-table-column>
      </el-table>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryRole.page"
        :page-sizes="roleTable.pageSizes"
        :page-size="queryRole.length"
        :layout="roleTable.layout"
        :total="roleTable.total"
      ></el-pagination>
    </el-row>
    <!-- 编辑弹出框 -->
    <el-row>
      <el-dialog
        :title="editDialog.title"
        :visible.sync="editDialog.visible"
        :close-on-click-modal="editDialog.close_on_click_modal"
        width="40%"
      >
        <el-form
          ref="editForm"
          :rules="rules"
          :model="editRole"
          label-width="100px"
          :disabled="editDialog.formDisabled"
        >
          <el-form-item :label="$t('role.label.roleId')" prop="roleId">
            <el-input v-model="editRole.roleId" :disabled="editDialog.disabled"></el-input>
          </el-form-item>
          <el-form-item :label="$t('role.label.roleName')" prop="roleName">
            <el-input v-model="editRole.roleName"></el-input>
          </el-form-item>
          <el-form-item :label="$t('role.label.description')" prop="description">
            <el-input v-model="editRole.description"></el-input>
          </el-form-item>
          <el-form-item :label="$t('role.label.permission')" prop="permission">
            <div class="el-dialog-div" style="height: 300px">
              <el-tree
                ref="tree"
                :data="resourceTree"
                show-checkbox
                node-key="id"
                :default-checked-keys="treeChecked"
                :props="treeNode"
                highlight-current
              />
            </div>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="editDialog.visible = false">{{$t("common.button.cancel")}}</el-button>
          <el-button v-if="editDialog.isDetail == false" type="primary" @click="save('editForm')">{{$t("common.button.save")}}</el-button>
        </span>
      </el-dialog>
    </el-row>
  </el-row>
</template>
<script>
import { SysRoleModel } from "../../model/system/SysRoleModel";
import { queryRole, saveRole, deleteRole, getRoleTree } from "@/api/getData";
import { Rules } from "../../rules/Rules";

export default {
  name: "RoleMaintain",
  data() {
    return {
      queryRole: new SysRoleModel(),
      editRole: new SysRoleModel(),
      deleteRoleModel: new SysRoleModel(),
      roleTable: new this.TableModel(),
      editDialog: new this.DialogModel(),
      resourceTree: [],
      treeChecked: [],
      rules: Rules.RoleRules,
      treeNode: {
        children: "children",
        label: "name"
      }
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentRow = val;
    },
    handleSizeChange(val) {
      this.queryRole.length = val;
      this.query();
    },
    handlePageChange(val) {
      this.queryRole.page = val;
      this.query();
    },
    handleDblclick(val) {
      this.detail();
    },
    query(type) {
      this.roleTable.loading = true;
      if (!this.isBlank(type)) {
        this.queryRole.page = 1;
      }
      queryRole(this.queryRole).then(res => {
        if (res.success || res.success == "true") {
          this.roleTable.total = res.total;
          this.roleTable.data = res.data;
        } else {
          this.$message.error(this.$t("code." + res.code));
        }
        this.roleTable.loading = false;
      });
    },
    add() {
      this.editRole = new SysRoleModel();
      this.treeChecked = [];
      this.editRole.operation = this.GLOBAL.operation.add;
      this.editDialog.title = this.$t("role.title.add");
      this.editDialog.formDisabled = false;
      this.editDialog.isDetail = false;
      this.editDialog.disabled = false;
      this.editDialog.visible = true;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
      this.getRoleTree();
    },
    edit() {
      if (this.isBlank(this.currentRow)) {
        this.$message.warning(this.$t("role.message.edit"));
        return;
      }
      this.editDialog.formDisabled = false;
      this.editDialog.isDetail = false;
      this.editDialog.disabled = true;
      this.editRole = this.copyObject(this.currentRow, this.editRole);
      this.editRole.operation = this.GLOBAL.operation.update;
      this.editDialog.title = this.$t("role.title.edit");

      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
      this.editDialog.visible = true;
      const roleId = this.currentRow.roleId;
      this.getRoleTree(roleId);
    },
    detail() {
      this.editRole = this.currentRow;
      this.editDialog.title = this.$t("role.title.detail");
      this.editDialog.formDisabled = true;
      this.editDialog.isDetail = true;
      this.editDialog.visible = true;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
      const roleId = this.currentRow.roleId;
      this.getRoleTree(roleId);
    },
    save(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          this.editRole.permission = this.$refs.tree.getCheckedKeys();
          saveRole(this.editRole).then(res => {
            if (res.success || res.success == "true") {
              this.editDialog.visible = false;
              this.$message.success(this.$t("code." + res.code));
              this.query();
            } else {
              this.$message.error(this.$t("code." + res.code));
            }
          });
        } else {
          console.log("验证失败");
        }
      });
    },
    //删除角色信息
    deleteRole() {
      if (this.isBlank(this.currentRow)) {
        this.$message.warning(this.$t("role.message.deleteSelect"));
        return;
      }
      this.$confirm(
        this.$t("role.message.deletePrompt"),
       this.$t("common.label.prompt"),
        {
          confirmButtonText: this.$t("common.button.confirm"),
          cancelButtonText: this.$t("common.button.cancel"),
          type: "warning"
        }
      )
        .then(() => {
          this.deleteRoleModel = this.copyObject(
            this.currentRow,
            this.deleteRoleModel
          );
          deleteRole(this.deleteRoleModel).then(res => {
            if (res.success || res.success == "true") {
              this.$message.success(this.$t("code." + res.code));
              this.query();
            } else {
              this.$message.error(this.$t("code." + res.code));
            }
          });
        })
        .catch(() => {
          this.$message.info(this.$t("role.message.cancelDeletePrompt"));
        });
    },
    getRoleTree(roleId) {
      getRoleTree({ roleId: roleId }).then(res => {
        if (res.success) {
          this.resourceTree = res.data.resourceTree;
          this.treeChecked = res.data.checked;
        } else {
          this.$message.error(this.$t("code." + res.code));
        }
      });
    }
  },
  mounted() {
    this.query();
  }
};
</script>
