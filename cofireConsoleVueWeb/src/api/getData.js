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

/** 角色管理 */
/** 获取角色列表 */
/** 获取角色列表 */
export const queryRole = data => fetch('/console/role/query', data, 'POST');
/** 保存角色信息 */
export const saveRole = data => fetch('/console/role/save', data, 'POST');
/**删除角色信息 */
export const deleteRole = data => fetch('/console/role/delete', data, 'POST');

