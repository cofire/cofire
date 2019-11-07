import fetch from '../config/fetch'
import downloadFile from '../config/downloadFile'

/** 注意添加注释 */
/** 公共接口 */
/** 登录 */
export const login = data => fetch('/console/login', data, 'POST');
/** 登出 */
export const loginOut = () => fetch('/console/loginOut', {}, 'POST');
/** 获取用户信息 */
export const getUserDetail = () => fetch('/getUserDetail', {}, 'POST');

/** 用户管理 */
/** 获取用户列表 */
export const queryUser = data => fetch('/console/user/query', data, 'POST');
/** 保存用户信息 */
export const saveUser = data => fetch('/console/user/save', data, 'POST');
/**删除用户信息 */
export const deleteUser = data => fetch('/console/user/delete', data, 'POST');
/**密码重置 */
export const restPassWord = data => fetch('/console/user/restPassWord', data, 'POST');
/** 保存用户的角色信息 */
export const saveUserRole = data => fetch('/console/user/saveUserRole', data, 'POST');
/**修改密码 */
export const changePassWord = data => fetch('/console/user/changePassWord', data, 'POST');
/**导出用户信息 */
export const exportUser = data => downloadFile('/console/user/exportExcel', data);

/** 角色管理 */
/** 获取角色列表 */
/** 获取角色列表 */
export const queryRole = data => fetch('/console/role/query', data, 'POST');
/** 保存角色信息 */
export const saveRole = data => fetch('/console/role/save', data, 'POST');
/**删除角色信息 */
export const deleteRole = data => fetch('/console/role/delete', data, 'POST');
/**查询用户角色信息 */
export const queryUserRoleList = data => fetch('/console/role/queryUserRoleList', data, 'POST');
/**查询角色菜单树 */
export const getRoleTree = data => fetch('/console/role/getRoleTree', data, 'POST');

/** 菜单管理 */
/** 获取菜单列表 */
/** 获取菜单列表 */
export const queryResource = data => fetch('/console/resource/query', data, 'POST');
/** 保存菜单信息 */
export const saveResource = data => fetch('/console/resource/save', data, 'POST');
/**删除菜单信息 */
export const deleteResource = data => fetch('/console/resource/delete', data, 'POST');

/** 数据字典管理 */
/** 获取数据字典列表 */
export const queryDict = data => fetch('/console/dict/query', data, 'POST');
/** 保存数据字典信息 */
export const saveDict = data => fetch('/console/dict/save', data, 'POST');
/**删除数据字典信息 */
export const deleteDict = data => fetch('/console/dict/delete', data, 'POST');

/** 系统参数管理 */
/** 获取系统参数列表 */
export const queryParam = data => fetch('/console/param/query', data, 'POST');
/** 保存系统参数信息 */
export const saveParam = data => fetch('/console/param/save', data, 'POST');
/**删除系统参数信息 */
export const deleteParam = data => fetch('/console/param/delete', data, 'POST');

/** 返回码管理 */
/** 获取返回码列表 */
export const queryReturnCode = data => fetch('/console/returnCode/query', data, 'POST');
/** 保存返回码信息 */
export const saveReturnCode = data => fetch('/console/returnCode/save', data, 'POST');
/**删除返回码信息 */
export const deleteReturnCode = data => fetch('/console/returnCode/delete', data, 'POST');

/** 查询定时任务日志 */
export const queryJobLog = data => fetch('/console/jobLog/query', data, 'POST');
/** 获取登录登出日志列表 */
export const queryLoginAudit = data => fetch('/console/loginAudit/query', data, 'POST');
/** 获取操作日志列表 */
export const queryOperateAudit = data => fetch('/console/operateAudit/query', data, 'POST');

/** 定时任务管理 */ 
/** 获取定时任务列表 */
export const queryJob = data => fetch('/console/job/query', data, 'POST');
/** 保存定时任务信息 */
export const saveJob = data => fetch('/console/job/save', data, 'POST');
/**删除定时任务信息 */
export const deleteJob = data => fetch('/console/job/delete', data, 'POST');