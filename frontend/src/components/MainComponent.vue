<template>
    <div>
        <Map></Map>
    </div>
</template>

<script>
import Map from './Map';

export default {
    name: "MainComponent",
    components: {
        Map,
    },
}
</script>

<style scoped>
div {
    height: 100%;
    width: 100%;
}
</style>
