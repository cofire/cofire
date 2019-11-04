import {
  CommonModel
} from "../common/CommonModel";

export class SysReturnCodeModel extends CommonModel {
  /** 返回码 (主健ID) (无默认值) */
  code = '';

  /** 返回信息(必填项) (无默认值) */
  message = '';

  /** 备注 (无默认值) */
  remark = '';

  /** 最后修改时间 (无默认值) */
  modifyTime = '';

  /** 最后修改人 (无默认值) */
  modifier = '';

  /** 预留字段1 (无默认值) */
  filler1 = '';

  /** 预留字段2 (无默认值) */
  filler2 = '';

  /** 预留字段3 (无默认值) */
  filler3 = '';
}
