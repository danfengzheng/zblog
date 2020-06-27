import request from '@/utils/request'

function getList(data) {
  return request({
    url: '/api/operation/tag',
    method: 'get',
    params: data
  })
}

function getTree() {
  return request({
    url: '/api/operation/tag/findList',
    method: 'get'
  })
}

export default { getList, getTree }
