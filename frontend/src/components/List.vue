<template>
  <div class="list" :class="{expanded: listExpanded}">
    <div class="expand" @click="$emit('expand')">
      <img class="expand-img" src="../assets/arrow.svg"/>
    </div>
    <div class="atm-list">
      <div
        v-show="!showDetail"
        class="item"
        v-for="(feature, index) in features"
        @click="$emit('openATM', feature)"
        :key="index">
        {{ feature.shortName }}
        {{ feature.address }}
      </div>
      <Detail
        v-if="showDetail"
        :model="activeFeature"
        @viewOnMap="$emit('viewOnMap')"
        @closeDetail="$emit('closeATM')">
      </Detail>
    </div>
  </div>
</template>

<script>
import Detail from './Detail';

export default {
  name: 'List',
  components: {
    Detail,
  },
  props: {
    listExpanded: Boolean,
    showDetail: Boolean,
    features: Array,
    activeFeature: Object,
  },
}
</script>

<style lang="scss">
  .list {
    position: absolute;
    bottom: calc(-70% + 2rem);
    width: 100%;
    height: 70%;
    z-index: 2;
    background-color: #fff;
    border-radius: 18px 18px 0 0;
    transition: all 200ms ease-in;
  }
  .item {
    width: calc(100% - 3.5rem);
    padding: 1.5rem 0.5rem 1.5rem 3rem;
    border-bottom: 1px solid rgba(49, 108, 0, 0.1);
    background-image: url('../assets/pin.svg');
    background-repeat: no-repeat;
    background-size: 1.5rem;
    background-position: 6px center;
    cursor: default;
  }
  .item:hover {
    background-color: #F6F7F5;
  }
  .item:last-child {
    border-top: none;
  }
  .expand {
    display: flex;
    justify-content: center;
    width: 100%;
    height: 2rem;
    border-radius: 18px 18px 0 0;
    background-color: #F0FBE2;
    border-bottom: 1px solid rgba(49, 108, 0, 0.1);
  }
  .expand-img {
    width: 32px;
    height: 32px;
    transition: all 200ms ease-in;
  }
  .expanded {
    bottom: 0;
  }
  .expanded  .expand-img {
    transform: rotate(180deg);
  }
  .atm-list {
    width: 100%;
    height: calc(100% - 2rem);
    overflow-y: auto;
  }
</style>