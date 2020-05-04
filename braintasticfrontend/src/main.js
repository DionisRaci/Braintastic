import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import VueCookie from 'vue-cookie'
import { routes } from './routes'

Vue.use(VueRouter)
Vue.use(VueCookie);

const router = new VueRouter({
  routes,
  mode: 'history'
})

new Vue({
  el: '#app',
  router,
  render: h => h(App)
})