<template>
  <q-page class="q-gutter-md" :style-fn="minPageHeight">
    <p class="text-h4">Shop</p>
    <p class="text-italic text-grey-7" style="font-size: 1rem">
      Discover a world where every piece of furniture is a work of art,
      meticulously crafted to elevate your living spaces.
    </p>
    <item-list v-if="items.length > 0" :items="items" />
    <div v-else class="q-pt-xl">
      <div class="row flex-center">
        <q-icon name="warning" size="8rem" color="orange-3" />
      </div>
      <p class="text-h6 text-bold text-center">No item found</p>
    </div>
  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import ItemList from 'src/components/ItemList.vue';
import { minPageHeight } from 'src/utils/sharedFunctions';
import { ShopItemBean } from 'src/api/model'
import { getItems } from 'src/api/shop-controller'

export default defineComponent({
  components: { ItemList },
  name: 'ShopPage',
  data() {
    const items: ShopItemBean[] = [];

    return {
      items,
      //cardWidth: '200px',
    };
  },
  methods: {
    minPageHeight,
  },
  async created() {
    this.items = await getItems().catch((error) => {
      console.error('Error while getting shop items', error);
      return [];
    });
  },
});
</script>
<style lang="scss" scoped></style>
