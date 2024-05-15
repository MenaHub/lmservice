import { defineConfig } from 'orval';

export default defineConfig({
  lmservice: {
    output: {
      mode: 'tags',
      workspace: 'src/api',
      schemas: './model',
      mock: false, // enable/disable test mock generation
      prettier: true, // enable/disable prettier formatting
      clean: true, // recreate the whole folder (avoid outdated files)
      override: {
        mutator: {
          path: '../boot/axios.ts',
          name: 'customInstance',
        },
      },
    },
    input: {
      // use your own Swagger url: http://server:port/context-path/v3/api-docs
      target: 'http://localhost:7777/v3/api-docs',
    },
  },
});
