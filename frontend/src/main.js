import Vue from 'vue';
import App from './App.vue';
import router from './router';

Vue.config.productionTip = false;

// Bootstrap


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

