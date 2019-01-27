<template>
  <div id="app">
      <router-view></router-view>
  </div>
</template>

<script>
import MainComponent from './components/MainComponent';

export default {
  name: 'app',
    components: {
        MainComponent
    }
}
</script>

<style lang="scss">
html, body {
  margin: 0;
  font-size: 16px;
}
#app {
  height: 100%;
  width: 100%;
}
div > .esri-ui-corner {
  top: 7rem;
  border: none;
  background-color: rgba(0,0,0,0);
  box-shadow: none;
}
div > .esri-widget {
  background-color: rgba(0,0,0,0);
  border: none;
  box-shadow: none;
}
div > .esri-zoom {
  background-color: rgba(0,0,0,0);
  border: none;
  box-shadow: none;
}
div > .esri-widget--button {
  width: 36px;
  height: 36px;
  margin-bottom: 4px;
  border-radius: 6px;
  background-color: #fff;
}
</style>
