<template>
  <div class="pb-10">
    <h1 class="h1-blue">UserList</h1>
    <div class="flex space-x-5">
      <div @click="modalUser"
      class="
      bg-slate-600 
      w-80 p-5 
      text-white
      cursor-pointer"
      v-for="item in arr" :key="item.idx">
        <h1>idx = {{ item.idx }}</h1>
        <h1>name = {{ item.name }}</h1>
        <h1>email = {{ item.email }}</h1>
        <h1>가입일 = {{ item.wdate }}</h1>
        <h1>작성한 글 = {{ item.list.length }}</h1>
      </div>
    </div>
  </div>
</template>

<script setup>
import { getUsers } from '@/api/userApi';
import { ref, watchEffect } from 'vue';

const arr = ref([]);
const modalUser = () => {
  console.log('test');
};

watchEffect(async () => {
  const retValue = await getUsers();
  // console.log('retValue = ' + JSON.stringify(retValue.data));
  arr.value = retValue.data;
  console.log(arr.value);
});
</script>

<style scoped>
.h1-blue {
  font-size: 5rem;
  color: blue;
}
</style>
