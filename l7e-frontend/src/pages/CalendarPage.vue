<template>
  <q-page>
    <div v-if="confirmedBooking">
      <div class="row flex-center">
        <div class="col-6">
          <div class="row text-h3">Booking confirmed!</div>
          <div class="row text-h5 q-my-md">
            Thank you for booking with us! <br />
            We will send you an email with the details.
          </div>
          <div class="row">
            <q-btn to="/" class="bg-primary text-white"> Go to homepage</q-btn>
          </div>
        </div>
        <div class="col-6">
          <q-icon name="verified" color="primary" size="10rem" />
        </div>
      </div>
    </div>
    <div v-else>
      <div
        class="q-pa-md"
        :class="$q.screen.gt.sm ? 'col q-mb-none' : 'col-12 q-mb-xl'"
      >
        <p class="text-h4">Book a consultation</p>
        <p class="text-italic text-grey-7" style="font-size: 1rem">
          Select a date and time for your consultation and fill in your details
        </p>
      </div>
      <q-splitter v-model="splitterModel" class="flex-center">
        <template v-slot:before>
          <div class="q-pa-md row justify-center">
            <q-date
              v-model="date"
              :events="events"
              event-color="orange"
              landscape
            />
          </div>
        </template>

        <template v-slot:after>
          <q-tab-panels
            v-model="date"
            transition-prev="jump-up"
            transition-next="jump-down"
            transition-duration="8000"
          >
            <q-tab-panel :name="date">
              <div class="text-h4 q-mb-md">{{ formatDate(date) }}</div>
              <div
                v-for="slot in availableSlots(date)"
                :key="slot"
                class="q-mb-sm"
                style="border: 1px solid #000000; border-radius: 40px"
              >
                <q-item
                  clickable
                  v-ripple
                  :key="slot"
                  @click="openConfirmDialog(slot)"
                >
                  <q-item-section>
                    <q-item-label>{{ slot }}</q-item-label>
                  </q-item-section>
                  <q-item-section side>
                    <q-icon name="event" />
                  </q-item-section>
                </q-item>
              </div>
            </q-tab-panel>
          </q-tab-panels>
        </template>
      </q-splitter>
      <q-dialog v-model="confirmDialog.open" persistent>
        <q-card>
          <q-card-section class="text-h6">Confirm booking</q-card-section>
          <q-card-section class="text-body1 q-py-none">
            {{ confirmDialog.message }}
          </q-card-section>
          <q-card-section>
            <q-input
              v-model="clientDetails.name"
              label="Name"
              dense
              outlined
              hide-bottom-space
              :rules="[(val) => !!val || 'Please enter your name']"
            />
            <q-input
              v-model="clientDetails.email"
              label="Email"
              dense
              outlined
              hide-bottom-space
              :rules="[
                (val) => !!val || 'Please enter your email',
                (val) => emailRegex.test(val) || 'E-mail must be valid',
              ]"
              class="q-my-xs"
            />
            <q-input
              v-model="clientDetails.phone"
              label="Phone"
              dense
              outlined
              hide-bottom-space
              :rules="[
                (val) => !!val || 'Please enter your phone number',
                (val) => /^\d{3}-*\d{7}$/.test(val) || 'Phone must be valid',
              ]"
            />
          </q-card-section>
          <q-card-section class="q-py-none">
            <q-item>
              <q-item-section>
                <q-item-label>Date</q-item-label>
              </q-item-section>
              <q-item-section side>
                <q-item-label>{{ formatDate(date) }}</q-item-label>
              </q-item-section>
            </q-item>
            <q-item>
              <q-item-section>
                <q-item-label>Slot</q-item-label>
              </q-item-section>
              <q-item-section side>
                <q-item-label>{{ slotToBook }}</q-item-label>
              </q-item-section>
            </q-item>
          </q-card-section>
          <q-card-actions align="right">
            <q-btn
              flat
              label="Cancel"
              color="primary"
              @click="confirmDialog.open = false"
            />
            <q-btn
              flat
              label="Confirm"
              color="primary"
              @click="createCalendarEvent()"
            />
          </q-card-actions>
        </q-card>
      </q-dialog>
    </div>
  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { parse, format } from 'date-fns';

export default defineComponent({
  name: 'CalendarPage',
  data() {
    return {
      emailRegex: /^[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\.[A-Z]{2,}$/i,
      splitterModel: 50,
      date: '',
      events: ['2024/02/01', '2024/02/05', '2024/02/06'],
      slotToBook: '',
      clientDetails: {
        name: '',
        email: '',
        phone: '',
      },
      confirmDialog: {
        open: false,
        title: 'Confirm booking',
        message: 'Please confirm your booking details:',
      },
      confirmedBooking: false,
    };
  },
  mounted() {
    this.date = this.$route.params.date
      ? this.formatDate(
          this.$route.params.date as string,
          'dd-MM-yyyy',
          'yyyy/MM/dd'
        )
      : '';
  },
  methods: {
    formatDate(
      date: string,
      startingFormat: string = 'yyyy/MM/dd' as string,
      goalFormat: string = 'dd-MM-yyyy' as string
    ): string {
      return format(parse(date, startingFormat, new Date()), goalFormat);
    },
    availableSlots(date: string): string[] {
      return ['09:00', '10:00', '11:00', '14:00', '15:00'];
    },
    openConfirmDialog(slot: string) {
      // TODO: get data from authenticated user
      this.clientDetails.name = 'Giancarlo Corzo';
      this.clientDetails.email = 'g.corzo@gmail.com';
      this.clientDetails.phone = '394-3943943';
      this.slotToBook = slot;
      this.confirmDialog.open = true;
    },
    createCalendarEvent() {
      console.log('Creating event...');
      // TODO: create event on Google Calendar and call backend to send emails to client and admin
      // createEventAndSendEmails().then(() => { this.confirmedBooking = true; this.confirmDialog.open = false; })
      this.confirmedBooking = true;
      this.confirmDialog.open = false;
    },
  },
  computed: {},
});
</script>
