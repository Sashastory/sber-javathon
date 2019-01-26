import Vue from 'vue'
import App from './App.vue'
import router from './router'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.config.productionTip = false

// Bootstrap
Vue.use(BootstrapVue)


Object.defineProperty(Vue.prototype, '$bus', {
    get() {
        return this.$root.bus;
    },
});


new Vue({
    router,
    render: h => h(App),
    data: {
        bus: new Vue({}),
    },
}).$mount('#app')

