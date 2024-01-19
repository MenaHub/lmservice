<template>
  <q-layout
    view="hHh LpR fff"
    container
    style="max-width: 1280px; min-height: 100vh"
  >
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="toggleLeftDrawer"
        />

        <q-toolbar-title class="col-auto"> L.M. Service </q-toolbar-title>
        <q-input
          class="col-grow q-mx-sm"
          dense
          clearable
          borderless
          placeholder="Search"
          type="search"
          clear-icon="close"
          :input-style="{ color: 'white' }"
          v-model="search"
        >
          <template v-slot:prepend>
            <q-icon name="search" color="white" />
          </template>
        </q-input>
        <q-btn
          flat
          dense
          round
          icon="shopping_cart"
          aria-label="Shopping Cart"
          @click="toogleCartDrawer"
        />
      </q-toolbar>
    </q-header>

    <q-drawer
      overlay
      v-model="leftDrawerOpen"
      show-if-above
      elevated
      ref="leftDrawer"
    >
      <q-list>
        <q-item-label header> Menu </q-item-label>
        <q-item
          v-for="route in internalRoutes"
          :key="route.title"
          clickable
          :active="`/${route.link}` === $route.path"
          :to="`/${route.link}`"
        >
          <q-item-section v-if="route.icon" avatar>
            <q-icon :name="route.icon" />
          </q-item-section>

          <q-item-section>
            <q-item-label>{{ route.title }}</q-item-label>
            <!-- <q-item-label caption>{{ route.caption }}</q-item-label> -->
          </q-item-section>
        </q-item>
      </q-list>
    </q-drawer>

    <q-drawer
      side="right"
      overlay
      v-model="cartDrawerOpen"
      show-if-above
      elevated
    >
      <q-list>
        <q-item-label header> Shopping cart</q-item-label>
        <q-item v-for="item in shoppingCart" :key="item.id">
          <q-item-section>
            <q-item-label class="ellipsis">{{ item.name }}</q-item-label>
            <q-item-label> $ {{ item.price }}</q-item-label>
          </q-item-section>
          <q-item-section>
            <q-input v-model="item.quantity" readonly borderless>
              <template v-slot:prepend>
                <q-icon
                  class="cursor-pointer"
                  name="remove"
                  @click="item.quantity--"
                  v-if="item.quantity > 0"
                />
              </template>
              <template v-slot:append>
                <q-icon
                  class="cursor-pointer"
                  name="add"
                  @click="item.quantity++"
                />
              </template>
            </q-input>
          </q-item-section>

          <q-item-section side>
            <q-btn flat dense round icon="delete" aria-label="Delete" />
          </q-item-section>
        </q-item>
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>

    <q-footer elevated>
      <q-toolbar>
        <q-toolbar-title class="row flex-center">
          L.M. Service - Copyright {{ new Date().getFullYear() }}
        </q-toolbar-title>
      </q-toolbar>
    </q-footer>
  </q-layout>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { CartItem } from 'components/models';

export default defineComponent({
  name: 'MainLayout',
  components: {},
  data() {
    return {
      leftDrawerOpen: false,
      cartDrawerOpen: false,
      internalRoutes: [
        {
          title: 'Home',
          icon: 'home',
          link: '',
        },
        {
          title: 'About',
          icon: 'info',
          link: 'about',
        },
        {
          title: 'Services',
          icon: 'handyman',
          link: 'services',
        },
        {
          title: 'Shop',
          icon: 'store',
          link: 'shop',
        },
        {
          title: 'Contacts',
          icon: 'contacts',
          link: 'contacts',
        },
      ],
      search: '',
      //TODO: get the shopping cart from the store
      shoppingCart: [
        {
          id: 1,
          name: 'item1111111111111111111111111111',
          price: 10,
          quantity: 1,
        },
        {
          id: 2,
          name: 'item2',
          price: 35,
          quantity: 2,
        },
        {
          id: 3,
          name: 'item3',
          price: 40,
          quantity: 3,
        },
      ] as CartItem[],
    };
  },
  methods: {
    toggleLeftDrawer() {
      this.leftDrawerOpen = !this.leftDrawerOpen;
    },
    toogleCartDrawer() {
      this.cartDrawerOpen = !this.cartDrawerOpen;
    },
  },
});
</script>
