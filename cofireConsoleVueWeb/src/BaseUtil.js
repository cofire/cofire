export default {
  install(Vue)  {
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
  }
};