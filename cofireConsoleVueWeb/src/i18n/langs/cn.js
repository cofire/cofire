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
      'platformTitle': 'I SECURITY',
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
    rule: {
      'userId': '请输入M/XUID',
      'userName': '请输入用户名称',
      'password': '请输入密码',
      'phoneValidator': '请输入正确的手机号',
      'userIdValidator': 'M/XUID只能是字母和数字',
      'userNameValidator': '用户名称不能包含特殊字符',
      'userIdLength': 'M/XUID长度应该在1~32个合法字符',
      'userNameLength': '用户名称长度应该在1~50个合法字符'
    },
    button: {
      'detail': '详情',
      'sync': '同步',
      'roleSet': '角色设置',
      'resetPassword': '密码重置',
      'refuse': '拒绝',
      'pass': '通过',
      'back': '返回',
      'confirm': '确认',
      'cancel': '取消'
    },
    label: {
      //用户信息维护
      'num': '序号',
      'userId': 'M/XUID',
      'userName': '用户名称',
      'password': '密码',
      'deptName': '部门名称',
      'phone': '手机号码',
      'creator': '创建人',
      'createTime': '创建时间',
      'auditor': '审核人',
      'auditTime': '审核时间',
      'addUser': '用户新增',
      'editUser': '用户编辑',
      'auditUser': '用户审核',
      'viewDetail': '查看详情',
      'deleteInfo': '是否确认删除?',
      'resetPasswordInfo': '是否确认重置密码',
      'tip': '提示',
      'roleSet': '角色设置',
      'role': '角色信息'
    },
    message: {
      'editSelect': '请选中需要修改的记录',
      'deleteSelect': '请选中需要删除的记录',
      'viewSelect': '请选中需要查看的记录',
      'resetPassword': '请选中需要重置密码的用户记录！',
      'cancelDelete': '已取消删除',
      'cancelResetPaw': '已取消重置密码',
      'returnNewPasswInfo': '重置密码成功,新密码：',
      'auditRefuse': '审核拒绝',
      'roleSet': '请选中需要设置角色的记录'
    },
    item: {
      'userManagement': '用户管理',
      'userMaintenance': '用户信息维护'
    }
  },

  role: {
    //角色维护
    rules: {
      'roleId': '请输入角色代码',
      'roleName': '请输入角色名称',
    },

    button: {
      'detail': '详情',
      'confirm': '确 认',
      'cancel': '取 消',
      'back': '返 回',
      'reset': '重置',
    },

    label: {
      'num': '序号',
      'roleId': '角色代码',
      'roleName': '角色名称',
      'descr': '角色描述',
      'rolePermission': '角色权限',
      'creator': '创建人',
      'createTime': '创建时间',
      'viewDetail': '查看详情',
      'deleteInfo': '是否确认删除?',
      'tip': '提示'


    },

    message: {
      'editSelect': '请选中需要修改的记录',
      'deleteSelect': '请选中需要删除的记录',
      'viewSelect': '请选中需要查看的记录',
      'cancelDelete': '已取消删除'

    },

    title: {
      'addtitle': '角色新增',
      'edittitle': '角色编辑',
    },

    item: {
      'userManagement': '用户管理',
      'roleMaintenance': '角色维护'
    }
  },

  log: { //日志管理模块
    'log': '日志管理',
    'loginAuditsMes': '登入登出日志信息',
    'opeAuditsMes': '操作日志信息',
    label: {
      'userId': 'M/XUID',
      'ip': 'IP',
      'date': '选择日期',
      'auditType': '类型',
      'sourceType': '来源',
    },
    placeholder: {
      'userId': '请输入M/XUID',
      'ip': '请输入IP',
      'dateto': '至',
      'dateStr': '开始日期',
      'dateEnd': '结束日期',
      'description': '请输入描述',
    },
    table: {
      'userId': 'M/XUID',
      'ip': 'IP',
      'auditType': '类型',
      'sourceType': '来源',
      'createTime': '时间',
      'url': 'URL',
      'description': '描述',
      'requiredPara': '请求参数',
      'result': "返回结果"
    },
  },
  depart: {
    'depart': '组织架构',
    'departInfo': '组织架构信息',
    'checker': '审核人',
    'upload': '上传',
    label: {
      'branchNo': '部门编号',
      'branchName': '部门名称',
      'userId': 'M/XUID',
      'userName': '用户名称',
      'checker': '员工类型',
      'fileName': '文件名称',
    },
    placeholder: {
      'branchNo': '请输入部门编号',
      'branchName': '请输入部门名称',
      'userId': '请输入M/XUID',
      'userName': '请输入用户名称',
    },
    table: {
      'userId': 'M/XUID',
      'userName': '用户名称',
      'phone': '联系方式',
      'checker': '员工类型',
    },
    mes: {
      'editDepart': '部门编辑',
      'addDepart': '新增部门',
      'pleSelDepart': '请先选择部门！',
      'isDelDepart': '是否删除该部门？',
      'tip': '提示',
      'cancelDel': '已取消删除',
      'pleSelChecker': '请先选择审核人！',
      'isDelChecker': '是否删除审核人？',
      'isAddChecker': '确认将以下人员设置为审核组人员吗？',
      'cancelAddChecker': '取消添加审核人',
      'fileErr': '文件上传失败',
      'fileTypeErr': '文件格式不正确',
      'importDepart': '导入部门',
      'importUser': '导入员工',
      'exportDepart': '导出部门',
      'exportUser': '导出员工',
      'notAllcheck': '您必须选择一个普通员工',
    },
    rules: {
      'branchNameRequired': '请输入部门名称',
      'branchNameFormat': '请输入正确的部门名称格式',
      'branchNameLength': '部门名称长度应该在2~128个合法字符',
      'branchNoRequired': '请输入部门编号',
      'branchNoLength': '请输入字母数字下划线组合',
      'pleSelFile': '请选择上传的文件',
    },
  },
  dictMaintain: { //数据字典管理模块
    message: {
      'editmes': '请选中需要修改的记录！',
      'deletemes': '请选中需要删除的记录！',
      'deleteConfirmmes': '已取消删除',
      'deleteask': '是否删除?',
      'deletetip': '提示',
      'check': '请选中要查看的记录',

    },
    title: {
      'addtitle': '数据字典新增',
      'edittitle': '数据字典编辑',
    },
    common: {
      'confirm': '确认',
      'cancel': '取消',
    },
    item: {
      'System Management': '系统管理',
      'Data Dictionary Maintenance': '数据字典维护'
    },
    label: {
      'groupId': '字典组号',
      'dictValue': '字典值'
    },
    rule: {
      'groupId': '字典组号不可为空！',
      'dictValue': '字典值不可为空！',
      'groupName': '组名不能为空！',
      'dictName': '字典名称不能为空！',
      'groupName2': '最长100个字符！',
      'dictName2': '最长100个字符！',
      'groupId2': '请输入字母或数字组合，最长4位！',
      'dictValue2': '请输入字母或数字组合，最长30位！',

    },
    table: {
      'index': '序号',
      'groupId': '组号',
      'groupName': '组名',
      'dictValue': '字典值',
      'dictName': '字典名称',
      'modifyUser': '最后修改人',
      'modifyTime': '最后修改时间',
    },

  },
  param: { //系统参数模块
    message: {
      'editMessage': '请选中需要修改的记录！',
      'selectDeleteMessage': '请选中需要删除的记录！',
      'deleteConfirmMessage': '已取消删除',
      'deleteAsk': '是否删除?',
      'deleteWarn': '提示',
      'validationFail': '验证失败',
      'inputGroupId': '请输入段号',
      'inputParamId': '请输入参数号',
      'inputParamName': '请输入参数名',
      'inputParamVal': '请输入参数值',
      'alertAboutNumAndChar': '请输入数字或者英文字符',
      'alertAboutGroupIdLength': '输入的内容长度不可以大于4',
      'alertAboutParamIdLength': '输入的内容长度不可以大于10',
      'alertAboutParamName': '请输入合法的参数名',
      'alertAboutParamVal': '请输入合法的参数值',
      'alertAboutRemark': '请输入合法的备注',

    },
    title: {
      'addTitle': '系统参数新增',
      'editTitle': '系统参数编辑',
    },
    common: {
      'confirm': '确认',
      'cancel': '取消',
    },
    item: {
      'systemManagement': '系统管理',
      'systemParamMaintenance': '系统参数维护'
    },
    label: {
      'groupId': '参数段号',
      'paramId': '参数号',
      'paramVal': '参数值',
      'paramName': '参数名',
      'remark': '备注'
    },
    rule: {
      'groupId': '参数组号ID不可为空',
      'paramVal': '参数值不可为空！',
    },
    table: {
      'index': '序号',
      'groupId': '段号',
      'paramId': '参数号',
      'paramVal': '参数值',
      'paramName': '参数名',
      'remark': '备注'
    },
  },
  richText: {
    label: {
      'abbreviation': '简称'
    },
    table: {
      'abbreviation': '简称',
      'textCn': '中文文本',
      'textEn': '英文文本',
      'groupId': '组号',
      'textId': '文本号',
    },
    mes: {
      'edit': '编辑富文本',
      'detail': '查看富文本',
      'add': '新增富文本',
      'pleSelDepart': '请先选择富文本',
      'isDelDepart': '是否删除该富文本信息？',
      'tip': '提示',
      'cancelDel': '已取消删除',
    },
    rules: {
      'groupIdRequired': '请输入组号',
      'groupIdLength': '组号长度应该在1~4个合法字符',
      'textIdRequired': '请输入文本号',
      'textIdLength': '文本号长度应该在1~32个合法字符',
      'abbreviationRequired': '请输入简称',
      'abbreviationLength': '简称长度应该在1~32个合法字符',
    },
  }
}

export default cn
