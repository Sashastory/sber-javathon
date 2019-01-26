<template>
  <div class="list" :class="{expanded: expandList}">
    <div class="expand" @click="expandList"></div>
    <div class="item">
      Адрес: Совхозная, 3
    </div>
  </div>
</template>

<script>

export default {
  name: 'List',
  props: {
    expandList: Boolean,
  },
}
</script>

<style lang="scss">
  .list {
    position: absolute;
    bottom: calc(-100% + 2rem);
    width: 100%;
    height: 100%;
    z-index: 2;
  }
  .item {
    width: 100%;
    background-color: cadetblue;
  }
  .expand {
    width: 100%;
    height: 2rem;
    border-radius: 2px 2px 0 0;
    background-color: #fff;
    background-image: url('../assets/arrow.svg');
    background-position: center;
    background-repeat: no-repeat;
    background-size: 2.5rem;
  }
  .expanded {
    bottom: 0;
  }
</style>