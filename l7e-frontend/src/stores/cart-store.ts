import { defineStore } from 'pinia';
import { CartItem } from 'src/components/models';

export const useCartStore = defineStore('cart', {
  persist: true,
  state: () => ({
    cartItems: [] as CartItem[],
  }),
  getters: {
    getCartTotal: (state) => {
      return state.cartItems.reduce((acc, i) => acc + i.price * i.quantity, 0);
    },
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
