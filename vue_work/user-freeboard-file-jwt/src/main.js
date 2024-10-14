import './assets/main.css';
import 'sweetalert2/dist/sweetalert2.min.css';

import { createApp } from 'vue';
import { createPinia } from 'pinia';

import App from './App.vue';
import router from './router';

import VueSweetalert2 from 'vue-sweetalert2';

const app = createApp(App);
const pinia = createPinia();

app.use(VueSweetalert2);
app.use(router);
app.use(pinia);

app.mount('#app');
