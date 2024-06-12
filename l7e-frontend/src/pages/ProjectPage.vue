<template>
  <q-page class="q-gutter-md">
    <q-carousel
      class="rounded-borders"
      swipeable
      arrows
      navigation
      animated
      infinite
      autoplay
      v-model="project.carouselIndex"
      height="600px"
    >
      <q-carousel-slide
        v-for="(photo, j) in project.photos"
        :key="j"
        :name="j"
        :img-src="photo"
      />
    </q-carousel>

    <p class="text-h3 q-mt-xl">{{ project.title.replace(/_/g, ' ') }}</p>
    <p class="text-italic text-grey-7" style="font-size: 1rem">
      {{ project.shortDescription}}
    </p>
    <div>
      <p class="text-subtitle1">Welcome to a world where craftsmanship meets design.</p>
      <p class="text-subtitle1">This fixed furniture project is a journey into the heart of artisanal creativity.</p>
      <p class="text-subtitle1">Each piece is a testament to meticulous detail, skill, and an unwavering commitment to quality.</p>
      <p class="text-subtitle1">Handcrafted from sustainable materials, each piece ensures longevity and contributes to a greener planet.</p>
      <p class="text-subtitle1">The design is a blend of functionality and aesthetics, with clean, modern lines that exude timeless elegance.</p>
      <p class="text-subtitle1">The artisan's expertise shines through in the custom solutions created for unique spaces.</p>
      <p class="text-subtitle1">Every piece is designed to fit perfectly, resulting in a harmonious interior that is as practical as it is beautiful.</p>
      <p class="text-subtitle1">But this project is more than just furniture.</p>
      <p class="text-subtitle1">It's about creating spaces that resonate with warmth and a sense of home.</p>
      <p class="text-subtitle1">It's about celebrating the beauty of handmade furniture and the passion that fuels the artisan's craft.</p>
      <p class="text-subtitle1">Welcome to a world where every detail matters.</p>
    </div>
    
  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { projectPhotos } from '../utils/projectPhotos';

export default defineComponent({
  name: 'ProjectPage',
  data() {
    return {
      project: {
        title: this.$route.params.project as string,
        shortDescription: 'Short and fancy description',
        description: 'Project description',
        carouselIndex: 0,
        photos: this.getProjectPhotos(),
      },
    };
  },
  methods: {
    getProjectPhotos() {
      let projectTitle = this.$route.params.project as keyof (typeof projectPhotos);
      return projectPhotos[projectTitle]();
    },
  },
});
</script>
