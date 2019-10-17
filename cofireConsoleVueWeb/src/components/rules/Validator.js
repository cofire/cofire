import i18n from '../../i18n/i18n'
export class Validator {
  // 检查手机号
  checkPhone = (rule, value, callback) => {
    if (value != "") {
      var isPhone = /^1[3|4|5|7|8][0-9]\d{8}$/; 
      if (isPhone.test(value)) {
        callback();
      } else {
        callback(new Error(i18n.t("validator.common.phoneError")));
      }
    } else {
      callback(new Error(i18n.t("validator.common.phoneRequired")));
    }
  }
}
