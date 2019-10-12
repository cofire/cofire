<template>
  <el-row>
    <el-row class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-calendar"></i>
          {{ $t('common.route.R1') }}
        </el-breadcrumb-item>
        <el-breadcrumb-item>{{ $t('common.route.R12')}}</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-row class="query-form">
      <el-form :inline="true" :model="queryRole" ref="queryForm">
        <!-- :model="queryRole" ----表单数据对象 -->

        <el-form-item :label="$t('role.label.roleId')" prop="roleId" class="queryCondition">
          <el-input v-model="queryRole.roleId" :placeholder="$t('role.label.roleId')"></el-input>
        </el-form-item>

        <el-form-item :label="$t('role.label.roleName')" prop="roleName" class="queryCondition">
          <el-input v-model="queryRole.roleName" :placeholder="$t('role.label.roleName')"></el-input>
        </el-form-item>

        <el-form-item
          :label="this.$t('visitor.label.date')"
          prop="createTime"
          class="queryCondition"
        >
          <el-date-picker
            v-model.trim="queryRole.createTime"
            type="daterange"
            value-format="yyyyMMdd"
            :range-separator="this.$t('log.placeholder.dateto')"
            :start-placeholder="this.$t('visitor.placeholder.dateStr')"
            :end-placeholder="this.$t('visitor.placeholder.dateEnd')"
          ></el-date-picker>
        </el-form-item>
      </el-form>
    </el-row>
    <el-row class="table-operations">
      <el-button
        type="primary"
        icon="el-icon-lx-search"
        @click="submitQuery()"
      >{{$t('common.button.query')}}</el-button>
      <el-button
        type="primary"
        icon="el-icon-lx-attention"
        @click="viewDetail()"
      >{{$t('role.button.detail')}}</el-button>
      <el-button
        type="primary"
        icon="el-icon-lx-roundadd"
        @click="add()"
      >{{$t('common.button.add')}}</el-button>
      <el-button type="primary" icon="el-icon-lx-edit" @click="edit()">{{$t('common.button.edit')}}</el-button>
      <el-button
        type="primary"
        icon="el-icon-lx-delete"
        @click="delUserConfirm()"
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
        border
        highlight-current-row
        :data="tableData"
        v-loading="loading"
        @current-change="handleCurrentChange"
        @row-dblclick="handleDblclick"
        style="width: 100%"
      >
        <el-table-column type="index" :label="$t('role.label.num')" width="50"></el-table-column>
        <el-table-column property="roleId" :label="$t('role.label.roleId')" width="200"></el-table-column>
        <el-table-column property="roleName" :label="$t('role.label.roleName')" width="200"></el-table-column>
        <el-table-column property="descr" :label="$t('role.label.descr')" width="200"></el-table-column>
        <el-table-column property="creator" :label="$t('role.label.creator')" width="200"></el-table-column>
        <el-table-column
          property="createTime"
          :label="$t('role.label.createTime')"
          width="200"
          :formatter="formatCreateTime"
        ></el-table-column>
      </el-table>
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handlePageChange"
        :current-page="queryRole.page"
        :page-sizes="pageSizes"
        :page-size="queryRole.length"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
      ></el-pagination>
    </el-row>
    <!-- 编辑弹出框 -->
    <el-row>
      <el-dialog
        :title="title"
        :visible.sync="editVisible"
        width="40%"
        :close-on-click-modal="false"
      >
        <el-form
          ref="editForm"
          :rules="rules"
          :model="editRole"
          label-width="140px"
          :disabled="formDisabled"
        >
          <el-form-item :label="$t('role.label.roleId')" prop="roleId">
            <el-input v-model="editRole.roleId" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="$t('role.label.roleName')" prop="roleName">
            <el-input v-model="editRole.roleName"></el-input>
          </el-form-item>
          <el-form-item :label="$t('role.label.descr')" prop="descr">
            <el-input v-model="editRole.descr"></el-input>
          </el-form-item>
          <el-form-item :label="$t('role.label.rolePermission')" prop="rolePermission">
            <!--树形结构                               :check-strictly="checkStrictly"-->
            <div class="el-dialog-div">
              <el-tree
                ref="tree"
                :data="tree"
                show-checkbox
                node-key="id"
                class="permission-tree"
                :props="defaultProps"
                highlight-current
              />
            </div>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="editVisible = false">{{$t('common.button.cancel')}}</el-button>
          <el-button type="primary" @click="save('editForm')">{{$t('role.button.confirm')}}</el-button>
        </span>
      </el-dialog>
    </el-row>

    <!-- 查看详情弹出框 -->
    <el-row>
      <el-dialog
        :title="title"
        :visible.sync="viewVisible"
        width="40%"
        :close-on-click-modal="false"
      >
        <el-card class="box-card" model="viewRole">
          <el-row :gutter="12">
            <el-col :span="12">
              <el-card shadow="hover">{{$t('role.label.roleId')}}：{{viewRole.roleId}}</el-card>
            </el-col>
            <el-col :span="12">
              <el-card shadow="hover">{{$t('role.label.roleName')}}： {{viewRole.roleName}}</el-card>
            </el-col>
          </el-row>
          <el-row :gutter="12">
            <el-col :span="12">
              <el-card shadow="hover">{{$t('role.label.descr')}}: {{viewRole.descr}}</el-card>
            </el-col>
            <el-col :span="12">
              <el-card shadow="hover">{{$t('role.label.creator')}}: {{viewRole.creator}}</el-card>
            </el-col>
          </el-row>
          <el-row :gutter="12">
            <el-col :span="12">
              <el-card shadow="hover">{{$t('role.label.createTime')}}: {{viewRole.createTime}}</el-card>
            </el-col>
          </el-row>
        </el-card>
        <!--树形结构-->
        <div class="el-dialog-div">
          <el-tree
            ref="dataTree"
            :data="dataTree"
            show-checkbox
            node-key="id"
            class="permission-tree"
            :props="detailProps"
            highlight-current
          />
        </div>
        <span slot="footer" class="dialog-footer">
          <el-button type="primary" @click="viewVisible = false">{{this.$t('role.button.back')}}</el-button>
        </span>
      </el-dialog>
    </el-row>
  </el-row>
