import Vue from 'vue'
import Router from 'vue-router'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import Playground from '../views/Playground.vue'
import Event from '../views/Event.vue'
import JoinEvent from '../views/JoinEvent.vue'


import HomeDefault from '../views/HomeDefault.vue'
Vue.component('home-default', HomeDefault)

import HomeAuth from '../components/HomeAuth.vue'
Vue.component('home-auth', HomeAuth)

import HomeGuest from '../components/HomeGuest.vue'
Vue.component('home-guest', HomeGuest)

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    
    {
      path: '/',
      name: 'home',
      component: HomeDefault,
      requiresAuth: false
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/playground",
      name: "playground",
      component: Playground,
      meta: {
        requiresAuth: false
      }
    },
 
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/event/:eventID",
      name: "event",
      component: Event,
      meta: {
        requiresAuth: false
      }
    },
    
    {
      path: "/join-event",
      name: "join-event",
      component: JoinEvent,
      meta: {
        requiresAuth: false
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
