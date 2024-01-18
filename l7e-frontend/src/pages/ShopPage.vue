<template>
  <q-page class="q-pa-md">
    <div class="row q-mb-md">
      <div class="col-4 q-pa-sm" v-for="(item, index) in items" :key="index">
        <q-card>
          <!-- Display item information here -->
          <q-card-section>
            <q-img :src="item.image" />
          </q-card-section>
          <q-card-section>
            <q-item-label header>{{ item.name }}</q-item-label>
            <q-item-label>{{ item.category }}</q-item-label>
            <q-item-label>{{ item.description }}</q-item-label>
            <q-item-label>{{ item.price }}</q-item-label>
          </q-card-section>
        </q-card>
      </div>
    </div>
  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

// Define TypeScript interface for item
interface ShopItem {
  name: string;
  category: string;
  description: string;
  price: string;
  image: string;
}

export default defineComponent({
  name: 'ShopPage',
  data() {
    // Sample data, replace with your actual data
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
      // Add more items as needed
    ];

    return {
      items,
      cardWidth: '200px', // Adjust as needed
    };
  },
});
</script>
