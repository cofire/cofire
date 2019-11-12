import {
  BaseModel
} from "../common/BaseModel";

export class SysUserRoleModel extends BaseModel {
  /** 用户id (主健ID)(必填项) (无默认值) */
  userId = '';

  /** 角色id(必填项) (主健ID) (无默认值) */
  roleId = '';

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
