<template>
  <q-page class="q-pa-md">
    <div class="row q-mb-md flex-center">
      <div
        class="col-12 col-sm-6 col-md-4 q-pa-sm flex flex-center"
        v-for="(item, index) in items"
        :key="index"
      >
        <q-card class="my-card rounded-borders">
          <q-card-section horizontal>
            <q-img class="col-5" src="src/assets/shop/example-img.jpg" />

            <q-card-section>
              <div class="row items-center q-mb-md" style="gap: 5px">
                <div class="col-12 q-pa-xs text-center rounded-section">
                  <div class="row items-center">
                    <div class="col-3">
                      <q-icon name="circle" color="orange" size="xs" />
                    </div>
                    <div class="col">
                      {{ item.category }}
                    </div>
                  </div>
                </div>
                <div class="col-12 q-pa-xs text-center rounded-section">
                  {{ item.material }}
                </div>
              </div>
              <q-item-label>{{ item.description }}</q-item-label>
              <q-item-label class="flex justify-end">
                {{ '€ ' + item.price }}
              </q-item-label>
            </q-card-section>
          </q-card-section>

          <q-separator />
          <q-card-actions class="flex justify-between">
            <div>
              <q-btn flat round color="red" icon="favorite" />
              <q-btn flat round color="teal" icon="bookmark" />
              <q-btn flat round color="blue" icon="share" />
            </div>
            <div>
              <q-btn flat color="primary" @click="addToCart(item)">
                Add to cart
              </q-btn>
            </div>
          </q-card-actions>
        </q-card>
      </div>
    </div>
  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { ShopItem, CartItem } from 'src/components/models';
import { useCartStore } from 'src/stores/cart-store';
const cartStore = useCartStore();

export default defineComponent({
  name: 'ShopPage',
  data() {
    //TODO: to be replaced with a call to the backend
    const items: ShopItem[] = [];
    for (let i = 1; i <= 10; i++) {
      items.push({
        id: `${i}`,
        name: `Item ${i}`,
        category: `Category ${i}`,
        material: `Material ${i}`,
        description: `${i} Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
              eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
              enim ad minim veniam, quis nostrud exercitation ullamco laboris
              nisi ut aliquip ex ea commodo consequat.`,
        price: i * 10,
        image: 'src/assets/shop/example-img.jpg',
      });
    }

    return {
      items,
      cardWidth: '200px',
    };
  },
  methods: {
    addToCart(item: ShopItem) {
      const { id, name, price } = item;
      const cartItem: CartItem = { id, name, price, quantity: 1 };
      cartStore.addItemToCart(cartItem);
    },
  },
});
</script>
<style lang="scss" scoped>
.rounded-borders {
  border-radius: 10px;
  box-shadow: 8px 8px 8px rgba(0, 0, 0, 0.24);
}

.rounded-section {
  border-radius: 20px;
  box-shadow: 0px 0px 10px 5px rgba(0, 0, 0, 0.24);
}
.my-card {
  width: 100%;
  max-width: 350px;
}
</style>
