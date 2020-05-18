<template>
<div class="landing">
    <div class="row">
      <div class="col-md-12">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb mt-4 mx-4">
              <li class="breadcrumb-item"><a v-bind:href="'/'">Home</a></li>
              <li class="breadcrumb-item active" aria-current="page">Daftar User</li>
            </ol>
        </nav>
      </div>
    </div>

    <div class="col-md-12">
      <div class="list row">
          <div class="col-md-12">
            <div class="card mx-4">
              <div class="card-body">
                <h1 class="m-4">Daftar User</h1>
                <button type="button" class="btn btn-outline-info mx-4" v-on:click="addBorrower()">Tambah</button>

                <form class="form-inline m-3 my-lg-3 float-right">
                  <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                  <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>                
                <BorrowerList></BorrowerList>
              </div>
            </div>
          </div>
      </div>
    </div>
</div>
</template>

<script>
import BorrowerList from "./BorrowerList";
export default {
  name: "Home",
  components: {
    BorrowerList
  },
  methods: {
      addBorrower(){
        this.$router.push(`/tambah`);
    },
  }
};
</script>

<style scoped>
.landing{
  background-color : #F4F5F5;
}

table{
  width:100%;
  border-style : none;
}

.breadcrumb{
  background-color : #FFFFFF;
}

.breadcrumb-item{
  color : #03D0B6;
}
</style>

<style>
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css)
</style>