<template>
  <q-page :style-fn="minPageHeight">
    <p class="text-h4">Favorites</p>
    <p class="text-italic text-grey-7" style="font-size: 1rem">
      Your liked items, all in one place.
    </p>
    <items-list-component v-if="items.length > 0" :items="items" />
    <div v-else>
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
import ItemsListComponent from 'src/components/ItemsListComponent.vue';
import { ShopItem } from 'src/components/models';
import { useFavoritesStore } from 'src/stores/favorites-store';
const favoritesStore = useFavoritesStore();

export default defineComponent({
  components: { ItemsListComponent },
  name: 'ShopPage',
  data() {
    return {
      items: favoritesStore.favorites as ShopItem[],
    };
  },
  methods: {
    minPageHeight,
  },
});
</script>
