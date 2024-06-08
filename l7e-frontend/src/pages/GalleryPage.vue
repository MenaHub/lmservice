<template>
  <q-page class="q-pa-md">
    <div class="q-gutter-md">
      <p class="text-h4">Gallery</p>
      <p class="text-italic text-grey-7" style="font-size: 1rem">
        A glimpse of our creations
      </p>
      <q-card
        class="q-mb-xl"
        v-for="(project, i) in projects"
        :key="i"
        :name="project.title"
      >
        <q-carousel
          swipeable
          arrows
          navigation
          animated
          infinite
          v-model="carouselIndexes[i].currentIndex"
        >
          <q-carousel-slide
            v-for="(photo, j) in project.photos"
            :key="j"
            :name="j"
            :img-src="photo"
          >
            <div class="absolute-top custom-caption" style="cursor: pointer">
              <div class="text-h2">{{ project.title }}</div>
              <div class="text-subtitle1">{{ project.description }}</div>
            </div>
          </q-carousel-slide>
        </q-carousel>
      </q-card>
    </div>
  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'GalleryPage',
  data() {
    return {
      projects: [
        {
          routeTitle: 'BB_Bistro',
          title: 'BB Bistrò',
          description: 'BB Bistrò description',
          photos: this.getBBPhotos(),
        },
        {
          routeTitle: 'Brazilian_Taste',
          title: 'Brazilian Taste',
          description: 'Brazilian Taste description',
          photos: this.getBrazilianTastePhotos(),
        },
        {
          routeTitle: 'Caos_Calmo',
          title: 'Caos Calmo',
          description: 'Caos Calmo description',
          photos: this.getCaosCalmoPhotos(),
        },
        {
          routeTitle: 'Green_Nest',
          title: 'Green Nest',
          description: 'Green Nest description',
          photos: this.getGreenNestPhotos(),
        },
        {
          routeTitle: 'Hygge',
          title: 'Hygge',
          description: 'Hygge description',
          photos: this.getHyggePhotos(),
        },
        {
          routeTitle: 'MedicalOfficeHeadquarters',
          title: 'Medical Office Headquarters',
          description: 'Medical Office Headquarters description',
          photos: this.getMedicalOfficeHQPhotos(),
        },
        {
          routeTitle: 'Out_of_the_blue',
          title: 'Out of the blue',
          description: 'Out of the blue description',
          photos: this.getOutOfTheBluePhotos(),
        },
        {
          routeTitle: 'Sought_After',
          title: 'Sought After',
          description: 'Sought After description',
          photos: this.getSoughtAfterPhotos(),
        },
      ],
      carouselIndexes: [] as { currentIndex: number }[],
    };
  },
  created() {
    this.carouselIndexes = this.projects.map(() => ({ currentIndex: 0 }));
  },
  methods: {
    getBBPhotos(){
      const glob = import.meta.globEager('src/assets/aim/BB_Bistro/*.jpg');
      return Object.values(glob).map((photo) => photo.default);
    },
    getBrazilianTastePhotos(){
      const glob = import.meta.globEager('src/assets/aim/Brazilian_Taste/*.jpg');
      return Object.values(glob).map((photo) => photo.default);
    },
    getCaosCalmoPhotos(){
      const glob = import.meta.globEager('src/assets/aim/Caos Calmo/Photos/*/*.jpg');
      return Object.values(glob).map((photo) => photo.default);
    },
    getGreenNestPhotos(){
      const glob = import.meta.globEager('src/assets/aim/Green_Nest/*.jpg');
      return Object.values(glob).map((photo) => photo.default);
    },
    getHyggePhotos(){
      const glob = import.meta.globEager('src/assets/aim/Hygge/Photos/*/*.jpg');
      return Object.values(glob).map((photo) => photo.default);
    },
    getMedicalOfficeHQPhotos(){
      const glob = import.meta.globEager('src/assets/aim/MedicalOfficeHeadquarters/Photos/*/*.jpg');
      return Object.values(glob).map((photo) => photo.default);
    },
    getOutOfTheBluePhotos(){
      const glob = import.meta.globEager('src/assets/aim/Out of the blue/Photos/*.jpg');
      return Object.values(glob).map((photo) => photo.default);
    },
    getSoughtAfterPhotos(){
      const glob = import.meta.globEager('src/assets/aim/Sought_After/*.jpg');
      return Object.values(glob).map((photo) => photo.default);
    },
  }
});
</script>

<style scoped>
.custom-caption {
  text-align: center;
  padding: 12px;
  color: white;
  background-color: rgba(0, 0, 0, 0.3);
}
</style>
