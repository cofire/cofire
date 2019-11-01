<template>
  <el-row>
    <el-row class="query-form">
      <el-form :inline="true" :model="queryJobLog" ref="queryForm">
        <el-form-item :label="$t('jobLog.label.jobId')" prop="jobId" class="queryCondition">
          <el-input :placeholder="$t('jobLog.label.jobId')" v-model="queryJobLog.jobId"></el-input>
        </el-form-item>
        <el-form-item :label="$t('jobLog.label.runTime')" prop="runTimeList" class="queryCondition">
          <el-date-picker
            v-model.trim="queryJobLog.runTimeList"
            type="daterange"
            value-format="yyyyMMdd"
            :range-separator="this.$t('common.label.dateto')"
            :start-placeholder="this.$t('common.label.startTime')"
            :end-placeholder="this.$t('common.label.endTime')"
          ></el-date-picker>
        </el-form-item>
        <el-form-item :label="$t('jobLog.label.isSuccess')" prop="isSuccess" class="queryCondition">
          <el-select v-model="queryJobLog.isSuccess" clearable>
            <el-option
              v-for="item in this.isSuccessDict"
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
        highlight-current-row
        :data="joblogTable.data"
        @current-change="handleCurrentChange"
        @row-dblclick="handleDblclick"
        :border = "joblogTable.border"
        v-loading="joblogTable.loading"
        :element-loading-text="joblogTable.text"
        :element-loading-spinner="joblogTable.spinner"
        :element-loading-background="joblogTable.background"
      >
        <el-table-column type="index" :label="this.$t('common.label.index')" width="60"></el-table-column>
        <el-table-column property="jobId" :label="this.$t('jobLog.label.jobId')" width="200"></el-table-column>
        <el-table-column
          property="runTime"
          :label="this.$t('jobLog.label.runTime')"
          width="200"
          :formatter="formatTableTime"
        ></el-table-column>
        <el-table-column property="ip" :label="this.$t('jobLog.label.ip')" width="200"></el-table-column>
        <el-table-column
          property="isSuccess"
          :label="this.$t('jobLog.label.isSuccess')"
          width="200"
          :formatter="formateTableDict" className="dict-0004"
        ></el-table-column>
        <el-table-column
          property="message"
          :label="$t('jobLog.label.message')"
          width="300"
          :show-overflow-tooltip="true"
        ></el-table-column>
      </el-table>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryJobLog.page"
        :page-sizes="joblogTable.pageSizes"
        :page-size="queryJobLog.length"
        :layout="joblogTable.layout"
        :total="joblogTable.total"
      ></el-pagination>
    </el-row>
  </el-row>
</template>
<script>
import { QtzJobLogModel } from "../../model/system/QtzJobLogModel";
import { queryJobLog } from "../../../api/getData";

export default {
  name: "JobLogMaintain",
  data() {
    return {
      queryJobLog: new QtzJobLogModel(),
      joblogTable: new this.TableModel(),
      isSuccessDict: this.getDictByGroup("0004")
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentRow = val;
    },
    handleSizeChange(val) {
      this.queryJobLog.length = val;
      this.query();
    },
    handlePageChange(val) {
      this.queryJobLog.page = val;
      this.query();
    },
    handleDblclick(val) {
      this.edit();
    },
    query(type) {
      if (!this.isBlank(type)) {
        this.queryJobLog.page = 1;
      }
      this.queryJobLog.runTime = this.getQueryTimeBeginAndEnd(
        this.queryJobLog.runTimeList
      );
      this.joblogTable.loading = true;
      queryJobLog(this.queryJobLog).then(res => {
        if (res.success || res.success == "true") {
          this.joblogTable.total = res.total;
          this.joblogTable.data = res.data;
        } else {
          this.$message.error(this.$t("code." + res.code));
        }
        this.joblogTable.loading = false;
      });
    }
  },
  mounted() {
    this.queryJobLog.runTimeList = this.getCurrentDayStartAndEndTime();
    this.query();
  }
};
</script>
