<template>
  <el-row>
    <el-row class="query-form">
      <el-form :inline="true" :model="queryDict" ref="queryForm">
        <el-form-item :label="$t('dict.label.groupId')" prop="groupId" class="queryCondition">
          <el-input v-model="queryDict.groupId" :placeholder="$t('dict.label.groupId')"></el-input>
        </el-form-item>
        <el-form-item :label="$t('dict.label.dictValue')" prop="dictValue" class="queryCondition">
          <el-input v-model="queryDict.dictValue" :placeholder="$t('dict.label.dictValue')"></el-input>
        </el-form-item>
        <el-form-item :label="$t('dict.label.dictNameCn')" prop="dictNameCn" class="queryCondition">
          <el-input v-model="queryDict.dictNameCn" :placeholder="$t('dict.label.dictNameCn')"></el-input>
        </el-form-item>
        <el-form-item :label="$t('dict.label.dictNameEn')" prop="dictNameEn" class="queryCondition">
          <el-input v-model="queryDict.dictNameEn" :placeholder="$t('dict.label.dictNameEn')"></el-input>
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
        @click="deleteDict()"
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
        :data="dictTable.data"
        @current-change="handleCurrentChange"
        @row-dblclick="handleDblclick"
        :border = "dictTable.border"
        v-loading="dictTable.loading"
        :element-loading-text="dictTable.text"
        :element-loading-spinner="dictTable.spinner"
        :element-loading-background="dictTable.background"
      >
        <el-table-column type="index" :label="this.$t('common.label.index')" width="60"></el-table-column>
        <el-table-column property="groupId" :label="this.$t('dict.label.groupId')" width="200"></el-table-column>
        <el-table-column property="groupName" :label="this.$t('dict.label.groupName')" width="200"></el-table-column>
        <el-table-column property="dictValue" :label="this.$t('dict.label.dictValue')" width="250"></el-table-column>
      =  <el-table-column property="dictNameCn" :label="this.$t('dict.label.dictNameCn')" width="200"></el-table-column>
        <el-table-column property="dictNameEn" :label="this.$t('dict.label.dictNameEn')" width="200"></el-table-column>
        <el-table-column property="modifyUser" :label="this.$t('dict.label.modifier')" width="200"></el-table-column>
        <el-table-column
          property="modifyTime"
          :label="this.$t('dict.label.modifyTime')"
          width="200"
          :formatter="formatTableTime"
        ></el-table-column>
      </el-table>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryDict.page"
        :page-sizes="dictTable.pageSizes"
        :page-size="queryDict.length"
        :layout="dictTable.layout"
        :total="dictTable.total"
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
          :model="editDict"
          label-width="140px"
          :disabled="editDialog.formDisabled"
        >
          <el-form-item :label="this.$t('dict.label.groupId')" prop="groupId">
            <el-input v-model="editDict.groupId" :disabled="editDialog.disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('dict.label.groupName')" prop="groupName">
            <el-input v-model="editDict.groupName" :disabled="editDialog.disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('dict.label.dictValue')" prop="dictValue">
            <el-input v-model="editDict.dictValue" :disabled="editDialog.disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('dict.label.dictNameCn')" prop="dictNameCn">
            <el-input v-model="editDict.dictNameCn"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('dict.label.dictNameEn')" prop="dictNameEn">
            <el-input v-model="editDict.dictNameEn"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="editDialog.visible = false">{{this.$t('common.button.cancel')}}</el-button>
          <el-button v-if="editDialog.isDetail == false" type="primary" @click="save('editForm')">{{this.$t('common.button.save')}}</el-button>
        </span>
      </el-dialog>
    </el-row>
  </el-row>
</template>
<script>
import { SysDictModel } from "../../model/system/SysDictModel";
import { queryDict, saveDict, deleteDict } from "../../../api/getData";
import { Rules } from "../../rules/Rules";

export default {
  name: "DictMaintain",
  data() {
    return {
      queryDict: new SysDictModel(),
      editDict: new SysDictModel(),
      deleteDictModel: new SysDictModel(),
      dictTable: new this.TableModel(),
      editDialog: new this.DialogModel(),
      rules: Rules.DictRules
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentRow = val;
    },
    handleSizeChange(val) {
      this.queryDict.length = val;
      this.query();
    },
    handlePageChange(val) {
      this.queryDict.page = val;
      this.query();
    },
    handleDblclick(val) {
      this.detail();
    },
    query(type) {
      if (!this.isBlank(type)) {
        this.queryDict.page = 1;
      }
      this.dictTable.loading = true;
      queryDict(this.queryDict).then(res => {
        if (res.success || res.success == "true") {
          this.dictTable.total = res.total;
          this.dictTable.data = res.data;
        } else {
          this.$message.error(this.$t("code." + res.code));
        }
        this.dictTable.loading = false;
      });
    },
    add() {
      this.editDict = new SysDictModel();
      this.editDict.operation = this.GLOBAL.operation.add;
      this.editDialog.title = this.$t("dict.title.add");
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
        this.$message.warning(this.$t("dict.message.edit"));
        return;
      }
      this.editDialog.disabled = true;
      this.editDialog.formDisabled = false;
      this.editDialog.isDetail = false;
      this.editDict = this.copyObject(this.currentRow, this.editDict);
      this.editDict.operation = this.GLOBAL.operation.update;
      this.editDialog.title = this.$t("dict.title.edit");
      this.editDialog.visible = true;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
    },
    detail() {
      this.editDict = this.currentRow;
      this.editDialog.title = this.$t("dict.title.detail");
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
          saveDict(this.editDict).then(res => {
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
    //删除数据字典信息
    deleteDict() {
      if (this.isBlank(this.currentRow)) {
        this.$message.warning(this.$t("dict.message.deleteSelect"));
        return;
      }
      this.$confirm(
        this.$t("dict.message.deletePrompt"),
        this.$t("common.label.prompt"),
        {
          confirmButtonText: this.$t("common.button.confirm"),
          cancelButtonText: this.$t("common.button.cancel"),
          type: "warning"
        }
      )
        .then(() => {
          this.deleteDictModel = this.copyObject(
            this.currentRow,
            this.deleteDictModel
          );
          deleteDict(this.deleteDictModel).then(res => {
            if (res.success || res.success == "true") {
              this.$message.success(this.$t("code." + res.code));
              this.query();
            } else {
              this.$message.error(this.$t("code." + res.code));
            }
          });
        })
        .catch(() => {
          this.$message.info(this.$t("dict.message.cancelDeletePrompt"));
        });
    }
  },
  mounted() {
    this.query();
  }
};
</script>
