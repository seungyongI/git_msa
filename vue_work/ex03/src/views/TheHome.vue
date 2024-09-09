<template>
  <div class="p-10">
    <h1 class="text-5xl">HOME</h1>
    <p>use the ref method</p>
    <h2>{{ count }}</h2>
    <div class="flex space-x-3">
    <button @click="doPls" class="bg-slate-500 hover:bg-slate-700 text-white font-bold py-2 px-4 rounded">Plus</button>
    <button @click="doMin" class="bg-slate-500 hover:bg-slate-700 text-white font-bold py-2 px-4 rounded">Minus</button>
  </div>
</div>
</template>

<script>
import { ref } from 'vue';
export default {
  setup() {
    const count = ref(0);
    const doPls = () => {
      count.value = count.value + 1;
    }
    const doMin = () => {
      count.value = count.value - 1;
    }
    return { count, doPls, doMin }
  }
}
</script>

<style lang="scss" scoped></style>