<template>
 <div id="login">
    <h1>Login</h1>
    <input type="text" name="" placeholder="Username">
    <input type="password" name="" placeholder="Passwort">
    <button type="button">Login</button>
  </div>
</template>

<style scoped>
h1{
    color: white;
}
 
#login {
        width: 500px;
        border: 10px solid #0174DF;
        background-color: #848484;
        margin: auto;
        margin-top: 200px;
        padding: 20px;
}
button {
        background-color: #0174DF; 
        border:none;
        color: white;
        padding: 10px 25px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
}
input{
     border: none;
     border-bottom: 2px solid #0174DF ;
     color: white;
     background: #848484;
}
::placeholder{
    color: white;

}   
</style>