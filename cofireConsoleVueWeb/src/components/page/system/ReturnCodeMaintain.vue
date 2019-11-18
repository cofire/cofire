<template>
  <el-row>
    <el-row class="query-form">
      <el-form :inline="true" :model="queryReturnCode" ref="queryForm">
        <el-form-item :label="$t('returnCode.label.code')" prop="groupId" class="queryCondition">
          <el-input v-model="queryReturnCode.code" :placeholder="$t('returnCode.label.code')"></el-input>
        </el-form-item>
        <el-form-item :label="$t('returnCode.label.message')" prop="message" class="queryCondition">
          <el-input v-model="queryReturnCode.message" :placeholder="$t('returnCode.label.message')"></el-input>
        </el-form-item>
      </el-form>
    </el-row>
    <el-row class="table-operations">
      <el-button
        type="primary"
        icon="el-icon-search"
        @click="query('click')"
      >{{$t('common.button.query')}}</el-button>
      <el-button
        type="primary"
        icon="el-icon-circle-plus-outline"
        @click="add()"
      >{{$t('common.button.add')}}</el-button>
      <el-button type="primary" icon="el-icon-edit-outline" @click="edit()">{{$t('common.button.edit')}}</el-button>
      <el-button
        type="primary"
        icon="el-icon-delete"
        @click="deleteReturnCode()"
      >{{$t('common.button.delete')}}</el-button>
      <el-button
        type="primary"
        icon="el-icon-refresh-right"
        @click="resetForm($refs['queryForm'])"
      >{{$t('common.button.reset')}}</el-button>
    </el-row>
    <el-row class="table-result">
      <el-table
        ref="singleTable"
        highlight-current-row
        :data="returnCodeTable.data"
        @current-change="handleCurrentChange"
        @row-dblclick="handleDblclick"
        :border="returnCodeTable.border"
        v-loading="returnCodeTable.loading"
        :element-loading-text="returnCodeTable.text"
        :element-loading-spinner="returnCodeTable.spinner"
        :element-loading-background="returnCodeTable.background"
      >
        <el-table-column type="index" :label="this.$t('common.label.index')" width="60"></el-table-column>
        <el-table-column property="code" :label="this.$t('returnCode.label.code')" width="200"></el-table-column>
        <el-table-column
          property="message"
          :label="this.$t('returnCode.label.message')"
          width="200"
        ></el-table-column>
        <el-table-column property="remark" :label="this.$t('returnCode.label.remark')" width="200"></el-table-column>
        <el-table-column
          property="modifyTime"
          :label="this.$t('returnCode.label.modifyTime')"
          width="200"
          :formatter="formatTableTime"
        ></el-table-column>
        <el-table-column
          property="modifier"
          :label="this.$t('returnCode.label.modifier')"
          width="200"
        ></el-table-column>
        <el-table-column
          property="modifyTime"
          :label="this.$t('returnCode.label.modifyTime')"
          width="200"
          :formatter="formatTableTime"
        ></el-table-column>
      </el-table>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryReturnCode.page"
        :page-sizes="returnCodeTable.pageSizes"
        :page-size="queryReturnCode.length"
        :layout="returnCodeTable.layout"
        :total="returnCodeTable.total"
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
          :model="editReturnCode"
          label-width="120px"
          :disabled="editDialog.formDisabled"
        >
          <el-form-item :label="this.$t('returnCode.label.code')" prop="code">
            <el-input v-model="editReturnCode.code" :disabled="editDialog.disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('returnCode.label.message')" prop="message">
            <el-input v-model="editReturnCode.message"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('returnCode.label.remark')" prop="remark">
            <el-input v-model="editReturnCode.remark"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="editDialog.visible = false">{{this.$t('common.button.cancel')}}</el-button>
          <el-button
            v-if="editDialog.isDetail == false"
            type="primary"
            @click="save('editForm')"
          >{{this.$t('common.button.save')}}</el-button>
        </span>
      </el-dialog>
    </el-row>
  </el-row>
</template>
<script>
import { SysReturnCodeModel } from "../../model/system/SysReturnCodeModel";
import {
  queryReturnCode,
  saveReturnCode,
  deleteReturnCode
} from "../../../api/getData";
import { Rules } from "../../rules/Rules";

export default {
  name: "ReturnCodeMaintain",
  data() {
    return {
      queryReturnCode: new SysReturnCodeModel(),
      editReturnCode: new SysReturnCodeModel(),
      deleteReturnCodeModel: new SysReturnCodeModel(),
      returnCodeTable: new this.TableModel(),
      editDialog: new this.DialogModel(),
      rules: Rules.ReturnCodeRules
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentRow = val;
    },
    handleSizeChange(val) {
      this.queryReturnCode.length = val;
      this.query();
    },
    handlePageChange(val) {
      this.queryReturnCode.page = val;
      this.query();
    },
    handleDblclick(val) {
      this.detail();
    },
    query(type) {
      if (!this.isBlank(type)) {
        this.queryReturnCode.page = 1;
      }
      this.returnCodeTable.loading = true;
      queryReturnCode(this.queryReturnCode).then(res => {
        if (res.success || res.success == "true") {
          this.returnCodeTable.total = res.total;
          this.returnCodeTable.data = res.data;
        } else {
          this.$message.error(this.$t("code." + res.code));
        }
        this.returnCodeTable.loading = false;
      });
    },
    add() {
      this.editReturnCode = new SysReturnCodeModel();
      this.editReturnCode.operation = this.GLOBAL.operation.add;
      this.editDialog.title = this.$t("returnCode.title.add");
      this.editDialog.visible = true;
      this.editDialog.formDisabled = false;
      this.editDialog.isDetail = false;
      this.editDialog.disabled = false;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
    },
    edit() {
      if (this.isBlank(this.currentRow)) {
        this.$message.warning(this.$t("returnCode.message.edit"));
        return;
      }
      this.editDialog.disabled = true;
      this.editDialog.formDisabled = false;
      this.editDialog.isDetail = false;
      this.editReturnCode = this.copyObject(
        this.currentRow,
        this.editReturnCode
      );
      this.editReturnCode.operation = this.GLOBAL.operation.update;
      this.editDialog.title = this.$t("returnCode.title.edit");
      this.editDialog.visible = true;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
    },
    detail() {
      this.editReturnCode = this.currentRow;
      this.editDialog.title = this.$t("returnCode.title.detail");
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
          saveReturnCode(this.editReturnCode).then(res => {
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
    //删除返回码信息
    deleteReturnCode() {
      if (this.isBlank(this.currentRow)) {
        this.$message.warning(this.$t("returnCode.message.deleteSelect"));
        return;
      }
      this.$confirm(
        this.$t("returnCode.message.deletePrompt"),
        this.$t("common.label.prompt"),
        {
          confirmButtonText: this.$t("common.button.confirm"),
          cancelButtonText: this.$t("common.button.cancel"),
          type: "warning"
        }
      )
        .then(() => {
          this.deleteReturnCodeModel = this.copyObject(
            this.currentRow,
            this.deleteReturnCodeModel
          );
          this.deleteReturnCodeModel.operation = this.GLOBAL.operation.delete;
          deleteReturnCode(this.deleteReturnCodeModel).then(res => {
            if (res.success || res.success == "true") {
              this.$message.success(this.$t("code." + res.code));
              this.query("delete");
            } else {
              this.$message.error(this.$t("code." + res.code));
            }
          });
        })
        .catch(() => {
          this.$message.info(this.$t("returnCode.message.cancelDeletePrompt"));
        });
    }
  },
  mounted() {
    this.query();
  }
};
</script>

