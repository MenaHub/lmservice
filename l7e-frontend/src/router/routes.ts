import { RouteRecordRaw } from 'vue-router';

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/HomePage.vue') },
      { path: '/about', component: () => import('pages/AboutPage.vue') },
      { path: '/contacts', component: () => import('pages/ContactsPage.vue') },
      { path: '/services', component: () => import('pages/ServicesPage.vue') },
      { path: '/shop', component: () => import('pages/ShopPage.vue') },
    ],
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue'),
  },
];

export default routes;
