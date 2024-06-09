<template>
    <q-page class="q-gutter-md">
        <p class="text-h4">Checkout</p>
        <p class="text-italic text-grey-7" style="font-size: 1rem">
            One step away from enjoying your new items
        </p>
        <q-card class="checkout-card rounded-borders">
            <q-card-section>
                <h2 class="text-h6">User Info</h2>
                <div class="row" style="gap: 20px">
                    <div class="col">
                        <q-input label="First name" v-model="userInfo.firstName" />
                    </div>
                    <div class="col">
                        <q-input label="Last name" v-model="userInfo.lastName" />
                    </div>
                </div>
                <div class="row" style="gap: 20px">
                    <div class="col">
                        <q-input label="Email" v-model="userInfo.email" />
                    </div>
                    <div class="col">
                        <q-input label="Phone" v-model="userInfo.phone" />
                    </div>
                </div>                
            </q-card-section>

            <q-card-section>
                <h2 class="text-h6">Shipping Details</h2>
                <!-- Shipping details form fields -->
                <q-input label="Address" v-model="shippingDetails.address" />
                <q-input label="City" v-model="shippingDetails.city" />
                <!-- Add more shipping details fields as needed -->
            </q-card-section>

            <q-card-section>
                <h2 class="text-h6">Payment Details</h2>
                <!-- Payment details form fields -->
                <q-input label="Card Number" v-model="paymentDetails.cardNumber" />
                <q-input label="Expiration Date" v-model="paymentDetails.expirationDate" />
                <!-- Add more payment details fields as needed -->
            </q-card-section>

            <q-card-actions align="right">
                <q-btn rounded label="Place Order" color="primary" @click="placeOrder" />
            </q-card-actions>
        </q-card>
    </q-page>
</template>

<script>
export default {
    data() {
        return {
            userInfo: {
                firstName: '',
                lastName: '',
                email: '',
                phone: '',
            },
            shippingDetails: {
                address: '',
                city: '',
            },
            paymentDetails: {
                cardNumber: '',
                expirationDate: '',
            },
        };
    },
    methods: {
        placeOrder() {
            // Handle placing the order logic here
        },
    },
};
</script>

<style scoped>
.checkout-card {
    max-width: 1320px;
    padding: 20px;
}
</style>