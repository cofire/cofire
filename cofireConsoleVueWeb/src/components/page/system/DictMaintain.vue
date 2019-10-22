<template>
  <el-row>
    <el-row class="query-form">
      <el-form :inline="true" :model="queryDict" ref="queryForm">
        <el-form-item :label="$t('dict.label.groupId')" prop="groupId" class='queryCondition'>
            <el-input v-model="queryDict.groupId"  :placeholder="$t('dict.label.groupId')"  ></el-input>
          </el-form-item>
 
          <el-form-item :label="$t('dict.label.dictValue')" prop="dictValue" class='queryCondition'>
            <el-input v-model="queryDict.dictValue" :placeholder="$t('dict.label.dictValue')" ></el-input>
          </el-form-item>

          <el-form-item :label="$t('dict.label.dictName')" prop="dictName" class='queryCondition'>
            <el-input v-model="queryDict.dictName" :placeholder="$t('dict.label.dictName')" ></el-input>
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
        @click="deleteDict()"
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
        <el-table-column property="groupId" :label="this.$t('dict.label.groupId')" width="200"></el-table-column>
        <el-table-column property="groupName" :label="this.$t('dict.label.groupName')" width="200"></el-table-column>
        <el-table-column property="dictValue" :label="this.$t('dict.label.dictValue')" width="250"></el-table-column>
        <el-table-column property="dictName" :label="this.$t('dict.label.dictName')" width="200"></el-table-column>
        <el-table-column property="modifyUser" :label="this.$t('dict.label.modifier')" width="200"></el-table-column>
        <el-table-column property="modifyTime" :label="this.$t('dict.label.modifyTime')" width="200" :formatter="formatTableTime"></el-table-column>
      </el-table>
      <el-pagination
        background=""
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryDict.page"
        :page-sizes="pageSizes"
        :page-size="queryDict.limit"
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
          :model="editDict"
          label-width="100px"
          :disabled="formDisabled"
        >
          <el-form-item :label="this.$t('dict.label.groupId')" prop="groupId">
            <el-input v-model="editDict.groupId" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('dict.label.groupName')" prop="groupName">
            <el-input v-model="editDict.groupName" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('dict.label.dictValue')" prop="dictValue">
            <el-input v-model="editDict.dictValue" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('dict.label.dictName')" prop="dictName">
            <el-input v-model="editDict.dictName"></el-input>
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
import { SysDictModel } from "../../model/system/SysDictModel";
import { pageSizes, pageSize } from "../../common/global";
import { queryDict, saveDict, deleteDict } from "../../../api/getData";
import { copyObject } from "../../common/util";
export default {
  name: "DictMaintain",
  data() {
    return {
      queryDict: new SysDictModel(),
      editDict: new SysDictModel(),
      deleteDictModel: new SysDictModel(),
      pageSizes: pageSizes,
      total: 0,
      tableData: [],
      editVisible: false,
      title: "数据字典新增",
      formDisabled: false /** 为true时，整个表单不可编辑 */,
      disabled: false /** 为true时，编辑时某些字段不可编辑 */,
      rules: {
        dictId: [{ required: true, message: "数据字典代码", trigger: "blur" }],
        dictName: [{ required: true, message: "数据字典名称", trigger: "blur" }]
      }
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentRow = val;
    },
    handleSizeChange(val) {
      this.queryDict.limit = val;
      this.search();
    },
    handlePageChange(val) {
      this.queryDict.page = val;
      this.search();
    },
    handleDblclick(val) {
      this.edit();
    },
    search() {
      queryDict(this.queryDict).then(res => {
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
      this.editDict = new SysDictModel();
      this.editDict.saveFlag = "add";
      this.title = "数据字典新增";
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
      this.editDict = copyObject(this.currentRow, this.editDict);
      this.editDict.saveFlag = "update";
      this.title = "数据字典编辑";
      this.editVisible = true;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
    },
    save(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          saveDict(this.editDict).then(res => {
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
    //删除数据字典信息
    deleteDict() {
      debugger
      if (this.currentRow == null || this.currentRow == undefined) {
        this.$message({
          type: "warning",
          message: this.$t("dict.message.deleteSelect")
        });
        return;
      }
      this.$confirm(
        this.$t("dict.label.deleteInfo"),
        this.$t("dict.label.tip"),
        {
          confirmButtonText: this.$t("dict.button.confirm"),
          cancelButtonText: this.$t("dict.button.cancel"),
          type: "warning"
        }
      )
        .then(() => {
          this.deleteDictModel = copyObject(this.currentRow, this.deleteDictModel);
          deleteDict(this.deleteDictModel).then(res => {
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
            message: this.$t("dict.message.cancelDelete")
          });
        });
    }
  },
  mounted() {
    this.search();
  }
};
</script>
