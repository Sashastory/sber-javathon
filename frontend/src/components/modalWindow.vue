<template>
    <div class="container">
        <div v-for="element in info.info">
            <div v-if="element.type === info.type">
                <div class="subTitle">{{element.name}}</div>
                <div class="value">{{element.value}}</div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "modalWindow",
        props: {
            info: Object,
        }
    }
</script>

<style scoped>
.container{
    position: absolute;
    top: 200px;
    left: calc(50% - 120px);
    width: 200px;
    background: white;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 1px 1px 4px 2px rgba(0, 0, 0, 0.2);
}
    .subTitle{
        float: left;
        width: 50%;
    }
.value{
        float: right;
        width: 50%;
    }
    .title {
        text-align: center;
        font-size: 20px;
    }
</style>
