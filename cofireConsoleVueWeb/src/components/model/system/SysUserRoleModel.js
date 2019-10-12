import {
  CommonModel
} from "../common/CommonModel";

export class SysUserRoleModel extends CommonModel {
  /** 用户id (主健ID)(必填项) (无默认值) */
  userId = '';

  /** 角色id(必填项) (主健ID) (无默认值) */
  roleId = '';

  /** 创建人 (无默认值) */
  creator = '';

  /** 创建日期 (无默认值) */
  createTime = '';

  /** 预留字段1 (无默认值) */
  filler1 = '';

  /** 预留字段2 (无默认值) */
  filler2 = '';

  /** 预留字段3 (无默认值) */
  filler3 = '';
}
