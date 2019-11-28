<template>
  <div
    class="login-wrap"
    v-loading="loadingModel.loading"
    :element-loading-text="loadingModel.text"
    :element-loading-spinner="loadingModel.spinner"
    :element-loading-background="loadingModel.background"
  >
    <div class="ms-login">
      <div class="ms-title">{{$t('common.label.platformTitle')}}</div>
      <el-form
        :model="loginForm"
        :rules="rules"
        ref="loginForm"
        label-width="0px"
        class="ms-content"
      >
        <el-form-item prop="userId">
          <el-input
            v-model="loginForm.userId"
            prefix-icon="el-icon-user"
            :placeholder="$t('login.userId')"
          ></el-input>
        </el-form-item>
        <el-form-item prop="passWord">
          <el-input
            type="passWord"
            :placeholder="$t('login.passWord')"
            v-model="loginForm.passWord"
            @keyup.enter.native="submitForm('loginForm')"
            prefix-icon="el-icon-lock"
          ></el-input>
        </el-form-item>
        <div class="lang">
          <label class="lang-label">{{$t('common.label.selectLang')}}：</label>
          <el-radio-group v-model="lang" @change="langChangeHandler">
            <el-radio label="cn">中文</el-radio>
            <el-radio label="en">English</el-radio>
          </el-radio-group>
        </div>
        <div class="login-btn">
          <el-button
            type="primary"
            @click="submitForm('loginForm')"
          >{{$t('common.button.login')}}</el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script>
import { login, getUserDetail } from "../../api/getData";
import { encrypt } from "../common/3des";
import { Rules } from "../rules/Rules";
import { CurrentUserStore } from "../store/common/CurrentUserStore";
import {BaseModel} from "../model/common/BaseModel";

export default {
  inject: ["reload"],
  data: function() {
    return {
      loadingModel: new this.LoadingModel(),
      loginForm: {
        userId: "",
        passWord: ""
      },
      lang: CurrentUserStore.state.lang,
      rules: Rules.LoginRules
    };
  },
  methods: {
    langChangeHandler(val) {
      this.$i18n.locale = val;
      CurrentUserStore.dispatch("setLang", val );
      this.setSelectOption();
      this.reload();
    },
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          // this.loadingModel.loading = true;
          this.fullScreenLoading("common.message.loginLoading");
          login({
            userId: this.loginForm.userId,
            passWord: encrypt(this.loginForm.userId, this.loginForm.passWord),
            source: "pc",
            operation: "login",
          }).then(res => {
            if (res.success || res.success == "true") {
              getUserDetail(new BaseModel()).then(re => {
                if (re.success || re.success == "true") {
                  CurrentUserStore.dispatch("set", re.data);
                  CurrentUserStore.dispatch("clearTagList")
                  console.log("加载菜单成功");
                } else {
                  console.log("加载菜单失败");
                }
                this.$message.success(this.$t("code." + res.code));
                this.$router.replace("/dashboard");
              });
            } else {
              this.$message.error(this.$t("code." + res.code));
            }
            debugger;
            this.fullScreenLoading("common.message.loginLoading").close();
            // this.loadingModel.loading = false;
          });
        } else {
          console.log("error submit!!");
          this.loading = false;
          return false;
        }
      });
    }
  },
  mounted() {
    this.lang = this.$i18n.locale;
  }
};
</script>

<style scoped>
.login-wrap {
  position: relative;
  width: 100%;
  height: 100%;
  background-image: url(../../assets/img/login-bg.jpg);
  background-size: 100%;
}
.ms-title {
  width: 100%;
  line-height: 50px;
  text-align: center;
  font-size: 20px;
  color: #fff;
  border-bottom: 1px solid #ddd;
}
.ms-login {
  position: absolute;
  left: 50%;
  top: 50%;
  width: 350px;
  margin: -190px 0 0 -175px;
  border-radius: 5px;
  background: rgba(255, 255, 255, 0.3);
  overflow: hidden;
}
.ms-content {
  padding: 30px 30px;
}
.login-btn {
  text-align: center;
}
.login-btn button {
  width: 100%;
  height: 36px;
  margin-bottom: 10px;
}
.login-tips {
  font-size: 12px;
  line-height: 30px;
  color: #fff;
}
.lang {
  background-color: #fff;
  line-height: 32px;
  padding: 0 15px;
  margin-bottom: 15px;
}
.lang-label {
  line-height: 32px;
  font-size: 14px;
  color: #606266;
}
</style>
