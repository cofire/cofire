import i18n from '../../../i18n/i18n';

export default class TableModel {
  /** 表格数据 */
  data = [];
  /**是否带有纵向边框 */
  border = true;

  /** 以下为分页器属性*/
  /** 表格数据总数 */
  total = 0;
  /** 表格每页显示条数 */
  pageSize = 10;
  pageSizes = [10, 20, 30, 40, 50];
  layout = "total, sizes, prev, pager, next, jumper"

  /** 以下为加载特效属性 */
  /** 正在加载特效 */
  loading = false;
  /** 正在加载文字描述 */
  text = i18n.t('common.message.loadingText');
  /** 正在加载图标 */
  spinner = 'el-icon-loading';
  /** 遮罩背景色 */
  background = 'rgba(0, 0, 0, 0.8)';

}
