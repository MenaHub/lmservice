export interface Todo {
  id: number;
  content: string;
}

export interface Meta {
  totalCount: number;
}

export interface CartItem {
  id: number;
  name: string;
  price: number;
  quantity: number;
}

export interface ShopItem {
  name: string;
  category: string;
  description: string;
  price: string;
  image: string;
}
