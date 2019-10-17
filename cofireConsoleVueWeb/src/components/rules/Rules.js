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
  },
  UserRules: {
    userId: [
      {
        required: true,
        message:  i18n.t('user.rule.userId'),
        trigger: 'blur'
      }
    ],
    userName: [
      {
        required: true,
        message:  i18n.t('user.rule.userName'),
        trigger: 'blur'
      },
    ],
    passWord: [
      {
        required: true,
        message:  i18n.t('user.rule.password'),
        trigger: 'blur'
      }
    ],
  }
}