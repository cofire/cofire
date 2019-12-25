export class BaseModel {
  operation = ''; //操作类型
  source = 'pc'; //操作来源
  length = 10; // 页码大小
  page = 1; // 当前页码
  sort = ''; // 排序字段
  order = ''; // 排序类型
}