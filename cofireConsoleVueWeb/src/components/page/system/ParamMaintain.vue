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
      <el-form :inline="true" :model="queryParam" ref="queryForm">
          <el-form-item :label="$t('param.label.groupId')" prop="groupId" class='queryCondition'>
            <el-input :placeholder="$t('param.label.groupId')" v-model="queryParam.groupId"></el-input>
          </el-form-item>
          <el-form-item :label="$t('param.label.paramId')" prop="paramId" class='queryCondition'>
            <el-input :placeholder="$t('param.label.paramId')" v-model="queryParam.paramId"></el-input>
          </el-form-item>
          <el-form-item :label="$t('param.label.paramName')" prop="paramName" class='queryCondition'>
            <el-input :placeholder="$t('param.label.paramName')" v-model="queryParam.paramName"></el-input>
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
        @click="deleteParam()"
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
        <el-table-column property="groupId" :label="this.$t('param.label.groupId')" width="200"></el-table-column>
        <el-table-column property="paramId" :label="this.$t('param.label.paramId')" width="200"></el-table-column>
        <el-table-column property="paramValue" :label="this.$t('param.label.paramValue')" width="250"></el-table-column>
        <el-table-column property="paramName" :label="this.$t('param.label.paramName')" width="200"></el-table-column>
        <el-table-column property="modifier" :label="this.$t('param.label.modifier')" width="200"></el-table-column>
        <el-table-column property="modifyTime" :label="this.$t('param.label.modifyTime')" width="200"></el-table-column>
      </el-table>
      <el-pagination
        background=""
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryParam.page"
        :page-sizes="pageSizes"
        :page-size="queryParam.limit"
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
          :model="editParam"
          label-width="100px"
          :disabled="formDisabled"
        >
          <el-form-item :label="this.$t('param.label.groupId')" prop="groupId">
            <el-input v-model="editParam.groupId" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('param.label.paramId')" prop="paramId">
            <el-input v-model="editParam.paramId" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('param.label.paramValue')" prop="paramValue">
            <el-input v-model="editParam.paramValue" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('param.label.paramName')" prop="paramName">
            <el-input v-model="editParam.paramName"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="editVisible = false">{{this.$t('common.button.cancel')}}</el-button>
          <el-button type="primary" @click="save('editForm')">确定</el-button>
        </span>
      </el-dialog>
    </el-row>
  </el-row>
</template>
<script>
import { SysParamModel } from "../../model/system/SysParamModel";
import { pageSizes, pageSize } from "../../common/global";
import { queryParam, saveParam, deleteParam } from "../../../api/getData";
import { copyObject } from "../../common/util";
export default {
  name: "ParamMaintain",
  data() {
    return {
      queryParam: new SysParamModel(),
      editParam: new SysParamModel(),
      deleteParamModel: new SysParamModel(),
      pageSizes: pageSizes,
      total: 0,
      tableData: [],
      editVisible: false,
      title: "系统参数新增",
      formDisabled: false /** 为true时，整个表单不可编辑 */,
      disabled: false /** 为true时，编辑时某些字段不可编辑 */,
      rules: {
        paramId: [{ required: true, message: "系统参数代码", trigger: "blur" }],
        paramName: [{ required: true, message: "系统参数名称", trigger: "blur" }]
      }
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentRow = val;
    },
    handleSizeChange(val) {
      this.queryParam.limit = val;
      this.search();
    },
    handlePageChange(val) {
      this.queryParam.page = val;
      this.search();
    },
    handleDblclick(val) {
      this.edit();
    },
    search() {
      queryParam(this.queryParam).then(res => {
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
      this.editParam = new SysParamModel();
      this.editParam.saveFlag = "add";
      this.title = "系统参数新增";
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
      this.editParam = copyObject(this.currentRow, this.editParam);
      this.editParam.saveFlag = "update";
      this.title = "系统参数编辑";
      this.editVisible = true;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
    },
    save(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          saveParam(this.editParam).then(res => {
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
    //删除系统参数信息
    deleteParam() {
      debugger
      if (this.currentRow == null || this.currentRow == undefined) {
        this.$message({
          type: "warning",
          message: this.$t("param.message.deleteSelect")
        });
        return;
      }
      this.$confirm(
        this.$t("param.label.deleteInfo"),
        this.$t("param.label.tip"),
        {
          confirmButtonText: this.$t("param.button.confirm"),
          cancelButtonText: this.$t("param.button.cancel"),
          type: "warning"
        }
      )
        .then(() => {
          this.deleteParamModel = copyObject(this.currentRow, this.deleteParamModel);
          deleteParam(this.deleteParamModel).then(res => {
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
            message: this.$t("param.message.cancelDelete")
          });
        });
    }
  },
  mounted() {
    this.search();
  }
};
</script>
