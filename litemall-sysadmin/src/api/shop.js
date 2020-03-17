import request from '@/utils/request'

export function listShop(query) {
  return request({
    url: '/shop/list',
    method: 'get',
    params: query
  })
}

export function createShop(data) {
  return request({
    url: '/shop/create',
    method: 'post',
    data
  })
}

export function updateShop(data) {
  return request({
    url: '/shop/update',
    method: 'post',
    data
  })
}

export function deleteShop(data) {
  return request({
    url: '/shop/delete',
    method: 'post',
    data
  })
}

export function changeStatus(data) {
  return request({
    url: '/shop/changeStatus',
    method: 'post',
    data
  })
}
