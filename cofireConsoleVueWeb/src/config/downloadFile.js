import Vue from 'vue'
export default async (url = '', data = {}) => {
  url = Vue.prototype.GLOBAL.baseUrl + url;
  let dataStr = ''; //数据拼接字符串
  Object.keys(data).forEach(key => {
    if (data[key] !== undefined && data[key] !== null && data[key] !== "") {
      dataStr += key + '=' + encodeURIComponent(data[key]) + '&';
    }
  })
  if (dataStr !== '') {
    dataStr = dataStr.substr(0, dataStr.lastIndexOf('&'));
  }
  url = url + '?' + dataStr;
  window.open(url, '_blank');
}
