import { defineStore } from 'pinia';
import { ShopItemBean } from 'src/api';

export const useFavoritesStore = defineStore('favorites', {
  persist: true,
  state: () => ({
    favorites: [] as ShopItemBean[],
  }),
  getters: {
    isItemInFavorites: (state) => (item: ShopItemBean) => {
      return state.favorites.some((i) => i.id === item.id);
    },
  },
  actions: {
    addItemToFavorites(item: ShopItemBean) {
      const existingItem = this.favorites.find((i) => i.id === item.id);
      if (!existingItem) {
        this.favorites.push(item);
      }
    },
    removeItemFromFavorites(item: ShopItemBean) {
      const index = this.favorites.findIndex((i) => i.id === item.id);
      if (index > -1) {
        this.favorites.splice(index, 1);
      }
    },
  },
});
