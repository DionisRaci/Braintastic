<template>
  <div class="idea">
    <p>{{ideaText}}</p>
  </div>
</template>

<script>
export default {
  props: {
    ideaText: String
  }
};
</script>

<style scoped>
.idea {
  background-color: white;
  margin: 20px;
  padding: 20px;
  display: inline-block;
}
</style>
