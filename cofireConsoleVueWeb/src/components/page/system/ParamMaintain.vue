<template>
  <el-row>
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
        highlight-current-row
        :data="paramTable.data"
        @current-change="handleCurrentChange"
        @row-dblclick="handleDblclick"
        :border = "paramTable.border"
        v-loading="paramTable.loading"
        :element-loading-text="paramTable.text"
        :element-loading-spinner="paramTable.spinner"
        :element-loading-background="paramTable.background"
      >
        <el-table-column type="index" :label="this.$t('common.label.index')" width="60"></el-table-column>
        <el-table-column property="groupId" :label="this.$t('param.label.groupId')" width="200"></el-table-column>
        <el-table-column property="paramId" :label="this.$t('param.label.paramId')" width="200"></el-table-column>
        <el-table-column property="paramValue" :label="this.$t('param.label.paramValue')" width="250"></el-table-column>
        <el-table-column property="paramName" :label="this.$t('param.label.paramName')" width="200"></el-table-column>
         <el-table-column property="canDelete" :label="this.$t('param.label.canDelete')" width="200" :formatter="formatCanDelete"></el-table-column>
        <el-table-column property="modifier" :label="this.$t('param.label.modifier')" width="200"></el-table-column>
        <el-table-column property="modifyTime" :label="this.$t('param.label.modifyTime')" width="200" :formatter="formatTableTime"></el-table-column>
      </el-table>
      <el-pagination
       @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryParam.page"
        :page-sizes="paramTable.pageSizes"
        :page-size="queryParam.limit"
        :layout="paramTable.layout"
        :total="paramTable.total"
      ></el-pagination>
    </el-row>
    <!-- 编辑弹出框 -->
    <el-row>
      <el-dialog :title="editDialog.title" :visible.sync="editDialog.visible" :close-on-click-modal="editDialog.close_on_click_modal" width="30%">
        <el-form
          ref="editForm"
          :rules="rules"
          :model="editParam"
          label-width="100px"
          :disabled="editDialog.formDisabled"
        >
          <el-form-item :label="this.$t('param.label.groupId')" prop="groupId">
            <el-input v-model="editParam.groupId" :disabled="editDialog.disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('param.label.paramId')" prop="paramId">
            <el-input v-model="editParam.paramId" :disabled="editDialog.disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('param.label.paramValue')" prop="paramValue">
            <el-input v-model="editParam.paramValue" :disabled="editDialog.disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('param.label.paramName')" prop="paramName">
            <el-input v-model="editParam.paramName"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('param.label.canDelete')" prop="canDelete">
            <el-radio-group v-model="editParam.canDelete">
              <el-radio label="0">否</el-radio>
              <el-radio label="1">是</el-radio>
            </el-radio-group>
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
import { SysParamModel } from "../../model/system/SysParamModel";
import { queryParam, saveParam, deleteParam } from "../../../api/getData";
import { Rules } from "../../rules/Rules";

export default {
  name: "ParamMaintain",
  data() {
    return {
      queryParam: new SysParamModel(),
      editParam: new SysParamModel(),
      deleteParamModel: new SysParamModel(),
      paramTable: new this.TableModel(),
      editDialog: new this.DialogModel(),
      rules: Rules.ParamRules,
      canDeleteDict: this.getDictByGroup("0003")
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentRow = val;
    },
    handleSizeChange(val) {
      this.queryParam.limit = val;
      this.query();
    },
    handlePageChange(val) {
      this.queryParam.page = val;
      this.query();
    },
    handleDblclick(val) {
      this.detail();
    },
    formatCanDelete(row, column) {
      return this.getDictName(this.canDeleteDict, row[column.property]);
    },
    query(type) {
      if (!this.isBlank(type)) {
        this.queryParam.page = 1;
      }
      this.paramTable.loading = true;
      queryParam(this.queryParam).then(res => {
        if (res.success || res.success == "true") {
          this.paramTable.total = res.total;
          this.paramTable.data = res.data;
        } else {
          this.$message.error(this.$t("code." + res.code));
        }
        this.paramTable.loading = false;
      });
    },
     add() {
      this.editParam = new SysParamModel();
      this.editParam.saveFlag = "add";
      this.editDialog.title = this.$t("param.title.add");
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
        this.$message.warning(this.$t("param.message.edit"));
        return;
      }
      this.editDialog.formDisabled = false;
      this.editDialog.isDetail = false;
      this.editDialog.disabled = true;
      this.editParam = this.copyObject(this.currentRow, this.editParam);
      this.editParam.saveFlag = "update";
      this.editDialog.title = this.$t("param.title.edit");
      this.editDialog.visible = true;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
    },
    detail() {
      this.editParam = this.currentRow;
      this.editDialog.title = this.$t("param.title.detail");
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
          saveParam(this.editParam).then(res => {
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
    //删除系统参数信息
    deleteParam() {
      if (this.isBlank(this.currentRow)) {
        this.$message.warning(this.$t("param.message.deleteSelect"));
        return;
      }
      if(this.isFalse(this.currentRow.canDelete)){
        this.$message.warning(this.$t("param.message.canNotDeletePrompt"));
        return;
      }
      this.$confirm(
        this.$t("param.message.deletePrompt"),
        this.$t("common.label.prompt"),
        {
          confirmButtonText: this.$t("common.button.confirm"),
          cancelButtonText: this.$t("common.button.cancel"),
          type: "warning"
        }
      )
        .then(() => {
          this.deleteParamModel = this.copyObject(
            this.currentRow,
            this.deleteParamModel
          );
          deleteParam(this.deleteParamModel).then(res => {
            if (res.success || res.success == "true") {
              this.$message.success(this.$t("code." + res.code));
              this.query();
            } else {
              this.$message.error(this.$t("code." + res.code));
            }
          });
        })
        .catch(() => {
          this.$message.info(this.$t("param.message.cancelDeletePrompt"));
        });
    }
  },
  mounted() {
    this.query();
  }
};
</script>