</template>
<script>
import { roleModel } from "../../model/role/roleModel";
import { pageSizes, pageSize } from "../../common/global";
import {
  queryRole,
  saveRole,
  deleteRole,
  getRoleTree,
  getRoleTreeDetail
} from "@/api/getData";
import { copyObject, formatDate, getBeginAndEnd } from "../../common/util";
export default {
  name: "roleMaintain",
  data() {
    //角色代码校验（字母和数字）
    var checkRoleId = (rule, value, callback) => {
      //校验用户代码
      var reg = /^[A-Za-z0-9 _]{1,32}$/;
      if (value != "" && reg.test(value)) {
        callback();
      } else {
        callback(new Error("角色代码只能是字母和数字"));
      }
    };

    return {
      queryRole: new roleModel(),
      editRole: new roleModel(),
      viewRole: new roleModel(),
      deleteRole: new roleModel(),
      pageSizes: pageSizes,
      total: 0,
      dataTree: [], //所有的权限列表
      tree: [],
      dataResourcetree: [], //接受后台传入的roleResources，即相关角色拥有的权限
      tableData: [],
      editVisible: false,
      viewVisible: false,
      title: this.$t("role.title.addtitle"),
      formDisabled: false /** 为true时，整个表单不可编辑 */,
      disabled: false /** 为true时，编辑时某些字段不可编辑 */,
      loading: false,
      rules: {
        //trigger: ‘blur’ 表示“当失去焦点时（光标不显示的时候），触发此提示”
        //required:true 表示必填
        roleId: [
          {
            required: true,
            message: this.$t("role.rules.roleId"),
            trigger: "blur"
          },
          {
            min: 1,
            max: 32,
            message: "长度在 1 到 32 个字符",
            trigger: "blur"
          },
          {
            validator: checkRoleId,
            trigger: "blur"
          }
        ],
        roleName: [
          {
            required: true,
            message: this.$t("role.rules.roleName"),
            trigger: "blur"
          },
          {
            min: 1,
            max: 50,
            message: "长度在 1 到 50 个字符",
            trigger: "blur"
          }
        ],
        descr: [
          {
            min: 0,
            max: 120,
            message: "长度不可超过 120 个字符",
            trigger: "blur"
          }
        ]
      },
      defaultProps: {
        children: "children",
        label: "label",
        id: "id"
      },
      detailProps: {
        children: "children",
        label: "label",
        id: "id",
        disabled: "disabled"
      }
    };
  },
  methods: {
    // //获取角色树
    // 	getRoleTree(editRole) {
    // 		getRoleTree(editRole).then(res => {
    // 			console.info(res);
    // 			if (res.success) {
    //         console.log(res);
    //         this.dataTree = res.data.resource;
    //         this.dataResourcetree = res.data.roleResources;
    // 			} else {
    // 				this.$message({
    // 					type: "error",
    // 					message: this.$t('common.code.' + res.code)
    // 				});
    // 			}
    // 		});
    // 	},

    //创建时间格式转换
    formatCreateTime(row, column) {
      return formatDate(row.createTime);
    },

    handleCurrentChange(val) {
      this.currentRow = val;
    },
    handleSizeChange(val) {
      this.queryRole.length = val;
      this.search();
    },
    handlePageChange(val) {
      this.queryRole.page = val;
      this.search();
    },
    handleDblclick(val) {
      this.edit();
    },
    //重置查询表单
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },

    //删除确认框
    delUserConfirm() {
      if (this.currentRow == null || this.currentRow == undefined) {
        this.$message({
          type: "warning",
          message: this.$t("role.message.deleteSelect")
        });
        return;
      }
      this.$confirm(
        this.$t("role.label.deleteInfo"),
        this.$t("role.label.tip"),
        {
          confirmButtonText: this.$t("role.button.confirm"),
          cancelButtonText: this.$t("role.button.cancel"),
          type: "warning"
        }
      )
        .then(() => {
          this.deleRole();
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: this.$t("role.message.cancelDelete")
          });
        });
    },

    //删除角色信息
    deleRole() {
      this.deleteRole = copyObject(this.currentRow, this.deleteRole);
      deleteRole(this.deleteRole).then(res => {
        if (res.success || res.success == "true") {
          this.$message({
            type: "success",
            message: this.$t("common.code." + res.code)
          });
          this.search();
        } else {
          this.$message({
            type: "error",
            message: this.$t("common.code." + res.code)
          });
        }
      });
    },

    //点击查询，当前页码改为1
    submitQuery() {
      this.queryRole.page = 1;
      this.search();
    },

    search() {
  
      this.loading = true;
      if (null != this.queryRole.createTime) {
        var list = getBeginAndEnd(this.queryRole.createTime.toString());
        this.queryRole.createTime = list.split(",");
      }
      queryRole(this.queryRole).then(res => {
        if (res.success || res.success == "true") {
          if (res.total > 0 && res.data.length == 0) {
            this.queryRole.page--;
            this.search();
          } else {
            this.total = res.total;
            this.tableData = res.data;
          }
        } else {
          this.$message({
            type: "error",
            message: res.message
          });
        }
        this.loading = false;
      });
    },

    add() {
      this.editRole = new roleModel();
      this.editRole.flag = "add";
      this.title = this.$t("role.title.addtitle");
      this.editVisible = true;
      this.disabled = false; //设置角色代码为可编辑
      // this.getRoleTree(this.editRole);
      getRoleTree(this.editRole).then(res => {
        if (res.success) {
          this.$nextTick(() => {
            this.$refs.tree.setCheckedKeys([]);
          });
          this.tree = res.data.resource;
        } else {
          this.$message({
            type: "error",
            message: this.$t("common.code." + res.code)
          });
        }
      });
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
    },

    edit() {
      if (this.currentRow == null || this.currentRow == undefined) {
        this.$message({
          type: "warning",
          message: this.$t("role.message.editSelect")
        });
        return;
      }
      this.disabled = true;
      //把选中的角色复制到修改角色对象中
      this.editRole = copyObject(this.currentRow, this.editRole);
      this.editRole.flag = "mod";
      this.title = this.$t("role.title.edittitle");
      // this.getRoleTree(this.editRole);
      getRoleTree(this.editRole).then(res => {
        if (res.success) {
          console.info(res.data);
          this.tree = res.data.resource;
          this.dataResourcetree = res.data.roleResources;
          var roleResources = [];
          for (var i = 0; i < this.dataResourcetree.length; i++) {
            if (this.dataResourcetree[i].children.length != 0) {
              for (
                var j = 0;
                j < this.dataResourcetree[i].children.length;
                j++
              ) {
                roleResources.push(this.dataResourcetree[i].children[j].resId);
              }
            }
            //              roleResources.push(this.dataResourcetree[i].resId);
          }
          // this.$refs.dataTree.setCheckedKeys(roleResources);
          this.$nextTick(() => {
            this.$refs.tree.setCheckedKeys(roleResources);
          });
        } else {
          this.$message({
            type: "error",
            message: this.$t("common.code." + res.code)
          });
        }
      });
      // this.$refs.dataTree.getCheckedKeys()
      this.editVisible = true;
      //清除校验提醒
      if (this.$refs["editForm"] != undefined) {
        this.$refs["editForm"].clearValidate();
      }
    },

    //查看详情
    viewDetail() {
      if (this.currentRow == undefined || this.currentRow == null) {
        this.$message({
          type: "warning",
          message: this.$t("role.message.viewSelect")
        });
        return;
      }
      this.viewRole = copyObject(this.currentRow, this.viewRole);
      this.viewRole.flag = "detail";
      this.viewRole.createTime = formatDate(this.viewRole.createTime);
      this.title = this.$t("role.label.viewDetail");
      getRoleTreeDetail(this.viewRole).then(res => {
        if (res.success) {
          var roleResources = [];
          this.dataTree = res.data.resource;
          this.dataResourcetree = res.data.roleResources;

          for (var i = 0; i < this.dataResourcetree.length; i++) {
            if (this.dataResourcetree[i].children.length != 0) {
              for (
                var j = 0;
                j < this.dataResourcetree[i].children.length;
                j++
              ) {
                roleResources.push(this.dataResourcetree[i].children[j].resId);
              }
            }
          }
          for (var s = 0; s < this.dataResourcetree[s]; s++) {
            this.dataResourcetree[s].disabled = false;
          }
          this.$refs.dataTree.setCheckedKeys(roleResources);
          for (var m = 0; s < this.dataResourcetree[m]; m++) {
            this.dataResourcetree[m].disabled = true;
          }
        } else {
          this.$message({
            type: "error",
            message: this.$t("common.code." + res.code)
          });
        }
      });
      this.viewVisible = true;
    },

    //数组转字符串
    acTiveArrStringFun(obj) {
      var arr = [];
      if (obj != null && obj.length != 0) {
        for (var i = 0; i < obj.length; i++) {
          arr.push(obj[i]);
        }
      }
      return arr.toString();
    },

    save(formName) {
      this.$refs[formName].validate(valid => {
        this.editRole.rolePermission =
          this.acTiveArrStringFun(this.$refs.tree.getCheckedKeys()) +
          "," +
          this.acTiveArrStringFun(this.$refs.tree.getHalfCheckedKeys());
        if (valid) {
          saveRole(this.editRole).then(res => {
            if (res.success || res.success == "true") {
              this.editVisible = false;
              this.$message({
                type: "success",
                message: res.message
              });
              this.search();
            } else {
              this.$message({
                type: "error",
                message: res.message
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
<style>
.el-dialog-div {
  height: 40vh;
  overflow: auto;
}
</style>