import Vue from 'vue'
import Vuex from 'vuex'
import { SysUserModel } from "../../model/system/SysUserModel";
import { menuBarModel } from '../../model/common/menuBarModel';
import { menuModel } from '../../model/common/menuModel';

Vue.use(Vuex)

/**
 *
 * @param {*} data 后台获取到菜单数据
 * @param {boolean} [flag=true] 为true时代表的是一级菜单
 * @returns
 */
function getMenuList(data, flag = true){
  if(data == undefined || data == null){
      return null;
  }
  var menuList = [];
  if(Object.prototype.toString.call(data)  === '[object Array]'){
      data.forEach(item => {
          var menu = new menuBarModel(); //侵短接受对象
          var menuM = new menuModel(); // 后台返回对象
          menuM = item;
          menu.title = 'common.route.R'+menuM.data;
          menu.index = menuM.link;
          if((menuM.submenu == undefined || menuM.submenu == null) && flag){
              menu.icon = 'el-icon-li-content';
          }else if(menuM.submenu != null && flag){
              menu.icon = 'el-icon-lx-cascades';
          }
          if(menuM.submenu != null){
              var submenuList = getMenuList(menuM.submenu, false);
              menu.submenu = submenuList;
              menu.index = menuM.data;
      menu.title = 'common.route.R'+menuM.data;
          }
          menuList.push(menu);
      });
      return menuList;
  }
  return null;
}


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
           // 菜单初始化
          var menuList = [
              {
                  icon: 'el-icon-lx-home',
                  index: '/dashboard',
                  title: 'common.route.R02',
                  submenu: null
              },
          ];
          getMenuList(data).forEach(menu => {
              menuList.push(menu);
          });
          state.menuList = menuList;
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