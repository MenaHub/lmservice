<template>
  <q-layout view="hHh LpR fff" style="min-height: 100vh">
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          icon="menu"
          aria-label="Menu"
          @click="toggleMenuDrawer"
        />

        <q-toolbar-title class="col">
          <q-breadcrumbs>
            <template v-slot:separator>
              <q-icon size="1.2em" name="chevron_right" />
            </template>
            <q-breadcrumbs-el class="text-white" label="L.M. Service" to="/" />
            <q-breadcrumbs-el
              v-if="getCurrentRoute()"
              :label="getCurrentRoute()?.title"
              :to="
                getCurrentRoute()?.link == '/'
                  ? '/'
                  : `/${getCurrentRoute()?.link}`
              "
            />
            />
          </q-breadcrumbs>
        </q-toolbar-title>
        <!-- <q-input
          class="col q-mx-sm"
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
        </q-input> -->
        <q-btn
          flat
          dense
          round
          icon="shopping_cart"
          aria-label="Shopping Cart"
          @click="toogleCartDrawer"
        >
          <q-badge
            v-if="shoppingCart.length > 0"
            color="red"
            rounded
            floating
            :label="shoppingCart.length"
          />
        </q-btn>
        <q-btn
          class="q-ml-sm"
          flat
          dense
          round
          icon="account_circle"
          aria-label="Account"
          @click="toogleAccountDrawer"
        />
      </q-toolbar>
    </q-header>

    <q-drawer
      class="q-pt-sm"
      overlay
      v-model="menuDrawerOpen"
      elevated
      ref="menuDrawer"
    >
      <q-list>
        <q-item-label header> Menu </q-item-label>
        <q-item
          v-for="route in internalRoutes"
          :key="route.title"
          clickable
          :active="`/${route.link}` === $route.path"
          :to="`/${route.link}`"
          active-class="bg-primary text-white"
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
      class="q-pt-sm"
      side="right"
      overlay
      v-model="cartDrawerOpen"
      elevated
      ref="cartDrawer"
    >
      <div v-if="shoppingCart.length > 0">
        <q-list>
          <q-item>
            <q-item-section>
              <div class="text-h6 text-center">Shopping cart</div>
            </q-item-section>
          </q-item>
          <q-item v-for="item in shoppingCart" :key="item.id">
            <q-item-section class="col-6 q-ml-sm">
              <q-item-label class="ellipsis">{{ item.name }}</q-item-label>
              <q-item-label> {{ '€ ' + item.price }}</q-item-label>
            </q-item-section>
            <q-item-section class="flex flex-center">
              <q-icon
                v-if="item.quantity > 1"
                class="cursor-pointer"
                name="remove"
                @click="item.quantity--"
              />
            </q-item-section>
            <q-item-section class="flex flex-center">
              {{ item.quantity }}
            </q-item-section>
            <q-item-section class="flex flex-center">
              <q-icon
                class="cursor-pointer"
                name="add"
                @click="item.quantity++"
              />
            </q-item-section>
            <q-item-section class="flex flex-center">
              <q-btn
                flat
                dense
                round
                color="red-12"
                icon="delete"
                aria-label="Delete"
                @click="removeItemFromCart(item)"
              />
            </q-item-section>
          </q-item>
        </q-list>
        <q-separator size="2px" />
        <q-item>
          <q-item-section class="col-6 q-ml-sm">
            <q-item-label class="text-h6">Total</q-item-label>
          </q-item-section>
          <q-item-section class="flex flex-center">
            <q-item-label class="text-h6">
              {{ '€ ' + getCartTotal }}
            </q-item-label>
          </q-item-section>
        </q-item>
      </div>
      <div v-else class="column full-height flex-center">
        <div class="row text-center q-pa-sm">
          <q-icon name="remove_shopping_cart" size="8rem" color="grey-5" />
        </div>
        <div class="row text-center">
          <p class="text-h6 text-bold">No item in the cart</p>
        </div>
      </div>
    </q-drawer>

    <q-drawer
      class="q-pt-sm"
      side="right"
      overlay
      v-model="accountDrawerOpen"
      elevated
      ref="accountDrawer"
    >
      <q-list v-if="!userLoggedIn && customLogin">
        <q-item>
          <q-item-section>
            <div class="text-h6 text-center">Log in</div>
          </q-item-section>
        </q-item>
        <q-item>
          <q-item-section>
            <q-input v-model="username" label="Username" />
          </q-item-section>
        </q-item>
        <q-item>
          <q-item-section>
            <q-input v-model="password" :type="showPassword ? 'text' : 'password'" label="Password">
              <template v-slot:append>
                <q-icon
                  v-if="password !== ''"
                  :name="showPassword ? 'visibility_off' : 'visibility'"
                  class="cursor-pointer"
                  @click="showPassword = !showPassword"
                />
              </template>
            </q-input>
          </q-item-section>
        </q-item>
        <q-item>
          <q-item-section>
            <q-btn rounded no-caps label="Log in" color="primary" @click="classicLogin" />
          </q-item-section>
        </q-item>

        <q-separator class="q-my-md" inset />
      </q-list>
      
      <q-item>
        <GoogleLogin
          class="full-width"
          :callback="callback"
          popup-type="TOKEN"
          prompt
        >
          <q-btn
            icon="img:/google-logo.png"
            class="text-black full-width"
            outline
            rounded
            no-caps
            label="Log in with Google"
          />
        </GoogleLogin>
      </q-item>
      
      <q-list v-if="userLoggedIn">
        <q-item>
          <q-item-section>
            <div class="text-h6 text-center"> Welcome, {{ username  || 'User'}}!</div>
          </q-item-section>
        </q-item>
        <q-item>
          <q-item-section class="flex-center">
            <q-avatar size="8rem">
              <img src="https://cdn.quasar.dev/img/avatar4.jpg" />
            </q-avatar>
          </q-item-section>
        </q-item>
        <q-item>
          <q-item-section>
            <q-btn rounded no-caps label="My account" color="primary" />
          </q-item-section>
        </q-item>
        <q-item>
          <q-item-section>
            <q-btn rounded no-caps label="Log out" color="red-5" @click="userLogout" />
          </q-item-section>
        </q-item>
      </q-list>
    </q-drawer>

    <q-page-container class="flex justify-center">
      <router-view class="q-pa-xl" style="max-width: 1280px; width: 90%" />
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
import { CartItem } from 'src/components/models';
import { useCartStore } from 'src/stores/cart-store';
import { GoogleLogin, googleLogout } from 'vue3-google-login';
const cartStore = useCartStore();

