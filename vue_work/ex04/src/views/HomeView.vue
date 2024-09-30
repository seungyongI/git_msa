<template>
  <div>
    <h1 class="text-3xl">HOME</h1>
    <div class="p-5">
      <table class="border border-gray-500 w-full">
        <tr>
          <th class="border border-gray-500">idx</th>
          <th class="border border-gray-500">name</th>
          <th class="border border-gray-500">age</th>
          <th class="border border-gray-500">email</th>
          <th class="border border-gray-500">password</th>
        </tr>
        <tr v-for="user in list" v-bind:key="user.idx">
          <td class="border border-gray-500">{{ user.idx }}</td>
          <td class="border border-gray-500">{{ user.name }}</td>
          <td class="border border-gray-500">{{ user.age }}</td>
          <td class="border border-gray-500">{{ user.email }}</td>
          <td class="border border-gray-500">{{ user.password }}</td>
        </tr>
      </table>

      <button @click="select" class="bg-yellow-200 
               p-3 m-3 
             hover:bg-yellow-400
              border border-gray-200">불러오기</button>
    </div>
    <div v-for="num in myList" v-bind:key="num">
      num = {{ num }}
    </div>
    <div class="p-5">
      name = <input type="text" name="name" class="border border-yellow-400 focus:ring-2 focus:ring-yellow-500 focus:outline-none rounded-lg p-3 w-64
           text-yellow-900 placeholder-yellow-500 bg-yellow-100 transition-all duration-300 shadow-md
           hover:bg-yellow-200 hover:shadow-lg" v-model="name"><br>
      age = <input type="number" name="name" class="border border-yellow-400 focus:ring-2 focus:ring-yellow-500 focus:outline-none rounded-lg p-3 w-64
           text-yellow-900 placeholder-yellow-500 bg-yellow-100 transition-all duration-300 shadow-md
           hover:bg-yellow-200 hover:shadow-lg" v-model="age"><br>
      email = <input type="text" name="name" class="border border-yellow-400 focus:ring-2 focus:ring-yellow-500 focus:outline-none rounded-lg p-3 w-64
           text-yellow-900 placeholder-yellow-500 bg-yellow-100 transition-all duration-300 shadow-md
           hover:bg-yellow-200 hover:shadow-lg" v-model="email"><br>
      password = <input type="text" name="name" class="border border-yellow-400 focus:ring-2 focus:ring-yellow-500 focus:outline-none rounded-lg p-3 w-64
           text-yellow-900 placeholder-yellow-500 bg-yellow-100 transition-all duration-300 shadow-md
           hover:bg-yellow-200 hover:shadow-lg" v-model="password"><br>
      <button @click="insert" class="bg-yellow-200 
               p-3 m-3 
             hover:bg-yellow-400
              border border-gray-200">insert</button>
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
      "name": "탁천재야",
      "age": 100,
      "email": "aaa@nave44asdasda.com",
      "password": "password",
      "wdate": null
    }]);

    const name = ref('');
    const age = ref('');
    const email = ref('');
    const password = ref('');

    const select = () => {
      fetch(`http://localhost:8080/user/select`)
        .then(res => {
          return res.json();
        })
        .then(result => {
          list.value = result;
          // console.log(result);
        })
        .catch(e => {
          // console.log("예외 발생");
          console.log(e);
        })
    }

    const insert = () => {
      const data = {
        name: name.value,
        age: age.value,
        email: email.value,
        password: password.value
      }
      try{
      fetch(`http://localhost:8080/user/insert`, {
        method: "POST",
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
      })
        .then(res => {
          if(res.status.toString().startsWith('2'))
            alert('입력 실패');
          // console.log(res.status);
        })
      } catch(e) {
        // console.log(e);
      }
    }

    return { list, myList, select, insert, name, age, email, password }
  }
}
</script>

<style lang="scss" scoped></style>