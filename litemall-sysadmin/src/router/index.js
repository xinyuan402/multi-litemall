import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/views/layout/Layout'

/** note: Submenu only appear when children.length>=1
 *  detail see  https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 **/

/**
* hidden: true                   if `hidden:true` will not show in the sidebar(default is false)
* alwaysShow: true               if set true, will always show the root menu, whatever its child routes length
*                                if not set alwaysShow, only more than one route under the children
*                                it will becomes nested mode, otherwise not show the root menu
* redirect: noredirect           if `redirect:noredirect` will no redirect in the breadcrumb
* name:'router-name'             the name is used by <keep-alive> (must set!!!)
* meta : {
    perms: ['GET /aaa','POST /bbb']     will control the page perms (you can set multiple perms)
    title: 'title'               the name show in submenu and breadcrumb (recommend set)
    icon: 'svg-name'             the icon show in the sidebar,
    noCache: true                if true ,the page will no be cached(default is false)
  }
**/
export const constantRouterMap = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path*',
        component: () => import('@/views/redirect/index')
      }
    ]
  },
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },
  {
    path: '/auth-redirect',
    component: () => import('@/views/login/authredirect'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/errorPage/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/errorPage/401'),
    hidden: true
  },
  {
    path: '',
    component: Layout,
    redirect: 'dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('@/views/dashboard/index'),
        name: 'Dashboard',
        meta: {
          title: '系统级管理首页 TD',
          icon: 'dashboard',
          affix: true
        }
      }
    ]
  }
]

export default new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})

