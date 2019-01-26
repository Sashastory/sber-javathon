<template>
    <div id="mapView">
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
            .then(function([MapView, Map]) {
                    this.map = new Map({
                        basemap: "streets"
                    });
                    console.log(this.map);
                    this.view = new MapView({
                        container: "viewDiv",
                        map: this.map,
                        zoom: 4,
                        center: [53, 55],
                    });
                    console.log(this.view);
                }.bind(this))
            .catch(err => {
                // handle any errors
                console.error(err);
            });

    },
}
</script>
<style>
div {
    height: 100%;
    width: 100%;
}
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
</style>
