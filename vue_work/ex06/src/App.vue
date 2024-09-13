<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <div class="wrapper">
      <nav class="flex justify-center">
        <RouterLink class="p-3 text-2xl text-amber-700" to="/">Home</RouterLink>
        <RouterLink class="p-3 text-2xl text-amber-700" to="/user">User</RouterLink>
        <RouterLink class="p-3 text-2xl text-amber-700" to="/freeboard">FreeBoard</RouterLink>
      </nav>
    </div>
    <RouterView />
  </header>

</template>

<style scoped></style>