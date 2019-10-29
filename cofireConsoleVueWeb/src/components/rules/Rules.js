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
  },
  ResourceRules: {
    resourceId: [{
      required: true,
      message: i18n.t('resource.rule.resourceId'),
      trigger: 'blur'
    }],
    resourceName: [{
      required: true,
      message: i18n.t('resource.rule.resourceName'),
      trigger: 'blur'
    }],
    parentResourceId: [{
      required: true,
      message: i18n.t('resource.rule.parentResourceId'),
      trigger: 'blur'
    }],
    enabled: [{
      required: true,
      message: i18n.t('resource.rule.enabled'),
      trigger: 'blur'
    }],
    isLeaf: [{
      required: true,
      message: i18n.t('resource.rule.isLeaf'),
      trigger: 'blur'
    }]
  },
  DictRules: {
    groupId: [{
      required: true,
      message: i18n.t('dict.rule.groupId'),
      trigger: 'blur'
    }],
    dictValue: [{
      required: true,
      message: i18n.t('dict.rule.dictValue'),
      trigger: 'blur'
    }],
    groupName: [{
      required: true,
      message: i18n.t('dict.rule.groupName'),
      trigger: 'blur'
    }],
    dictName: [{
      required: true,
      message: i18n.t('dict.rule.dictName'),
      trigger: 'blur'
    }]
  },
  ParamRules: {
    groupId: [{
      required: true,
      message: i18n.t('param.rule.groupId'),
      trigger: 'blur'
    }],
    paramValue: [{
      required: true,
      message: i18n.t('param.rule.paramValue'),
      trigger: 'blur'
    }],
    paramId: [{
      required: true,
      message: i18n.t('param.rule.paramId'),
      trigger: 'blur'
    }],
    paramName: [{
      required: true,
      message: i18n.t('param.rule.paramName'),
      trigger: 'blur'
    }],
    canDelete: [{
      required: true,
      message: i18n.t('param.rule.canDelete'),
      trigger: 'blur'
    }]
  },
  JobRules: {
    jobId: [{
      required: true,
      message: i18n.t('job.rule.jobId'),
      trigger: 'blur'
    }],
    jobName: [{
      required: true,
      message: i18n.t('job.rule.jobName'),
      trigger: 'blur'
    }]
  }
}
