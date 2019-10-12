import {
    commonModel
} from "../common/commonModel";

export class parkingModel extends commonModel {
    /** 主健ID (无默认值) */
    uId = '';

    /** 申请单号 (无默认值) */
    applyNo = '';

    /** 状态 (无默认值) */
    status = '';

    /** 车主姓名 (无默认值) */
    name = '';

    /** 联系方式 (无默认值) */
    phone = '';

    /** 车牌号 (无默认值) */
    carNo = '';

    /** 车辆描述 (无默认值) */
    carDes = '';

    /** 事由 (无默认值) */
    reason = '';

    /** 停车区域 (无默认值) */
    parkingArea = '';

    /** 审核人 (无默认值) */
    auditor = '';

    /** 审核信息 (无默认值) */
    auditInformation = '';

    /** 审核时间 (无默认值) */
    auditTime = '';

    /** 创建时间 */
    createTime = "";

    /**  上报时间*/
    reportTime = "";

    /**  上报状态*/
    reportStatus = "";

    /** 预留字段1 (无默认值) */
    filler1;

    /** 预留字段2 (无默认值) */
    filler2;

    /** 预留字段3 (无默认值) */
    filler3;
    /**车辆申请人的MXUID */
    EHS_USER_ID="";
    /**mxuid */
    mxuid="";

}
