<template>
  <q-page class="q-gutter-md">
    <p class="text-h4">Services</p>
    <p class="text-italic text-grey-7" style="font-size: 1rem">
      Elevating spaces with diverse services tailored to your needs
    </p>
    <div v-for="(service, index) in services" :key="index">
      <q-card class="my-card" flat rounded bordered style="min-width: 100%">
        <q-card-section
          class="row justify-between items-center"
          :class="index % 2 == 1 && $q.screen.gt.sm ? 'reverse' : ''"
          :horizontal="$q.screen.gt.sm"
        >
          <q-card-section
            :class="$q.screen.gt.sm ? 'col q-mb-none' : 'col-12 q-mb-xl'"
          >
            <p class="text-h5 text-italic text-grey-7 q-mb-md">
              {{ service.title }}
            </p>
            <p class="text-body1">
              {{ service.description }}
            </p>
            <div
              v-if="service.title === 'Artisanal Stock Furniture'"
              class="flex justify-end q-mt-md"
            >
              <q-btn color="primary" label="Go to shop" to="/shop" />
            </div>
          </q-card-section>

          <q-img
            :class="$q.screen.gt.sm ? 'col-5' : 'col-12'"
            :src="service.image"
          />
        </q-card-section>
      </q-card>
    </div>
  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'ServicesPage',
  components: {},
  data() {
    return {
      services: [
        {
          title: 'Custom Furniture',
          description: `Crafted creations for every space: tailored furniture and woodwork designed to perfection, 
          from initial concept to the final masterpiece.`,
          image: 'src/assets/shop/1-grossa.jpg',
        },
        {
          title: 'Artisanal Stock Furniture',
          description: `Homemade masterpieces for timeless appeal: impeccably detailed furniture, painstakingly 
          created to infuse your living spaces with unparalleled charm and individuality.`,
          image: 'src/assets/shop/1-grossa.jpg',
        },
        {
          title: 'Moving Services',
          description: `Seamless transitions, stress-free moves: whether you're refreshing your space or 
          relocating, let us alleviate the burden with our comprehensive moving services, ensuring a smooth 
          transition every step of the way.`,
          image: 'src/assets/shop/1-grossa.jpg',
        },
      ],
    };
  },
});
</script>

<style scoped>
.my-card {
  max-width: 600px;
  width: 100%;
}
</style>
