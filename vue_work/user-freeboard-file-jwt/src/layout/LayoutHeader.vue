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
        <template v-if="loginCheck">
          <button class="hover:bg-slate-700" @click="logout">로그아웃</button>
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

console.log(loginPinia.loginCheck);

const logout = () => {
    localStorage.removeItem('token');
    loginPinia.logout();
    window.location.href = '/login';
};

watchEffect(async () => {
  const result = await doLoginCheck();
  if (result == false) {
    loginPinia.logout();
  } else {
    if (result.status != 200) {
      loginPinia.logout();
      localStorage.removeItem('token');
    } else {
      loginPinia.login(result.data);
    }
  }
});

</script>

<style lang="scss" scoped></style>
