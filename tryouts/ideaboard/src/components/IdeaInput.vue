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