import Vue from "vue";
import App from "./App.vue";

export const eventBus = new Vue({
  methods: {
    addIdea(ideaText) {
      this.$emit("addedIdea", ideaText);
    }
  }
});

new Vue({
  el: "#app",
  render: h => h(App)
});
