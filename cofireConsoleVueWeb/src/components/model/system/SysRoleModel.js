import {
  CommonModel
} from "../common/CommonModel";

export class SysRoleModel extends CommonModel {
  /** 角色id (主健ID) (无默认值) */
  roleId = '';

  /** 角色名称 (无默认值) */
  roleName = '';

  /** 描述 (无默认值) */
  description = '';

  /** 是否可用 (无默认值) */
  enabled = '';

  /** 创建人 (无默认值) */
  creator = '';

  /** 创建时间 (无默认值) */
  createTime = '';

  /** 审核人 (无默认值) */
  checker = '';

  /** 审核时间,格式yyyymmddhh24miss (无默认值) */
  checkTime = '';

  /** 预留字段1 (无默认值) */
  filler1 = '';

  /** 预留字段2 (无默认值) */
  filler2 = '';

  /** 预留字段3 (无默认值) */
  filler3 = '';
}
