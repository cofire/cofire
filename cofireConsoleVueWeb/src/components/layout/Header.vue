<template>
  <el-row>
    <div class="header">
      <!-- 折叠按钮 -->
      <div class="collapse-btn" @click="collapseChage">
        <i class="el-icon-menu"></i>
      </div>
      <div class="logo">{{this.$t('common.label.platformTitle')}}</div>
      <div class="header-right">
        <div class="header-user-con">
          <!-- 全屏显示 -->
          <div class="btn-fullscreen" @click="handleFullScreen">
            <el-tooltip effect="dark" :content="fullscreen?`取消全屏`:`全屏`" placement="bottom">
              <i class="el-icon-rank"></i>
            </el-tooltip>
          </div>
          <div class="lang">
            <label class="lang-label">{{this.$t('common.label.selectLang')}}：</label>
            <el-radio-group v-model="lang" @change="langChangeHandler">
              <el-radio label="cn">中文</el-radio>
              <el-radio label="en">English</el-radio>
            </el-radio-group>
          </div>
          <!-- 用户头像 -->
          <div class="user-avator">
            <img src="/static/avator.jpg">
          </div>
          <!-- 用户名下拉菜单 -->
          <el-dropdown class="user-name" trigger="click" @command="handleCommand">
            <span class="el-dropdown-link">
              {{username}}
              <i class="el-icon-caret-bottom"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <!-- <a href target="_blank">
                <el-dropdown-item>关于作者</el-dropdown-item>
              </a>
              <a href target="_blank">
                <el-dropdown-item>项目仓库</el-dropdown-item>
              </a>-->
              <!-- 下拉框的写法 -->
              <el-dropdown-item divided command="updatePassword" icon="el-icon-key" >{{$t('common.button.resetPsw')}}</el-dropdown-item>
              <el-dropdown-item divided command="loginout" icon="el-icon-switch-button">{{ $t('common.button.loginOut')}}</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </div>
    </div>

    <el-row><!-- 添加不关闭遮罩的代码 -->
      <el-dialog :title="title" width="30%" :visible.sync="editVisible" :close-on-click-modal="false">
        <el-form ref="updateUserPsw" :rules="rules" :model="updateUserPsw" label-width="100px">
          <el-form-item :label="$t('common.label.currentPsw')" prop="currentPsw">
            <el-input type="password" v-model="updateUserPsw.currentPsw"></el-input>
          </el-form-item>
          <el-form-item :label="$t('common.label.newPsw')" prop="newPsw">
            <el-input type="password" v-model="updateUserPsw.newPsw"></el-input>
          </el-form-item>
          <el-form-item :label="$t('common.label.confirmNewPsw')" prop="confirmNewPsw">
            <el-input type="password" v-model="updateUserPsw.confirmNewPsw"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
              <el-button @click="editVisible = false">{{ $t('common.button.cancel') }}</el-button>
              <el-button type="primary"
                         @click="confirmUpdatePsw('updateUserPsw')">{{ $t('common.button.confirm') }}</el-button>
        </span>
      </el-dialog>
    </el-row>
  </el-row>
