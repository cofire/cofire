import {
  CommonModel
} from "../common/CommonModel";

export class QtzJobModel extends CommonModel {
	/** 定时任务id (主健ID) (无默认值) */
  jobId = '';

  /** 任务名称(必填项) (无默认值) */
  jobName = '';

  /** 任务描述 (无默认值) */
  jobDesc = '';

  /** 年(必填项) (无默认值) */
  year = '';

  /** 月(必填项) (无默认值) */
  month = '';

  /** 日期(必填项) (无默认值) */
  date = '';

  /** 星期(必填项) (无默认值) */
  day = '';

  /** 小时(必填项) (无默认值) */
  hour = '';

  /** 分(必填项) (无默认值) */
  minute = '';

  /** 秒(必填项) (无默认值) */
  second = '';

  /** 生效日期 (无默认值) */
  activeDt = '';

  /** 失效日期 (无默认值) */
  expiryDt = '';

  /** 逻辑删除标识:0-未删除；1-已删除(必填项) (无默认值) */
  isDel = '';

  /** 附加参数1 (无默认值) */
  param1 = '';

  /** 附加参数2 (无默认值) */
  param2 = '';

  /** 附加参数3 (无默认值) */
  param3 = '';

  /** 附加参数4 (无默认值) */
  param4 = '';

  /** 附加参数5 (无默认值) */
  param5 = '';
}
