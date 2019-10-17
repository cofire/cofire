import i18n from '../../i18n/i18n'
import {Validator} from './Validator'
var validator = new Validator();
export const Rules = {
  LoginRules:{
    userId: [
      {
        required: true,
        message: i18n.t("login.rule.userId"),
        trigger: "blur"
      }
    ],
    passWord: [
      {
        required: true,
        message: i18n.t("login.rule.passWord"),
        trigger: "blur"
      }
    ]
  }
}