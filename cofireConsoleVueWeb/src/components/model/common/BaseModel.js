export class BaseModel {
  operation = 'query'; //操作类型
  source_type = 'pc'; //操作来源
  length = 10; // 页码大小
  page = 1; // 当前页码
}