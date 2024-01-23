import { defineStore } from 'pinia';
import { ShopItem } from 'src/components/models';

export const useFavoritesStore = defineStore('favorites', {
  persist: true,
  state: () => ({
    favorites: [] as ShopItem[],
  }),
  getters: {
    isItemInFavorites: (state) => (item: ShopItem) => {
      return state.favorites.some((i) => i.id === item.id);
    },
  },
  actions: {
    addItemToFavorites(item: ShopItem) {
      const existingItem = this.favorites.find((i) => i.id === item.id);
      if (!existingItem) {
        this.favorites.push(item);
      }
    },
    removeItemFromFavorites(item: ShopItem) {
      const index = this.favorites.findIndex((i) => i.id === item.id);
      if (index > -1) {
        this.favorites.splice(index, 1);
      }
    },
  },
});
