import { commonModel } from '../common/commonModel';

//这里是创建 paramsModel 类，目前除了存放一些属性没做别的
export class paramsModel extends commonModel {
  /** 参数组号 (主健ID)(必填项) (无默认值) */
  groupId = '';

  /** 参数号 (主健ID) (无默认值) */
  paramId = '';

  /** 参数值 (无默认值) */
  paramVal = '';

  /** 参数名 (无默认值) */
  paramName = '';

  /** 是否可修改 (无默认值) */
  ifCanmodify = '';

  /** 备注 (无默认值) */
  remark = '';

  /** 修改时间 (无默认值) */
  modifyTime = '';

  /** 修改人 (无默认值) */
  modifyUser = '';

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
