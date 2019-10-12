// loginUserDetailStore 是储存系统中已经登录了的用户信息
import Vue from 'vue'
import Vuex from 'vuex'
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

const loginUserDetailStore = new Vuex.Store({
    // 全局变量
    state: {
        userId: "",
        menuList: []
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
                // {
                //     icon: 'el-icon-lx-emoji',
                //     index: '/icon',
                //     title: 'common.route.R03',
                //     submenu: null
                // }
            ];
            // console.log("处理后:"+getMenuList(data));
            getMenuList(data).forEach(menu => {
                menuList.push(menu);
            });
            state.menuList = menuList;
            localStorage.setItem('menuList', JSON.stringify(menuList));
        },
        clearMenuList(state) {
            state.menuList = [];
        },
        setUserId(state, data) {
            state.userId = data;
            localStorage.setItem('userName', data);
        }
    },
    // 异步方法用actions
    // actions不能直接修改全局变量，需要调用commit方法来触发mutation中的方法
    actions: {
        set (context, data) {
            console.log(data);
            context.commit('setMenuList', data)
        },
        setUserId (context, data) {
            console.log(data);
            context.commit('setUserId', data)
        },
        clear (context) {
            console.log(data);
            context.commit('clearMenuList')
        }
    }
})

export {loginUserDetailStore};