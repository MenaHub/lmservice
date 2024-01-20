<template>
  <q-page class="q-pa-md">
    <div class="row q-mb-md items-center">
      <div
        class="col-12 col-sm-4 col-md-4 q-pa-sm flex flex-center"
        v-for="(item, index) in items"
        :key="index"
      >
        <q-card class="my-card">
          <q-card-section horizontal>
            <q-img class="col-5" src="src/assets/shop/example-img.jpg" />

            <q-card-section>
              <q-item-label>{{ item.category }}</q-item-label>
              <q-item-label>{{ item.description }}</q-item-label>
              <q-item-label>{{ item.price }}</q-item-label>
              Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
              eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
              enim ad minim veniam, quis nostrud exercitation ullamco laboris
              nisi ut aliquip ex ea commodo consequat.
            </q-card-section>
          </q-card-section>

          <q-separator />
          <q-card-actions>
            <q-btn flat round color="red" icon="favorite" />
            <q-btn flat round color="teal" icon="bookmark" />
            <q-btn flat round color="blue" icon="share" />
            <!-- add the item to the shop array in the store, on click -->
            <q-btn class="col items-end" flat color="primary">
              Add to cart
            </q-btn>
          </q-card-actions>
        </q-card>
      </div>
    </div>
  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { ShopItem } from 'src/components/models';

export default defineComponent({
  name: 'ShopPage',
  data() {
    const items: ShopItem[] = [
      {
        name: 'Item 1',
        category: 'Category 1',
        description: 'Description 1',
        price: '$19.99',
        image: 'path/to/image1.jpg',
      },
      {
        name: 'Item 2',
        category: 'Category 2',
        description: 'Description 2',
        price: '$29.99',
        image: 'path/to/image2.jpg',
      },
      {
        name: 'Item 1',
        category: 'Category 1',
        description: 'Description 1',
        price: '$19.99',
        image: 'path/to/image1.jpg',
      },
      {
        name: 'Item 2',
        category: 'Category 2',
        description: 'Description 2',
        price: '$29.99',
        image: 'path/to/image2.jpg',
      },
      {
        name: 'Item 1',
        category: 'Category 1',
        description: 'Description 1',
        price: '$19.99',
        image: 'path/to/image1.jpg',
      },
      {
        name: 'Item 2',
        category: 'Category 2',
        description: 'Description 2',
        price: '$29.99',
        image: 'path/to/image2.jpg',
      },
      {
        name: 'Item 1',
        category: 'Category 1',
        description: 'Description 1',
        price: '$19.99',
        image: 'path/to/image1.jpg',
      },
      {
        name: 'Item 2',
        category: 'Category 2',
        description: 'Description 2',
        price: '$29.99',
        image: 'path/to/image2.jpg',
      },
      {
        name: 'Item 2',
        category: 'Category 2',
        description: 'Description 2',
        price: '$29.99',
        image: 'path/to/image2.jpg',
      },
    ];

    return {
      items,
      cardWidth: '200px',
    };
  },
});
</script>
<style lang="scss" scoped>
.rounded-borders {
  border-radius: 10px;
  box-shadow: 8px 8px 8px rgba(0, 0, 0, 0.24);
}
.my-card {
  width: 100%;
  max-width: 350px;
}
</style>
