import request from '@/utils/request'

function query(data) {
  return request({
    url: '/admin/article',
    method: 'get',
    params: { data }
  })
}

function add(data) {
  return request({
    url: '/admin/article',
    method: 'put',
    data: data
  })
}

export default { query, add }
