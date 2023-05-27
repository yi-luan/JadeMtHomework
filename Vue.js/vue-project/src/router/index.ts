import { createRouter, createWebHistory } from 'vue-router'
import LoginComponent from '@/components/LoginComponent.vue'
import MainPageComponent from '@/components/MainPage.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Login',
      component: LoginComponent
    },
    {
      path: '/',
      name: 'MainPage',
      component: MainPageComponent
    }
  ]
})

export default router
