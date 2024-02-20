<template>
  <q-page
    class="row flex-center"
    style="column-gap: 4rem"
    :style-fn="minPageHeight"
  >
    <div
      class="q-pa-md"
      :class="$q.screen.gt.sm ? 'col q-mb-none' : 'col-12 q-mb-xl'"
    >
      <p class="text-h4">Contact us</p>
      <p class="text-italic text-grey-7 q-mb-xl" style="font-size: 1rem">
        We are here to help you
      </p>
      <q-form @submit.prevent="onSubmit" @reset="onReset" class="q-gutter-md">
        <q-input
          ref="fullName"
          filled
          v-model="contactsForm.fullName"
          hint="Name and surname"
          :rules="[
            (val) =>
              isFieldValid(val, 0) || 'Please insert your name and surname',
          ]"
        />

        <q-input
          ref="email"
          filled
          v-model="contactsForm.email"
          hint="Your email"
          :rules="[
            (val) => (val !== null && val !== '') || 'Please type your email',
            (val) => isEmailValid(val) || 'Please type a valid email',
          ]"
        />

        <q-input
          ref="enquirySubject"
          filled
          counter
          maxlength="100"
          v-model="contactsForm.enquirySubject"
          hint="Your enquiry subject"
          :rules="[
            (val) =>
              isFieldValid(val, 5) ||
              'Please be more specific about your enquiry',
          ]"
        />

        <q-input
          ref="enquiryBody"
          filled
          autogrow
          counter
          maxlength="1000"
          v-model="contactsForm.enquiryBody"
          hint="Your request/suggestion"
          :rules="[
            (val) =>
              isFieldValid(val, 10) ||
              'Please be more specific about your request/suggestion',
          ]"
        />

        <q-toggle
          required
          v-model="contactsForm.accept"
          label="I accept the license and terms"
        />

        <div>
          <q-btn
            label="Submit"
            type="submit"
            color="primary"
            :disabled="!validForm"
          />
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

    <div class="q-pa-md" :class="$q.screen.gt.sm ? 'col-5' : 'col-12'">
      <q-card flat bordered>
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
          <q-btn
            flat
            icon="event"
            label="Book a consultation"
            text-color="primary"
          >
            <q-popup-proxy
              :anchor="$q.screen.gt.sm ? 'bottom left' : 'top right'"
              self="top right"
              transition-show="jump-down"
              transition-hide="jump-up"
              transition-duration="800"
            >
              <!-- get already booked day from gcal api and hide them -->
              <q-date
                v-model="consultationDate"
                :landscape="$q.screen.gt.sm"
                mask="DD-MM-YYYY"
                :events="['2024/02/17', '2024/02/09', '2024/02/26']"
                event-color="primary"
              >
                <div class="row justify-end">
                  <q-btn
                    dense
                    flat
                    color="primary"
                    label="Book"
                    @click="
                      $router.push(`/book-a-consultation/${consultationDate}`)
                    "
                  />
                </div>
              </q-date>
            </q-popup-proxy>
          </q-btn>
        </q-card-actions>
      </q-card>
    </div>
  </q-page>
</template>

<script lang="ts">
import { ClientRequest } from 'src/components/models';
import { defineComponent } from 'vue';
import { minPageHeight } from 'src/utils/sharedFunctions';

export default defineComponent({
  name: 'ContactsPage',
  components: {},
  data() {
    return {
      contactsForm: {
        fullName: '',
        email: '',
        enquirySubject: '',
        enquiryBody: '',
        accept: false,
      } as ClientRequest,
      stars: 4,
      validForm: false,
      emailRegex: /^[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\.[A-Z]{2,}$/i,
      consultationDate: new Date(),
    };
  },
  watch: {
    contactsForm: {
      deep: true,
      handler() {
        this.validateForm();
      },
    },
  },
  methods: {
    minPageHeight,
    isFieldValid(val: string, length: number): boolean {
      return (val && val.length > length) as boolean;
    },
    isEmailValid(val: string): boolean {
      return (val && this.emailRegex.test(val)) as boolean;
    },
    validateForm() {
      this.validForm =
        this.isFieldValid(this.contactsForm.fullName, 0) &&
        this.isFieldValid(this.contactsForm.enquirySubject, 5) &&
        this.isFieldValid(this.contactsForm.enquiryBody, 10) &&
        this.isEmailValid(this.contactsForm.email) &&
        (this.contactsForm.accept as boolean);
    },
    onSubmit() {
      this.sendUserEnquiry(this.contactsForm);
      this.$q.notify({
        color: 'positive',
        message: 'Request sent successfully!',
        icon: 'check',
      });
      this.contactsForm.accept = false;
    },
    sendUserEnquiry(form: ClientRequest) {
      //console.log('Sending request to the server', form);
      // TODO: send the form to the server through an API
      this.$api.post('/createUserEnquiry', form).then((response) => {
        console.log('Server response:', JSON.stringify(response, null, 2));
      });
    },
    onReset() {
      this.contactsForm = {
        fullName: '',
        email: '',
        enquirySubject: '',
        enquiryBody: '',
        accept: false,
      };
    },
    redirectToMaps() {
      const mapsUrl =
        'https://www.google.com/maps/place/Via+Vignone,+14,+20822+Seveso+MB/@45.6401212,9.1753578,19z/data=!3m1!4b1!4m14!1m7!3m6!1s0x4786bda353ec759f:0xd375cd45ebc9c302!2sProserpio+Gabriele!8m2!3d45.6400646!4d9.1758954!16s%2Fg%2F1tj7zvlq!3m5!1s0x4786bda35422648f:0x64ee301d3f6a79be!8m2!3d45.6401212!4d9.1760015!16s%2Fg%2F11c26zbw2c?entry=ttu';
      window.open(mapsUrl, '_blank');
    },
  },
});
</script>
