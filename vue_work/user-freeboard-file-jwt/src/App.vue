<script setup>
import { RouterLink, RouterView } from 'vue-router';
</script>

<template>
  <header>
    <div class="p-5 bg-slate-500 text-white text-3xl">
      <nav class="flex justify-between">
        <div class="flex space-x-5">
          <div>
            <RouterLink to="/">HOME</RouterLink>
          </div>
          <div>
            <RouterLink to="/user">USER</RouterLink>
          </div>
          <div class="group relative">
            <h1 class="text-3xl cursor-pointer">FREEBOARD</h1>
            <div
              class="opacity-0 group-hover:opacity-100 transition absolute bg-slate-700 p-3 top-14 -left-5 rounded"
            >
              <div>
                <RouterLink to="/freeboardlist">FREEBOARDLIST</RouterLink>
              </div>
              <div>
                <RouterLink to="/freeboardinput">FreeBoardInput</RouterLink>
              </div>
            </div>
          </div>
          <div>
            <RouterLink to="/fileupload">FileUpload</RouterLink>
          </div>
        </div>
        <div class="flex space-x-5">
          <div>
            <RouterLink to="/join">join</RouterLink>
          </div>
          <div>
            <RouterLink to="/login">login</RouterLink>
          </div>
        </div>
      </nav>
    </div>
    <RouterView />
  </header>
</template>

<style scoped></style>
