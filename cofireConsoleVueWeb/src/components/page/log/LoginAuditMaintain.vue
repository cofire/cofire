<template>
  <el-row>
    <el-row class="query-form">
      <el-form :inline="true" :model="queryLoginAudit" ref="queryForm">
        <el-form-item :label="$t('loginAudit.label.userId')" prop="userId" class="queryCondition">
          <el-input :placeholder="$t('loginAudit.label.userId')" v-model="queryLoginAudit.userId"></el-input>
        </el-form-item>
        <el-form-item
          :label="$t('loginAudit.label.createTime')"
          prop="createTimeList"
          class="queryCondition"
        >
          <el-date-picker
            v-model.trim="queryLoginAudit.createTimeList"
            type="daterange"
            value-format="yyyyMMdd"
            :range-separator="this.$t('common.label.dateto')"
            :start-placeholder="this.$t('common.label.startTime')"
            :end-placeholder="this.$t('common.label.endTime')"
          ></el-date-picker>
        </el-form-item>
        <el-form-item
          :label="$t('loginAudit.label.auditType')"
          prop="auditType"
          class="queryCondition"
        >
          <el-select v-model="queryLoginAudit.auditType" clearable>
            <el-option
              v-for="item in this.auditTypeDict"
              :key="item.dict_value"
              :label="item.dict_name"
              :value="item.dict_value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item
          :label="$t('loginAudit.label.sourceType')"
          prop="sourceType"
          class="queryCondition"
        >
          <el-select v-model="queryLoginAudit.sourceType" clearable>
            <el-option
              v-for="item in this.sourceTypeDict"
              :key="item.dict_value"
              :label="item.dict_name"
              :value="item.dict_value"
            ></el-option>
          </el-select>
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
        icon="el-icon-lx-refresh"
        @click="resetForm($refs['queryForm'])"
      >{{$t('common.button.reset')}}</el-button>
    </el-row>
    <el-row class="table-result">
      <el-table
        ref="singleTable"
        :data="loginAuditTable.data"
        highlight-current-row
        :border = "loginAuditTable.border"
        v-loading="loginAuditTable.loading"
        :element-loading-text="loginAuditTable.text"
        :element-loading-spinner="loginAuditTable.spinner"
        :element-loading-background="loginAuditTable.background"
      >
        <el-table-column type="index" :label="this.$t('common.label.index')" width="60"></el-table-column>
        <el-table-column property="userId" :label="this.$t('loginAudit.label.userId')" width="100"></el-table-column>
        <el-table-column property="ip" :label="this.$t('loginAudit.label.ip')" width="200"></el-table-column>
        <el-table-column
          property="sessionId"
          :label="this.$t('loginAudit.label.sessionId')"
          width="300"
        ></el-table-column>
        <el-table-column
          property="createTime"
          :label="this.$t('loginAudit.label.createTime')"
          width="200"
          :formatter="formatTableTime"
        ></el-table-column>
        <el-table-column
          property="auditType"
          :label="this.$t('loginAudit.label.auditType')"
          width="100"
          :formatter="formateTableDict" className="dict-0002"
        ></el-table-column>
        <el-table-column
          property="sourceType"
          :label="this.$t('loginAudit.label.sourceType')"
          width="100"
          :formatter="formateTableDict" className="dict-0005"
        ></el-table-column>
        <el-table-column
          property="message"
          :label="this.$t('loginAudit.label.message')"
          width="400"
          :show-overflow-tooltip="true"
        ></el-table-column>
      </el-table>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryLoginAudit.page"
        :page-sizes="loginAuditTable.pageSizes"
        :page-size="queryLoginAudit.length"
        :layout="loginAuditTable.layout"
        :total="loginAuditTable.total"
      ></el-pagination>
    </el-row>
  </el-row>
</template>
<script>
import { SysLoginAuditModel } from "../../model/system/SysLoginAuditModel";
import { queryLoginAudit } from "../../../api/getData";
export default {
  name: "LoginAuditMaintain",
  data() {
    return {
      queryLoginAudit: new SysLoginAuditModel(),
      auditTypeDict: this.getDictByGroup("0002"),
      sourceTypeDict: this.getDictByGroup("0005"),
      loginAuditTable: new this.TableModel()
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentRow = val;
      this.query();
    },
    handleSizeChange(val) {
      this.queryLoginAudit.length = val;
      this.query();
    },
    handlePageChange(val) {
      this.queryLoginAudit.page = val;
      this.query();
    },
    handleDblclick(val) {
      this.edit();
    },
    query(type) {
      if (!this.isBlank(type)) {
        this.queryLoginAudit.page = 1;
      }
      this.loginAuditTable.loading = false;
      this.queryLoginAudit.createTime = this.getQueryTimeBeginAndEnd(
        this.queryLoginAudit.createTimeList
      );
      queryLoginAudit(this.queryLoginAudit).then(res => {
        if (res.success || res.success == "true") {
          this.loginAuditTable.total = res.total;
          this.loginAuditTable.data = res.data;
        } else {
          this.$message.error(this.$t("code." + res.code));
        }
        this.loginAuditTable.loading = false;
      });
    },
    formatAuditType(row, column) {
      return this.getDictName(this.auditTypeDict, row[column.property]);
    },
    formatSourceType(row, column) {
      return this.getDictName(this.sourceTypeDict, row[column.property]);
    }
  },
  mounted() {
    this.queryLoginAudit.createTimeList = this.getCurrentDayStartAndEndTime();
    this.query();
  }
};
</script>
