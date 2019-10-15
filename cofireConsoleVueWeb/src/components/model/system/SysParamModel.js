import {
  CommonModel
} from "../common/CommonModel";

export class SysParamModel extends CommonModel {
  /** 组号 (主健ID)(必填项) (无默认值) */
  groupId = '';

  /** 参数id(必填项) (主健ID) (无默认值) */
  paramId = '';

  /** 参数值(必填项)(必填项) (无默认值) */
  paramValue = '';

  /** 参数名(必填项)(必填项) (无默认值) */
  paramName = '';

  /** 是否可修改(必填项)(必填项) (无默认值) */
  canDelete = '';

  /** 备注 (无默认值) */
  remark = '';

  /** 最后修改人 (无默认值) */
  modifier = '';

  /** 最后修改时间 (无默认值) */
  modifyTime = '';

  /** 预留字段1 (无默认值) */
  filler1 = '';

  /** 预留字段2 (无默认值) */
  filler2 = '';

  /** 预留字段3 (无默认值) */
  filler3 = '';

  /** 预留字段4 (无默认值) */
  filler4 = '';
}
