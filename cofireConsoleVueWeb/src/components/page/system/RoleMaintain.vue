<template>
  <el-row>
    <el-row class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-calendar"></i>
          {{ $t('common.route.R1') }}
        </el-breadcrumb-item>
        <el-breadcrumb-item>{{ $t('common.route.R12') }}</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
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
        @click="search()"
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
        @click="resetForm('queryForm')"
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
        ></el-table-column>
        <el-table-column property="filler1" :label="this.$t('role.label.filler1')" width="200"></el-table-column>
        <el-table-column property="filler2" :label="this.$t('role.label.filler2')" width="200"></el-table-column>
        <el-table-column property="filler3" :label="this.$t('role.label.filler3')" width="200"></el-table-column>
      </el-table>
      <el-pagination
        background=""
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryRole.page"
        :page-sizes="pageSizes"
        :page-size="queryRole.limit"
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
import { pageSizes, pageSize } from "../../common/global";
import { queryRole, saveRole, deleteRole } from "@/api/getData";
import { copyObject } from "../../common/util";
export default {
  name: "RoleMaintain",
  data() {
    return {
      queryRole: new SysRoleModel(),
      editRole: new SysRoleModel(),
      deleteRoleModel: new SysRoleModel(),
      pageSizes: pageSizes,
      total: 0,
      tableData: [],
      editVisible: false,
      title: "角色新增",
      formDisabled: false /** 为true时，整个表单不可编辑 */,
      disabled: false /** 为true时，编辑时某些字段不可编辑 */,
      rules: {
        roleId: [{ required: true, message: "角色代码", trigger: "blur" }],
        roleName: [{ required: true, message: "角色名称", trigger: "blur" }]
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
    search() {
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
      this.editRole = copyObject(this.currentRow, this.editRole);
      this.editRole.saveFlag = "update";
      this.title = "角色编辑";
      this.editVisible = true;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
    },
    save(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
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
      debugger
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
          this.deleteRoleModel = copyObject(this.currentRow, this.deleteRoleModel);
          deleteRole(this.deleteRoleModel).then(res => {
            if (res.success || res.success == "true") {
              this.$message({
                type: "success",
                message: this.$t("common.code." + res.code)
              });
              this.search();
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
            message: this.$t("role.message.cancelDelete")
          });
        });
    }
  },
  mounted() {
    this.search();
  }
};
</script>
