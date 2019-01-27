<template>
    <div class="main">
        <FeatureToggle
            :activeFeature='activeFeature'
            @toggleFeature="toggleFeature">
        </FeatureToggle>
        <div class="ok-panel">
            <button class="button ok-button" @click="getATM">
                Показать банкоматы
            </button>
        </div>
        <List
            @expand="expandList"
            :listExpanded="listExpanded">
        </List>
        <Map></Map>
    </div>
</template>

<script>
import Map from './map/Map';
import FeatureToggle from './FeatureToggle';
import List from './List';

export default {
    name: "MainComponent",
    components: {
        Map,
        FeatureToggle,
        List,
    },
    data() {
      return {
        activeFeature: 0,
        listExpanded: false,
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
      },
      getATM() {
          console.log('get ATM');
      },
      expandList() {
          this.listExpanded = !this.listExpanded;
      },
    },
}
</script>

<style>
    .map {
        height: 100%;
        width: 100%;
    }
.main {
    position: relative;
    height: 100%;
    width: 100%;
    font-size: 1rem;
    overflow: hidden;
}
.button {
    padding: 0.5rem 1rem;
    background-color: #57A913;
    border: none;
    border-radius: 0.5rem;
    outline: none;
    font-size: 1rem;
    color: #fff;
    box-shadow: 1px 1px 4px 2px rgba(0,0,0,0.2);
    transition: box-shadow 100ms ease-out;
}
button:hover {
    box-shadow: 1px 1px 4px 4px rgba(0,0,0,0.2);
}
.ok-panel {
    position: absolute;
    width: 100%;
    bottom: 4rem;
    display: flex;
    justify-content: center;
    z-index: 2;
}
.ok-button {
    height: 60px;
    padding: 0.6rem 1.16rem 0.6rem 3.75rem ;
    background-color: #fff;
    color: #57A913;
    background-image: url('../assets/atm.svg');
    background-size: 42px;
    background-repeat: no-repeat;
    background-position: 1rem center;
}
html {
    height: 100%;
    width: 100%;
}

body {
    height: 100%;
    width: 100%;
}
</style>
