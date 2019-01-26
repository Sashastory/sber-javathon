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
</style>
