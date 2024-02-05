import { RouteRecordRaw } from 'vue-router';

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '/', component: () => import('pages/AboutPage.vue') },
      {
        path: '/gallery',
        component: () => import('pages/GalleryPage.vue'),
        children: [
          {
            path: ':id',
            component: () => import('src/pages/ProjectsPage.vue'),
          },
        ],
      },
      { path: '/contacts', component: () => import('pages/ContactsPage.vue') },
      { path: '/services', component: () => import('pages/ServicesPage.vue') },
      {
        path: '/shop',
        component: () => import('pages/ShopPage.vue'),
        children: [
          { path: ':id', component: () => import('pages/ItemPage.vue') },
        ],
      },
      {
        path: '/favorites',
        component: () => import('pages/FavoritesPage.vue'),
      },
      {
        path: '/book-a-consultation',
        component: () => import('pages/CalendarPage.vue'),
      },
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
