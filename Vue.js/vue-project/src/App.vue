<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <div id="main-view">
    <RouterView />
  </div>
</template>

<style scoped>
#main-view{
  width:100vw;
  height:100vh;
  position:absolute;
  left:0px;
  top:0px;
  background:white;
  color: #000;
}
</style>
