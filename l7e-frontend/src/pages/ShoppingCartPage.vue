<template>
  <q-page class="q-gutter-md" :style-fn="minPageHeight">
    <p class="text-h4">Shopping cart</p>
    <p v-if="shoppingCart.length > 0" class="text-italic text-grey-7" style="font-size: 1rem">
      All the items you need to let your place shine, in one place, ready to be shipped.
    </p>
    <p v-else class="text-italic" style="font-size: 1rem">
      It looks like your shopping cart is empty. Add items to it by clicking the "Add to cart" button on the items you like.
    </p>
    <div 
      v-if="shoppingCart.length > 0"
      class="row q-gutter-md"
    >
      <div class="col-9">
        <q-card v-for="item in shoppingCart" :key="item.id" class="rounded-borders q-mb-md">
          <q-card-section horizontal>
            <q-img class="col-5" src="src/assets/shop/example-img.jpg" />

            <q-card-section>
              <!--<div class="row flex-center q-mb-md" style="gap: 5px">
                <div class="col-10 q-pa-xs text-center rounded-borders">
                  <div class="row items-center">
                    <div class="col-3">
                      <q-icon
                        name="circle"
                        color="orange"
                        style="font-size: 1rem"
                      />
                    </div>
                    <div class="col" style="font-size: 0.75rem">
                      {{ item.category }}
                    </div> 
                  </div>
                </div>
                <div class="col-10 q-pa-xs text-center rounded-borders">
                  <p style="font-size: 0.75rem">{{ item.material }}</p>
                </div> 
              </div>-->
              <q-item-label class="text-bold"> {{ item.name }}</q-item-label>
              <!-- <q-item-label>{{ item.description }}</q-item-label> -->
              <q-item-label class="flex justify-end">
                <p class="q-mt-md">{{ '€ ' + item.price }}</p>
              </q-item-label>
            </q-card-section>
          </q-card-section>

          <q-separator />
          <q-card-actions class="flex items-center justify-between">     
            <q-btn flat round color="blue" icon="share" />
            <div class="q-gutter-x-sm">
              <q-icon
                v-if="item.quantity > 1"
                class="cursor-pointer q-mr-sm"
                name="remove"
                @click="item.quantity--"
              />
              {{ item.quantity }}
              <q-icon
                  class="cursor-pointer"
                  name="add"
                  @click="item.quantity++"
                />
              <q-btn
                flat
                round
                color="red-12"
                icon="delete"
                aria-label="Delete"
                @click="removeItemFromCart(item)"
              />
            </div>
          </q-card-actions>
        </q-card>
      </div>
      <q-card class="col text-center q-gutter-y-md rounded-borders" style="height: fit-content;">
        <q-card-section>
          <p class="text-h6">Total ({{ cartTotalItems + (cartTotalItems == 1 ? ' item' : ' items') }}): </p>
          <p class="text-h6">{{ '€ ' + cartTotalPrice }} </p>
        </q-card-section>
        <q-card-section>
          <q-btn
            color="primary"
            label="Proceed to checkout"
            rounded
            to='/checkout'
          />
        </q-card-section>
      </q-card>
    </div>
  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { minPageHeight } from 'src/utils/sharedFunctions';
import { CartItem } from 'src/components/models';
import { useCartStore } from 'src/stores/cart-store';
const cartStore = useCartStore();

export default defineComponent({
  name: 'ShoppingCartPage',
  data() { 
    return {
      shoppingCart: cartStore.cartItems,
    };
  },
  methods: {
    minPageHeight,
    removeItemFromCart(item: CartItem) {
      cartStore.removeItemFromCart(item);
    },
  },
  computed: {
    cartTotalPrice() {
      return cartStore.getCartTotal;
    },
    cartTotalItems() {
      return cartStore.getCartQuantity;
    },
  },
});
</script>
