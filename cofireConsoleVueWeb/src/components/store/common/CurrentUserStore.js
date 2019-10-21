import Vue from 'vue'
import Vuex from 'vuex'
import { SysUserModel } from "../../model/system/SysUserModel";

Vue.use(Vuex)

const CurrentUserStore = new Vuex.Store({
  // 全局变量
  state: {
      user: new SysUserModel(),
      menuList: [],
      lang: 'cn'
  },
  // 修改全局变量必须通过mutations中的方法
  // mutations只能采用同步方法
  mutations: {
      setMenuList(state, data) {
          state.menuList = data;
      },
      clearMenuList(state) {
          state.menuList = [];
      },
      setUser(state, data) {
          state.user = data;
      },
      clearUser(state) {
          state.user = new SysUserModel();
      },
      setLang (state, data) {
        state.lang = data;
      },
      clearLang (state) {
        state.lang = 'cn';
      }
  },
  // 异步方法用actions
  // actions不能直接修改全局变量，需要调用commit方法来触发mutation中的方法
  actions: {
      setMenuList (context, data) {
          context.commit('setMenuList', data)
      },
      setUser (context, data) {
          context.commit('setUser', data)
      },
      clearMenuList (context) {
          context.commit('clearMenuList')
      },
      clearUser (context) {
        context.commit('clearUser')
      },
      setLang (context, data) {
        context.commit('setLang', data)
      },
      clearLang (context) {
        context.commit('clearLang')
      }
  }
})

export {CurrentUserStore};