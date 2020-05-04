<template>
  <div>
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  components: {}
}
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
