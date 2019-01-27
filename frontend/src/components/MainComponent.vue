<template>
    <div class="main">
        <FeatureToggle
            :activeType='activeType'
            @toggleType="toggleType">
        </FeatureToggle>
        <button class="button ok-button" @click="getATM">
            Показать банкоматы
        </button>
        <List
            @expand="expandList"
            @openATM="openATM"
            @closeATM="closeATM"
            @viewOnMap="viewOnMap"
            :features="features"
            :activeFeature="activeFeature"
            :showDetail="showDetail"
            :listExpanded="listExpanded">
        </List>
        <Map></Map>
    </div>
</template>

<script>
import Map from './map/Map';
import FeatureToggle from './FeatureToggle';
import List from './List';

export default {
    name: "MainComponent",
    components: {
        Map,
        FeatureToggle,
        List,
    },
    data() {
      return {
        activeType: 0,
        listExpanded: false,
        atmTypes: [
          'take',
          'deposit',
        ],
        activeFeature: null,
        showDetail: false,
        features: [
            {
                shortName: 'Сбербанк',
                id: '1',
                postalCode: "109012",
                address: 'Красная площадь, 3',
                "Phones": [
                    {
                      "type": "phone",
                      "formatted": "8 (800) 555-55-50",
                      "country": "7",
                      "prefix": "800",
                      "number": "5555550"
                    },
                ],
                "Hours": {
                    "Availabilities": [
                      {
                        "Everyday": true,
                        "Intervals": [
                          {
                            "from": "10:00:00",
                            "to": "22:00:00"
                          }
                        ]
                      }
                    ],
                    "text": "ежедневно, 10:00–22:00",
                    "tzOffset": 10800,
                    "State": {
                      "is_open_now": "0",
                      "text": "Закрыто до 10:00",
                      "short_text": "Закрыто до 10:00"
                    }
                },
                "Features": [
                    {
                      "id": "cash_to_card",
                      "type": "bool",
                      "name": "внесение наличных",
                      "value": false
                    },
                    {
                      "id": "location_opening_hours",
                      "type": "bool",
                      "name": "в режиме работы места установки",
                      "value": true
                    }
                ],
            },
            {
                shortName: 'Сбербанк',
                id: '1',
                address: 'Красная площадь, 3',
            },
            {
                shortName: 'Сбербанк',
                id: '1',
                address: 'Красная площадь, 3',
            },
            {
                shortName: 'Сбербанк',
                id: '1',
                address: 'Красная площадь, 3',
            },
        ]
      };
    },
    methods: {
      toggleType(index) {
        this.activeType = index;
        console.log(this.atmTypes[index]);
      },
      getATM() {
          this.$bus.$emit('getATM');
      },
      expandList() {
          console.log('expand list');
          this.listExpanded = !this.listExpanded;
      },
      openATM(feature) {
          console.log(feature);
          this.showDetail = true;
          this.activeFeature = feature;
      },
      closeATM() {
          this.showDetail = false;
      },
      viewOnMap() {
          console.log('viewOnMap');

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
