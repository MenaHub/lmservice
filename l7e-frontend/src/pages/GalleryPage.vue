<template>
  <q-page class="q-pa-md q-gutter-md">
    <p class="text-h4">Gallery</p>
    <p class="text-italic text-grey-7" style="font-size: 1rem">
      A glimpse of our creations
    </p>
    <q-card
      class="q-mb-xl rounded-borders"
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
          <div 
            class="absolute-top custom-caption cursor-pointer" 
            @click.capture="$router.push(`/gallery/${project.routeTitle}`)"
          >
            <div class="text-h2">{{ project.title }}</div>
            <div class="text-subtitle1">
              <q-icon name="place" /> {{ project.location }}
            </div>
          </div>
        </q-carousel-slide>
      </q-carousel>
    </q-card>
  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { projectPhotos } from '../utils/projectPhotos';

export default defineComponent({
  name: 'GalleryPage',
  data() {
    return {
      projects: [
        {
          routeTitle: 'BB_Bistro',
          title: 'BB Bistrò',
          location: 'Milan, Italy',
          photos: projectPhotos['BB_Bistro'](),
        },
        {
          routeTitle: 'Brazilian_Taste',
          title: 'Brazilian Taste',
          location: 'Rome, Italy',
          photos: projectPhotos['Brazilian_Taste'](), 
        },
        {
          routeTitle: 'Caos_Calmo',
          title: 'Caos Calmo',
          location: 'Madrid, Spain',
          photos: projectPhotos['Caos_Calmo'](),
        },
        {
          routeTitle: 'Green_Nest',
          title: 'Green Nest',
          location: 'Seregno, Italy',
          photos: projectPhotos['Green_Nest'](),
        },
        {
          routeTitle: 'Hygge',
          title: 'Hygge',
          location: 'London, UK',
          photos: projectPhotos['Hygge'](),
        },
        {
          routeTitle: 'Medical_Office_Headquarters',
          title: 'Medical Office Headquarters',
          location: 'Monza, Italy',
          photos: projectPhotos['Medical_Office_Headquarters'](),
        },
        {
          routeTitle: 'Out_Of_The_Blue',
          title: 'Out of the blue',
          location: 'Florence, Italy',
          photos: projectPhotos['Out_Of_The_Blue'](),
        },
        {
          routeTitle: 'Sought_After',
          title: 'Sought After',
          location: 'Milan, Italy',
          photos: projectPhotos['Sought_After'](),
        },
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
../utils/projectPhotos