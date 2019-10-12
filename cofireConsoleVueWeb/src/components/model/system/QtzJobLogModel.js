import {
  CommonModel
} from "../common/CommonModel";

export class QtzJobLogModel extends CommonModel {
	/** 自增id (主健ID) (无默认值) */
  sid = '';

  /** 定时任务id (无默认值) */
  jobId = '';

  /** 执行时间 (无默认值) */
  runTime = '';

  /** 运行时ip (无默认值) */
  ip = '';

  /** 是否成功 (无默认值) */
  isSuccess = '';

  /** 信息 (无默认值) */
  message = '';

  /** 预留字段1 (无默认值) */
  filler1 = '';

  /** 预留字段2 (无默认值) */
  filler2 = '';

  /** 预留字段3 (无默认值) */
  filler3 = '';
}
