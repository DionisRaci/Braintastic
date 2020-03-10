<template>
  <div id="join">
    <h1>Join</h1>
    <input type="code" name placeholder="Register-Code" />
    <input type="password" name placeholder="Passwort" />
    <button type="button">Join</button>
  </div>
</template>


<style scoped>
h1 {
  color: white;
}
#join {
  width: 500px;
  border: 10px solid #0174df;
  background-color: #848484;
  margin: auto;
  margin-top: 200px;
  padding: 20px;
}
button {
  background-color: #0174df;
  border: none;
  color: white;
  padding: 10px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}
input {
  border: none;
  border-bottom: 1px solid #0174df;
  color: white;
  background: #848484;
}
::placeholder {
  color: white;
}
</style>
