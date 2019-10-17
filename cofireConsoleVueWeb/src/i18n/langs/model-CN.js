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
      "returnNewPasswInfo": "用户新密码为："
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
    }
  },
  dict:{
    label: {
      'groupId': '组号',
      'dictValue': '数据字典值',
      'groupName': '组名',
      'dictName': '数据字典名称',
      'modifyTime': '最后修改时间',
      'modifier': '最后修改人',
      'filler1': '预留字段1',
      'filler2': '预留字段2',
      'filler3': '预留字段3',
      'filler4': '预留字段4',
    }
  },
  param:{
    label: {
      'groupId': '组号',
      'paramId': '参数id',
      'paramValue': '参数值',
      'paramName': '参数名',
      'canDelete': '是否可修改',
      'remark': '备注',
      'modifier': '最后修改人',
      'modifyTime': '最后修改时间',
      'filler1': '预留字段1',
      'filler2': '预留字段2',
      'filler3': '预留字段3',
      'filler4': '预留字段4',
    }
  },
  job:{
    label: {
      'jobId': '定时任务id',
      'jobName': '任务名称',
      'jobDesc': '任务描述',
      'year': '年',
      'month': '月',
      'date': '日期',
      'day': '星期',
      'hour': '小时',
      'minute': '分',
      'second': '秒',
      'activeDt': '生效日期',
      'expiryDt': '失效日期',
      'isDel': '逻辑删除标识',
      'modifier': '最后修改人',
      'modifyTime': '最后修改时间',
      'param1': '附加参数1',
      'param2': '附加参数2',
      'param3': '附加参数3',
      'param4': '附加参数4',
      'param5': '附加参数5'
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
      'filler1': '预留字段1',
      'filler2': '预留字段2',
      'filler3': '预留字段3'
    }
  },
}