export default defineComponent({
  name: 'MainLayout',
  components: { GoogleLogin },
  data() {
    return {
      customLogin: process.env.CUSTOM_LOGIN_ENABLED === 'true',
      userLoggedIn: false,
      showPassword: false,
      menuDrawerOpen: false,
      cartDrawerOpen: false,
      accountDrawerOpen: false,
      internalRoutes: [
        {
          title: 'About',
          icon: 'home',
          link: '',
        },
        {
          title: 'Gallery',
          icon: 'image',
          link: 'gallery',
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
          title: 'Favorites',
          icon: 'favorite',
          link: 'favorites',
        },
        {
          title: 'Contacts',
          icon: 'contacts',
          link: 'contacts',
        },
        {
          title: 'Book a consultation',
          icon: 'event',
          link: 'book-a-consultation',
        },
      ],
      shoppingCart: cartStore.cartItems,
      username: '',
      password: '',
    };
  },
  methods: {
    toggleMenuDrawer() {
      this.menuDrawerOpen = !this.menuDrawerOpen;
    },
    toogleCartDrawer() {
      this.accountDrawerOpen = false;
      this.cartDrawerOpen = !this.cartDrawerOpen;
    },
    toogleAccountDrawer() {
      this.cartDrawerOpen = false;
      this.accountDrawerOpen = !this.accountDrawerOpen;
    },
    removeItemFromCart(item: CartItem) {
      cartStore.removeItemFromCart(item);
    },
    getCurrentRoute() {
      let route = this.internalRoutes
        .slice(1)
        .find((route) => this.$route.path.includes(`/${route.link}`));
      return route ? route : null;
    },
    callback(response: any) {
      //console.log("Response", response)
      console.log("Access token", response.access_token)
      //validateToken({accessToken: response.access_token})
    },
    userLogout(){
      this.userLoggedIn = false;
      googleLogout();
    },
    classicLogin() {
      // TODO: add standard login logic here
      console.log('Logging in with username:', this.username, 'and password:', this.password);
      // Example: You may use an authentication service to authenticate the user
    },
    loginWithGoogle() {
      // TODO: add Google login logic here
      console.log('Logging in with Google');
      // TODO: use OAuth2 authentication with Google APIs


    },
  },
  computed: {
    getCartTotal(): number {
      return this.shoppingCart.reduce(
        (acc, item) => acc + item.price * item.quantity,
        0
      );
    },
  },
});
</script>
