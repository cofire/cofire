<template>
  <el-row>
    <el-row class="query-form">
      <el-form :inline="true" :model="queryOperateAudit" ref="queryForm">
        <el-form-item :label="$t('operateAudit.label.userId')" prop="userId" class="queryCondition">
          <el-input
            :placeholder="$t('operateAudit.label.userId')"
            v-model="queryOperateAudit.userId"
          ></el-input>
        </el-form-item>
        <el-form-item
          :label="$t('operateAudit.label.description')"
          prop="description"
          class="queryCondition"
        >
          <el-input
            :placeholder="$t('operateAudit.label.description')"
            v-model="queryOperateAudit.description"
          ></el-input>
        </el-form-item>
        <el-form-item
          :label="this.$t('operateAudit.label.requestTime')"
          prop="requestTimeList"
          class="queryCondition"
        >
          <el-date-picker
            v-model.trim="queryOperateAudit.requestTimeList"
            type="daterange"
            value-format="yyyyMMdd"
            :range-separator="this.$t('common.label.dateto')"
            :start-placeholder="this.$t('common.label.startTime')"
            :end-placeholder="this.$t('common.label.endTime')"
          ></el-date-picker>
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
        :data="queryOperateTable.data"
        highlight-current-row
        :border = "queryOperateTable.border"
        v-loading="queryOperateTable.loading"
        :element-loading-text="queryOperateTable.text"
        :element-loading-spinner="queryOperateTable.spinner"
        :element-loading-background="queryOperateTable.background"
      >
        <el-table-column type="index" :label="this.$t('common.label.index')" width="60"></el-table-column>
        <el-table-column
          property="userId"
          :label="this.$t('operateAudit.label.userId')"
          width="100"
        ></el-table-column>
        <el-table-column property="ip" :label="this.$t('operateAudit.label.ip')" width="100"></el-table-column>
        <el-table-column
          property="description"
          :label="this.$t('operateAudit.label.description')"
          width="200"
        ></el-table-column>
        <el-table-column
          property="requestUrl"
          :label="this.$t('operateAudit.label.requestUrl')"
          width="200"
        ></el-table-column>
        <el-table-column
          property="requestParam"
          :label="this.$t('operateAudit.label.requestParam')"
          width="300"
          :show-overflow-tooltip="true"
        ></el-table-column>
        <el-table-column
          property="requestTime"
          :label="this.$t('operateAudit.label.requestTime')"
          width="200"
          :formatter="this.formatTableTime"
        ></el-table-column>
        <el-table-column
          property="result"
          :label="$t('operateAudit.label.result')"
          width="300"
          :show-overflow-tooltip="true"
        ></el-table-column>
        <el-table-column
          property="returnTime"
          :label="this.$t('operateAudit.label.returnTime')"
          width="200"
          :formatter="this.formatTableTime"
        ></el-table-column>
      </el-table>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryOperateAudit.page"
        :page-sizes="queryOperateTable.pageSizes"
        :page-size="queryOperateAudit.limit"
        :layout="queryOperateTable.layout"
        :total="queryOperateTable.total"
      ></el-pagination>
    </el-row>
  </el-row>
</template>
<script>
import { SysOperateAuditModel } from "../../model/system/SysOperateAuditModel";
import { queryOperateAudit } from "../../../api/getData";
export default {
  name: "OperateAuditMaintain",
  data() {
    return {
      queryOperateAudit: new SysOperateAuditModel(),
      queryOperateTable: new this.TableModel()
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentRow = val;
    },
    handleSizeChange(val) {
      this.queryOperateAudit.limit = val;
      this.query();
    },
    handlePageChange(val) {
      this.queryOperateAudit.page = val;
      this.query();
    },
    handleDblclick(val) {
      this.edit();
    },
    query(type) {
      if (!this.isBlank(type)) {
        this.queryOperateAudit.page = 1;
      }
      this.queryOperateAudit.requestTime = this.getQueryTimeBeginAndEnd(
        this.queryOperateAudit.requestTimeList
      );
      this.queryOperateTable.loading = true;
      queryOperateAudit(this.queryOperateAudit).then(res => {
        if (res.success || res.success == "true") {
          this.queryOperateTable.total = res.total;
          this.queryOperateTable.data = res.data;
        } else {
          this.$message.error(this.$t("code." + res.code));
        }
        this.queryOperateTable.loading = false;
      });
    }
  },
  mounted() {
    this.queryOperateAudit.requestTimeList = this.getCurrentDayStartAndEndTime();
    this.query();
  }
};
</script>
