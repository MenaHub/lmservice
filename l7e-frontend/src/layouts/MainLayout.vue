<template>
  <q-layout class="gradient-background" view="hHh LpR fff" style="min-height: 100vh">
    <q-header class="gradient-background" style="min-height:fit-content">
      <q-toolbar class="flex-center q-pa-md" style="flex-wrap:wrap; gap:10px">
        <q-btn
          class="header-footer"
          v-for="route in internalRoutes"
          flat
          unelevated
          rounded
          no-caps
          :ripple="false"
          :label="route.title"
          :key="route.title"
          :to="`/${route.link}`"
        />
        <q-btn
          color="black"
          flat
          round
          size="md"
          icon="shopping_cart"
          aria-label="Shopping Cart"
          :to="'/shopping-cart'"
        >
          <q-badge
            v-if="shoppingCart.length > 0"
            color="red"
            rounded
            floating
            :label="shoppingCart.length"
          />
        </q-btn>
        <!-- <q-btn
          class="q-ml-sm"
          flat
          dense
          round
          icon="account_circle"
          aria-label="Account"
          @click="toogleAccountDrawer"
        /> -->
      </q-toolbar>
    </q-header>

    <!-- TODO: refactor into a drop down dialog -->
    <!-- <q-drawer
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
    </q-drawer> -->

    <q-page-container class="flex justify-center relative">
      <router-view class="q-pa-xl" style="max-width: 1280px; width: 90%"/>
        <q-btn
          class="favorite-btn"
          v-if="getFavoritesNumber() > 0"
          round
          push
          icon="favorite"
          :to="'/favorites'"
        >
          <q-badge
            color="red"
            rounded
            floating
            :label="getFavoritesNumber()"
          />
        </q-btn>
    </q-page-container>

    <q-footer class="bg-transparent">
      <q-toolbar>
        <q-toolbar-title class="row flex-center header-footer">
          L.M. Service - Copyright {{ new Date().getFullYear() }}
        </q-toolbar-title>
      </q-toolbar>
    </q-footer>
  </q-layout>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { useFavoritesStore } from 'src/stores/favorites-store';
import { useCartStore } from 'src/stores/cart-store';
const cartStore = useCartStore();
//import { GoogleLogin, googleLogout } from 'vue3-google-login';

const favoritesStore = useFavoritesStore();


export default defineComponent({
  name: 'MainLayout',
  //components: { GoogleLogin },
  data() {
    return {
      customLogin: process.env.CUSTOM_LOGIN_ENABLED === 'true',
      userLoggedIn: false,
      showPassword: false,
      cartDrawerOpen: false,
      accountDrawerOpen: false,
      shoppingCart: cartStore.cartItems,
      internalRoutes: [
        {
          title: 'Home',
          link: '',
        },
        {
          title: 'Gallery',
          link: 'gallery',
        },
        {
          title: 'Services',
          link: 'services',
        },
        {
          title: 'Shop',
          link: 'shop',
        },
        {
          title: 'Contacts',
          link: 'contacts',
        },
        // {
        //   title: 'Book a consultation',
        //   link: 'book-a-consultation',
        // },
      ],
      username: '',
      password: '',
    };
  },
  methods: {
    getFavoritesNumber() {
      return favoritesStore.favorites.length;
    },
    toogleCartDrawer() {
      this.accountDrawerOpen = false;
      this.cartDrawerOpen = !this.cartDrawerOpen;
    },
    // toogleAccountDrawer() {
    //   this.cartDrawerOpen = false;
    //   this.accountDrawerOpen = !this.accountDrawerOpen;
    // },
    getCurrentRoute() {
      let route = this.internalRoutes
        .slice(1)
        .find((route) => this.$route.path.includes(`/${route.link}`));
      return route ? route : null;
    },
    // callback(response: any) {
    //   //console.log("Response", response)
    //   console.log("Access token", response.access_token)
    //   //validateToken({accessToken: response.access_token})
    // },
    // userLogout(){
    //   this.userLoggedIn = false;
    //   googleLogout();
    // },
    // classicLogin() {
    //   // TODO: add standard login logic here
    //   console.log('Logging in with username:', this.username, 'and password:', this.password);
    //   // Example: You may use an authentication service to authenticate the user
    // },
    // loginWithGoogle() {
    //   // TODO: add Google login logic here
    //   console.log('Logging in with Google');
    //   // TODO: use OAuth2 authentication with Google APIs
    // },
  },
});
</script>
<style lang="scss">
.gradient-background {
  background: linear-gradient(to right, $primary, white);
}

.header-footer {
  font-size: medium; 
  font-weight: 300;
  color: black;
  min-width: fit-content;
}
.favorite-btn {
  position: fixed;
  bottom: 30px;
  right: 30px;
  z-index: 1000;
  max-width: 20px;
  max-height: 20px;
}
</style>