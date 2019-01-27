<template>
  <div class="detail">
    <div class="close-detail" @click="$emit('closeDetail')">
      <img class="close-detail-img" src="../assets/arrow.svg"/>
      &nbsp; назад к списку
    </div>
    <div class="info">
      <div class="info-title">
        <img class="info-title-img" src="../assets/atm.svg"/>
        <div>
          <div>
            <span class="item-name">{{ model.shortName }}</span>
          </div>
          <div class="info-item">
            {{ model.address }}
          </div>
        </div>
      </div>
      <div class="info-item">
        <span>телефон:</span> <span>{{ model.Phones[0].formatted }}</span>
      </div>
      <div class="info-item">
        <span>время работы:</span> <span>{{ model.Hours.text}}</span>
      </div>
      <div class="info-item">
        <span>индекс:</span> {{ model.postalCode }}
      </div>
      <div v-for="(item, i)  in model.Features" class="info-item" :key="i">
        <span v-if="i !== 0"></span>
        <span v-if="i === 0">возможности:</span> {{ item.name }}
      </div>
      <button
        @click="$emit('viewOnMap')"
        class="button route-button">
        Показать на карте
      </button>
    </div>
  </div>
</template>

<script> 
export default {
  name: 'Detail',
  props: {
    model: Object,
  },
}
</script>

<style lang="scss">
.detail {
  width:100%;
  height: 100%;
}
.close-detail {
  display: flex;
  width: calc(100% - 2.5rem);
  padding: 0.5rem 0.5rem 0.5rem 2rem;
  align-items: center;
  line-height: 100%;
  color: #56A812;
  background-color: #F0FBE2;
}
.close-detail-img {
  width: 22px;
  height: 22px;
  transform: rotate(270deg);
}
.info {
  width: calc(100% - 2rem);
  padding-left: 2rem;
}
.info-title {
  display: flex;
  align-items: center;
  padding: 1rem 0 2rem 0;
}
.info-title-img {
  width: 3.5rem;
  height: 3.5rem;
  margin-right: 1rem;
}
.item-name {
  color: #56A812;
  font-size: 1.25rem;
}
.info-item {
  margin-bottom: 0.5rem;
}
.info-item > span:first-child{
  display: inline-block;
  width: 8rem;
  margin-right: 0.5rem;
  text-align: left;
  color: rgba(0,0,0,0.5);
}
.route-button {
  margin-top: 1rem;
}
@media(max-width: 1024px) {
  .info-item > span:last-child{
    display: flex;
  }
}
</style>