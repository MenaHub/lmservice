export const projectPhotos = {
    BB_Bistro: function() {
      const glob = import.meta.globEager('src/assets/aim/BB_Bistro/Photos/*/*.jpg');
      return Object.values(glob).map((photo) => photo.default);
    },
    Brazilian_Taste: function() {
      const glob = import.meta.globEager('src/assets/aim/Brazilian_Taste/Photos/*/*.jpg');
      return Object.values(glob).map((photo) => photo.default);
    },
    Caos_Calmo: function() {
      const glob = import.meta.globEager('src/assets/aim/Caos_Calmo/Photos/*/*.jpg');
      return Object.values(glob).map((photo) => photo.default);
    },
    Green_Nest: function() {
      const glob = import.meta.globEager('src/assets/aim/Green_Nest/Photos/*/*.jpg');
      return Object.values(glob).map((photo) => photo.default);
    },
    Hygge: function() {
      const glob = import.meta.globEager('src/assets/aim/Hygge/Photos/*/*.jpg');
      return Object.values(glob).map((photo) => photo.default);
    },
    Medical_Office_Headquarters: function() {
      const glob = import.meta.globEager('src/assets/aim/Medical_Office_Headquarters/Photos/*/*.jpg');
      return Object.values(glob).map((photo) => photo.default);
    },
    Out_Of_The_Blue: function() {
      const glob = import.meta.globEager('src/assets/aim/Out_Of_The_Blue/Photos/*/*.jpg');
      return Object.values(glob).map((photo) => photo.default);
    },
    Sought_After: function() {
      const glob = import.meta.globEager('src/assets/aim/Sought_After/Photos/*/*.jpg');
      return Object.values(glob).map((photo) => photo.default);
    },
  };