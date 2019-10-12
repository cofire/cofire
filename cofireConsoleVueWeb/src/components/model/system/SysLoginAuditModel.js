import {
  CommonModel
} from "../common/CommonModel";

export class SysLoginAuditModel extends CommonModel {
	/** 自增id (主健ID) (无默认值) */
  sid = '';

  /** 用户id (无默认值) */
  userId = '';

  /** ip地址 (无默认值) */
  ip = '';

  /** 会话id (无默认值) */
  sessionId = '';

  /** 创建时间 (无默认值) */
  createTime = '';

  /** 日志类型:0-登录；1-登出 (无默认值) */
  auditType = '';

  /** 来源类型 (无默认值) */
  sourceType = '';

  /** 预留字段1 (无默认值) */
  filler1 = '';

  /** 预留字段2 (无默认值) */
  filler2 = '';

  /** 预留字段3 (无默认值) */
  filler3 = '';

  /** 消息 (无默认值) */
  message = '';
}
