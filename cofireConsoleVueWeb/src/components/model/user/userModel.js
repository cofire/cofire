import {
  commonModel
} from "../common/commonModel";

export class userModel extends commonModel {
  /** 默克的MUID (主健ID) (无默认值) */
  userId = '';

  /** 用户名称 (无默认值) */
  userName = '';

  /** 密码 (无默认值) */
  passwd = '';

  /** 部门代码 (无默认值) */
  deptCode = '';

  /** 联系方式 (无默认值) */
  phone = '';

  /** 创建人 (无默认值) */
  creator = '';

  /** 创建时间 (无默认值) */
  createTime = '';

  /** 审核人 (无默认值) */
  auditor = '';

  /** 审核时间 (无默认值) */
  auditTime = '';

  /** 预留字段1 (无默认值) */
  filler1 = '';

  /** 预留字段2 (无默认值) */
  filler2 = '';

  /** 预留字段3 (无默认值) */
  filler3 = '';
}
