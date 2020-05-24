import request from '@/utils/request'

function getList(data) {
  return request({
    url: '/admin/operation/tag',
    method: 'get',
    params: data
  })
}

export default { getList }
