<template>
  <nav class="navbar navbar-expand-lg custom-nav">
    <a class="navbar-brand" href="/" id="logo">
        <img src="../assets/LogoDoIt.png" width="70" height="38" alt="">
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText">
        <span class="navbar-text">
        <h5></h5>
        </span>
    </div>
    
    <div style="float : right;"> <p style="margin:1%;">{{new Date().toDateString()}}</p> </div>
    
    <div class="row" style="float : right; margin-right:1%">
    <div class="col-md-9"><p style="margin: 1%; float:right"> Nama disini</p></div>
    <div class="col-md-3"><img src="../assets/logo.png" width="30" height="30" alt=""></div>
    </div>
 </nav>
 
</template>

<style>
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css);

.custom-nav {
    background-color : #FFFFFF;
    color : #000000;
}
#logo{
  margin-left:0.5% ;
}
</style>
