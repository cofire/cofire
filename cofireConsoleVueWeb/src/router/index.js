import Vue from 'vue';
import Router from 'vue-router';
import Home from '../components/layout/Home'
import Dashboard from '../components/page/Dashboard'
import Login from '../components/page/Login'
import P404 from '../components/page/404'
import P403 from '../components/page/404'
import UserMaintain from '../components/page/system/UserMaintain'
import RoleMaintain from '../components/page/system/RoleMaintain'
import DictMaintain from '../components/page/system/DictMaintain'
import ParamMaintain from '../components/page/system/ParamMaintain'
import JobLogMaintain from '../components/page/log/JobLogMaintain'
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
                    path: '/role',
                    component: RoleMaintain,
                    meta: {
                        title: 'common.route.R12'
                    }
                },
                {
                    path: '/dict',
                    component: DictMaintain,
                    meta: {
                        title: 'common.route.R22'
                    }
                },
                {
                    path: '/param',
                    component: ParamMaintain,
                    meta: {
                        title: 'common.route.R21'
                    }
                },
                {
                    path: '/jobLog',
                    component: JobLogMaintain,
                    meta: {
                        title: 'common.route.R33'
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
