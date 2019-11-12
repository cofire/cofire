import {
  BaseModel
} from "../common/BaseModel";

export class SysDictModel extends BaseModel {
  /** 组号 (主健ID)(必填项) (无默认值) */
  groupId = '';

  /** 数据字典值(必填项) (主健ID) (无默认值) */
  dictValue = '';

  /** 组名 (无默认值) */
  groupName = '';

  /** 数据字典名称 (无默认值) */
  dictName = '';

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

  /** 预留字段4 (无默认值) */
  filler4 = '';
}
