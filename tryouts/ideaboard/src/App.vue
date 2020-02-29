<template>
  <div>
    <idea-board></idea-board>
    <idea-input></idea-input>
  </div>
</template>

<script>
import Ideaboard from "./components/Ideaboard.vue";
import IdeaInput from "./components/IdeaInput.vue";

export default {
  data() {
    return {
      ideas: [],
      Idea: {
        title: ""
      }
    };
  },
  components: {
    "idea-board": Ideaboard,
    "idea-input": IdeaInput
  }
};
</script>

<style>
</style>
