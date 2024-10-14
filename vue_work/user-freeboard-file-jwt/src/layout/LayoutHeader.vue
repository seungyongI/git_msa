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
            <h1 class="text-3xl cursor-pointer">FreeBoard</h1>
            <div
              class="opacity-0 group-hover:opacity-100 transition absolute bg-slate-700 p-3 top-14 -left-5 rounded"
            >
              <div>
                <RouterLink to="/freeboardlist">FreeboardList</RouterLink>
              </div>
              <div>
                <RouterLink to="/freeboardinput">FreeboardInput</RouterLink>
              </div>
            </div>
          </div>
          <div class="group relative">
            <h1 class="text-3xl cursor-pointer">File</h1>
            <div
              class="opacity-0 group-hover:opacity-100 transition absolute bg-slate-700 p-3 top-14 -left-5 rounded"
            >
              <div>
                <RouterLink to="/fileupload">FileUpload</RouterLink>
              </div>
              <div>
                <RouterLink to="/fileuploads">fileuploads</RouterLink>
              </div>
              <div>
                <RouterLink to="/filedownload">filedownload</RouterLink>
              </div>
            </div>
          </div>
        </div>
        <template v-if="loginPinia.loginCheck">
          <div class="flex space-x-5">
            <h1 class="hover:cursor-pointer">{{ loginPinia.name }} 님</h1>
            <button class="hover:bg-slate-700" @click="logout">로그아웃</button>
          </div>
        </template>
        <template v-else>
          <div class="flex space-x-5">
            <div>
              <RouterLink to="/join">JOIN</RouterLink>
            </div>
            <div>
              <RouterLink to="/login">LOGIN</RouterLink>
            </div>
          </div>
        </template>
      </nav>
    </div>
  </header>
</template>

<script setup>
import { doLoginCheck } from '@/api/loginApi';
import { useLoginStore } from '@/store/loginPinia';
import { watchEffect } from 'vue';
import { RouterLink } from 'vue-router';

const loginPinia = useLoginStore();

const logout = async () => {
  await loginPinia.logout();
  localStorage.removeItem('token');
  window.location.href = '/login';
};

watchEffect(async () => {
  const result = await doLoginCheck();
  if (result == false) {
    loginPinia.logout();
  } else {
    if (result.status == 200) {
      loginPinia.login(result.data);
    } else if (result.status == 401) {
      localStorage.removeItem('token');
      loginPinia.logout();
    }
  }
});
</script>

<style lang="scss" scoped></style>
