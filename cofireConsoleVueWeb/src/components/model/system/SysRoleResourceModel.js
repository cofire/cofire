import {
  CommonModel
} from "../common/CommonModel";

export class SysRoleResourceModel extends CommonModel {
	/** 角色id (主健ID)(必填项) (无默认值) */
  roleId = '';

  /** 资源id(必填项) (主健ID) (无默认值) */
  resourceId = '';

  /** 创建人 (无默认值) */
  creator = '';

  /** 创建时间 (无默认值) */
  createTime = '';

  /** 预留字段1 (无默认值) */
  filler1 = '';

  /** 预留字段2 (无默认值) */
  filler2 = '';

  /** 预留字段3 (无默认值) */
  filler3 = '';
}
