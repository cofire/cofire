import {
  CommonModel
} from "../common/CommonModel";

export class SysResourceModel extends CommonModel {
  /** 菜单id (主健ID) (无默认值) */
  resourceId = '';

  /** 菜单名称(必填项) (无默认值) */
  resourceName = '';

  /** 菜单链接 (无默认值) */
  url = '';

  /** 父节点id (无默认值) */
  parentResourceId = '';

  /** 是否叶节点(必填项) (无默认值) */
  isLeaf = '';

  /** 排序 (无默认值) */
  morder = '';

  /** 是否可用(必填项) (无默认值) */
  enabled = '';

  /** 创建人 (无默认值) */
  creator = '';

  /** 创建时间 (无默认值) */
  createTime = '';

  /** 小图标 (无默认值) */
  icon = '';

  /** 预留字段1 (无默认值) */
  filler1 = '';

  /** 预留字段2 (无默认值) */
  filler2 = '';

  /** 预留字段3 (无默认值) */
  filler3 = '';
}
