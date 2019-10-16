import axios from 'axios'

// axios 配置
axios.defaults.timeout = 5000

// http request 拦截器
axios.interceptors.request.use(
  config => {
    return config
  },
  err => {
    return Promise.reject(err)
  },
)
// http response 拦截器
axios.interceptors.response.use(
  response => {
    console.log(response)
    return response
  },
  error => {
    if (error.response) {
      console.log(error.response)
    }
    return Promise.reject(error.response.data)
  },
)

export default axios