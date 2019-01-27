<template>
  <div class="feature-toggle">
    <div>
        <button class="button feature-toggle-button"
            :class="{disable: (activeType === 1)}"
            @click="$emit('toggleType', 0)">
            Снять
        </button>
        <button class="button feature-toggle-button"
            :class="{disable: (activeType === 0)}"
            @click="$emit('toggleType', 1)">
            Внести
        </button>
    </div>
    <input class="button input" type="number"/>
  </div>
</template>

<script>
export default {
    name: "FeatureToggle",
    props: {
      activeType: Number,
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
.input {
  display: block;
  background-color: #fff;
  color: #000;
}
</style>