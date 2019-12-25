import {
  CurrentUserStore
} from "../store/common/CurrentUserStore";

const baseUrl = 'http://localhost:8048/cofire'; //本地运行时链接

const noPermissionRoutes=['/login','/404','/403','/printer'];
// 版本号
const version = "1.0";
// 操作类型
const operation = {
  query: "query",
  add: "add",
  update: "update",
  delete: "delete",
  export: "export",
  upload: "upload"
};

const selectOption = {
  key: "dict_value",
  label: "dict_name_" + CurrentUserStore.state.lang,
  value: "dict_value"
};

export default {
  baseUrl,
  version,
  operation,
  selectOption,
  noPermissionRoutes
}
