<template>
  <div>
    <idea v-bind:key="idea" v-for="idea in ideas" :ideaText="idea"></idea>
  </div>
</template>

<script>
import Idea from "./Idea.vue";
export default {
  props: {
    ideas: Array
  },
  components: {
    idea: Idea
  }
};
</script>

<style></style>
