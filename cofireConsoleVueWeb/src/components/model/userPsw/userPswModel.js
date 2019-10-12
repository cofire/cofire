import { CommonModel } from '../common/CommonModel';

//这里是创建 paramsModel 类，目前除了存放一些属性没做别的
export class userPswModel extends CommonModel {
  /** 当前密码 (必填项)  */
  currentPsw = '';

  /** 新密码  (必填项) */
  newPsw = '';

  /** 确认新密码 (必填项) */
  confirmNewPsw = '';


}
