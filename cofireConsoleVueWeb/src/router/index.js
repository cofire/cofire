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
import ResourceMaintain from '../components/page/system/ResourceMaintain'
import ReturnCodeMaintain from '../components/page/system/ReturnCodeMaintain'
import JobLogMaintain from '../components/page/log/JobLogMaintain'
import JobMaintain from '../components/page/system/JobMaintain'
import LoginAuditMaintain from '../components/page/log/LoginAuditMaintain'
import OperateAuditMaintain from '../components/page/log/OperateAuditMaintain'

import Printer from '../components/page/tools/Printer'
import Icon from '../components/page/tools/Icon'

Vue.use(Router);

export default new Router({
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition //游览器返回记住位置
    } else {
      return {
        x: 0,
        y: 0
      } //滚动到顶
    }
  },
  routes: [{
      path: '/',
      redirect: '/login'
    },
    {
      path: '/',
      component: Home,
      meta: {
        title: 'common.route.Home'
      },
      children: [{
          path: '/dashboard',
          component: Dashboard,
          meta: {
            title: 'common.route.Home'
          }
        },
        {
          path: '/user',
          component: UserMaintain,
          meta: {
            title: 'common.route.UserMaintain'
          }
        },
        {
          path: '/role',
          component: RoleMaintain,
          meta: {
            title: 'common.route.RoleMaintain'
          }
        },
        {
          path: '/resource',
          component: ResourceMaintain,
          meta: {
            title: 'common.route.ResourceMaintain'
          }
        },
        {
          path: '/dict',
          component: DictMaintain,
          meta: {
            title: 'common.route.DictMaintain'
          }
        },
        {
          path: '/param',
          component: ParamMaintain,
          meta: {
            title: 'common.route.ParamMaintain'
          }
        },
        {
          path: '/returnCode',
          component: ReturnCodeMaintain,
          meta: {
            title: 'common.route.ReturnCodeMaintain'
          }
        },
        {
          path: '/job',
          component: JobMaintain,
          meta: {
            title: 'common.route.JobMaintain'
          }
        },
        {
          path: '/jobLog',
          component: JobLogMaintain,
          meta: {
            title: 'common.route.JobLogMaintain'
          }
        },
        {
          path: '/loginAudit',
          component: LoginAuditMaintain,
          meta: {
            title: 'common.route.LoginAuditMaintain'
          }
        },
        {
          path: '/oprateAudit',
          component: OperateAuditMaintain,
          meta: {
            title: 'common.route.OperateAuditMaintain'
          }
        },
        {
          path: '/icon',
          component: Icon,
          meta: {
            title: 'common.route.Icon'
          }
        },
        {
          path: '/404',
          component: P404,
          meta: {
            title: 'common.route.R404'
          }
        },
        {
          path: '/403',
          component: P403,
          meta: {
            title: 'common.route.R403'
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
    },
    {
      path: '/printer',
      component: Printer
    }
  ]
})
