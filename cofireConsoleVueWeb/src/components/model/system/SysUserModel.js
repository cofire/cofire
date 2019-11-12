import {
  BaseModel
} from "../common/BaseModel";

export class SysUserModel extends BaseModel {
  /** 用户名-即用户登录时使用的名称(必填项) (无默认值) */
  userId = '';

  /** 用户昵称，或者真实名称 (无默认值) */
  userName = '';

  /** 密码 (无默认值) */
  passWord = '';

  /** 最后修改人 (无默认值) */
  modifier = '';

  /** 最后修改时间 (无默认值) */
  modifyTime = '';

  /** 预留字段1 (无默认值) */
  filler1 = '';

  /** 预留字段2 (无默认值) */
  filler2 = '';

  /** 预留字段3 (无默认值) */
  filler3 = '';
}
