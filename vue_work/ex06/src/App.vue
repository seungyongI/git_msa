<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <div class="p-5 bg-slate-500 text-white text-3xl">
      <nav class="flex space-x-5">
        <div>
          <RouterLink to="/">Home</RouterLink>
        </div>
        <div>
          <RouterLink to="/user">User</RouterLink>
        </div>
        <div class="group relative">
          <h1 class="text-3xl cursor-pointer">FreeBoard</h1>
          <div class="opacity-0 group-hover:opacity-100 transition absolute bg-slate-700 p-3 top-14 -left-5 rounded">
            <div>
              <RouterLink to="/freeboardlist">FreeBoardList</RouterLink>
            </div>
            <div>
              <RouterLink to="/freeboardinput">FreeBoardInput</RouterLink>
            </div>
          </div>
        </div>
      </nav>
    </div>
    <RouterView />
  </header>

</template>

<style scoped></style>