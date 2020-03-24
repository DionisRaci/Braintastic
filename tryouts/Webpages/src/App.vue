<template>
  <div>
    <app-login></app-login>
    <app-join></app-join>
  </div>
</template>

<script>
import Login from "./components/login.vue";
import Join from "./components/join.vue";
import Create from "./components/create.vue";

export default {
  components: {
    "app-login": Login,
    "app-join": Join,
    "app-create": Create
  }
};
</script>

<style>
</style>
