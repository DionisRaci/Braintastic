<template>
  <div>
    <login></login>
    <register></register>
  </div>
</template>

<script>
import WebsocketGreetings from "./components/WebsocketGreetings.vue";
import Login from "./components/Login.vue";
import Register from "./components/Register.vue";

export default {
  components: {
    WebsocketGreetings,
    Login,
    Register
  }
};
</script>

<style>
/* Removes Browser scrollbar in ...*/
html {
  -ms-overflow-style: none; /* Internet Explorer 10+ */
  scrollbar-width: none; /* Firefox */
}
::-webkit-scrollbar {
  display: none; /* Safari and Chrome */
}
</style>
