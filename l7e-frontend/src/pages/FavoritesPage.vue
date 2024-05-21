<template>
  <q-page :style-fn="minPageHeight">
    <p class="text-h4">Favorites</p>
    <p class="text-italic text-grey-7" style="font-size: 1rem">
      Your liked items, all in one place.
    </p>
    <item-list v-if="items.length > 0" :items="items" />
    <div v-else class="q-pt-xl">
      <div class="row flex-center">
        <q-icon name="heart_broken" size="8rem" color="red" />
      </div>
      <p class="text-h6 text-bold text-center">No favorite added</p>
    </div>
  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { minPageHeight } from 'src/utils/sharedFunctions';
import ItemList from 'src/components/ItemList.vue';
import { ShopItemBean } from 'src/api';
import { useFavoritesStore } from 'src/stores/favorites-store';
const favoritesStore = useFavoritesStore();

export default defineComponent({
  components: { ItemList },
  name: 'ShopPage',
  data() {
    return {
      items: favoritesStore.favorites as ShopItemBean[],
    };
  },
  methods: {
    minPageHeight,
  },
});
</script>
