<template>
  <div>
    <idea-board :ideas="ideas"></idea-board>
    <idea-input></idea-input>
  </div>
</template>

<script>
import Ideaboard from "./components/Ideaboard.vue";
import IdeaInput from "./components/IdeaInput.vue";

import { eventBus } from "./main";

export default {
  data() {
    return {
      ideas: [
        "Socal Media Marketing",
        "Google AdWords is very practical and efficient",
        "Facebook ads are easy to setup and target the right group of people"
      ],
      ideaText: null
    };
  },
  components: {
    "idea-board": Ideaboard,
    "idea-input": IdeaInput
  },
  created() {
    eventBus.$on("addedIdea", ideaText => {
      this.ideaText = ideaText;
      this.ideas.push(this.ideaText);
    });
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
