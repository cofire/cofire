import {
    commonModel
} from "../common/commonModel";

export class carModel extends commonModel {

      pageNo='';       //当前页
      pageSize='';    //定义页的大小 
      uniqueNo='';    //过车信息唯一标识
      direction='';   //过车行驶方向
      plateNo='';     //车牌号码
      cardNo='';      //卡号
      passTime='';    //通行时间
      vehType='';     //车辆类型
      vehColor='';    //车辆颜色
      operatorName='';//操作员账号
      terminalNo='';  //放行的终端编号
      gateName='';    //出入口名称
      laneName='';    //放行车道名称
      passType='';    //通行方式
      inPassTime='';  //(可选)出场对应的入场时间
      inUniqueNo='';  //(可选)出场对应的入场车辆唯一编号
      shouldPay='';   //(可选)出场应付金额 单位:分
      actualPay='';   //(可选)出场实付金额 单位:分
      picFilePath=''; //过车图片相对路径
      plateFilePath='';//过车车牌相对路径
      
}
