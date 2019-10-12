import Vue from 'vue';
import Router from 'vue-router';
import Home from '@/components/layout/Home'
import Dashboard from '@/components/page/Dashboard'
import Login from '@/components/page/Login'
import P404 from '@/components/page/404'
import P403 from '@/components/page/404'
import UserMaintain from '@/components/page/userManage/UserMaintain'
// import LoginLog from '@/components/page/logManage/LoginLog'
// import OpeLog from '@/components/page/logManage/OpeLog'
// import Depart from '@/components/page/departManage/Depart'
// import RoleMaintain from '@/components/page/roleManage/RoleMaintain'
// import DictMaintain from '@/components/page/dictManage/DictMaintain'
// import ParamsMaintain from '@/components/page/paramsManage/ParamsMaintain'
// import RichTextMaintain from '@/components/page/richTextManage/RichTextMaintain'
Vue.use(Router);

export default new Router({
    routes: [{
            path: '/',
            redirect: '/login'
        },
        {
            path: '/',
            component: Home,
            meta: {
                title: 'common.route.R01'
            },
            children: [{
                    path: '/dashboard',
                    component: Dashboard,
                    meta: {
                        title: 'common.route.R02'
                    }
                },
                {
                    path: '/user',
                    component: UserMaintain,
                    meta: {
                        title: 'common.route.R11'
                    }
                },
                {
                    path: '/404',
                    component: P404,
                    meta: {
                        title: '404'
                    }
                },
                {
                    path: '/403',
                    component: P403,
                    meta: {
                        title: '403'
                    }
                }
            ]
        },
        {
            path: '/login',
            component: Login
        },
        {
            path: '*',
            redirect: '/404'
        }
    ]
})