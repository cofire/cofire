import {
  CommonModel
} from "../common/CommonModel";

export class SysUserModel extends CommonModel {
  /** 自增id (主健ID) (无默认值) */
  sid = '';

  /** 用户名-即用户登录时使用的名称(必填项) (无默认值) */
  userId = '';

  /** 用户昵称，或者真实名称 (无默认值) */
  userName = '';

  /** 部门编号 (无默认值) */
  deptCode = '';

  /** 密码 (无默认值) */
  passWord = '';

  /** 上次登录ip (无默认值) */
  lastIp = '';

  /** 上次登录时间 (无默认值) */
  lastDate = '';

  /** 密码连续错误次数 (无默认值) */
  wrongPwdCount = '';

  /** 创建人 (无默认值) */
  creator = '';

  /** 创建时间 (无默认值) */
  createTime = '';

  /** 用户状态 "00-未登录
  01-已登录
  02-已冻结
  03-已过期04-已注销" (无默认值) */
  status = '';

  /** 审核状态0-未审核;1-已审核;2-审核拒绝 (无默认值) */
  checkStatus = '';

  /** 审核人 (无默认值) */
  checker = '';

  /** 审核时间,格式yyyymmddhh24miss (无默认值) */
  checkTime = '';

  /** 修改密码标志 0-不需要；1-需要 (无默认值) */
  changePwdFlag = '';

  /** 预留字段1 (无默认值) */
  filler1 = '';

  /** 预留字段2 (无默认值) */
  filler2 = '';

  /** 预留字段3 (无默认值) */
  filler3 = '';
}
