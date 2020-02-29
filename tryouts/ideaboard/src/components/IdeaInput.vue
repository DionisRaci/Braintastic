<template>
  <div class="container">
    <input
      type="text"
      id="ideaInput"
      v-on:keyup.enter="onEnter"
      v-model="text"
      placeholder="Write your superduper creative idea in here..."
    />
    <button id="ideaSubmit" @click="onSubmitIdea">Sumbit Idea</button>
    <p>{{count}}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      text: "",
      count: 0
    };
  },
  props: {
    ideaText: String
  },
  methods: {
    onSubmitIdea() {
      this.ideaText = this.text;
      console.log(this.ideaText);
      this.count += 1;
      this.clearInput();
    },
    onEnter() {
      document.getElementById("ideaSubmit").click();
    },
    clearInput(event) {
      document.getElementById("ideaInput").blur();
      this.text = "";
    }
  }
};
</script>

<style scoped>
</style>