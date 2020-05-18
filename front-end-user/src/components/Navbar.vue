<template>
  <nav class="navbar navbar-expand-lg custom-nav">
    <a class="navbar-brand" v-bind:href="'/'">
        <img src="../assets/LogoDoIt.png" width="60" height="30" alt="">
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse align-right" id="navbarText">
        <span class="navbar-text">
        Admin
        </span>
    </div>
 </nav>
</template>

<style>
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css);

.custom-nav {
    background-color : white;
    color : #000000;
}
</style>
