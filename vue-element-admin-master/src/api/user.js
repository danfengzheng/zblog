import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/admin/sys/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/admin/sys/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/admin/sys/logout',
    method: 'post'
  })
}
