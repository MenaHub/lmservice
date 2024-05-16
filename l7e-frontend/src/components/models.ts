export interface CartItem {
  id: number;
  name: string;
  price: number;
  quantity: number;
}

export interface ShopItem {
  id: string;
  name: string;
  category: string;
  material: string;
  description: string;
  price: number;
  imagePath: string;
}

export interface ClientRequest {
  fullName: string;
  email: string;
  enquirySubject: string;
  enquiryBody: string;
  accept: boolean;
}
