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
html,
body {
  margin: 0;
  padding: 0;
  font-family: Arial, sans-serif;
  background: radial-gradient(#e5e7e8 1px, #ebedee 2px);
  background-size: 8px 8px;
}
.red {
  background-color: #e5e7e8;
}
</style>
