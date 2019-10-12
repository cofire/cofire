import {
    commonModel
  } from "../common/commonModel";
  
  export class roleModel extends commonModel {
    /** 角色ID (主健ID) (无默认值) */
    roleId = '';
  
    /** 角色名称 (无默认值) */
    roleName ='';
  
    /** 描述 (无默认值) */
    descr = '';
  
    /** 是否可用 (无默认值) */
    enabled = '';
  
    /** 创建人 (无默认值) */
    creator = '';
  
    /** 创建时间 (无默认值) */
    createTime = '';

    /** 角色权限*/
    rolePermission = '';
  
    /** 预留字段1 (无默认值) */
    filler1;
  
    /** 预留字段2 (无默认值) */
    filler2;
  
    /** 预留字段3 (无默认值) */
    filler3;
  }
  