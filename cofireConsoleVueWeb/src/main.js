import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'; // 默认主题
// import '../static/css/theme-green/index.css';       // 浅绿色主题
import './assets/css/icon.css';
import './assets/css/common.css';
import './components/common/directives';
import "babel-polyfill";
// vuei18n 
import i18n from './i18n/i18n';
import BaseUtil from './BaseUtil'

import {getUserDetail} from '@/api/getData'
import {loginUserDetailStore} from '@/components/store/common/loginUserDetailStore';

import Viewer from 'v-viewer'
import 'viewerjs/dist/viewer.css'

Vue.config.productionTip = false
Vue.use(ElementUI, {
    size: 'small',
    i18n: (key, value) => i18n.t(key, value)
});

Vue.use(BaseUtil);

Vue.prototype.$axios = axios;
axios.defaults.withCredentials = true

//使用钩子函数对路由进行权限跳转
router.beforeEach((to, from, next) => {
    const userId = loginUserDetailStore.state.userId;
    const localUserName = localStorage.getItem("userName");
    if((localUserName == undefined || localUserName == null || localUserName == "") &&  to.path !== '/login'){
        next('/login');
        return;
    }
    if((userId == undefined || userId == null || userId == "") &&  to.path !== '/login'){
        getUserDetail().then((re) => {
            if (re.success || re.success == "true") {
                loginUserDetailStore.dispatch("set", re.data.menuList);
                loginUserDetailStore.dispatch("setUserId", re.data.userId);
                localStorage.setItem('common', JSON.stringify(re.data.common));
                console.log("加载菜单成功");
                next();
            }else{
                console.log("加载菜单失败");
                localStorage.removeItem('userName');
                localStorage.removeItem('menuList');
                next('/login');
            }
        });
    } else {
        next();
    }
    
})


new Vue({
    router,
    i18n,
    render: h => h(App)
}).$mount('#app')

Vue.use(Viewer)
Viewer.setDefaults({
  Options: {
    'inline': true, // 启用 inline 模式
    'button': true, // 显示右上角关闭按钮
    'navbar': true, // 显示缩略图导航
    'title': true, // 显示当前图片的标题
    'toolbar': true, // 显示工具栏
    'tooltip': true, // 显示缩放百分比
    'movable': true, // 图片是否可移动
    'zoomable': true, // 图片是否可缩放
    'rotatable': true, // 图片是否可旋转
    'scalable': true, // 图片是否可翻转
    'transition': true, // 使用 CSS3 过度
    'fullscreen': true, // 播放时是否全屏
    'keyboard': true, // 是否支持键盘
    'url': 'data-source' ,// 设置大图片的 url
    'zIndexInline':2,//在inline模式下设置图片的优先级
    
  }
})