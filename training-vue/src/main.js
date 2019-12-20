import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
//import router from "../router";
import VueResource from 'vue-resource'

Vue.config.productionTip = false;
Vue.use(VueResource);
Vue.use(ElementUI);

new Vue({
  render: h => h(App),
}).$mount('#app');
