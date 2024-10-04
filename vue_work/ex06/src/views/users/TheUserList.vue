<template>
  <div class="overlay" :class="{ isModal: isModal }"></div>
  <div class="modal p-5 rounded" :class="{ isView: isModal }">
    <h1 class="text-5xl">User Update</h1>
    <div class="bg-slate-600 p-5 m-5 w-80 text-white rounded cursor-pointer">
      <h1>idx : {{ idx }}</h1>
      <h1>
        name :
        <input
          type="text"
          v-model="name"
          class="border border-gray-300 rounded-lg shadow-sm focus:outline-none focus:ring-1 focus:ring-blue-500 focus:border-blue-500 text-gray-700"
        />
      </h1>
      <h1>email : {{ email }}</h1>
      <h1>wdate : {{ wdate }}</h1>
    </div>
    <div class="flex space-x-5 justify-center">
      <button
        @click="modalUser('save')"
        class="px-4 py-2 bg-blue-500 hover:bg-blue-700 text-white font-bold rounded focus:outline-none focus:ring-2"
      >
        save
      </button>
      <button
        @click="modalUser"
        class="px-4 py-2 bg-blue-500 hover:bg-blue-700 text-white font-bold rounded focus:outline-none focus:ring-2"
      >
        cancel
      </button>
    </div>
  </div>
  <div class="pb-10">
    <h1 class="h1-blue">UserList</h1>
    <div class="my-flex">
      <div
        @click="modalUser(item)"
        class="bg-slate-600 w-80 p-5 m-5 text-white rounded cursor-pointer"
        v-for="item in arr"
        :key="item.idx"
      >
        <h1>idx : {{ item.idx }}</h1>
        <h1>name : {{ item.name }}</h1>
        <!-- <h1>{{ item.name }}</h1> -->
        <h1>email : {{ item.email }}</h1>
        <!-- <h1>{{ item.email }}</h1> -->
        <h1>가입일 : {{ item.wdate }}</h1>
        <h1>작성한 글 : {{ item.list.length }}</h1>
        <button
          class="mt-3 mr-3 px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg shadow-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300"
          @click.stop="modalUser(item)"
        >
          수정
        </button>
        <button
          class="mt-3 px-4 py-2 bg-blue-500 text-white font-semibold rounded-lg shadow-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-300"
          @click.stop="doDelete(item.idx)"
        >
          삭제
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { deleteUser, getUsers, saveUser } from '@/api/userApi';
import { ref, watchEffect } from 'vue';

const arr = ref([]);

const idx = ref();
const name = ref();
const email = ref();
const wdate = ref();

const isModal = ref(false);

const doDelete = async (idx) => {
  await deleteUser(idx);
  const retValue = await getUsers();
  arr.value = retValue.data;
};

const modalUser = async (item) => {
  isModal.value = !isModal.value;

  if (item == 'save') {
    await saveUser({
      idx: idx.value,
      name: name.value,
      email: email.value,
      password: '1234'
    });
    // update 필요
    alert('수정하였습니다.');
    const retValue = await getUsers();
    arr.value = retValue.data;
    return;
  }

  idx.value = item.idx;
  name.value = item.name;
  email.value = item.email;
  wdate.value = item.wdate;
};

watchEffect(async () => {
  const retValue = await getUsers();
  arr.value = retValue.data;
});
</script>

<style scoped>
.h1-blue {
  font-size: 5rem;
  color: blue;
}
.my-flex {
  display: flex;
  flex-wrap: wrap;
}
.overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1000;
  background-color: rgb(0, 0, 0, 0.3);
  display: none;
}
.isModal {
  display: block;
}
.modal {
  position: fixed;
  top: 50%;
  left: 50%;
  /* width: 300px; */
  /* height: 200px; */
  z-index: 1001;
  transform: translate(-50%, -50%);
  background-color: white;
  display: none;
}
.isView {
  display: block;
}
</style>
