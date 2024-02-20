<template>
  <q-page class="row items-center justify-evenly" :style-fn="minPageHeight">
  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { minPageHeight } from 'src/utils/sharedFunctions';

export default defineComponent({
  name: 'ItemPage',
  methods: {
    minPageHeight,
  },
  data() {
    return {};
  },
});
</script>
