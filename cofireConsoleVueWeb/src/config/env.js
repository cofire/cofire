/**
 * 配置编译环境和线上环境之间的切换
 *
 * baseUrl: 域名地址
 * routerMode: 路由模式
 * baseImgPath: 图片存放地址
 *
 */
let baseUrl = 'http://localhost:8080'; //本地运行时链接
// let baseUrl = 'http://192.168.100.115:8080'; //115电脑上发布连接
// let baseUrl = 'http://isecurity-mnt.com'; //发布生产环境链接
// let baseUrl = 'http://www.cool-srv.com:8089'; //统一打包时链接
let routerMode = 'hash';
let baseImgPath = baseUrl + "/console/image";
let imgUploadUrl = baseUrl + "/console/imgUplode";
//导出  导入  部门  员工
let exportDepartUrl = baseUrl + "/console/depart/getDepartExcel";
let exportUserUrl = baseUrl + "/console/depart/getUserExcel";
let importDepartUrl = baseUrl + "/console/depart/importDepartExcel";
let importUserUrl = baseUrl + "/console/depart/importUserExcel";

export {
  baseUrl,
  routerMode,
  baseImgPath,
  imgUploadUrl,
  exportDepartUrl,
  exportUserUrl,
  importDepartUrl,
  importUserUrl
}
