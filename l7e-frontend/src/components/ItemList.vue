<template>
  <div class="row items-center justify-start">
    <div
      class="q-pa-sm flex flex-center"
      :class="[
        $q.screen.width > 1090
          ? 'col-4'
          : $q.screen.width > 760
          ? 'col-6'
          : 'col-12',
      ]"
      v-for="(item, index) in items"
      :key="index"
    >
      <q-card class="my-card rounded-borders">
        <q-card-section horizontal>
          <q-img class="col-5" src="src/assets/shop/example-img.jpg" />

          <q-card-section>
            <div class="row flex-center q-mb-md" style="gap: 5px">
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
                <div class="row items-center">
                  <div class="col-3">
                    <q-icon
                      name="circle"
                      color="red"
                      style="font-size: 1rem"
                    />
                  </div>
                  <div class="col" style="font-size: 0.75rem">
                    {{ item.material }}
                  </div>
                </div>
              </div>
            </div>
            <q-item-label class="text-bold"> {{ item.name }}</q-item-label>
            <q-item-label>{{ item.description }}</q-item-label>
            <q-item-label class="flex justify-end">
              <p class="q-mt-md">{{ '€ ' + item.price }}</p>
            </q-item-label>
          </q-card-section>
        </q-card-section>

        <q-separator />
        <q-card-actions class="flex justify-between">
          <div>
            <q-btn
              v-if="!isItemInFavorites(item)"
              flat
              round
              color="red"
              icon="favorite_border"
              @click="addToFavorites(item)"
            />
            <q-btn
              v-else
              flat
              round
              color="red"
              icon="favorite"
              @click="removeFromFavorites(item)"
            />
            <q-btn flat round color="blue" icon="share" />
          </div>
          <div>
            <q-btn flat rounded color="primary" @click="addToCart(item)">
              Add to cart
            </q-btn>
          </div>
        </q-card-actions>
      </q-card>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent, PropType } from 'vue';
import { CartItem } from 'src/components/models';
import { useCartStore } from 'src/stores/cart-store';
import { useFavoritesStore } from 'src/stores/favorites-store';
import { ShopItemBean } from 'src/api';
const cartStore = useCartStore();
const favoritesStore = useFavoritesStore();

export default defineComponent({
  name: 'ItemList',
  props: {
    items: {
      type: Array as PropType<ShopItemBean[]>,
      required: true,
      default: () => [] as ShopItemBean[],
    },
  },
  methods: {
    addToCart(item: ShopItemBean) {
      const { id, name, price } = item;
      // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
      const cartItem: CartItem = { id: id!, name: name!, price: price!, quantity: 1 };
      cartStore.addItemToCart(cartItem);
    },
    addToFavorites(item: ShopItemBean) {
      favoritesStore.addItemToFavorites(item);
    },
    removeFromFavorites(item: ShopItemBean) {
      favoritesStore.removeItemFromFavorites(item);
    },
    isItemInFavorites(item: ShopItemBean): boolean {
      return favoritesStore.isItemInFavorites(item);
    },
  },
  computed: {},
});
</script>

<style lang="scss" scoped>
.my-card {
  width: 100%;
  max-width: 350px;
}
</style>
