<template>
  <el-row>
    <el-row class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-calendar"></i>
          {{this.$t('log.log')}}
        </el-breadcrumb-item>
        <el-breadcrumb-item>{{this.$t('log.opeAuditsMes')}}</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-row class="query-form">
      <el-form :inline="true" :model="operateAudits" ref="queryForm">
        <el-form-item :label="this.$t('log.label.userId')" prop="userId" class="queryCondition">
          <el-input
            v-model.trim="operateAudits.userId"
            :placeholder="this.$t('log.placeholder.userId')"
          ></el-input>
        </el-form-item>

        <el-form-item :label="this.$t('log.label.ip')" prop="ip" class="queryCondition">
          <el-input v-model.trim="operateAudits.ip" :placeholder="this.$t('log.placeholder.ip')"></el-input>
        </el-form-item>
        <el-form-item
          :label="this.$t('log.table.description')"
          prop="description"
          class="queryCondition"
        >
          <el-input
            v-model.trim="operateAudits.description"
            :placeholder="this.$t('log.placeholder.description')"
          ></el-input>
        </el-form-item>

        <el-form-item :label="this.$t('log.label.date')" prop="createTime" class="queryCondition">
          <el-date-picker
            v-model.trim="operateAudits.createTime"
            type="daterange"
            value-format="yyyyMMdd"
            :range-separator="this.$t('log.placeholder.dateto')"
            :start-placeholder="this.$t('log.placeholder.dateStr')"
            :end-placeholder="this.$t('log.placeholder.dateEnd')"
          ></el-date-picker>
        </el-form-item>
      </el-form>
    </el-row>
    <el-row class="table-operations">
      <el-button
        type="primary"
        icon="el-icon-lx-search"
        @click="submitQuery()"
      >{{this.$t('common.button.query')}}</el-button>
      <el-button
        type="primary"
        icon="el-icon-lx-refresh"
        @click="resetForm('queryForm')"
      >{{this.$t('common.button.reset')}}</el-button>
    </el-row>
    <el-row class="table-result">
      <el-table
        v-loading="loading"
        ref="operateAuditsTableData"
        border
        highlight-current-row
        :data="operateAuditsTableData"
        style="width: 100%"
      >
        <el-table-column type="index" :label="$t('common.label.index')" width="80"></el-table-column>
        <el-table-column
          property="reqUrl"
          :label="this.$t('log.table.url')"
          width="200"
          :show-overflow-tooltip="true"
        ></el-table-column>
        <el-table-column property="ip" :label="this.$t('log.table.ip')" width="200"></el-table-column>
        <el-table-column property="userId" :label="this.$t('log.table.userId')" width="200"></el-table-column>
        <el-table-column
          property="description"
          :label="this.$t('log.table.description')"
          width="200"
          :show-overflow-tooltip="true"
        ></el-table-column>
        <el-table-column
          property="requiredPara"
          :label="this.$t('log.table.requiredPara')"
          width="200"
          :show-overflow-tooltip="true"
        ></el-table-column>
        <el-table-column
          property="filler1"
          :label="this.$t('log.table.result')"
          width="200"
          :show-overflow-tooltip="true"
        ></el-table-column>
        <el-table-column
          property="createTime"
          :label="this.$t('log.table.createTime')"
          width="200"
          :formatter="formatCreateTime"
        ></el-table-column>
      </el-table>
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="operateAudits.page"
        :page-sizes="pageSizes"
        :page-size="operateAudits.length"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </el-row>
  </el-row>
</template>

<script>
import { OperateAuditsModel } from "../../model/log/OperateAuditsModel";
import { pageSizes, pageSize } from "../../common/global";
import { queryOpeLog } from "@/api/getData";
import {
  formatDate,
  getBeginAndEnd,
  getCurrentStartAndEndTime
} from "../../common/util";

export default {
  name: "OpeLog", //页面头部tag数据
  data() {
    return {
      operateAudits: new OperateAuditsModel(),
      pageSizes: pageSizes,
      total: 0,
      operateAuditsTableData: [],
      loading: false
    };
  },
  mounted() {
    this.getTodayTime();
    this.query();
  },
  methods: {
    //重置按钮
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    //点击查询，当前页码改为1
    submitQuery() {
      this.operateAudits.page = 1;
      this.query();
    },
    query() {
      this.loading = true;
      if (null != this.operateAudits.createTime) {
        var list = getBeginAndEnd(this.operateAudits.createTime.toString());
        this.operateAudits.createTime = list.split(",");
      }

      queryOpeLog(this.operateAudits).then(res => {
        if (res.success || res.success == "true") {
          this.total = res.total;
          this.operateAuditsTableData = res.data;
        } else {
          this.$message({
            type: "error",
            message: this.$t("common.code." + res.code)
          });
        }
        this.loading = false;
      });
    },
    handleSizeChange(val) {
      this.operateAudits.length = val;
      this.query();
    },
    handlePageChange(val) {
      this.operateAudits.page = val;
      this.query();
    },
    formatCreateTime(row, column) {
      return formatDate(row.createTime);
    },
    //获取当天时间
    getTodayTime() {
      this.operateAudits.createTime = getCurrentStartAndEndTime();
      // this.queryRecordOfAccess.applyTime=[beg,end]
    }
  }
};
</script>

<style>
</style>
