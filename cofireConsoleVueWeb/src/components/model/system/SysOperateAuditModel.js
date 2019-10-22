import {
  CommonModel
} from "../common/CommonModel";

export class SysOperateAuditModel extends CommonModel {
  /** 自增id (主健ID) (无默认值) */
  sid = '';

  /** 登录的用户id (无默认值) */
  userId = '';

  /** 请求ip地址 (无默认值) */
  ip = '';

  /** sessionid (无默认值) */
  sessionId = '';

  /** 方法描述 (无默认值) */
  description = '';

  /** 请求的url (无默认值) */
  requestUrl = '';

  /** 请求参数 (无默认值) */
  requestParam = '';

  /** 请求发生时间 (无默认值) */
  requestTime = '';

  /** 返回结果 (无默认值) */
  result = '';

  /** 接口调用返回时间 (无默认值) */
  returnTime = '';

  /** 预留字段1 (无默认值) */
  filler1 = '';

  /** 预留字段2 (无默认值) */
  filler2 = '';

  /** 预留字段3 (无默认值) */
  filler3 = '';

  requestTimeList = [];
}
