<template>
  <div>
    <h1>TheHeader</h1>
    <RouterLink to="/">HOME </RouterLink>
    <RouterLink to="/join"> JOIN </RouterLink>
    <RouterLink to="/about"> ABOUT</RouterLink>
  </div>
</template>

<script setup>
import { RouterLink } from 'vue-router';
</script>

<style lang="scss" scoped></style>