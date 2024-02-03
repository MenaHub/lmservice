<template>
  <q-page class="row q-pa-xl" style="row-gap: 5rem">
    <div :class="$q.screen.gt.sm ? 'col-6' : 'col-12'">
      <p class="text-h3">About L.M Service</p>
      <p class="text-h5">
        Welcome to Our World of Craftsmanship and Creativity
      </p>
      <p class="text-body1">
        At L.M Service, we don't just create furniture; we embark on a journey
        of storytelling through wood and design. Our passion for crafting
        bespoke pieces is more than a profession; it's a lifelong dedication to
        transforming spaces into timeless expressions of individuality.
      </p>
      <p class="text-h5">The Artisan's Tale</p>
      <p class="text-body1">
        Behind each masterpiece stands a master artisan with a story to tell.
        Meet Luigino, the creative force behind the craftsmanship that defines
        us. From the first stroke of the design sketch to the final touch of a
        hand-finished surface, Luigino infuses every creation with a deep-rooted
        passion for woodworking and an unwavering commitment to excellence.
      </p>
      <p class="text-h5">Where Art Meets Craft</p>
      <p class="text-body1">
        Our workshop is not just a space; it's a sanctuary where creativity
        intertwines with the natural beauty of hand-selected materials. Here,
        traditional craftsmanship dances harmoniously with contemporary design,
        giving birth to furniture that transcends trends and stands as a
        testament to the enduring allure of bespoke creations.
      </p>
      <p class="text-h5">The Philosophy</p>
      <p class="text-body1">
        Our philosophy is simple yet profound - each piece of furniture should
        tell a story and evoke emotions. We believe in the power of custom
        craftsmanship to elevate living spaces and create a canvas for personal
        narratives. Every knot, every grain tells a tale, and Luigino has
        mastered the art of storytelling through every piece that leaves our
        workshop.
      </p>
      <p class="text-h5">Beyond Wood and Nails</p>
      <p class="text-body1">
        At L.M. Service, we are not merely furniture makers; we are
        storytellers, weaving narratives into every joint and curve. Our
        creations are not just functional; they are pieces of art that
        seamlessly blend form and function. Immerse yourself in a world where
        the ordinary transforms into extraordinary, and where your unique vision
        comes to life.
      </p>
      <p class="text-h5">Collaborate, Create, Captivate</p>
      <p class="text-body1">
        Join us on this journey of collaboration and creation. Whether you're
        envisioning a statement piece for your home or seeking to redefine a
        space, L.M. Service is here to bring your ideas to life. Let's embark on
        a creative exploration, where every project is an opportunity to create
        something extraordinary. <br />
        <br />
      </p>
      <p class="text-h5">
        Thank you for being a part of our story. <br />
        Luigino Menarbin - Founder & Master Artisan, L.M. Service
      </p>
    </div>
    <div class="q-px-xl" :class="$q.screen.gt.sm ? 'col-6' : 'col-12'">
      <q-card class="my-card" flat bordered>
        <q-img src="src/assets/shop/1-grossa.jpg" />

        <q-card-section>
          <q-btn
            fab
            color="primary"
            icon="place"
            class="absolute"
            style="top: 0; right: 12px; transform: translateY(-50%)"
            @click="redirectToMaps"
          />

          <div class="row no-wrap items-center">
            <div class="col text-h6">L.M. Service</div>
            <div
              class="col-auto text-grey text-caption q-pt-md row no-wrap items-center"
            >
              <q-icon name="place" />
              <!-- implement distance only if location is allowed by the user -->
              250 ft
            </div>
          </div>

          <q-rating v-model="stars" :max="5" size="32px" />
        </q-card-section>

        <q-card-section class="q-pt-none">
          <div class="text-subtitle1">$・Artisan</div>
          <div class="text-caption text-grey">
            <!--             Custom tailored furniture transforming your spaces into timeless
            expressions of individuality. -->
            Tailored forniture and woodwork for every design need.
          </div>
        </q-card-section>

        <q-separator />

        <q-card-actions>
          <q-btn flat round icon="event" />
          <q-btn flat color="primary"> Book a consultation </q-btn>
        </q-card-actions>
      </q-card>
    </div>
  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'AboutPage',
  components: {},
  data() {
    return {
      stars: 4,
    };
  },
  methods: {
    redirectToMaps() {
      const mapsUrl =
        'https://www.google.com/maps/place/Via+Vignone,+14,+20822+Seveso+MB/@45.6401212,9.1753578,19z/data=!3m1!4b1!4m14!1m7!3m6!1s0x4786bda353ec759f:0xd375cd45ebc9c302!2sProserpio+Gabriele!8m2!3d45.6400646!4d9.1758954!16s%2Fg%2F1tj7zvlq!3m5!1s0x4786bda35422648f:0x64ee301d3f6a79be!8m2!3d45.6401212!4d9.1760015!16s%2Fg%2F11c26zbw2c?entry=ttu';
      window.open(mapsUrl, '_blank');
    },
  },
});
</script>
