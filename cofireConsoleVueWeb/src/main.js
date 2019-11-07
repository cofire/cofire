import Vue from 'vue'
import App from './App.vue'
import router from './router'
import axios from './config/http'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'; // 默认主题
import './assets/css/common.css';
import './components/common/directives';
import "babel-polyfill";
// vuei18n 
import i18n from './i18n/i18n';
import BaseUtil from './components/common/BaseUtil'

import {getUserDetail} from '@/api/getData'
import {CurrentUserStore} from './components/store/common/CurrentUserStore';

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
    const userId = CurrentUserStore.state.user.userId;
    if(to.path !== '/login' && Vue.prototype.isBlank(userId)){
        getUserDetail().then((re) => {
            if (re.success || re.success == "true") {
                CurrentUserStore.dispatch("set", re.data);
                console.log("加载菜单成功");
                next();
            }else{
                console.log("加载菜单失败"); 
                CurrentUserStore.dispatch("clear");
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