</template>
<script>
  import bus from '../common/bus'
  import {loginOut} from '@/api/getData'
  import {userPswModel} from '../model/userPsw/userPswModel'
  // import {confirmUpdatePsw} from '../../api/getData'
  import {baseImgPath} from '@/config/env.js'
  import { CurrentUserStore } from "../store/common/CurrentUserStore";
  export default {
    inject: ['reload'],
    data () {
      var validatePass = (rule, value, callback) => {
        if (this.updateUserPsw.confirmNewPsw !== '') {
          this.$refs.updateUserPsw.validateField('confirmNewPsw')
        }
        var reg = /[\u4E00-\u9FA5]/
        if (reg.test(value)) {
          callback(new Error(this.$t('common.message.pswContainChinese')))
        } else {
          callback()
        }
      }
      var validatePass2 = (rule, value, callback) => {
        var reg = /[\u4E00-\u9FA5]/
        if (reg.test(value)) {
          callback(new Error(this.$t('common.message.pswContainChinese')))
        }
        if (value !== this.updateUserPsw.newPsw) {
          callback(new Error(this.$t('common.message.pswNotSame')))
        } else {
          callback()
        }
      }
      var checkPswContainChinese = (rule, value, callback) => {
        var reg = /[\u4E00-\u9FA5]/
        if (reg.test(value)) {
          callback(new Error(this.$t('common.message.pswContainChinese')))
        } else {
          callback()
        }
      }
      return {
        updateUserPsw: new userPswModel(),
        editVisible: false,//控制弹出框是否显示的问题
        title: this.$t('common.title.resetPswTitle'),
        lang: 'cn',
        collapse: false,
        fullscreen: false,
        name: 'linxin',
        message: 2,
        updateUserPsw: {
          currentPsw: '',
          newPsw: '',
          confirmNewPsw: ''
        },
        rules: {
          currentPsw: [
            {required: true, message: this.$t('common.message.inputCurrentPsw'), trigger: 'blur'},
            {validator: checkPswContainChinese, trigger: 'blur'}
          ],
          newPsw: [
            {required: true, message: this.$t('common.message.inputNewPsw'), trigger: 'blur'},
            // { validator: checkGroupId , trigger: 'blur'},
            {validator: validatePass, trigger: 'blur'}
          ],
          confirmNewPsw: [
            {required: true, message: this.$t('common.message.inputConfirmNewPsw'), trigger: 'blur'},
            {validator: validatePass2, trigger: 'blur'}
          ]
        }
      }
    },
    computed: {
      username () {
        let username = CurrentUserStore.state.user.userName;
        return username ? username : this.name
      }
    },
    methods: {
      langChangeHandler (val) {
        localStorage.setItem('lang', val)
        this.$i18n.locale = val
        this.reload()
      },
      // 用户名下拉菜单选择事件
      handleCommand (command) {
        //两个if校验
        if (command == 'loginout') {
          this.$confirm(this.$t('common.label.loginOutTitle'), this.$t('common.label.prompt'), {
            confirmButtonText: this.$t('common.button.confirm'),
            cancelButtonText: this.$t('common.button.cancel'),
            type: 'warning'
          }).then(() => {
            loginOut().then(res => {
              if (res.success || res.success == 'true') {
                this.$message({
                  type: 'success',
                  message: res.message
                })
              } else {
                this.$message({
                  type: 'error',
                  message: res.message
                })
              }
            })
            localStorage.removeItem('userName')
            localStorage.removeItem('menuList')
            this.$router.replace('/login')
          })
        }
        if (command == 'updatePassword') {
          this.updatePassword();
        }
      },
      // 侧边栏折叠
      collapseChage () {
        this.collapse = !this.collapse
        bus.$emit('collapse', this.collapse)
      },
      // 全屏事件
      handleFullScreen () {
        let element = document.documentElement
        if (this.fullscreen) {
          if (document.exitFullscreen) {
            document.exitFullscreen()
          } else if (document.webkitCancelFullScreen) {
            document.webkitCancelFullScreen()
          } else if (document.mozCancelFullScreen) {
            document.mozCancelFullScreen()
          } else if (document.msExitFullscreen) {
            document.msExitFullscreen()
          }
        } else {
          if (element.requestFullscreen) {
            element.requestFullscreen()
          } else if (element.webkitRequestFullScreen) {
            element.webkitRequestFullScreen()
          } else if (element.mozRequestFullScreen) {
            element.mozRequestFullScreen()
          } else if (element.msRequestFullscreen) {
            // IE11
            element.msRequestFullscreen()
          }
        }
        this.fullscreen = !this.fullscreen
      },
      //出现弹出框
      updatePassword () {
        this.updateUserPsw = new userPswModel()
        this.editVisible = true
        if (this.$refs['updateForm'] != undefined) {
          this.$refs['updateForm'].clearValidate()
        }
      },
      //点击确认 这里就执行重置功能
      confirmUpdatePsw (formName) {//这里需要接收表中传过来的参数值
        this.$refs[formName].validate(valid => {
          if (valid) {
            // currentPsw : encrypt('string', this.updateUserPsw.currentPsw)
            confirmUpdatePsw(this.updateUserPsw).then(res => {
              this.editVisible = false
              if (res.success || res.success == 'true') {
                this.$message({
                  type: 'success',
                  message: this.$t('code.' + res.code)
                })
              } else {
                this.$message({
                  type: 'error',
                  message: this.$t('code.' + res.code)
                })
              }
            })
          } else {
            console.log(this.$t('param.message.validationFail'))
          }
        })
      },
    },
    mounted () {
      this.lang = this.$i18n.locale
      if (document.body.clientWidth < 1500) {
        this.collapseChage()
      }
    }
  }
</script>
<style scoped>
  .header {
    position: relative;
    box-sizing: border-box;
    width: 100%;
    height: 70px;
    font-size: 22px;
    color: #fff;
  }

  .collapse-btn {
    float: left;
    padding: 0 21px;
    cursor: pointer;
    line-height: 70px;
  }

  .header .logo {
    float: left;
    width: 250px;
    line-height: 70px;
  }

  .header-right {
    float: right;
    padding-right: 50px;
  }

  .header-user-con {
    display: flex;
    height: 70px;
    align-items: center;
  }

  .btn-fullscreen {
    transform: rotate(45deg);
    margin-right: 5px;
    font-size: 24px;
  }

  .btn-bell,
  .btn-fullscreen {
    position: relative;
    width: 30px;
    height: 30px;
    text-align: center;
    border-radius: 15px;
    cursor: pointer;
  }

  .btn-bell-badge {
    position: absolute;
    right: 0;
    top: -2px;
    width: 8px;
    height: 8px;
    border-radius: 4px;
    background: #f56c6c;
    color: #fff;
  }

  .btn-bell .el-icon-bell {
    color: #fff;
  }

  .user-name {
    margin-left: 10px;
  }

  .user-avator {
    margin-left: 20px;
  }

  .user-avator img {
    display: block;
    width: 40px;
    height: 40px;
    border-radius: 50%;
  }

  .el-dropdown-link {
    color: #fff;
    cursor: pointer;
  }

  .el-dropdown-menu__item {
    text-align: center;
  }

  li {
    text-align: left !important;
  }

  .lang-label {
    /* line-height: 32px; */
    font-size: 14px;
  }
  .el-radio{
    color: rgb(191, 203, 217) !important;
  }  
</style>
