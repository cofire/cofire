<template>
  <el-row>
    <el-row class="query-form">
      <el-form :inline="true" :model="queryJobLog" ref="queryForm">
          <el-form-item :label="$t('jobLog.label.jobId')" prop="jobId" class='queryCondition'>
            <el-input :placeholder="$t('jobLog.label.jobId')" v-model="queryJobLog.jobId"></el-input>
          </el-form-item>
          <el-form-item :label="$t('jobLog.label.runTime')" prop="runTime" class='queryCondition'>
            <el-input :placeholder="$t('jobLog.label.runTime')" v-model="queryJobLog.runTime"></el-input>
          </el-form-item>
          <el-form-item :label="$t('jobLog.label.isSuccess')" prop="isSuccess" class='queryCondition'>
            <el-input :placeholder="$t('jobLog.label.isSuccess')" v-model="queryJobLog.isSuccess"></el-input>
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
        <el-table-column property="jobId" :label="this.$t('jobLog.label.jobId')" width="200"></el-table-column>
        <el-table-column property="runTime" :label="this.$t('jobLog.label.runTime')" width="200"></el-table-column>
        <el-table-column property="ip" :label="this.$t('jobLog.label.ip')" width="200"></el-table-column>
        <el-table-column property="isSuccess" :label="this.$t('jobLog.label.isSuccess')" width="200"></el-table-column>
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
        :page-sizes="pageSizes"
        :page-size="queryJobLog.limit"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </el-row>
  </el-row>
</template>
<script>
import { QtzJobLogModel } from "../../model/system/QtzJobLogModel";
import { pageSizes, pageSize } from "../../common/global";
import { queryJobLog } from "../../../api/getData";
import { copyObject } from "../../common/util";
export default {
  name: "JobLogMaintain",
  data() {
    return {
      queryJobLog: new QtzJobLogModel(),
      pageSizes: pageSizes,
      total: 0,
      tableData: [],
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentRow = val;
    },
    handleSizeChange(val) {
      this.queryJobLog.limit = val;
      this.search();
    },
    handlePageChange(val) {
      this.queryJobLog.page = val;
      this.search();
    },
    handleDblclick(val) {
      this.edit();
    },
    search() {
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
    this.search();
  }
};
</script>
