<template>
  <div>
    <h1 class="text-5xl">Hello tailwind</h1>
    <div class="flex space-x-5 p-5 bg-slate-500">
      <router-link class="text-white hover:text-gray-400" to="/">HOME</router-link>
      <router-link class="text-white hover:text-gray-400" to="/insert">INSERT</router-link>
      <router-link class="text-white hover:text-gray-400" to="/select">SELECT</router-link>
      <router-link class="text-white hover:text-gray-400" to="/update">UPDATE</router-link>
      <router-link class="text-white hover:text-gray-400" to="/delete">DELETE</router-link>
    </div>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  setup() {


    return {}
  }
}
</script>

<style lang="scss" scoped></style>