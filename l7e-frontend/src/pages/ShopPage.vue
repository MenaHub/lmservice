<template>
  <q-page :style-fn="minPageHeight">
    <p class="text-h4">Shop</p>
    <p class="text-italic text-grey-7" style="font-size: 1rem">
      Discover a world where every piece of furniture is a work of art,
      meticulously crafted to elevate your living spaces.
    </p>
    <items-list-component v-if="items.length > 0" :items="items" />
    <div v-else>
      <div class="row flex-center">
        <q-icon name="warning" size="8rem" color="orange-3" />
      </div>
      <p class="text-h6 text-bold text-center">No item found</p>
    </div>
  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import ItemsListComponent from 'src/components/ItemsListComponent.vue';
import { ShopItem } from 'src/components/models';
import { minPageHeight } from 'src/utils/sharedFunctions';

export default defineComponent({
  components: { ItemsListComponent },
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
      //cardWidth: '200px',
    };
  },
  methods: {
    minPageHeight,
  },
});
</script>
<style lang="scss" scoped></style>
