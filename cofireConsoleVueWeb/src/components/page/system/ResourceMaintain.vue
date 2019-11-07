<template>
  <el-row>
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
        @click="deleteResource()"
      >{{$t('common.button.delete')}}</el-button>
      <el-button
        type="primary"
        icon="el-icon-refresh-right"
        @click="resetForm('queryForm')"
      >{{$t('common.button.reset')}}</el-button>
    </el-row>
    <el-row class="table-result">
      <el-table
        ref="singleTable"
        highlight-current-row
        :data="resourceTable.data"
        @current-change="handleCurrentChange"
        @row-dblclick="handleDblclick"
        :border = "resourceTable.border"
        v-loading="resourceTable.loading"
        :element-loading-text="resourceTable.text"
        :element-loading-spinner="resourceTable.spinner"
        :element-loading-background="resourceTable.background"
        row-key="resourceId"
         default-expand-all
        :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
      >
        <el-table-column type="index" :label="$t('common.label.index')" width="60"></el-table-column>
        <el-table-column property="resourceId" :label="$t('resource.label.resourceId')" sortable width="200"></el-table-column>
        <el-table-column property="resourceName" :label="$t('resource.label.resourceName')" width="150"></el-table-column>
        <el-table-column property="url" :label="$t('resource.label.url')" width="200"></el-table-column>
        <el-table-column property="parentResourceId" :label="$t('resource.label.parentResourceId')" width="150"></el-table-column>
        <el-table-column property="icon" :label="$t('resource.label.icon')" width="200"></el-table-column>
        <el-table-column property="isLeaf" :label="$t('resource.label.isLeaf')" width="100" :formatter="formateTableDict" className="dict-0006"></el-table-column>
        <el-table-column property="morder" :label="$t('resource.label.morder')" width="100"></el-table-column>
        <el-table-column property="enabled" :label="$t('resource.label.enabled')" width="100" :formatter="formateTableDict" className="dict-0001"></el-table-column>
        <el-table-column property="modifier" :label="$t('resource.label.modifier')" width="100"></el-table-column>
        <el-table-column property="modifyTime" :label="$t('resource.label.modifyTime')" width="150" :formatter="formatTableTime"></el-table-column>
      </el-table>
    </el-row>
    <!-- 编辑弹出框 -->
    <el-row>
      <el-dialog :title="editDialog.title" :visible.sync="editDialog.visible" :close-on-click-modal="editDialog.close_on_click_modal" width="30%">
        <el-form
          ref="editForm"
          :rules="rules"
          :model="editResource"
          label-width="100px"
          :disabled="editDialog.formDisabled"
        >  
        <el-form-item :label="$t('resource.label.resourceId')" prop="resourceId">
            <el-input v-model="editResource.resourceId" :disabled="editDialog.disabled"></el-input>
          </el-form-item>
          <el-form-item :label="$t('resource.label.resourceName')" prop="resourceName">
            <el-input v-model="editResource.resourceName"></el-input>
          </el-form-item>
        
          <el-form-item :label="$t('resource.label.url')" prop="url">
            <el-input v-model="editResource.url"></el-input>
          </el-form-item>
          <el-form-item :label="$t('resource.label.parentResourceId')" prop="parentResourceId">
            <el-input v-model="editResource.parentResourceId"></el-input>
          </el-form-item>
          <el-form-item :label="$t('resource.label.icon')" prop="icon">
            <el-input v-model="editResource.icon"></el-input>
          </el-form-item>
          <el-form-item :label="$t('resource.label.morder')" prop="morder">
            <el-input v-model="editResource.morder"></el-input>
          </el-form-item>
          <el-form-item :label="$t('resource.label.enabled')" prop="enabled">
            <el-radio-group v-model="editResource.enabled">
              <el-radio v-for="(item,index) in enabledDict" :key="index" :label="item.dict_value">{{item.dict_name}}</el-radio>
            </el-radio-group>
          </el-form-item>
           <el-form-item :label="$t('resource.label.isLeaf')" prop="isLeaf">
            <el-radio-group v-model="editResource.isLeaf">
              <el-radio v-for="(item,index) in isLeafDict" :key="index" :label="item.dict_value">{{item.dict_name}}</el-radio>
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
import { SysResourceModel } from "../../model/system/SysResourceModel";
import { queryResource, saveResource, deleteResource } from "../../../api/getData";
import { Rules } from "../../rules/Rules";

export default {
  name: "ResourceMaintain",
  data() {
    return {
      queryResource: new SysResourceModel(),
      editResource: new SysResourceModel(),
      deleteResourceModel: new SysResourceModel(),
      resourceTable: new this.TableModel(),
      editDialog: new this.DialogModel(),
      rules: Rules.ResourceRules,
      isLeafDict: this.getDictByGroup("0006"),
      enabledDict: this.getDictByGroup("0001"),
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentRow = val;
    },
    handleSizeChange(val) {
      this.queryResource.length = val;
      this.query();
    },
    handlePageChange(val) {
      this.queryResource.page = val;
      this.query();
    },
    handleDblclick(val) {
      this.detail();
    },
    query(type) {
      if (!this.isBlank(type)) {
        this.queryResource.page = 1;
      }
      this.resourceTable.loading = true;
      queryResource(this.queryResource).then(res => {
        if (res.success || res.success == "true") {
          this.resourceTable.data = res.data;
        } else {
          this.$message.error(this.$t("code." + res.code));
        }
        this.resourceTable.loading = false;
      });
    },
     add() {
      this.editResource = new SysResourceModel();
      this.editResource.operation = this.GLOBAL.operation.add;
      this.editDialog.title = this.$t("resource.title.add");
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
        this.$message.warning(this.$t("resource.message.edit"));
        return;
      }
      this.editDialog.formDisabled = false;
      this.editDialog.isDetail = false;
      this.editDialog.disabled = true;
      this.editResource = this.copyObject(this.currentRow, this.editResource);
      this.editResource.operation = this.GLOBAL.operation.update;
      this.editDialog.title = this.$t("resource.title.edit");
      this.editDialog.visible = true;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
    },
    detail() {
      this.editResource = this.currentRow;
      this.editDialog.title = this.$t("resource.title.detail");
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
          saveResource(this.editResource).then(res => {
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
    deleteResource() {
      if (this.isBlank(this.currentRow)) {
        this.$message.warning(this.$t("resource.message.deleteSelect"));
        return;
      }
      if(this.isFalse(this.currentRow.canDelete)){
        this.$message.warning(this.$t("resource.message.canNotDeletePrompt"));
        return;
      }
      this.$confirm(
        this.$t("resource.message.deletePrompt"),
        this.$t("common.label.prompt"),
        {
          confirmButtonText: this.$t("common.button.confirm"),
          cancelButtonText: this.$t("common.button.cancel"),
          type: "warning"
        }
      )
        .then(() => {
          this.deleteResourceModel = this.copyObject(
            this.currentRow,
            this.deleteResourceModel
          );
          deleteResource(this.deleteResourceModel).then(res => {
            if (res.success || res.success == "true") {
              this.$message.success(this.$t("code." + res.code));
              this.query();
            } else {
              this.$message.error(this.$t("code." + res.code));
            }
          });
        })
        .catch(() => {
          this.$message.info(this.$t("resource.message.cancelDeletePrompt"));
        });
    }
  },
  mounted() {
    this.query();
  }
};
</script>
