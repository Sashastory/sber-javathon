<template>
    <div id="mapView">
    </div>
</template>

<script>
import './configmap';
import Map from 'esri/Map';
import MapView from 'esri/views/MapView';

export default {
    name: "Map",
    data() {
      return {
        map: null,
        view: null,
      };
    },
    mounted() {
      this.map = new Map({
        basemap: "streets"
      });
      
      this.view = new MapView({
        container: "viewDiv",
        map: this.map,
        zoom: 4,
        center: [53, 55],
      });
    },
}
</script>
<style scoped>
div {
    height: 100%;
    width: 100%;
}
#mapView {
  width: 100%;
  height: 100%;
}
</style>
