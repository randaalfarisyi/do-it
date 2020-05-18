<template>
<div>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb mt-4 mx-4">
          <li class="breadcrumb-item"><a v-bind:href="'/'" class="breadc">Home</a></li>
          <li class="breadcrumb-item" aria-current="page">nama</li>
          <li class="breadcrumb-item active" aria-current="page">Productive Segments</li>
        </ol>
    </nav>

    <div class="card mx-4">
      <div class="card-body">
        <div class="row">
          <div class="col-md-3">
              <h3 class="m-4">nama</h3>
                <ul class="list-group ml-3">
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/'+this.uuid">General Information</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/UserSegments/'+this.uuid">User Segments</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/IncomeSegments/'+this.uuid">Income Segments</a></li>
                  <li class="list-group-item active side-tab"><a>Productive Segments</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/FamilySegments/'+this.uuid">Family Segments</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/EmergencyContactSegments/'+this.uuid">Emergency Contact Segments</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/BankSegments/'+this.uuid">Bank Segments</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/UploadPicture/'+this.uuid">Upload Picture</a></li>
                </ul>
              <button type="button" class="btn btn-outline-info ml-3 my-3 btn-block">Kembali</button>
              </div>
          <div class="col-md-9 mt-5">
              <h2 class="m-4">Productive Segments</h2>
                <table class="table table-borderless">
                    <tbody>
                        <tr>
                            <th scope="row">Application Name</th>
                            <td>{{prodSeg.applicationName}}</td>
                        </tr>
                        <tr>
                            <th scope="row">Jangka Waktu</th>
                            <td>{{prodSeg.howLong}}</td>
                        </tr>
                        <tr>
                          <th scope="row">Daftar Foto Produk</th>
                          <td>
                            <tr>
                              {{prodSeg.productPhotoList}}
                            </tr>
                          </td>
                        </tr>
                        <tr>
                          <th>Daftar Mutasi Bank</th>
                          <td>
                            <tr v-for="mutasi in prodBankMutation" v-bind:key="mutasi.id">
                                {{mutasi.photo}}
                            </tr>
                          </td>
                        </tr> 
                    </tbody>
                </table>

                <button class="btn btn-info m-2" type="submit">Ubah</button>
            </div>
        </div>
      </div>
    </div>
</div>              
</template>

<script>
import BorrowerDataService from '../service/BorrowerDataService';

export default {
  name: "viewIncomeSegments",
  data(){
    return{
        prodSeg:[],
        prodPhoto:[],
        prodBankMutation:[],
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
        BorrowerDataService.viewProductiveSegments(this.uuid).then(res=> {
            this.prodSeg = res.data;
            this.prodPhoto = this.prodSeg.productPhotoList;
            this.prodBankMutation = this.prodSeg.bankMutationList;
        });
    },
  },
  created(){
    this.refreshBorrowerDetails();
  }
};
</script>

<style>
@import url(//unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.min.css);
@import url(//unpkg.com/bootstrap/dist/css/bootstrap.min.css);

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
color : white;
  text-decoration: none;
}

.selected:hover{
  text-decoration: none;
}
</style>