import Vue from 'vue'
import i18n from '../i18n/i18n'
import Router from '../router/index'
/**
 * fetch参数详解：
 *  url = '' 向后台请求数据的URL
 *  data = {} 向后台发起请求的数据
 *  type = 'POST' 向后台发起请求的方式，目前只支持 POST请求
 *  contentType = 'urlencoded' 请求数据的格式，目前支持x-www-form-urlencoded和 application/json两种格式
 *  method = 'fetch' 目前只支持fetch方法
 */
export default async (url = '', data = {}, type = 'POST', contentType = 'urlencoded', method = 'fetch') => {
  type = type.toUpperCase();
  contentType = contentType.toUpperCase();
  url = Vue.prototype.GLOBAL.baseUrl + url;

  if (window.fetch && method == 'fetch') {
    let dataStr = ''; //数据拼接字符串
    Object.keys(data).forEach(key => {
      if (data[key] !== undefined && data[key] !== null && data[key] !== "") {
        if (typeof data[key] === "string") {
          if (data[key].replace(/(^\s*)|(\s*$)/g, "") == "") {
            return true;
          }
          dataStr += key + '=' + encodeURIComponent(data[key].replace(/(^\s*)|(\s*$)/g, "")) + '&';
        } else {
          dataStr += key + '=' + encodeURIComponent(data[key]) + '&';
        }
      }
    })

    if (dataStr !== '') {
      dataStr = dataStr.substr(0, dataStr.lastIndexOf('&'));
    }

    let _contentType = "application/x-www-form-urlencoded;charset=utf-8";
    if (contentType === "JSON") {
      _contentType = "application/json"
    }

    let requestConfig = {
      credentials: 'include',
      method: type,
      headers: {
        'Accept': '*/*',
        'Content-Type': _contentType,
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, PUT, PATCH, DELETE',
        'Access-Control-Allow-Headers': 'Access-Control-Allow-Headers, Origin,Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Authorization , Access-Control-Request-Headers',
      },
      mode: "cors",
      cache: "force-cache"
    }

    if (type == 'POST') {
      if (contentType === "JSON") {
        Object.defineProperty(requestConfig, 'body', {
          value: JSON.stringify(data)
        })
      } else {
        Object.defineProperty(requestConfig, 'body', {
          value: dataStr
        })
      }

    }

    try {
      const response = await fetch(url, requestConfig);
      const responseJson = await response.json();
      if (responseJson.success === false && responseJson.code === "402") {
        Vue.prototype.$message.error(i18n.t("code." + responseJson.code));
        setTimeout(function () {
          Router.replace("/login");
        }, 1500);
      }
      return responseJson
    } catch (error) {
      throw new Error(error)
    }
  }
}
