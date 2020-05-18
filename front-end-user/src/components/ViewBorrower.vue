<template>
<div>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb mt-4 mx-4">
          <li class="breadcrumb-item"><a v-bind:href="'/'">Home</a></li>
          <li class="breadcrumb-item active" aria-current="page">{{borrower.name}}</li>
        </ol>
    </nav>

    <div class="card mx-4">
      <div class="card-body">
        <div class="row">
          <div class="col-md-3">
              <h3 class="m-4">{{borrower.name}}</h3>
                <ul class="list-group ml-3">
                  <li class="list-group-item active"><a class="selected">General Information</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/UserSegments/'+borrower.uuid">User Segments</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/IncomeSegments/'+borrower.uuid">Income Segments</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/ProductiveSegments/'+borrower.uuid">Productive Segments</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/FamilySegments/'+borrower.uuid">Family Segments</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/EmergencyContactSegments/'+borrower.uuid">Emergency Contact Segments</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/BankSegments/'+borrower.uuid">Bank Segments</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/UploadPicture/'+borrower.uuid">Upload Picture</a></li>
                </ul>
              <button type="button" class="btn btn-outline-info ml-3 my-3 btn-block">Kembali</button>
              </div>
          <div class="col-md-9 mt-5">
            <h4 class="my-4">General Information</h4>
              <table class="table table-borderless">
                  <tbody>
                      <tr>
                        <th scope="row">Status</th>
                        <td v-if="borrower.disabled == 0">
                          <p>Aktif</p>
                        </td>
                        <td v-else>
                          <p>Nonaktif</p>
                        </td>
                      </tr>
                      <tr>
                        <th scope="row">Email</th>
                        <td>{{borrower.email}}</td>
                      </tr>
                      <tr>
                        <th scope="row">Nomor HP</th>
                        <td>{{borrower.mobilePhoneNumber}}</td>
                      </tr>
                      <tr>
                        <th></th>
                        <td><button class="btn btn-info float-right mr-5" type="submit" v-on:click="editBorrowerClicked(borrower.uuid)">Ubah</button></td>
                      </tr>
                  </tbody>
              </table>
            </div>
        </div>
      </div>
    </div>
</div>              
</template>

<script>
import BorrowerDataService from '../service/BorrowerDataService';

export default {
  name: "viewBorrower",
  data(){
    return{
        borrower:[],
        errors:[],
        message: null
    };
  },
  computed:{
    uuid(){
        return this.$route.params.uuid;
    }
  },
  methods : {
    refreshBorrowerDetails(){
        BorrowerDataService.viewBorrower(this.uuid).then(res=> {
            this.borrower = res.data;
            console.log(this.borrower.name);
        });
    },
      editBorrowerClicked(uuid) {
        this.$router.push(`/borrower/ubah/${uuid}`);
    },
  },
  created(){
    this.refreshBorrowerDetails();
  }
};
</script>

<style>
@import url(//unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.min.css)
@import url(//unpkg.com/bootstrap/dist/css/bootstrap.min.css)

a{
  color :black;
  text-decoration:none;
}

.container{
  background-color : white;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}

.list-group-item .active{
  background-color : #03D0B6;
  color : white;
}

.background{
  background-color : #F4F5F5;
}

.breadcrumb{
  background-color : #FFFFFF;
}

.breadcrumb-item{
  color : #03D0B6;
}

.selected{
  color :white;
  text-decoration: none;
}

.selected:hover{
  text-decoration: none;
}
</style>