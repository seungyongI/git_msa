<template>
  <div>
    <h1 class="text-5xl">INSERT</h1>
    <label for="email">email</label>
    <input type="text" id="email" v-model="email" 
    class="w-full sm:w-1/2 md:w-1/3 lg:w-1/4 border border-gray-300 rounded-lg py-1 px-3 m-3 focus:outline-none focus:ring-2 focus:ring-slate-500">
    <h1 class="text-3xl">{{ email }}</h1>
    <button @click="doInsert"
      class="bg-slate-500 hover:bg-slate-700 text-white font-bold py-2 px-4 rounded">Insert</button>
  </div>
</template>

<script>
import { ref } from 'vue'
export default {
  setup() {
    const email = ref('');
    const doInsert = () => {
      // console.log(email.value);
      // fetch(`http://localhost:8080/user/insert`,)
      //  .then()
    }

    return { email, doInsert }
  }
}
</script>

<style lang="scss" scoped></style>