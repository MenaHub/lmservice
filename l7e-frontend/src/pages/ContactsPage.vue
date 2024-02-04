<template>
  <q-page class="row flex-center" style="column-gap: 4rem">
    <div
      class="q-pa-md"
      :class="$q.screen.gt.sm ? 'col-6 q-mb-none' : 'col-12 q-mb-xl'"
      style="max-width: 400px"
    >
      <p class="text-h3">Contact us</p>
      <p class="text-italic text-grey-7 q-mb-xl" style="font-size: 1rem">
        We are here to help you
      </p>
      <q-form
        v-model="validForm"
        @submit="onSubmit"
        @reset="onReset"
        @validation-error="onError"
        class="q-gutter-md"
      >
        <q-input
          filled
          required
          v-model="fullName"
          hint="Name and surname"
          lazy-rules
          :rules="[
            (val) =>
              (val && val.length > 0) || 'Please insert your name and surname',
          ]"
        />

        <q-input
          filled
          required
          v-model="email"
          hint="Your email"
          lazy-rules
          :rules="[
            (val) => (val !== null && val !== '') || 'Please type your email',
            (val) =>
              (val && emailRegex.test(val)) || 'Please type a valid email',
          ]"
        />

        <q-input
          filled
          required
          v-model="enquirySubject"
          hint="Your enquiry subject"
          lazy-rules
          :rules="[
            (val) =>
              (val && val.length > 5) ||
              'Please be more specific about your enquiry',
          ]"
        />

        <q-input
          filled
          required
          v-model="enquiryBody"
          hint="Your request/suggestion"
          lazy-rules
          :rules="[
            (val) =>
              (val && val.length > 10) ||
              'Please be more specific about your request/suggestion',
          ]"
        />

        <q-toggle
          required
          v-model="accept"
          label="I accept the license and terms"
        />

        <div>
          <q-btn
            label="Submit"
            type="submit"
            color="primary"
            :disabled="true"
          />
          <!-- :disabled="!validForm" -->
          <q-btn
            label="Reset"
            type="reset"
            color="primary"
            flat
            class="q-ml-sm"
          />
        </div>
      </q-form>
    </div>

    <div :class="$q.screen.gt.sm ? 'col' : 'col-12'">
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

        <q-card-actions
          :class="
            $q.screen.gt.sm
              ? 'flex items-center justify-start'
              : 'flex flex-center'
          "
        >
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
  name: 'ContactsPage',
  components: {},
  data() {
    return {
      fullName: '',
      email: '',
      enquirySubject: '',
      enquiryBody: '',
      accept: false,
      stars: 4,
      validForm: false,
      emailRegex: /^[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\.[A-Z]{2,}$/i,
    };
  },
  methods: {
    onSubmit() {
      console.log('Form submitted');
    },
    onReset() {
      console.log('Form reset');
    },
    onError() {
      console.log('Validation error');
    },
    redirectToMaps() {
      const mapsUrl =
        'https://www.google.com/maps/place/Via+Vignone,+14,+20822+Seveso+MB/@45.6401212,9.1753578,19z/data=!3m1!4b1!4m14!1m7!3m6!1s0x4786bda353ec759f:0xd375cd45ebc9c302!2sProserpio+Gabriele!8m2!3d45.6400646!4d9.1758954!16s%2Fg%2F1tj7zvlq!3m5!1s0x4786bda35422648f:0x64ee301d3f6a79be!8m2!3d45.6401212!4d9.1760015!16s%2Fg%2F11c26zbw2c?entry=ttu';
      window.open(mapsUrl, '_blank');
    },
  },
});
</script>
