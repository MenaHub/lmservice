<template>
  <q-page class="q-pa-md">
    <div class="q-gutter-md">
      <p class="text-h4">Gallery</p>
      <p class="text-italic text-grey-7" style="font-size: 1rem">
        A glimpse of our creations
      </p>
      <q-card
        class="my-card"
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
          description: 'BB Bistrò desription',
          photos: [
            'src/assets/aim/BB Bistrò/photo1.jpg',
            'src/assets/aim/BB Bistrò/photo2.jpg',
            'src/assets/aim/BB Bistrò/photo3.jpg',
            'src/assets/aim/BB Bistrò/photo4.jpg',
            'src/assets/aim/BB Bistrò/photo5.jpg',
            'src/assets/aim/BB Bistrò/photo6.jpg',
            'src/assets/aim/BB Bistrò/photo7.jpg',
          ],
        },
        {
          routeTitle: 'Brazilian_Taste',
          title: 'Brazilian Taste',
          description: 'Brazilian Taste descprition',
          photos: [
            'src/assets/aim/Brazilian Taste/photo1.jpg',
            'src/assets/aim/Brazilian Taste/photo2.jpg',
            'src/assets/aim/Brazilian Taste/photo3.jpg',
            'src/assets/aim/Brazilian Taste/photo4.jpg',
            'src/assets/aim/Brazilian Taste/photo5.jpg',
            'src/assets/aim/Brazilian Taste/photo6.jpg',
            'src/assets/aim/Brazilian Taste/photo7.jpg',
            'src/assets/aim/Brazilian Taste/photo8.jpg',
            'src/assets/aim/Brazilian Taste/photo9.jpg',
            'src/assets/aim/Brazilian Taste/photo10.jpg',
            'src/assets/aim/Brazilian Taste/photo11.jpg',
            'src/assets/aim/Brazilian Taste/photo12.jpg',
            'src/assets/aim/Brazilian Taste/photo13.jpg',
            'src/assets/aim/Brazilian Taste/photo14.jpg',
            'src/assets/aim/Brazilian Taste/photo15.jpg',
            'src/assets/aim/Brazilian Taste/photo16.jpg',
          ],
        },
        // Add more projects here
      ],
      carouselIndexes: [] as { currentIndex: number }[],
    };
  },
  created() {
    this.carouselIndexes = this.projects.map(() => ({ currentIndex: 0 }));
  },
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
