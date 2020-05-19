import request from '@/utils/request'

function queryPage(params) {
  console.log(params)
  return request({
    url: '/admin/operation/tag',
    method: 'get',
    params
  })
}

export default { queryPage }
