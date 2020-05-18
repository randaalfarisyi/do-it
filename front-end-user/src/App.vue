<template>
<div class="background">
    <navbar/>
    <router-view/>
</div>
</template>

<script>

import navbar from './components/Navbar';

export default {
  name: 'app',
  components : {
    navbar
  }
};
</script>

<style>
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css)

.background{
    background-color : #F4F5F5;
}

#app {
  padding-left: none !important;
  padding-right: none !important;
  margin-left: none !important;
  margin-right: none !important;
  background-color :#F4F5F5;
}
</style>