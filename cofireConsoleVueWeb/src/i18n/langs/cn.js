import zhLocale from 'element-ui/lib/locale/lang/zh-CN'
import zhCommon from './common-CN'
import zhCode from './code-CN'

const cn = {
  ...zhLocale,
  ...zhCommon,
  ...zhCode,
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
  }
}

export default cn
