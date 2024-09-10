<template>
  <div>
    <h1>HOME</h1>
    <ul>
      <li v-for="user in list" v-bind:key="user.idx">
        idx = {{ user.idx }}
        name = {{ user.name }}
      </li>
    </ul>
    <button @click="select" 
      class="bg-yellow-200 
               p-2 
             hover:bg-yellow-400
              border border-gray-200">불러오기</button>
    <div v-for="num in myList" v-bind:key="num">
      num = {{ num }}
    </div>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  setup() {
    const myList = [10, 20, 30];
    const list = ref([{
      "idx": 1,
      "name": "이승용",
      "age": 100,
      "email": "aaa@naver.com",
      "password": "password",
      "wdate": null
    },
    {
      "idx": 2,
      "name": "탁천재야",
      "age": 100,
      "email": "aaa@nave44asdasda.com",
      "password": "password",
      "wdate": null
    }]);
    const select = () => {
      
      list.value = [{ idx: 1, name: "change" }];
    }
    // fetch('localhost:8080/user/select')

    return { list, myList, select }
  }
}
</script>

<style lang="scss" scoped></style>