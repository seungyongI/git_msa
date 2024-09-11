<template>
  <div>
    <div class="flex items-center">
      <h1 class="text-3xl">{{ myVar }}</h1>
      <TheHeader />
      <RouterView></RouterView>
    </div>
  </div>
</template>

<script setup>
import TheHeader from './components/TheHeader.vue';
import { RouterView } from 'vue-router';
const myVar = "Hello";
</script>

<style lang="scss" scoped></style>