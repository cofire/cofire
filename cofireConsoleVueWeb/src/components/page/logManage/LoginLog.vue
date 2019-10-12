<template>
  <el-row>
    <el-row class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-calendar"></i>
          {{this.$t('log.log')}}
        </el-breadcrumb-item>
        <el-breadcrumb-item>{{this.$t('log.loginAuditsMes')}}</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-row class="query-form">
      <el-form :inline="true" :model="loginAudits" ref="queryForm">
        <el-form-item :label="this.$t('log.label.userId')" prop="userId" class="queryCondition">
          <el-input
            v-model.trim="loginAudits.userId"
            :placeholder="this.$t('log.placeholder.userId')"
          ></el-input>
        </el-form-item>

        <el-form-item
          :label="this.$t('log.label.auditType')"
          prop="auditType"
          class="queryCondition"
        >
          <el-select v-model="loginAudits.auditType" clearable>
            <el-option
              v-for="item in this.auditType"
              :key="item.DICT_VALUE"
              :label="item.DICT_NAME"
              :value="item.DICT_VALUE"
            ></el-option>
          </el-select>
        </el-form-item>

        <el-form-item :label="this.$t('log.label.ip')" prop="ip" class="queryCondition">
          <el-input v-model.trim="loginAudits.ip" :placeholder="this.$t('log.placeholder.ip')"></el-input>
        </el-form-item>
        <el-form-item :label="this.$t('log.label.sourceType')" prop="sourceType">
          <el-select v-model="loginAudits.sourceType" clearable>
            <el-option
              v-for="item in this.sourceType"
              :key="item.DICT_VALUE"
              :label="item.DICT_NAME"
              :value="item.DICT_VALUE"
            ></el-option>
          </el-select>
        </el-form-item>

        <el-form-item :label="this.$t('log.label.date')" prop="createTime" class="queryCondition">
          <el-date-picker
            v-model.trim="loginAudits.createTime"
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
        ref="loginAuditsTableData"
        border
        highlight-current-row
        :data="loginAuditsTableData"
        style="width: 100%"
      >
        <el-table-column type="index" :label="$t('common.label.index')" width="80"></el-table-column>
        <el-table-column property="userId" :label="this.$t('log.table.userId')" width="200"></el-table-column>
        <el-table-column property="ip" :label="this.$t('log.table.ip')" width="200"></el-table-column>
        <el-table-column
          property="auditType"
          :label="this.$t('log.table.auditType')"
          width="200"
          :formatter="formatAuditType"
        ></el-table-column>
        <el-table-column
          property="sourceType"
          :label="this.$t('log.table.sourceType')"
          width="200"
          :formatter="formatSourceType"
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
        :current-page="loginAudits.page"
        :page-sizes="pageSizes"
        :page-size="loginAudits.length"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </el-row>
  </el-row>
</template>

<script>
import { LoginAuditsModel } from "../../model/log/LoginAuditsModel";
import { pageSizes, pageSize } from "../../common/global";
import { queryLoginLog, getDictByGroup } from "@/api/getData";
import {
  formatDate,
  getDictName,
  getCurrentStartAndEndTime,
  getBeginAndEnd
} from "../../common/util";

export default {
  name: "LoginLog", //页面头部tag数据
  data() {
    return {
      loginAudits: new LoginAuditsModel(),
      pageSizes: pageSizes,
      total: 0,
      loginAuditsTableData: [],
      auditType: [], //类型
      sourceType: [], //来源
      loading: false
    };
  },
  mounted() {
    this.getTodayTime();
    this.auditDict();
    this.sourceDict();
    //获取数据字典，延迟查询
    this.$nextTick(function() {
      this.query();
    });
  },
  created() {},
  methods: {
    //获取数据字典方法--类型
    auditDict() {
      getDictByGroup({ groupCode: "0009" }).then(res => {
        if (res.success) {
          this.auditType = res.data;
        } else {
          this.$message({
            type: "error",
            message: this.$t("common.code." + res.code)
          });
        }
      });
    },
    //获取数据字典方法--来源
    sourceDict() {
      getDictByGroup({ groupCode: "0010" }).then(res => {
        if (res.success) {
          this.sourceType = res.data;
        } else {
          this.$message({
            type: "error",
            message: this.$t("common.code." + res.code)
          });
        }
      });
    },
    //重置按钮
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    //点击查询，当前页码改为1
    submitQuery() {
      this.loginAudits.page = 1;
      this.query();
    },
    query() {
      this.loading = true;
      if (null != this.loginAudits.createTime) {
        var list = getBeginAndEnd(this.loginAudits.createTime.toString());
        this.loginAudits.createTime = list.split(",");
      }

      queryLoginLog(this.loginAudits).then(res => {
        if (res.success) {
          this.total = res.total;
          this.loginAuditsTableData = res.data;
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
      this.loginAudits.length = val;
      this.query();
    },
    handlePageChange(val) {
      this.loginAudits.page = val;
      this.query();
    },
    //1-登录  2-退出    改为调用数据字典
    formatAuditType(row, column) {
      return getDictName(this.auditType, row.auditType);
    },
    //0-PC端； 1-pad端   改为调用数据字典
    formatSourceType(row, column) {
      return getDictName(this.sourceType, row.sourceType);
    },
    //创建时间格式转换
    formatCreateTime(row, column) {
      return formatDate(row.createTime);
    },
    //获取当天时间
    getTodayTime() {
      this.loginAudits.createTime = getCurrentStartAndEndTime();
      // this.queryRecordOfAccess.applyTime=[beg,end]
    }
  }
};
</script>

<style>
</style>
