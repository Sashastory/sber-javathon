<template>
  <div class="feature-toggle">
        <button class="button feature-toggle-button"
            :class="{disable: (activeFeature === 1)}"
            @click="$emit('toggleFeature', 0)">
            Снять
        </button>
        <button class="button feature-toggle-button"
            :class="{disable: (activeFeature === 0)}"
            @click="$emit('toggleFeature', 1)">
            Внести
        </button>
  </div>
</template>

<script>
export default {
    name: "FeatureToggle",
    props: {
      activeFeature: Number,
    }
}
</script>

<style scoped>
.feature-toggle {
    position: absolute;
    display: flex;
    width: 100%;
    padding: 6px 0;
    justify-content: center;
    background-color: rgba(0,0,0,0);
    z-index: 1;
}
.feature-toggle-button {
  font-size: 1rem;
}
.feature-toggle-button:first-child {
    margin-right: 2px;
    border-radius: 8px 0 0 8px;
}
.feature-toggle-button:last-child {
    margin-right: 8px;
    border-radius: 0 8px 8px 0;
}
.disable {
    background-color: rgb(190,190,190);
}
</style>