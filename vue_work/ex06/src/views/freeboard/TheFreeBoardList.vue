<template>
  <div>
    <h1 class="h1-red">FreeBoardList</h1>
    <div class="pb-10">
      <div class="px-5">
        <table class="border border-b-gray-500 w-full">
          <thead>
            <tr>
              <th class="border">IDX</th>
              <th class="border">title</th>
              <th class="border">author</th>
              <th class="border">regdate</th>
              <th class="border">viewcount</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="item in arr" :key="item.idx" class="cursor-pointer hover:bg-slate-200"
              @click="viewPage(item.idx)">
              <td class="border text-center text-lg p-1">{{ item.idx }}</td>
              <td class="border text-center text-lg p-1">{{ item.title }}</td>
              <td class="border text-center text-lg p-1">{{ item.creAuthor }}</td>
              <td class="border text-center text-lg p-1">{{ item.regDate }}</td>
              <td class="border text-center text-lg p-1">{{ item.view_count }}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    <div class="flex justify-center">
      <ul class="flex space-x-2">
        <li class="cursor-pointer p-3" v-for="num in totalPages" :key="num" @click="setPageNum(num-1)">
          {{ num }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const arr = ref([]);
const totalPages = ref(10);
const pageNum = ref(0);

const setPageNum = (num) => {
  pageNum.value = num;
  getFreeBoard(num);
}

const viewPage = (idx) => {
  const data = { name: 'freeboardview', params: { idx } };

  router.push(data);
}

const getFreeBoard = (pageNum) => {
  if (pageNum == undefined) pageNum = 0;
  axios.get(`http://localhost:8080/freeboard/select?pageNum=${pageNum}`)
    .then(res => {
      console.log(res);
      arr.value = res.data.list;
      totalPages.value = res.data.totalPages;
    })
    .catch(e => {
      console.log(e);
    });
}

// page 호출 시 자동실행
getFreeBoard();

</script>

<style scoped></style>