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
#app {
  height: 100%;
  width: 100%;
}
</style>
