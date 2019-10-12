<template>
  <el-row>
    <el-row class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-calendar"></i>
          {{ $t('common.route.R1') }}
        </el-breadcrumb-item>
        <el-breadcrumb-item>{{ $t('common.route.R11') }}</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-row class="query-form">
      <el-form :inline="true" :model="queryUser" ref="queryForm">
        <el-col :span="6">
          <el-form-item :label="$t('user.label.userId')">
            <el-input v-model="queryUser.userId" placeholder="用户代码"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item :label="$t('user.label.userName')">
            <el-input v-model="queryUser.userName" :placeholder="$t('user.label.userName')"></el-input>
          </el-form-item>
        </el-col>
      </el-form>
    </el-row>
    <el-row class="table-operations">
      <el-button type="primary" icon="el-icon-lx-search" @click="search()">查询</el-button>
      <el-button type="primary" icon="el-icon-lx-roundadd" @click="add()">新增</el-button>
      <el-button type="primary" icon="el-icon-lx-edit" @click="edit()">修改</el-button>
      <el-button type="primary" icon="el-icon-lx-settings">角色设置</el-button>
      <el-button type="primary" icon="el-icon-lx-refresh">密码重置</el-button>
      <el-button type="primary" icon="el-icon-lx-hot">用户激活</el-button>
      <el-button type="primary" icon="el-icon-lx-roundclose">用户注销</el-button>
    </el-row>
    <el-row class="table-result">
      <el-table
        ref="singleTable"
        border=""
        :data="tableData"
        @current-change="handleCurrentChange"
        @row-dblclick="handleDblclick"
        style="width: 100%"
      >
        <el-table-column type="index" :label="this.$t('common.label.index')" width="60"></el-table-column>
        <el-table-column property="userId" :label="$t('user.label.userId')" width="200"></el-table-column>
        <el-table-column property="userName" :label="$t('user.label.userName')" width="200"></el-table-column>
        <el-table-column property="deptCode" :label="$t('user.label.deptCode')" width="200"></el-table-column>
        <el-table-column property="passWord" :label="$t('user.label.passWord')" width="200"></el-table-column>
        <el-table-column property="lastIp" :label="$t('user.label.lastIp')" width="200"></el-table-column>
        <el-table-column property="lastDate" :label="$t('user.label.lastDate')" width="200"></el-table-column>
        <el-table-column
          property="wrongPwdCount"
          :label="$t('user.label.wrongPwdCount')"
          width="200"
        ></el-table-column>
        <el-table-column property="creator" :label="$t('user.label.creator')" width="200"></el-table-column>
        <el-table-column property="createTime" :label="$t('user.label.createTime')" width="200"></el-table-column>
        <el-table-column property="status" :label="$t('user.label.status')" width="200"></el-table-column>
        <el-table-column property="checkStatus" :label="$t('user.label.checkStatus')" width="200"></el-table-column>
        <el-table-column property="checker" :label="$t('user.label.checker')" width="200"></el-table-column>
        <el-table-column property="checkTime" :label="$t('user.label.checkTime')" width="200"></el-table-column>
        <el-table-column
          property="changePwdFlag"
          :label="$t('user.label.changePwdFlag')"
          width="200"
        ></el-table-column>
      </el-table>
      <el-pagination
        background=""
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryUser.page"
        :page-sizes="pageSizes"
        :page-size="queryUser.limit"
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
          :model="editUser"
          label-width="100px"
          :disabled="formDisabled"
        >
          <el-form-item :label="$t('user.label.userId')" prop="userId">
            <el-input v-model="editUser.userId" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="$t('user.label.userName')" prop="userName">
            <el-input v-model="editUser.userName"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="editVisible = false">取 消</el-button>
          <el-button type="primary" @click="save('editForm')">确 定</el-button>
        </span>
      </el-dialog>
    </el-row>
  </el-row>
</template>
<script>
import { SysUserModel } from "../../model/system/SysUserModel";
import { pageSizes, pageSize } from "../../common/global";
import { queryUser, saveUser } from "@/api/getData";
import { copyObject } from "../../common/util";
export default {
  name: "userMaintain",
  data() {
    return {
      queryUser: new SysUserModel(),
      editUser: new SysUserModel(),
      pageSizes: pageSizes,
      total: 0,
      tableData: [],
      editVisible: false,
      title: "用户新增",
      formDisabled: false /** 为true时，整个表单不可编辑 */,
      disabled: false /** 为true时，编辑时某些字段不可编辑 */,
      rules: {
        userId: [{ required: true, message: "用户代码", trigger: "blur" }],
        userName: [{ required: true, message: "用户名称", trigger: "blur" }]
      }
    };
  },
  methods: {
    handleCurrentChange(val) {
      this.currentRow = val;
    },
    handleSizeChange(val) {
      this.queryUser.limit = val;
      this.search();
    },
    handlePageChange(val) {
      this.queryUser.page = val;
      this.search();
    },
    handleDblclick(val) {
      this.edit();
    },
    search() {
      queryUser(this.queryUser).then(res => {
        if (res.success || res.success == "true") {
          this.total = res.total;
          this.tableData = res.dataList;
        } else {
          this.$message({
            type: "error",
            message: res.msg
          });
        }
      });
    },
    add() {
      this.editUser = new SysUserModel();
      this.editUser.saveFlag = "add";
      this.title = "用户新增";
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
      this.editUser = copyObject(this.currentRow, this.editUser);
      this.editUser.saveFlag = "mod";
      this.title = "用户编辑";
      this.editVisible = true;
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
    },
    save(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          saveUser(this.editUser).then(res => {
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
    }
  },
  mounted() {
    this.search();
  }
};
</script>
