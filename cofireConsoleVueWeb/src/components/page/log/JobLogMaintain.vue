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
          <el-input :placeholder="$t('jobLog.label.isSuccess')" v-model="queryJobLog.isSuccess"></el-input>
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
        border=""
        highlight-current-row
        :data="tableData"
        @current-change="handleCurrentChange"
        @row-dblclick="handleDblclick"
        style="width: 100%"
      >
        <el-table-column type="index" :label="this.$t('common.label.index')" width="60"></el-table-column>
        <el-table-column property="jobId" :label="this.$t('jobLog.label.jobId')" width="200"></el-table-column>
        <el-table-column property="runTime" :label="this.$t('jobLog.label.runTime')" width="200" :formatter="formatTableTime"></el-table-column>
        <el-table-column property="ip" :label="this.$t('jobLog.label.ip')" width="200"></el-table-column>
        <el-table-column
          property="isSuccess"
          :label="this.$t('jobLog.label.isSuccess')"
          width="200"
        ></el-table-column>
        <el-table-column property="message" :label="this.$t('jobLog.label.message')" width="200"></el-table-column>
        <el-table-column property="filler1" :label="this.$t('jobLog.label.filler1')" width="200"></el-table-column>
        <el-table-column property="filler2" :label="this.$t('jobLog.label.filler2')" width="200"></el-table-column>
        <el-table-column property="filler3" :label="this.$t('jobLog.label.filler3')" width="200"></el-table-column>
      </el-table>
      <el-pagination
        background=""
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryJobLog.page"
        :page-sizes="GLOBAL.pageSizes"
        :page-size="queryJobLog.limit"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
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
      total: 0,
      tableData: []
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentRow = val;
    },
    handleSizeChange(val) {
      this.queryJobLog.limit = val;
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
      queryJobLog(this.queryJobLog).then(res => {
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
    }
  },
  mounted() {
    console.log(this.getDictByGroup("0001"))
    this.queryJobLog.runTimeList = this.getCurrentDayStartAndEndTime();
    this.query();
  }
};
</script>
