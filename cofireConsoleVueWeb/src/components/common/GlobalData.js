const baseUrl = 'http://localhost:8080'; //本地运行时链接

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

export default {
  baseUrl,
  version,
  operation
}
