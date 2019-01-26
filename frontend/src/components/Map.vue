<template>
    <div id="mapView" ref="map">
    </div>
</template>

<script>
import esriLoader from 'esri-loader';

export default {
    name: "Map",
    data() {
      return {
        map: null,
        view: null,
            url: 'https://js.arcgis.com/4.10/'
      };
    },
    mounted() {
        esriLoader.loadModules(['esri/views/MapView', 'esri/Map'])
            .then(([MapView, Map]) => {
                    this.map = new Map({
                        basemap: "osm"
                    });
                    console.log(this.map);
                    this.view = new MapView({
                        container: this.$refs.map,
                        map: this.map,
                        zoom: 15,
                        center: [37.600531, 55.751666],
                        ui: null,
                    });
                    console.log(this.view);
                })
            .catch(err => {
                console.error(err);
            });
    },
    created() {
        esriLoader.loadCss('https://js.arcgis.com/4.10/esri/css/main.css');
    }
}
</script>
<style>
html {
    height: 100%;
    width: 100%;
}
body {
    height: 100%;
    width: 100%;
}
#mapView {
  width: 100%;
  height: 100%;
}
.esri-view-user-storage {
    display: none;
}
</style>