export const asyncRouterMap = [
  {
    path: '/shop',
    component: Layout,
    redirect: 'noredirect',
    alwaysShow: true,
    name: 'shop',
    meta: {
      title: '商户 TD',
      icon: 'chart'
    },
    children: [
      {
        path: 'shop',
        component: () => import('@/views/shop/shop'),
        name: 'shop',
        meta: {
          perms: ['GET /sysadmin/shop/list', 'POST /sysadmin/shop/create'],
          title: '商铺管理 TD',
          noCache: true
        }
      }
    ]
  },
  {
    path: '/user',
    component: Layout,
    redirect: 'noredirect',
    alwaysShow: true,
    name: 'userManage',
    meta: {
      title: '用户管理 TD',
      icon: 'chart'
    },
    children: [
      {
        path: 'user',
        component: () => import('@/views/user/user'),
        name: 'user',
        meta: {
          perms: ['GET /sysadmin/user/list'],
          title: '会员列表 TD',
          noCache: true
        }
      },
      {
        path: 'address',
        component: () => import('@/views/user/address'),
        name: 'address',
        meta: {
          perms: ['GET /sysadmin/address/list'],
          title: '收货地址 TD',
          noCache: true
        }
      },
      {
        path: 'collect',
        component: () => import('@/views/user/collect'),
        name: 'collect',
        meta: {
          perms: ['GET /sysadmin/collect/list'],
          title: '会员收藏 TD',
          noCache: true
        }
      },
      {
        path: 'footprint',
        component: () => import('@/views/user/footprint'),
        name: 'footprint',
        meta: {
          perms: ['GET /sysadmin/footprint/list'],
          title: '会员足迹 TD',
          noCache: true
        }
      },
      {
        path: 'history',
        component: () => import('@/views/user/history'),
        name: 'history',
        meta: {
          perms: ['GET /sysadmin/history/list'],
          title: '搜索历史 TD',
          noCache: true
        }
      },
      {
        path: 'feedback',
        component: () => import('@/views/user/feedback'),
        name: 'feedback',
        meta: {
          perms: ['GET /sysadmin/feedback/list'],
          title: '意见反馈 TD',
          noCache: true
        }
      }
    ]
  },
  {
    path: '/mall',
    component: Layout,
    redirect: 'noredirect',
    alwaysShow: true,
    name: 'mallManage',
    meta: {
      title: '商场管理 TD',
      icon: 'chart'
    },
    children: [
      {
        path: 'region',
        component: () => import('@/views/mall/region'),
        name: 'region',
        meta: {
          title: '行政区域 TD',
          noCache: true
        }
      },
      {
        path: 'brand',
        component: () => import('@/views/mall/brand'),
        name: 'brand',
        meta: {
          perms: ['GET /sysadmin/brand/list', 'POST /sysadmin/brand/create', 'GET /sysadmin/brand/read', 'POST /sysadmin/brand/update', 'POST /sysadmin/brand/delete'],
          title: '品牌制造商 TD',
          noCache: true
        }
      },
      {
        path: 'category',
        component: () => import('@/views/mall/category'),
        name: 'category',
        meta: {
          perms: ['GET /sysadmin/category/list', 'POST /sysadmin/category/create', 'GET /sysadmin/category/read', 'POST /sysadmin/category/update', 'POST /sysadmin/category/delete'],
          title: '商品类目 TD',
          noCache: true
        }
      },
      {
        path: 'order',
        component: () => import('@/views/mall/order'),
        name: 'order',
        meta: {
          perms: ['GET /sysadmin/order/list', 'GET /sysadmin/order/detail', 'POST /sysadmin/order/ordership', 'POST /sysadmin/order/orderrefund', 'POST /sysadmin/order/orderreply'],
          title: '订单管理 TD',
          noCache: true
        }
      },
      {
        path: 'keyword',
        component: () => import('@/views/mall/keyword'),
        name: 'keyword',
        meta: {
          perms: ['GET /sysadmin/keyword/list', 'POST /sysadmin/keyword/create', 'GET /sysadmin/keyword/read', 'POST /sysadmin/keyword/update', 'POST /sysadmin/keyword/delete'],
          title: '关键词 TD',
          noCache: true
        }
      }
    ]
  },

  {
    path: '/goods',
    component: Layout,
    redirect: 'noredirect',
    alwaysShow: true,
    name: 'goodsManage',
    meta: {
      title: '商品管理 TD',
      icon: 'chart'
    },
    children: [
      {
        path: 'list',
        component: () => import('@/views/goods/list'),
        name: 'goodsList',
        meta: {
          perms: ['GET /sysadmin/goods/list', 'POST /sysadmin/goods/delete'],
          title: '商品列表 TD',
          noCache: true
        }
      }
    ]
  },
  {
    path: '/promotion',
    component: Layout,
    redirect: 'noredirect',
    alwaysShow: true,
    name: 'promotionManage',
    meta: {
      title: '推广管理 TD',
      icon: 'chart'
    },
    children: [
      {
        path: 'ad',
        component: () => import('@/views/promotion/ad'),
        name: 'ad',
        meta: {
          perms: ['GET /sysadmin/ad/list', 'POST /sysadmin/ad/create', 'GET /sysadmin/ad/read', 'POST /sysadmin/ad/update', 'POST /sysadmin/ad/delete'],
          title: '广告管理 TD',
          noCache: true
        }
      }
    ]
  },

  {
    path: '/sys',
    component: Layout,
    redirect: 'noredirect',
    alwaysShow: true,
    name: 'sysManage',
    meta: {
      title: '系统管理 TD',
      icon: 'chart'
    },
    children: [
      {
        path: 'admin',
        component: () => import('@/views/sys/admin'),
        name: 'admin',
        meta: {
          perms: ['GET /sysadmin/admin/list', 'POST /sysadmin/admin/create', 'POST /sysadmin/admin/update', 'POST /sysadmin/admin/delete'],
          title: '系统管理员 TD',
          noCache: true
        }
      },
      {
        path: 'notice',
        component: () => import('@/views/sys/notice'),
        name: 'sysNotice',
        meta: {
          perms: ['GET /sysadmin/notice/list', 'POST /sysadmin/notice/create', 'POST /sysadmin/notice/update', 'POST /sysadmin/notice/delete'],
          title: '系统通知管理 TD',
          noCache: true
        }
      },
      {
        path: 'log',
        component: () => import('@/views/sys/log'),
        name: 'log',
        meta: {
          perms: ['GET /sysadmin/log/list'],
          title: '系统操作日志 TD',
          noCache: true
        }
      },
      {
        path: 'role',
        component: () => import('@/views/sys/role'),
        name: 'role',
        meta: {
          perms: ['GET /sysadmin/role/list', 'POST /sysadmin/role/create', 'POST /sysadmin/role/update', 'POST /sysadmin/role/delete', 'GET /sysadmin/role/permissions', 'POST /sysadmin/role/permissions'],
          title: '角色管理 TD',
          noCache: true
        }
      },
      {
        path: 'os',
        component: () => import('@/views/sys/os'),
        name: 'os',
        meta: {
          perms: ['GET /sysadmin/storage/list', 'POST /sysadmin/storage/create', 'POST /sysadmin/storage/update', 'POST /sysadmin/storage/delete'],
          title: '对象存储 TD',
          noCache: true
        }
      }
    ]
  },

  {
    path: '/config',
    component: Layout,
    redirect: 'noredirect',
    alwaysShow: true,
    name: 'configManage',
    meta: {
      title: '配置管理 TD',
      icon: 'chart'
    },
    children: [
      {
        path: 'order',
        component: () => import('@/views/config/order'),
        name: 'configOrder',
        meta: {
          perms: ['GET /sysadmin/config/order', 'POST /sysadmin/config/order'],
          title: '订单配置 TD',
          noCache: true
        }
      },
      {
        path: 'wx',
        component: () => import('@/views/config/wx'),
        name: 'configWx',
        meta: {
          perms: ['GET /sysadmin/config/wx', 'POST /sysadmin/config/wx'],
          title: '小程序配置 TD',
          noCache: true
        }
      }
    ]
  },

  {
    path: '/stat',
    component: Layout,
    redirect: 'noredirect',
    alwaysShow: true,
    name: 'statManage',
    meta: {
      title: '统计报表 TD',
      icon: 'chart'
    },
    children: [
      {
        path: 'user',
        component: () => import('@/views/stat/user'),
        name: 'statUser',
        meta: {
          perms: ['GET /sysadmin/stat/user'],
          title: '用户统计 TD',
          noCache: true
        }
      },
      {
        path: 'order',
        component: () => import('@/views/stat/order'),
        name: 'statOrder',
        meta: {
          perms: ['GET /sysadmin/stat/order'],
          title: '订单统计 TD',
          noCache: true
        }
      },
      {
        path: 'goods',
        component: () => import('@/views/stat/goods'),
        name: 'statGoods',
        meta: {
          perms: ['GET /sysadmin/stat/goods'],
          title: '商品统计 TD',
          noCache: true
        }
      }
    ]
  },
  {
    path: '/profile',
    component: Layout,
    redirect: 'noredirect',
    alwaysShow: true,
    children: [
      {
        path: 'password',
        component: () => import('@/views/profile/password'),
        name: 'password',
        meta: { title: '修改密码', noCache: true }
      },
      {
        path: 'notice',
        component: () => import('@/views/profile/notice'),
        name: 'notice',
        meta: { title: '通知中心', noCache: true }
      }
    ],
    hidden: true
  },

  { path: '*', redirect: '/404', hidden: true }
]
