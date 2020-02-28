<template>
  <div>
    <div class="card shadow1">
      <div class="content">
        <p></p>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
p {
  font-size: 14px;
}
.content {
}

textarea {
  padding: 5px;
  border: 1px solid white;
  resize: none;
}
textarea:hover {
  padding: 5px;
  border: 1px solid white;
  resize: both;
}
textarea:after {
  padding: 5px;
  border: 1px solid black;
  resize: both;
}

.card {
  background: #fff;
  display: inline-block;
}
</style>