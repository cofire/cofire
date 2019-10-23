import i18n from '../../../i18n/i18n';

export default class TableModel {
  /** 表格数据 */
  data = [];
  /** 正在加载特效 */
  loading = false;
  /** 正在加载文字描述 */
  loadingText = i18n.t('common.message.loadingText');

  /** 以下为分页器属性*/
  /** 表格数据总数 */
  total = 0;
  /** 表格每页显示条数 */
  pageSizes = [10, 20, 30, 40, 50];
  layout = "total, sizes, prev, pager, next, jumper"
}
