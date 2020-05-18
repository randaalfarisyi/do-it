/*
import Vue from "vue";
import App from "./App.vue";
import router from './router'
 
Vue.config.productionTip = false;
 
new Vue({
  router, // inject the router to make whole app router-aware
  render: h => h(App)
}).$mount("#app");
*/
import Vue from 'vue'
import App from './App.vue'
import router from './router'
import jquery from 'jquery'
window.$ = window.jQuery = jquery;
import 'bootstrap'
import { BootstrapVue, BootstrapVueIcons } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import moment from 'moment'
import { VuejsDatatableFactory } from 'vuejs-datatable';
import vuetify from './plugins/vuetify';


Vue.use(BootstrapVue)
Vue.use(BootstrapVueIcons)
Vue.use( VuejsDatatableFactory );



Vue.config.productionTip = false

new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')

Vue.filter('formatDate', function(value) {
  if (value) {
      return moment(String(value)).format('DD MMMM YYYY')
  }
});
Vue.filter('formatDateV1', function(value) {
  if (value) {
      return moment(String(value)).format('YYYY-MM-DD')
  }
});
Vue.filter('reverse', function(value) {
  // slice to make a copy of array, then reverse the copy
  return value.slice().reverse();
});
