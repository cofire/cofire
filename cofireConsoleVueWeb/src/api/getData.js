import fetch from '@/config/fetch'

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
export const resetPassword = data => fetch('/console/user/resetPassword', data, 'POST');
/**角色设置 */
export const saveUserRole = data => fetch('/console/user/saveUserRole', data, 'POST');
/**查询选中用户已经存在的角色 */
export const queryUserRole = data => fetch('/console/user/queryUserRole', data, 'POST');
/** 查看详情，获取用户角色信息*/
export const viewUserRole = data => fetch('/console/user/viewUserRole', data, 'POST');
/** 密码重置 */
export const confirmUpdatePsw = data => fetch('/console/updatePassword' , data , 'POST');
/** 同步 */
export const userSynchronize = () => fetch('/console/user/userSynchronize' , {} , 'POST');

/** 角色管理 */
/** 获取角色列表 */
export const queryRole = data => fetch('/console/role/query', data, 'POST');

/** 获取角色列表 */
export const queryRolePagination = data => fetch('/console/role/queryPagination', data, 'POST');


/** 新增/编辑角色信息 */
export const saveRole = data => fetch('/console/role/save', data, 'POST');

/**删除角色信息 */
export const deleteRole = data => fetch('/console/role/deleteRole', data, 'POST');

/**获取角色权限树 */
export const getRoleTree = data => fetch('/console/role/queryRoleResource', data, 'POST');

/**查看详情时获取角色权限树 */
export const getRoleTreeDetail = data => fetch('/console/role/queryRoleResourceDetail', data, 'POST');

/** 查询登入日志信息 */
export const queryLoginLog = data => fetch('/console/loginAudits/queryLoginLog', data, 'POST');
/** 查询操作日志信息 */
export const queryOpeLog = data => fetch('/console/operateAudits/queryOpeLog', data, 'POST');

/** 查询数据字典列表 */
export const queryDict = data => fetch('/console/dict/query', data, 'POST');

/** 新增/编辑数据字典信息 */
export const saveDict = data => fetch('/console/dict/save', data, 'POST');

/** 查询部门树 */
export const getTree = data => fetch('/console/depart/getTree', data, 'POST');
/** 导出部门 */
export const getDepartExcel = data => fetch('/console/depart/getDepartExcel',{responseType: 'arraybuffer'},data, 'POST');
/** 导出员工 */
export const getUserExcel = data => fetch('/console/depart/getUserExcel',{responseType: 'arraybuffer'},data, 'POST');

/** 删除数据字典信息 */
export const deleteDict = data => fetch('/console/dict/delete', data, 'POST');

/** 根据GroupID 获取数据字典 */
export const getDictByGroup = data => fetch('/console/getDictByGroup', data, 'POST');

/** 系统参数管理 */
/** 获取系统参数列表 */
export const queryParams = data => fetch('/console/params/queryParams', data, 'POST');
/** 新增/编辑系统参数 */
export const saveParams = data => fetch('/console/params/saveParams', data, 'POST');
/** 删除系统参数信息 */
export const deleteParams = data => fetch('/console/params/deleteParams', data, 'POST');

/** 修改部门名称  新增部门 */
export const saveDepart = data => fetch('/console/depart/save', data, 'POST');

/** 删除部门 */
export const deleteDepart = data => fetch('/console/depart/delete', data, 'POST');

/** 通过branchNo查询部门的员工，分页查询 */
export const queryUserByBranchNo = data => fetch('/console/departChecker/queryUserByBranchNo', data, 'POST');
/** 通过branchNo查询部门的审核人 */
export const queryCheckersByBranchNo = data => fetch('/console/departChecker/queryCheckersByBranchNo', data, 'POST');
/** 添加部门审核人 */
export const addCheckers = data => fetch('/console/departChecker/addCheckers', data, 'POST');
/** 删除部门审核人 */
export const delCheckers = data => fetch('/console/departChecker/delCheckers', data, 'POST');

/** 查询停车场 */
export const queryParking = data => fetch('/console/parking/queryParking', data, 'POST');

/** 添加停车场车辆信息 */
export const saveParking = data => fetch('/console/parking/saveParking', data, 'POST');

/** 删除停车场车辆信息 */
export const deleteParking = data => fetch('/console/parking/delParking', data, 'POST');

/** 系统管理 */
/** 查询富文本 */
export const queryRichText = data=> fetch('/console/richText/queryRichText',data,'POST');
/** 查询富文本 */
export const saveRichText = data=> fetch('/console/richText/saveRichText',data,'POST');
/** 查询富文本 */
export const deleteRichText = data=> fetch('/console/richText/deleteRichText',data,'POST');
