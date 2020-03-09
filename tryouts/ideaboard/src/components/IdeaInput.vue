<template>
  <div class="container">
    <input
      type="text"
      id="ideaInput"
      v-on:keyup.enter="onEnter"
      v-model="ideaText"
      placeholder="Write your superduper creative idea in here..."
    />
    <button id="ideaSubmit" @click="onSubmitIdea">Sumbit Idea</button>
  </div>
</template>

<script>
import { eventBus } from "../main";

export default {
  data() {
    return {
      ideaText: "",
      count: 0
    };
  },
  methods: {
    onSubmitIdea() {
      eventBus.addIdea(this.ideaText);

      this.count += 1;
      this.clearInput();
    },
    onEnter() {
      document.getElementById("ideaSubmit").click();
    },
    clearInput(event) {
      document.getElementById("ideaInput").blur();
      this.ideaText = "";
    }
  }
};
</script>

<style scoped>
.container {
  position: absolute;
  width: 80%;
  bottom: 0;
  left: 0;
  margin-left: 10%;
  margin-right: 10%;
}

button {
  float: right;
  width: 20%;
  margin: 8px 0;
  box-sizing: border-box;
  border: 3px solid sandybrown;
  padding: 12px 20px;
  background-color: sandybrown;
  -webkit-transition: 0.5s;
  transition: 0.5s;
  outline: none;
}

button:hover {
  border: 3px solid #555;
}

input[type="text"] {
  width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: 3px solid #ccc;
  -webkit-transition: 0.5s;
  transition: 0.5s;
  outline: none;
}

input[type="text"]:focus {
  border: 3px solid #555;
}
</style>
