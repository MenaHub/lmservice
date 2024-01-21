import { defineStore } from 'pinia';
import { CartItem } from 'src/components/models';

export const useCartStore = defineStore('cart', {
  state: () => ({
    cartItems: [] as CartItem[],
  }),
  getters: {
    //doubleCount: (state) => state.counter * 2,
  },
  actions: {
    addItemToCart(item: CartItem) {
      const existingItem = this.cartItems.find((i) => i.id === item.id);
      if (existingItem) {
        existingItem.quantity++;
      } else {
        this.cartItems.push(item);
      }
    },
    removeItemFromCart(item: CartItem) {
      const index = this.cartItems.findIndex((i) => i.id === item.id);
      if (index > -1) {
        this.cartItems.splice(index, 1);
      }
    },
  },
});
