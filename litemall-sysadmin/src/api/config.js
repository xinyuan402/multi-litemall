import request from '@/utils/request'

export function listOrder() {
  return request({
    url: '/config/order',
    method: 'get'
  })
}

export function updateOrder(data) {
  return request({
    url: '/config/order',
    method: 'post',
    data
  })
}

export function listWx() {
  return request({
    url: '/config/wx',
    method: 'get'
  })
}

export function updateWx(data) {
  return request({
    url: '/config/wx',
    method: 'post',
    data
  })
}
