export interface CartItem {
  id: string;
  name: string;
  price: number;
  quantity: number;
}

export interface ShopItem {
  id: string;
  name: string;
  category: string;
  description: string;
  price: number;
  image: string;
}
