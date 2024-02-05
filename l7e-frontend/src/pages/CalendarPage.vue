<template>
  <q-page>
    <div>
      <q-splitter v-model="splitterModel">
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
            transition-next="jump-up"
            transition-duration="8000"
          >
            <q-tab-panel :name="date">
              <div class="text-h4 q-mb-md">{{ formatDate(date) }}</div>
              <p>
                Lorem ipsum dolor sit, amet consectetur adipisicing elit. Quis
                praesentium cumque magnam odio iure quidem, quod illum numquam
                possimus obcaecati commodi minima assumenda consectetur culpa
                fuga nulla ullam. In, libero.
              </p>
              <p>
                Lorem ipsum dolor sit, amet consectetur adipisicing elit. Quis
                praesentium cumque magnam odio iure quidem, quod illum numquam
                possimus obcaecati commodi minima assumenda consectetur culpa
                fuga nulla ullam. In, libero.
              </p>
            </q-tab-panel>
          </q-tab-panels>
        </template>
      </q-splitter>
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
      splitterModel: 50,
      date: '',
      events: ['2024/02/01', '2024/02/05', '2024/02/06'],
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
    ) {
      return format(parse(date, startingFormat, new Date()), goalFormat);
    },
  },
});
</script>
