import i18n from '../../../i18n/i18n';

export default class DialogModel {
  /** 弹出框标题 */
  title = "title";
  /** 是否可见 */
  visible = false;
  /** 点击遮罩关闭 */
  close_on_click_modal = false;
  /** 弹出层宽度 */
  width = "60%";

  /** 弹出层中form表单是否禁用 */
  formDisabled = false;
  /** 弹出层中form表单中的字段是否禁用 */
  disabled = false;
}
