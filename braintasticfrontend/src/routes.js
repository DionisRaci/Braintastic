import Login from "./components/Login.vue"
import Register from "./components/Register.vue"
import AccessPage from "./components/AccessPage.vue"
import CreateSession from "./components/CreateSession.vue"

export const routes = [
  { 
    path: '/access', 
    component: AccessPage,

    //redirect to register if not login
    beforeEnter (to, from, next) {
      console.log(to.name)
      const isUndefined = to.name !== 'register' && to.name !== 'login';
  
      console.log(isUndefined);
      next(isUndefined ? { name:'register' } : true)
    },

    children: [
      { path: '/login', component: Login, name: 'login' },
      { path: '/register', component: Register, name: 'register' },
      { path: '*', redirect: '/register'}
  ]},
  { path: '/create', component: CreateSession, name: 'create'},
  { path: '*', redirect: 'access'}
  //{ path: '/dashboard', component: Dashboard}
]