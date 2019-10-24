import i18n from '../../../i18n/i18n';

export default class LoadingModel {
  loading =  false;
  text =  i18n.t('common.message.loadingText');
  spinner =  'el-icon-loading';
  background =  'rgba(0, 0, 0, 0.8)'

}
