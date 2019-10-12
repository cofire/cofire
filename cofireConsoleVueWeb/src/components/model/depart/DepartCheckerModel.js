import {
  commonModel
} from "../common/commonModel";
export class DepartCheckerModel extends commonModel {
	  /** null (主健ID)(必填项) (无默认值) */
    userId = '';
    /** null (主健ID) (无默认值) */
    branchNo = '';

    /** null (无默认值) */
    creator = '';

    /** null (无默认值) */
    createTime = '';

    /** null (无默认值) */
    filler1 = '';

    /** null (无默认值) */
    filler2 = '';

    /** null (无默认值) */
    filler3 = '';
		
		/** 用户名称 */
		userName = '';
		/** 是否是审核人 */
		checker = '';
		
	}