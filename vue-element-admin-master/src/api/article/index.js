import request from '@/utils/request'

function query(data) {
  return request({
    url: '/api/article',
    method: 'get',
    params: { data }
  })
}

function add(data) {
  return request({
    url: '/api/article',
    method: 'put',
    data: data
  })
}

function upload(fileobj) {
  const param = new FormData()
  // 上传文件对象 名称file与后台控制器参数要一致
  param.append('file', fileobj.file)
  return request({
    method: 'post',
    // 上传地址
    url: '/api/file/upload',
    // 定义上传头
    headers: { 'Content-Type': 'multipart/form-data' },
    data: param
  })
}

export default { query, add, upload }
