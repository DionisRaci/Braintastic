import Vue from 'vue'
import VueRouter from 'vue-router'
import Access from '../views/Access.vue'
import Login from '../components/Login.vue'
import Register from '../components/Register.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/access',
    name: 'Access',
    component: Access,

    // redirect to register if not login
    beforeEnter (to, from, next) {
      console.log(to.name)
      const isUndefined = to.name !== 'register' && to.name !== 'login'

      console.log(isUndefined)
      next(isUndefined ? { name: 'register' } : true)
    },
    children: [
      { path: '/login', component: Login, name: 'login' },
      { path: '/register', component: Register, name: 'register' }
    ]

  },
  { path: '*', redirect: '/register' }
  /*,
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */// '../views/About.vue')
  // }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
