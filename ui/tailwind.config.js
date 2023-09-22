/** @type {import('tailwindcss').Config} */
export default {
  mode: 'jit',
  content: ['./src/**/*.{html,ts}'],
  theme: {
    extend: {

      colors: {
        // transparent: 'transparent',
        // current: 'currentColor',
          'primary-light': '000',
          'primary-dark': '002324',
          'secondary': '4CABAE',
      },
    },
  },
  plugins: [
],
};

// /** @type {import('tailwindcss').Config} */
// module.exports = {
//   mode: 'jit',
//   content: ['./src/**/*.{html,ts}'],
//   theme: {
//     colors: {
//       transparent: 'transparent',
//       current: 'currentColor',
//         'primary-light': 'DEF0F0',
//         'primary-dark': '002324',
//         'secondary': '4CABAE',
//     },
//   },
//     plugins: [require('@tailwindcss/aspect-ratio')
// ,require('@tailwindcss/forms')
// ,require('@tailwindcss/line-clamp')
// ,require('@tailwindcss/typography')
// ],
// }