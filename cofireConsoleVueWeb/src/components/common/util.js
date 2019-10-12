/**
 * 自定义工具类
 */

/**
 * 对象复制
 */
export const copyObject = (source, dest) => {
  Object.keys(dest).forEach(key => {
    if (source[key] !== undefined) {
      dest[key] = source[key];
    }
  })
  return dest;
}
/**
 * 将字典对象数组转为数组
 * @param {} data
 */
export const formatDateDict = (data) => {
  return data.map(function (obj) {
    var arr2 = []
    arr2[obj.DICT_VALUE] = obj.DICT_NAME
    return arr2
  });
}

/**
 * 获取数据字典 DICT_NAME
 */
export const getDictName = (dictList, value) => {
  if (dictList === undefined || dictList === null || !(dictList instanceof Array)) {
    return value;
  }
  for (let index in dictList) {
    if (dictList[index].DICT_VALUE === value) {
      return dictList[index]['DICT_NAME'];
    }
  }
  return value;
}
/**
 * 时间格式转换  把20190519101010   转换成  2019-05-19 10:10:10 格式
 */
export const formatDate = (timeString) => {
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
  } //  其余格式视为不合法数据，不显示
}

/**
 * 转换图片上传url集合为 以,隔开的字符串
 * */
export const formatImgUrls = (urlList) => {
  if (urlList && urlList.length > 0) {
    let imgUrls = '';
    let i = 0;
    for (let url of urlList) {
      if (i == 0) {
        imgUrls = url;
      } else {
        imgUrls = imgUrls + "," + url;
      }
      i++;
    }
    return imgUrls;
  }
  return null;
}

/**
 * 删除图片时，传入删除图片的url，返回剩余图片url的集合
 * */
export const formatRemoveUrl = (removeUrl, imgUrlList) => {
  if (removeUrl && imgUrlList && imgUrlList.length > 0) {
    for (let i = 0; i < imgUrlList.length; i++) {
      if (imgUrlList[i] == removeUrl) {
        return i
      }
    }
    return -1;
  }
  return -1;
}

/**
 * 部门审核人和EHS审核人，把list转化成下拉框
 * */
export const formatChecker = (checkerList) => {
  if (checkerList && (checkerList instanceof Array) && checkerList.length > 0) {
    let checkerOptions = [];
    for (let i = 0; i < checkerList.length; i++) {
      let checker = {
        userId: checkerList[i].userId,
        userNameOne:checkerList[i].userName,
        userName: checkerList[i].userId + '-' + checkerList[i].userName
      };
      checkerOptions.push(checker);
    }
    return checkerOptions;
  }
  return null;
}
/**
 *
 * @param {获取当天最早和最晚时间}
 */

 export const getCurrentStartAndEndTime =() =>{
  var date = new Date();
  var seperator1 = "-";
  var year = date.getFullYear();
  var month = date.getMonth() + 1;
  var strDate = date.getDate();

  if (month >= 1 && month <= 9) {
    month = "0" + month;
  }
  if (strDate >= 0 && strDate <= 9) {
    strDate = "0" + strDate;
  }
  // let beg = year + month + strDate;
  // let end = year + month + strDate;

  let beg = year +""+ month +""+ strDate;
  let end = year +""+ month +""+ strDate;

  return [beg,end]
 }
/**
 *
 * @param {将查询条件的起始日期和结束日期添加时分秒  比如传入20190924,20190924  =>  20190924000000,20190924235959}
 */
export const getBeginAndEnd =(queryTime) =>{
  var timeString='';
  var timeList=[];
  if(''!=queryTime){
      timeList=queryTime.split(',');
     let firstTime=timeList[0]+"000000";
     let lastTime=timeList[1]+"235959";
     if(firstTime.length>14){
      timeString=timeList[0]+","+timeList[1]
      return timeString
     }
     timeString=firstTime+","+lastTime
      return timeString
  }else{
    return timeString
  }


}
/**
 * 获取当前时间字符串
 */
export const getCurrentTime = (formate) => {
  var date = new Date();
  var year = date.getFullYear();
  var month = date.getMonth() + 1;
  if (month < 10) {
    month = "0" + month;
  }
  var day = date.getDate();
  if (day < 10) {
    day = "0" + day;
  }
  var hour = date.getHours();
  if (hour < 10) {
    hour = "0" + hour;
  }
  var minute = date.getMinutes();
  if (minute < 10) {
    minute = "0" + minute;
  }
  var second = date.getSeconds();
  if (second < 10) {
    second = "0" + second;
  }
  if (formate === "yyyyMMdd") {
    return "" + year + month + day;
  }
  if (formate === "yyyyMMddHHmmss") {
    return "" + year + month + day + hour + minute + second;
  }
  return "" + year + month + day + hour + minute + second;
}

// 时间戳转yyyy-MM-dd HH:mm:ss 格式
export const timestampToTime = (timestamp) => {
  var multiple = 1;
  if(timestamp.length == 10){
    multiple = 1000;
  }
  var date = new Date(timestamp * multiple);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
  var Y = date.getFullYear() + '-';
  var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
  var D = (date.getDate() < 10 ? '0'+date.getDate() : date.getDate()) + ' ';
  var h = (date.getHours() < 10 ? '0'+date.getHours() : date.getHours()) + ':';
  var m = (date.getMinutes() < 10 ? '0'+date.getMinutes() : date.getMinutes()) + ':';
  var s = (date.getSeconds() < 10 ? '0'+date.getSeconds() : date.getSeconds());
  return Y+M+D+h+m+s;
}
