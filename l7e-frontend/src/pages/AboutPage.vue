<template>
  <q-page>
    <div class="q-mb-lg">
      <p class="text-h3">Welcome to L.M. Service</p>
    </div>
    <div class="row" style="column-gap: 4rem">
      <div :class="$q.screen.gt.sm ? 'col-6' : 'col-12'">
        <div :class="$q.screen.gt.sm ? 'q-mb-none' : 'q-mb-xl'">
          <p class="text-h5 text-italic text-grey-7 q-mb-md">
            Welcome to Our World of Craftsmanship and Creativity
          </p>
          <p class="text-body1">
            At L.M Service, we don't just create furniture; we embark on a
            journey of storytelling through wood and design. Our passion for
            crafting bespoke pieces is more than a profession; it's a lifelong
            dedication to transforming spaces into timeless expressions of
            individuality.
          </p>
          <p class="text-h5 q-mt-lg">The Artisan's Tale</p>
          <p class="text-body1">
            Behind each masterpiece stands a master artisan with a story to
            tell. Meet Luigino, the creative force behind the craftsmanship that
            defines us. From the first stroke of the design sketch to the final
            touch of a hand-finished surface, Luigino infuses every creation
            with a deep-rooted passion for woodworking and an unwavering
            commitment to excellence.
          </p>
          <p class="text-h5 q-mt-lg">The Philosophy</p>
          <p class="text-body1">
            Our philosophy is simple yet profound - each piece of furniture
            should tell a story and evoke emotions. We believe in the power of
            custom craftsmanship to elevate living spaces and create a canvas
            for personal narratives. Every knot, every grain tells a tale, and
            Luigino has mastered the art of storytelling through every piece
            that leaves our workshop.
          </p>
          <p class="text-h5 q-mt-lg">Beyond Wood and Nails</p>
          <p class="text-body1">
            At L.M. Service, we are not merely furniture makers; we are
            storytellers, weaving narratives into every joint and curve. Our
            creations are not just functional; they are pieces of art that
            seamlessly blend form and function. Immerse yourself in a world
            where the ordinary transforms into extraordinary, and where your
            unique vision comes to life.
          </p>
          <p class="text-h5 q-mt-lg">Collaborate, Create, Captivate</p>
          <p class="text-body1">
            Join us on this journey of collaboration and creation. Whether
            you're envisioning a statement piece for your home or seeking to
            redefine a space, L.M. Service is here to bring your ideas to life.
            Let's embark on a creative exploration, where every project is an
            opportunity to create something extraordinary. <br />
            <br />
          </p>
          <p class="text-h5">
            Thank you for being a part of our story. <br />
            Luigino Menarbin - Founder & Master Artisan, L.M. Service
          </p>
        </div>
      </div>
      <div :class="$q.screen.gt.sm ? 'col-5' : 'col-12'">
        <p class="text-h5 text-italic text-grey-7 q-mb-md">
          Where Imagination Meets Craftsmanship
        </p>
        <p class="text-body1">
          Discover a world where every piece of furniture is a work of art,
          meticulously crafted to reflect your individual style and elevate your
          living spaces. At L.M. Service, we don't just create furniture; we
          bring your vision to life. Our passion for precision and dedication to
          quality define every piece we make. Why settle for ordinary when you
          can have extraordinary? Immerse yourself in a bespoke experience where
          each custom creation tells a story – your story. From concept to
          completion, we collaborate closely with you, ensuring that every
          detail is a reflection of your taste and lifestyle. <br />
        </p>
        <p class="text-h5 q-mt-lg">What sets us apart</p>
        <p class="text-body1">
          - Unrivaled Craftsmanship: Our artisans are masters of their trade,
          blending traditional techniques with modern precision.<br />
          - Customization without Compromise: Tailor every aspect of your
          furniture, from materials and finishes to dimensions and design
          details. <br />
          - Timeless Elegance: Our pieces aren't just furniture; they are
          timeless statements of sophistication and individuality. <br />
          - Sustainable Luxury: Embrace eco-conscious living with our commitment
          to using responsibly sourced materials. <br />
        </p>
        <p class="text-h5 text-italic text-grey-7 q-my-lg">
          Transform your living spaces into a canvas of personal expression.
          Explore our portfolio, and let's embark on a journey to create
          something extraordinary together. Because your home deserves nothing
          less than exceptional craftsmanship
        </p>
      </div>
    </div>
  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'AboutPage',
  components: {},
  data() {
    return {};
  },
});
</script>
