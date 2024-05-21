export interface CartItem {
  id: number;
  name: string;
  price: number;
  quantity: number;
}

export interface ClientRequest {
  fullName: string;
  email: string;
  enquirySubject: string;
  enquiryBody: string;
  accept: boolean;
}
