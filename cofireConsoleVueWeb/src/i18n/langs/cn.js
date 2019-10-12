import zhLocale from 'element-ui/lib/locale/lang/zh-CN'

const cn = {
  ...zhLocale,
  common: {
    route: {
      "R02": "首页",
      "R1": "用户管理",
      "R11": "用户信息管理",
      "R12": "角色信息管理",
      "R13": "部门信息管理",
      "R14": "菜单管理",
      "R2": "系统管理",
      "R21": "系统参数",
      "R22": "数据字典",
      "R23": "定时任务管理",
      "R3": "日志管理",
      "R31": "登录登出日志",
      "R32": "操作日志",
      "R33": "定时任务日志",
    },
    button: {
      'login': '登录',
      'add': '新增',
      'edit': '编辑',
      'delete': '删除',
      'query': '查询',
      'detail': '详情',
      'save': '保存',
      'cancel': '取消',
      'reset': '重置',
      'check': '审核',
      'resetPsw': '修改密码',
      'loginOut': '退出登录',
      'confirm': '确认',
      'selectFile': '选择文件',
      'enter': '进场',
      'out': '离场',
      'refuse': '拒绝',
      'addVipCard': '新增VIP卡号'
    },

    label: {
      'selectLang': '选择语言',
      'platformTitle': 'cofire',
      'tags': '标签选项',
      'closeOther': '关闭其他',
      'closeAll': '关闭所有',
      'currentPsw': '当前密码',
      'newPsw': '新密码',
      'confirmNewPsw': '确认密码',
      'loginOutTitle': '正在退出系统, 是否继续?',
      'prompt': '提示',
      'index': '序号',
      'dateto': '至',
      'dateStr': '开始日期',
      'dateEnd': '结束日期',
    },
    code: {

    }
  },
  login: {
    'userId': '账号',
    'passWord': '密码',
    rule: {
      'userId': '请输入账号',
      'passWord': '请输入密码'
    }
  },
  user: {
    label: {
      'sid': '自增id',
      'userId': '用户账号',
      'userName': '用户姓名',
      'deptCode': '部门编号',
      'passWord': '密码',
      'lastIp': '上次登录ip',
      'lastDate': '上次登录时间',
      'wrongPwdCount': '密码连续错误次数',
      'creator': '创建人',
      'createTime': '创建时间',
      'status': '用户状态',
      'checkStatus': '审核状态',
      'checker': '审核人',
      'checkTime': '审核时间',
      'changePwdFlag': '修改密码标志',
      'filler1': '预留字段1',
      'filler2': '预留字段2',
      'filler3': '预留字段3'
    }
  }
}

export default cn
