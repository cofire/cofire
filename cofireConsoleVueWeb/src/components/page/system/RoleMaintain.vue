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
        @click="search('click')"
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
        border=""
        highlight-current-row
        :data="tableData"
        @current-change="handleCurrentChange"
        @row-dblclick="handleDblclick"
        style="width: 100%"
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
        background=""
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryRole.page"
        :page-sizes="GLOBAL.pageSizes"
        :page-size="queryRole.limit"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </el-row>
    <!-- 编辑弹出框 -->
    <el-row>
      <el-dialog :title="title" :visible.sync="editVisible" width="40%">
        <el-form
          ref="editForm"
          :rules="rules"
          :model="editRole"
          label-width="100px"
          :disabled="formDisabled"
        >
          <el-form-item :label="$t('role.label.roleId')" prop="roleId">
            <el-input v-model="editRole.roleId" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="$t('role.label.roleName')" prop="roleName">
            <el-input v-model="editRole.roleName"></el-input>
          </el-form-item>
          <el-form-item :label="$t('role.label.description')" prop="description">
            <el-input v-model="editRole.description"></el-input>
          </el-form-item>
          <el-form-item :label="$t('role.label.permission')" prop="permission">
            <!--树形结构                               :check-strictly="checkStrictly"-->
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
          <el-button @click="editVisible = false">取 消</el-button>
          <el-button type="primary" @click="save('editForm')">确 定</el-button>
        </span>
      </el-dialog>
    </el-row>
  </el-row>
</template>
<script>
import { SysRoleModel } from "../../model/system/SysRoleModel";
import { queryRole, saveRole, deleteRole, getRoleTree } from "@/api/getData";

export default {
  name: "RoleMaintain",
  data() {
    return {
      queryRole: new SysRoleModel(),
      editRole: new SysRoleModel(),
      deleteRoleModel: new SysRoleModel(),
      total: 0,
      tableData: [],
      editVisible: false,
      title: "角色新增",
      formDisabled: false /** 为true时，整个表单不可编辑 */,
      disabled: false /** 为true时，编辑时某些字段不可编辑 */,
      resourceTree: [],
      treeChecked: [],
      rules: {
        roleId: [{ required: true, message: "角色代码", trigger: "blur" }],
        roleName: [{ required: true, message: "角色名称", trigger: "blur" }]
      },
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
      this.queryRole.limit = val;
      this.search();
    },
    handlePageChange(val) {
      this.queryRole.page = val;
      this.search();
    },
    handleDblclick(val) {
      this.edit();
    },
    search(type) {
      if (!this.isBlank(type)) {
        this.queryRole.page = 1;
      }
      queryRole(this.queryRole).then(res => {
        if (res.success || res.success == "true") {
          this.total = res.total;
          this.tableData = res.data;
        } else {
          this.$message({
            type: "error",
            message: res.msg
          });
        }
      });
    },
    add() {
      this.editRole = new SysRoleModel();
      this.editRole.saveFlag = "add";
      this.title = "角色新增";
      this.editVisible = true;
      this.disabled = false;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
      this.getRoleTree();
    },
    edit() {
      if (this.currentRow == null || this.currentRow == undefined) {
        this.$message({
          type: "warning",
          message: "请选中需要修改的记录！"
        });
        return;
      }
      this.disabled = true;
      this.editRole = this.copyObject(this.currentRow, this.editRole);
      this.editRole.saveFlag = "update";
      this.title = "角色编辑";

      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
      this.editVisible = true;
      this.getRoleTree();
    },
    save(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          this.editRole.permission = this.$refs.tree.getCheckedKeys();
          saveRole(this.editRole).then(res => {
            if (res.success || res.success == "true") {
              this.editVisible = false;
              this.$message({
                type: "success",
                message: res.retMessage
              });
              this.search();
            } else {
              this.$message({
                type: "error",
                message: res.retMessage
              });
            }
          });
        } else {
          console.log("验证失败");
        }
      });
    },
    //删除角色信息
    deleteRole() {
      debugger;
      if (this.currentRow == null || this.currentRow == undefined) {
        this.$message({
          type: "warning",
          message: this.$t("role.message.deleteSelect")
        });
        return;
      }
      this.$confirm(
        this.$t("role.label.deleteInfo"),
        this.$t("role.label.tip"),
        {
          confirmButtonText: this.$t("role.button.confirm"),
          cancelButtonText: this.$t("role.button.cancel"),
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
              this.$message({
                type: "success",
                message: this.$t("code." + res.code)
              });
              this.search();
            } else {
              this.$message({
                type: "error",
                message: this.$t("code." + res.code)
              });
            }
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: this.$t("role.message.cancelDelete")
          });
        });
    },
    getRoleTree() {
      var roleId = "";
      if (this.currentRow != undefined && this.currentRow != null) {
        roleId = this.currentRow.roleId;
      }
      getRoleTree({ roleId: roleId }).then(res => {
        if (res.success) {
          this.resourceTree = res.data.resourceTree;
          this.treeChecked = res.data.checked;
          console.log(this.resourceTree);
        } else {
          this.$message({
            type: "error",
            message: this.$t("common.code." + res.code)
          });
        }
      });
    }
  },
  mounted() {
    this.search();
  }
};
</script>
