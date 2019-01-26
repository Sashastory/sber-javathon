<template>
    <div>
        <div id="mapView" ref="map"></div>
        <location
                :view="view"
                @location="setPosition"
                @locationfailed="cantSetPosition"
                class="location"></location>
        <myLocation class="myLocationContainer"></myLocation>
    </div>
</template>

<script>
    import esriLoader from 'esri-loader';
    import location from './location';
    import myLocation from './MyLocation';

    export default {
        name: "Map",
        components: {
            location,
            myLocation
        },
        data() {
            return {
                map: null,
                view: null,
                url: 'https://js.arcgis.com/4.10/',
                viewReady: false,
                defaultUi: {},
                Point: null,
            };
        },
        methods: {
            setPosition(position){
                this.view.goTo({
                    center: [position.coords.longitude, position.coords.latitude],
                    zoom: 15,
                }, {
                    duration: 500
                });
            },
            cantSetPosition() {
                alert('невозможно определить позицию');
            }
        },
        mounted() {
            esriLoader.loadModules(['esri/views/MapView',
                'esri/Map',
                'esri/geometry/Point'])
                .then(([MapView,
                           Map,
                           Point]) => {
                    this.map = new Map({
                        basemap: "osm"
                    });
                    this.view = new MapView({
                        container: this.$refs.map,
                        map: this.map,
                        zoom: 15,
                        center: [37.600531, 55.751666],
                    });
                    this.view.when(() => {
                        this.viewReady = true;

                        if (navigator.geolocation) {
                            navigator.geolocation
                                .getCurrentPosition(
                                    this.setPosition,
                                    () => this.setPosition({
                                        coords: {
                                            longitude: 37.531342,
                                            latitude: 55.741432,
                                        }
                                    }));
                        } else {
                            this.cantSetPosition();
                        }
                    });

                    this.view.constraints = {
                        rotationEnabled: false
                    };
                    this.Point = Point;
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
    .myLocationContainer {
        position: absolute;
        top: calc(50% - 32px);
        left: calc(50% - 16px);
    }
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

    .esri-view-user-storage {
        display: none;
    }

    .esri-ui-top-left {
        top: 0;
        left: 0;
        width: initial;
        height: initial;
    }

    .location {
        position: absolute;
        bottom: 20px;
        right: 20px;
        width: initial;
        height: initial;
    }
    .esri-ui-inner-container.esri-ui-manual-container {
        display: none;
    }
</style>
