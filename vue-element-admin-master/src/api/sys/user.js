import request from '@/utils/request'

function getList(data) {
  console.log('--------------------------')
  return request({
    url: '/admin/sys/user',
    method: 'get',
    params: data
  })
}

export default { getList }
