<template>
    <div class="main">
        <FeatureToggle
            :activeFeature='activeFeature'
            @toggleFeature="toggleFeature">
        </FeatureToggle>
        <Map></Map>
    </div>
</template>

<script>
import Map from './Map';
import FeatureToggle from './FeatureToggle';

export default {
    name: "MainComponent",
    components: {
        Map,
        FeatureToggle,
    },
    data() {
      return {
        activeFeature: 0,
        features: [ 
          'take',
          'deposit',
        ]
      };
    },
    methods: {
      toggleFeature(index) {
        this.activeFeature = index;
        console.log(this.features[index]);
      }
    },
}
</script>

<style>
.main {
    position: relative;
    height: 100%;
    width: 100%;
}
.button {
    padding: 6px 12px;
    background-color: rgb(153,204,51);
    border: none;
    border-radius: 4px;
    outline: none;
    color: #fff;
    box-shadow: 1px 1px 4px 2px rgba(0,0,0,0.2);
}
</style>
