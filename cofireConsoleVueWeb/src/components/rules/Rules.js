import i18n from '../../i18n/i18n'
import {
  Validator
} from './Validator'
var validator = new Validator();
export const Rules = {
  LoginRules: {
    userId: [{
      required: true,
      message: i18n.t("login.rule.userId"),
      trigger: "blur"
    }],
    passWord: [{
      required: true,
      message: i18n.t("login.rule.passWord"),
      trigger: "blur"
    }]
  },
  changePassWordRules: {
    currentPassWord: [{
        required: true,
        message: i18n.t("changePassWord.rule.currentPassWord"),
        trigger: "blur"
      },
      {
        validator: validator.checkPassWordContainChinese,
        trigger: 'blur'
      }
    ],
    newPassWord: [{
        required: true,
        message: i18n.t("changePassWord.rule.newPassWord"),
        trigger: "blur"
      },
      {
        validator: validator.checkPassWordContainChinese,
        trigger: 'blur'
      }
    ],
    confirmNewPassWord: [{
        required: true,
        message: i18n.t("changePassWord.rule.confirmNewPassWord"),
        trigger: "blur"
      },
      {
        validator: validator.checkPassWordContainChinese,
        trigger: 'blur'
      },
    ]
  },
  UserRules: {
    userId: [{
      required: true,
      message: i18n.t('user.rule.userId'),
      trigger: 'blur'
    }],
    userName: [{
      required: true,
      message: i18n.t('user.rule.userName'),
      trigger: 'blur'
    }, ]
  },
  RoleRules: {
    roleId: [{
      required: true,
      message: i18n.t('role.rule.roleId'),
      trigger: 'blur'
    }],
    roleName: [{
      required: true,
      message: i18n.t('role.rule.roleName'),
      trigger: 'blur'
    }, ]
  }
}
