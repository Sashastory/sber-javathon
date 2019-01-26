<template>
  <div class="feature-toggle">
      <button class="button feature-toggle-button">
          Снять
      </button>
      <button class="button feature-toggle-button disable">
          Внести
      </button>
  </div>
</template>

<script>
export default {
    name: "FeatureToggle",
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
.feature-toggle-button:first-child {
    margin-right: 14px;
}
.disable {
    background-color: rgb(95,95,97);
}
</style>