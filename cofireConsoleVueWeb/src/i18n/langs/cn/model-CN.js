'use strict';

exports.__esModule = true;
exports.default = {
  login: {
    'userId': '账号',
    'passWord': '密码',
    rule: {
      'userId': '请输入账号',
      'passWord': '请输入密码'
    }
  },
  changePassWord: {
    label: {
      'currentPassWord': '原密码',
      'newPassWord': '新密码',
      'confirmNewPassWord': '确认密码'
    },
    rule: {
      'currentPassWord': '请输入原密码',
      'newPassWord': '请输入新密码',
      'confirmNewPassWord': '请输入确认密码',
      'passWordContainChinese': '密码不能包含中文字符'
    },
    title: {
      'changePassWord': '修改密码'
    },
    message: {},
  },
  user: {
    label: {
      'sid': '自增id',
      'userId': '用户账号',
      'userName': '用户姓名',
      'passWord': '密码',
      'modifier': '最后修改人',
      'modifyTime': '最后修改时间',
      'filler1': '预留字段1',
      'filler2': '预留字段2',
      'filler3': '预留字段3'
    },
    rule: {
      'userId': '用户账号不能为空',
      'userName': '用户姓名不能为空',
    },
    title: {
      'add': '用户新增',
      'edit': '用户编辑',
      'detail': '用户信息详情',
      'roleSet': '角色设置'
    },
    message: {
      "edit": "请选中需要编辑的用户信息",
      "roleSet":"请选中需要角色设置的用户信息",
      "restPassWord": "请选中需要重置密码的用户信息",
      "restPassWordPrompt": "正在重置该用户密码，是否继续？",
      "cancelPassWordPrompt": "已取消重置该用户密码",
      "returnNewPasswInfo": "用户新密码为：",
      "delete":"请选中需要删除的用户信息",
      "deletePrompt":"正在删除该用户信息，是否继续？",
      "cancelDeletePrompt": "已取消删除该用户信息",
    }
  },
  role: {
    label: {
      'roleId': '角色id',
      'roleName': '角色名称',
      'description': '描述',
      'enabled': '是否可用',
      'modifier': '最后修改人',
      'modifyTime': '最后修改时间',
      'filler1': '预留字段1',
      'filler2': '预留字段2',
      'filler3': '预留字段3',
      'permission': '角色权限'
    },
    rule: {
      'roleId': '角色账号不能为空',
      'roleName': '角色姓名不能为空',
    },
    title: {
      'add': '角色新增',
      'edit': '角色编辑',
      'detail': '角色信息详情',
    },
    message: {
      "edit": "请选中需要编辑的角色信息",
      "roleSet":"请选中需要角色设置的角色信息",
      "delete":"请选中需要删除的角色信息",
      "deletePrompt":"正在删除该角色信息，是否继续？",
      "cancelDeletePrompt": "已取消删除该角色信息",
    }
  },
  resource:{
    label: {
      'resourceId': '菜单id',
      'resourceName': '菜单名称',
      'url': '菜单链接',
      'parentResourceId': '父节点id',
      'isLeaf': '是否叶节点',
      'morder': '排序',
      'enabled': '是否可用',
      'modifier': '最后修改人',
      'modifyTime': '最后修改时间',
      'icon': '小图标',
      'filler1': '预留字段1',
      'filler2': '预留字段2',
      'filler3': '预留字段3'
    },
    rule: {
      'resourceId': '菜单id不能为空',
      'resourceName': '菜单名称不能为空',
      'parentResourceId': '父节点id不能为空',
      'enabled': '是否可用不能为空',
      'isLeaf': '是否叶节点不能为空',
    },
    title: {
      'add': '菜单新增',
      'edit': '菜单编辑',
      'detail': '菜单信息详情',
    },
    message: {
      "edit": "请选中需要编辑的菜单信息",
      "roleSet":"请选中需要菜单设置的菜单信息",
      "delete":"请选中需要删除的菜单信息",
      "deletePrompt":"正在删除该菜单信息，是否继续？",
      "cancelDeletePrompt": "已取消删除该菜单信息",
    }
  },
  dict:{
    label: {
      'groupId': '组号',
      'dictValue': '数据字典值',
      'groupName': '组名',
      'dictNameCn': '数据字典中文名称',
      'dictNameEn': '数据字典英文名称',
      'modifyTime': '最后修改时间',
      'modifier': '最后修改人',
      'filler1': '预留字段1',
      'filler2': '预留字段2',
      'filler3': '预留字段3',
      'filler4': '预留字段4',
    },
    rule: {
      'groupId': '组号不能为空',
      'dictValue': '数据字典值不能为空',
      'groupName': '组名不能为空',
      'dictNameCn': '数据字典中文名称不能为空',
      'dictNameEn': '数据字典英文名称不能为空',
    },
    title: {
      'add': '数据字典新增',
      'edit': '数据字典编辑',
      'detail': '数据字典信息详情',
    },
    message: {
      "edit": "请选中需要编辑的数据字典信息",
      "delete":"请选中需要删除的数据字典信息",
      "deletePrompt":"正在删除该数据字典信息，是否继续？",
      "cancelDeletePrompt": "已取消删除该数据字典信息",
    }
  },
  param:{
    label: {
      'groupId': '组号',
      'paramId': '参数id',
      'paramValue': '参数值',
      'paramName': '参数名',
      'canDelete': '是否可删除',
      'remark': '备注',
      'modifier': '最后修改人',
      'modifyTime': '最后修改时间',
      'filler1': '预留字段1',
      'filler2': '预留字段2',
      'filler3': '预留字段3',
      'filler4': '预留字段4',
    },
    rule: {
      'groupId': '组号不能为空',
      'paramId': '参数id不能为空',
      'paramValue': '参数值不能为空',
      'paramName': '参数名不能为空',
      'canDelete': '是否可删除不能为空',
    },
    title: {
      'add': '系统参数新增',
      'edit': '系统参数编辑',
      'detail': '系统参数信息详情',
    },
    message: {
      "edit": "请选中需要编辑的系统参数信息",
      "delete":"请选中需要删除的系统参数信息",
      "deletePrompt":"正在删除该系统参数信息，是否继续？",
      "cancelDeletePrompt": "已取消删除该系统参数信息",
      "canNotDeletePrompt": "不可删除删除该系统参数信息",
    }
  },
  returnCode:{
    label: {
      'code': '返回码',
      'message': '返回信息',
      'remark': '备注',
      'modifyTime': '最后修改时间',
      'modifier': '最后修改人',
      'filler1': '预留字段1',
      'filler2': '预留字段2',
      'filler3': '预留字段3',
    },
    rule: {
      'code': '返回码不能为空',
      'message': '返回信息不能为空',
    },
    title: {
      'add': '返回码新增',
      'edit': '返回码编辑',
      'detail': '返回码信息详情',
    },
    message: {
      "edit": "请选中需要编辑的返回码信息",
      "delete":"请选中需要删除的返回码信息",
      "deletePrompt":"正在删除该返回码信息，是否继续？",
      "cancelDeletePrompt": "已取消删除该返回码信息",
      "canNotDeletePrompt": "不可删除删除该返回码信息",
    }
  },
  job:{
    label: {
      'jobId': '定时任务id',
      'jobName': '任务名称',
      'jobDesc': '任务描述',
      'year': '年',
      'month': '月',
      'day': '日期',
      'week': '星期',
      'hour': '小时',
      'minute': '分',
      'second': '秒',
      'activeDate': '生效日期',
      'expiryDate': '失效日期',
      'isDel': '逻辑删除标识',
      'modifier': '最后修改人',
      'modifyTime': '最后修改时间',
      'param1': '附加参数1',
      'param2': '附加参数2',
      'param3': '附加参数3',
      'param4': '附加参数4',
      'param5': '附加参数5'
    },
    rule: {
      'jobId': '定时任务id不能为空',
      'jobName': '任务名称不能为空'
    },
    title: {
      'add': '定时任务新增',
      'edit': '定时任务编辑',
      'detail': '定时任务信息详情',
    },
    message: {
      "edit": "请选中需要编辑的定时任务信息",
      "delete":"请选中需要删除的定时任务信息",
      "deletePrompt":"正在删除该定时任务信息，是否继续？",
      "cancelDeletePrompt": "已取消删除该定时任务信息",
      "canNotDeletePrompt": "不可删除删除该定时任务信息",
    }
  },
  jobLog:{
    label: {
      'sid': '自增id',
      'jobId': '定时任务id',
      'runTime': '执行时间',
      'ip': '运行时ip',
      'isSuccess': '是否成功',
      'message': '信息',
      'filler1': '预留字段1',
      'filler2': '预留字段2',
      'filler3': '预留字段3'
    }
  },
  loginAudit:{
    label: {
      'sid': '自增id',
      'userId': '用户id',
      'ip': 'ip地址',
      'sessionId': '会话id',
      'createTime': '创建时间',
      'auditType': '日志类型',
      'sourceType': '来源类型',
      'filler1': '预留字段1',
      'filler2': '预留字段2',
      'filler3': '预留字段3',
      'message': '消息',
    }
  },
  operateAudit:{
    label: {
      'sid': '自增id',
      'userId': '登录的用户id',
      'ip': '请求ip地址',
      'sessionId': 'sessionid',
      'description': '方法描述',
      'requestUrl': '请求的url',
      'requestParam': '请求参数',
      'requestTime': '请求发生时间',
      'result': '返回结果',
      'returnTime': '接口调用返回时间',
      'sourceType': '来源类型',
      'operationType': '操作类型',
      'filler1': '预留字段1',
      'filler2': '预留字段2',
      'filler3': '预留字段3'
    }
  },
}