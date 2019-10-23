<template>
  <el-row>
    <el-row class="query-form">
      <el-form :inline="true" :model="queryJob" ref="queryForm">
        <el-form-item :label="$t('job.label.jobId')" prop="jobId" class="queryCondition">
          <el-input :placeholder="$t('job.label.jobId')" v-model="queryJob.jobId"></el-input>
        </el-form-item>
        <el-form-item :label="$t('job.label.jobName')" prop="jobName" class="queryCondition">
          <el-input :placeholder="$t('job.label.jobName')" v-model="queryJob.jobName"></el-input>
        </el-form-item>
        <el-form-item :label="$t('job.label.jobDesc')" prop="jobDesc" class="queryCondition">
          <el-input :placeholder="$t('job.label.jobDesc')" v-model="queryJob.jobDesc"></el-input>
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
        @click="deleteJob()"
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
        <el-table-column property="jobId" :label="this.$t('job.label.jobId')" width="200"></el-table-column>
        <el-table-column property="jobName" :label="this.$t('job.label.jobName')" width="200"></el-table-column>
        <el-table-column property="jobDesc" :label="this.$t('job.label.jobDesc')" width="200"></el-table-column>
        <el-table-column property="year" :label="this.$t('job.label.year')" width="200"></el-table-column>
        <el-table-column property="month" :label="this.$t('job.label.month')" width="200"></el-table-column>
        <el-table-column property="day" :label="this.$t('job.label.day')" width="200"></el-table-column>
        <el-table-column property="week" :label="this.$t('job.label.week')" width="200"></el-table-column>
        <el-table-column property="hour" :label="this.$t('job.label.hour')" width="200"></el-table-column>
        <el-table-column property="minute" :label="this.$t('job.label.minute')" width="200"></el-table-column>
        <el-table-column property="second" :label="this.$t('job.label.second')" width="200"></el-table-column>
        <el-table-column property="activeDate" :label="this.$t('job.label.activeDate')" width="200"></el-table-column>
        <el-table-column property="expiryDate" :label="this.$t('job.label.expiryDate')" width="200"></el-table-column>
        <el-table-column property="isDel" :label="this.$t('job.label.isDel')" width="200"></el-table-column>
        <el-table-column property="modifier" :label="this.$t('job.label.modifier')" width="200"></el-table-column>
        <el-table-column property="modifyTime" :label="this.$t('job.label.modifyTime')" width="200"></el-table-column>
      </el-table>
      <el-pagination
        background=""
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryJob.page"
        :page-sizes="GLOBAL.pageSizes"
        :page-size="queryJob.limit"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </el-row>
    <!-- 编辑弹出框 -->
    <el-row>
      <el-dialog :title="title" :visible.sync="editVisible" width="45%">
        <el-form
          ref="editForm"
          :rules="rules"
          :model="editJob"
          label-width="100px"
          :disabled="formDisabled"
        >
          <el-row>
            <el-col :span="12">
              <el-form-item :label="this.$t('job.label.jobId')" prop="jobId">
                <el-input v-model="editJob.jobId" :disabled="disabled"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item :label="this.$t('job.label.jobName')" prop="jobName">
                <el-input v-model="editJob.jobName"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-form-item :label="this.$t('job.label.jobDesc')" prop="jobDesc">
              <el-input v-model="editJob.jobDesc"></el-input>
            </el-form-item>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item :label="this.$t('job.label.year')" prop="year">
                <el-input v-model="editJob.year" placeholder="年 否 空 或 1970-2099 , - * /"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item :label="this.$t('job.label.month')" prop="month">
                <el-input v-model="editJob.month" placeholder="月 是 1-12 或 JAN-DEC , - * /"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item :label="this.$t('job.label.day')" prop="day">
                <el-input v-model="editJob.day" placeholder="日 是 1-31 , - * ? / L W C"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item :label="this.$t('job.label.week')" prop="week">
                <el-input v-model="editJob.week" placeholder="周 是 1-7 或 SUN-SAT , - * ? / L C #"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item :label="this.$t('job.label.hour')" prop="hour">
                <el-input v-model="editJob.hour" placeholder="时 是 0-23 , - * /"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item :label="this.$t('job.label.minute')" prop="minute">
                <el-input v-model="editJob.minute" placeholder="分 是 0-59 , - * /"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item :label="this.$t('job.label.second')" prop="second">
                <el-input v-model="editJob.second" placeholder="秒 是 0-59 , - * /"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item :label="this.$t('job.label.activeDate')" prop="activeDate">
                <el-input v-model="editJob.activeDate"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item :label="this.$t('job.label.expiryDate')" prop="expiryDate">
                <el-input v-model="editJob.expiryDate"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="editVisible = false">{{this.$t('common.button.cancel')}}</el-button>
          <el-button type="primary" @click="save('editForm')">{{this.$t('common.button.save')}}</el-button>
        </span>
      </el-dialog>
    </el-row>
  </el-row>
</template>
<script>
import { QtzJobModel } from "../../model/system/QtzJobModel";
import { queryJob, saveJob, deleteJob } from "../../../api/getData";

export default {
  name: "JobMaintain",
  data() {
    return {
      queryJob: new QtzJobModel(),
      editJob: new QtzJobModel(),
      deleteJobModel: new QtzJobModel(),
      total: 0,
      tableData: [],
      editVisible: false,
      title: "定时任务新增",
      formDisabled: false /** 为true时，整个表单不可编辑 */,
      disabled: false /** 为true时，编辑时某些字段不可编辑 */,
      rules: {
        jobId: [{ required: true, message: "定时任务代码", trigger: "blur" }],
        jobName: [{ required: true, message: "定时任务名称", trigger: "blur" }]
      }
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentRow = val;
    },
    handleSizeChange(val) {
      this.queryJob.limit = val;
      this.query();
    },
    handlePageChange(val) {
      this.queryJob.page = val;
      this.query();
    },
    handleDblclick(val) {
      this.edit();
    },
    query(type) {
      if (!this.isBlank(type)) {
        this.queryJob.page = 1;
      }
      queryJob(this.queryJob).then(res => {
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
      this.editJob = new QtzJobModel();
      this.editJob.saveFlag = "add";
      this.title = "定时任务新增";
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
      this.editJob = this.copyObject(this.currentRow, this.editJob);
      this.editJob.saveFlag = "update";
      this.title = "定时任务编辑";
      this.editVisible = true;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
    },
    save(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          saveJob(this.editJob).then(res => {
            if (res.success || res.success == "true") {
              this.editVisible = false;
              this.$message({
                type: "success",
                message: res.retMessage
              });
              this.query();
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
    //删除定时任务信息
    deleteJob() {
      debugger;
      if (this.currentRow == null || this.currentRow == undefined) {
        this.$message({
          type: "warning",
          message: this.$t("job.message.deleteSelect")
        });
        return;
      }
      this.$confirm(this.$t("job.label.deleteInfo"), this.$t("job.label.tip"), {
        confirmButtonText: this.$t("job.button.confirm"),
        cancelButtonText: this.$t("job.button.cancel"),
        type: "warning"
      })
        .then(() => {
          this.deleteJobModel = this.copyObject(
            this.currentRow,
            this.deleteJobModel
          );
          deleteJob(this.deleteJobModel).then(res => {
            if (res.success || res.success == "true") {
              this.$message({
                type: "success",
                message: this.$t("code." + res.code)
              });
              this.query();
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
            message: this.$t("job.message.cancelDelete")
          });
        });
    }
  },
  mounted() {
    this.query();
  }
};
</script>
