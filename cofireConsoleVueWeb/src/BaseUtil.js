import { CurrentUserStore } from "./components/store/common/CurrentUserStore";
import  GlobalData  from "./components/common/GlobalData"
import TableModel from "./components/model/common/TableModel"
import DialogModel from "./components/model/common/DialogModel"
import LoadingModel from './components/model/common/LoadingModel';


export default {
  install(Vue)  {
    Vue.prototype.GLOBAL = GlobalData;
    Vue.prototype.TableModel = TableModel;
    Vue.prototype.DialogModel = DialogModel;
    Vue.prototype.LoadingModel = LoadingModel;
    /**
     * 日期格式格式化 
     * 请求示例 formatDate('20190519101010')
     * 方法可根据实际情况扩展
     */
    Vue.prototype.formatDate = (timeString)=>{//全局函数1
      let year = '';
      let month = '';
      let day = '';
      let hour = '';
      let min = '';
      let second = '';
      if (timeString === undefined || timeString === null) {
        return null;
      }
      if (timeString.length === 8) { // yyyyMMdd
        year = timeString.slice(0, 4);
        month = timeString.slice(4, 6);
        day = timeString.slice(6, 8);
        return year + '-' + month + '-' + day;
      } else if (timeString.length === 14) { // yyyyMMddHHmmss
        year = timeString.slice(0, 4);
        month = timeString.slice(4, 6);
        day = timeString.slice(6, 8);
        hour = timeString.slice(8, 10);
        min = timeString.slice(10, 12);
        second = timeString.slice(12, 14);
        return year + '-' + month + '-' + day + ' ' + hour + ':' + min + ':' + second;
      } else {
        return null;
      } 
    };
    /** 
     * 表格中时间格式化  
     * 请求示例 :formatter="formatTableTime"
     */
    Vue.prototype.formatTableTime = (row, column)=>{
      return Vue.prototype.formatDate(row[column.property]);
    }

    /** 
     * 修改查询条件中的时间 
     * queryTimeList 格式例如： ['20191017','20191018']
     */
    Vue.prototype.getQueryTimeBeginAndEnd =(queryTimeList) =>{
      if(queryTimeList == undefined || queryTimeList == null || queryTimeList.length < 2){
        return "";
      }
      return [queryTimeList[0]+"000000", queryTimeList[1]+"235959"]
    }
    /**
     *  获取当天的起始时间和结束时间
     * formate 值 类似于 yyyyMMdd yyyy-MM-dd 等常见的日期格式
     * 根据不同的格式 返回不同的值 可扩展
     * 请求示例 this.getCurrentDayStartAndEndTime("yyyyMMdd")
     * formate 为空时 默认为 yyyyMMdd
     */
    Vue.prototype.getCurrentDayStartAndEndTime =(formate) =>{
      var date = new Date();
      var year = date.getFullYear();
      var month = date.getMonth() + 1;
      var day = date.getDate();
      var begin = "";
      var end = "";

      if (month >= 1 && month <= 9) {
        month = "0" + month;
      }
      if (day >= 0 && day <= 9) {
        day = "0" + day;
      }
      if(formate === undefined || formate === null || formate == ""){
        formate = "yyyyMMdd";
      }
    
      switch (formate){
        case "yyyyMMdd":
            begin = "" + year + month + day;
            end = "" + year + month + day;
            break;
        case "yyyy-MM-dd":
            begin = "" + year + "-" + month + "-" + day;
            end =  "" + year + "-" + month + "-" + day;
            break;
        case "yyyyMMddHHmmss":
            begin = "" + year + month + day + "000000";
            end =  "" + year + month + day + "235959";;
            break;
        case "yyyy-MM-dd HH:mm:ss":
            begin = "" + year + "-" + month + "-" + day + " " + "00:00:00";
            end =  "" + year + "-" + month + "-" + day + " " + "23:59:59";;
            break;
        default:
            break;
      }
      return [begin,end]
     }
    /**重置表单 请求示例 @click="resetForm($refs['queryForm'])" */
     Vue.prototype.resetForm = (form) => {
      form.resetFields();
    }

    /** 根据数据字典组号，获取数据字典列表 */
    Vue.prototype.getDictByGroup = (groupCode) =>{
      return CurrentUserStore.state.dictList[groupCode];
    }

    /**获取数据字典名称*/ 
    Vue.prototype.getDictName = (dictList, value) =>{
      if (dictList === undefined || dictList === null || !(dictList instanceof Array)) {
        return value;
      }
      for (let index in dictList) {
        if (dictList[index].dict_value === value) {
          return dictList[index]['dict_name'];
        }
      }
      return value;
    }

    /**table中数据字典格式化---暂时不用 */ 
    Array.prototype.formateTableDict = function (row, column) {
      return Vue.prototype.getDictName(this, row[column.property]);
    };

    /** js对象深度复制 */
    Vue.prototype.copyObject = (source, dest) => {
      Object.keys(dest).forEach(key => {
        if (source[key] !== undefined) {
          dest[key] = source[key];
        }
      })
      return dest;
    }

    /** 判断为空 */
    Vue.prototype.isBlank = (value) =>{
      if(value == undefined || value == null || value == "" || value.length <= 0){
        return true;
      }
      return false;
    }
    /** 判断不为空 */
    Vue.prototype.isNotBlank = (value) =>{
      return !Vue.prototype.isBlank(value);
    }

    Vue.prototype.isFalse = (value) =>{
      if(Vue.prototype.isBlank(value)){
        return true;
      }
      if(value == "0" || value == "false" || value == "no"){
        return true;
      }
      return false;
    }
  }
};