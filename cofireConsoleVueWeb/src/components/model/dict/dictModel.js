import {
  commonModel
} from "../common/commonModel";

export class dictModel extends commonModel {
  /** 组号ID (主属性ID) (无默认值) */
  groupId='';

  /** 组号名称 (无默认值) */
  groupName='';

/** 字典值  (无默认值) */
  dictValue='';
/** 字典名称(无默认值) */
  dictName='';
/** 最后修改时间   (无默认值) */
  modifyTime='';
/** 最后修改人   (无默认值) */
  modifyUser='';
/**  审核人  (无默认值) */
  auditor='';
/**  审核时间  (无默认值) */
  auditTime='';

  /** 预留字段1 (无默认值) */
  filler1='';

  /** 预留字段2 (无默认值) */
  filler2='';

  /** 预留字段3 (无默认值) */
  filler3='';
}
