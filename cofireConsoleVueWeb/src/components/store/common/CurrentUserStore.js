import Vue from 'vue'
import Vuex from 'vuex'
import { SysUserModel } from "../../model/system/SysUserModel";
import createPersistedState from "vuex-persistedstate"

Vue.use(Vuex)

const CurrentUserStore = new Vuex.Store({
  plugins: [createPersistedState({
            storage:window.sessionStorage
        })],
  // 全局变量
  state: {
      user: new SysUserModel(),
      menuList: [],
      dictList: [],
      tagList:[],
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
      setTagList(state, data) {
        state.tagList = data;
      },
      clearTagList(state) {
          state.tagList = [];
      },
      setLang (state, data) {
        state.lang = data;
      },
      clearLang (state) {
        state.lang = 'cn';
      },
      set(state, data) {
        state.menuList = data.menuList;
        state.user = data.user;
        state.dictList = data.dictList;
      },
      clear(state){
        state.menuList = [];
        state.user = new SysUserModel();
        state.dictList = [];
        state.lang = 'cn';
      }
  },
  // 异步方法用actions
  // actions不能直接修改全局变量，需要调用commit方法来触发mutation中的方法
  actions: {
      setMenuList (context, data) {
          context.commit('setMenuList', data)
      },
      clearMenuList (context) {
          context.commit('clearMenuList')
      },
      setUser (context, data) {
          context.commit('setUser', data)
      },
      clearUser (context) {
        context.commit('clearUser')
      },
      setTagList (context, data) {
        context.commit('setTagList', data)
      },
      clearTagList (context) {
          context.commit('clearTagList')
      },
      setLang (context, data) {
        context.commit('setLang', data)
      },
      clearLang (context) {
        context.commit('clearLang')
      },
      set(context, data) {
        context.commit('set', data)
      },
      clear(context, data){
        context.commit('clear');
      }
  }
})

export {CurrentUserStore};