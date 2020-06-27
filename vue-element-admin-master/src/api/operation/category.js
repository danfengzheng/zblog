import request from '@/utils/request'

function query(data) {
  return request({
    url: '/api/operation/category',
    method: 'get',
    params: data
  })
}

function getTree() {
  return request({
    url: '/api/operation/category/getTree',
    method: 'get'
  })
}

export default { query, getTree }
