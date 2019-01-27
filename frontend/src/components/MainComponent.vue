<template>
    <div class="main">
        <FeatureToggle
            :activeType='activeType'
            @inputSum="inputSum"
            @toggleType="toggleType">
        </FeatureToggle>
        <button class="button ok-button" @click="getATM">
            Показать банкоматы
        </button>
        <List
            v-if="features.length"
            @expand="expandList"
            @openATM="openATM"
            @closeATM="closeATM"
            @viewOnMap="viewOnMap"
            @bookMoney="bookMoney"
            :features="features"
            :activeFeature="activeFeature"
            :showDetail="showDetail"
            :listExpanded="listExpanded">
        </List>
        <Map
                @newFeatures="setNewFeatures"
                @suceessBooking="showSuceess"
                @unsuceessBooking="showUnSuceess"></Map>
        <modalWindow v-if="isShowModalWindow" :info="modalInfo"></modalWindow>
    </div>
</template>

<script>
    import Map from './map/Map';
    import FeatureToggle from './FeatureToggle';
    import List from './List';
    import modalWindow from './modalWindow';

export default {
    name: "MainComponent",
    components: {
        Map,
        FeatureToggle,
        List,
        modalWindow,
    },
    data() {
      return {
        activeType: 0,
        listExpanded: false,
          sum: 0,
        atmTypes: [
          'take',
          'deposit',
        ],
        activeFeature: null,
        showDetail: false,
        features: [],
          modalInfo: {
              type: 'Успешно',
              info: [
                  {
                      type: 'Успешно',
                      name: 'Время в пути ',
                      value: 1
                  },
                  {
                      type: 'Успешно',
                      name: 'Расстояние ',
                      value: 1
                  },
                  {
                      type: 'Успешно',
                      name: 'Средства забронированы на ',
                      value: 1
                  },
                  {
                      type: 'Не успешно',
                      name: 'В данном банкомате средства не могут быть забронированы',
                      value: ''
                  },
              ]
          },
          isShowModalWindow: false,
      };
    },
    methods: {
      toggleType(index) {
        this.activeType = index;
      },
      getATM() {
          this.$bus.$emit('getATM');
      },
      expandList() {
          this.listExpanded = !this.listExpanded;
      },
      openATM(feature) {
          this.showDetail = true;
          this.activeFeature = feature;
      },
      closeATM() {
          this.showDetail = false;
      },
      viewOnMap() {
          this.listExpanded = false;
          this.$bus.$emit('showFeature', this.activeFeature);
      },
      setNewFeatures(features) {
          this.features = features.map((feature) => feature.properties.companyMetaData);
      },
        inputSum (value) {
            this.sum = parseInt(value);
        },
        bookMoney() {
            this.$bus.$emit('bookMoney', this.activeFeature);
        },
        showSuceess(event) {
            this.isShowModalWindow = true;
            this.modalInfo.type = 'Успешно';
            this.modalInfo.info[0].value = Math.round(event.time) + ' минут';
            this.modalInfo.info[1].value = Math.round(event.distance) + ' минут';
            this.modalInfo.info[2].value = Math.round(event.time + 20) + ' минут';
            this.listExpanded = false;
            setTimeout(() => {
                this.isShowModalWindow = false;
            }, 6000);
        },
        showUnSuceess() {
            this.isShowModalWindow = true;
            this.modalInfo.type = 'Не успешно';
            this.listExpanded = false;
            setTimeout(() => {
                this.isShowModalWindow = false;
            }, 6000);
        }

    },
}
</script>

<style>
@import url('https://fonts.googleapis.com/css?family=Roboto:100,400,500');
.map {
    height: 100%;
    width: 100%;
}
.main {
    position: relative;
    height: 100%;
    width: 100%;
    font-size: 1rem;
    overflow: hidden;
    font-family: 'Roboto';
}
button {
    font-family: 'Roboto';
}
.button {
    padding: 0.5rem 1rem;
    background-color: #57A913;
    border: none;
    border-radius: 0.5rem;
    outline: none;
    font-size: 1rem;
    color: #fff;
    box-shadow: 1px 1px 4px 2px rgba(0,0,0,0.2);
    transition: box-shadow 100ms ease-out;
}
button:hover {
    box-shadow: 1px 1px 4px 4px rgba(0,0,0,0.2);
}
.ok-panel {
    position: absolute;
    width: 100%;
    bottom: 4rem;
    display: flex;
    justify-content: center;
    z-index: 2;
}
.ok-button {
    position: absolute;
    width: 260px;
    height: 60px;
    bottom: 4rem;
    left: calc(50% - 130px);
    padding: 0.6rem 1.16rem 0.6rem 3.75rem ;
    background-color: #fff;
    color: #57A913;
    background-image: url('../assets/atm.svg');
    background-size: 42px;
    background-repeat: no-repeat;
    background-position: 1rem center;
    z-index: 2;
}
html {
    height: 100%;
    width: 100%;
}

    body {
        height: 100%;
        width: 100%;
    }
</style>
