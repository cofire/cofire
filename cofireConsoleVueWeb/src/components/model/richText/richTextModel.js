import { commonModel } from '../common/commonModel';

//这里是创建 paramsModel 类，目前除了存放一些属性没做别的
export class richTextModel extends commonModel {
  /** null (主健ID)(必填项) (无默认值) */
  groupId = '';
  /** null (主健ID) (无默认值) */
  textId = '';
  /** null (无默认值) */
  abbreviation = '';
  /** null (无默认值) */
  textCn = '';
  /** null (无默认值) */
  textEn = '';
  /** 预留字段1 (无默认值) */
  filler1 = '';
  /** 预留字段2 (无默认值) */
  filler2 = '';
  /** 预留字段3 (无默认值) */
  filler3 = '';

}
