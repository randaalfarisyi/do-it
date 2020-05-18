<template>
<div>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb mt-4 mx-4">
          <li class="breadcrumb-item"><a v-bind:href="'/'" class="breadc">Home</a></li>
          <li class="breadcrumb-item" aria-current="page">{{userSegments.fullName}}</li>
          <li class="breadcrumb-item active" aria-current="page">User Segments</li>
        </ol>
    </nav>

    <div class="card mx-4">
      <div class="card-body">
        <div class="row">
          <div class="col-md-3">
              <h3 class="m-4">{{userSegments.fullName}}</h3>
                <ul class="list-group ml-3">
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/'+this.uuid">General Information</a></li>
                  <li class="list-group-item active side-tab"><a class="selected">User Segments</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/IncomeSegments/'+this.uuid">Income Segments</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/ProductiveSegments/'+this.uuid">Productive Segments</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/FamilySegments/'+this.uuid">Family Segments</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/EmergencyContactSegments/'+this.uuid">Emergency Contact Segments</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/BankSegments/'+this.uuid">Bank Segments</a></li>
                  <li class="list-group-item"><a v-bind:href="'/borrower/lihat/UploadPicture/'+this.uuid">Upload Picture</a></li>
                </ul>
              <button type="button" class="btn btn-outline-info ml-3 my-3 btn-block">Kembali</button>
              </div>
          <div class="col-md-9 mt-5">
              <h2 class="m-4">User Segments</h2>
                <table class="table table-borderless">
                    <tbody>
                        <tr>
                            <th scope="row">Nama Lengkap</th>
                            <td>{{userSegments.fullName}}</td>
                        </tr>
                        <tr>
                            <th scope="row">Email</th>
                            <td>{{userSegments.email}}</td>
                        </tr>
                        <tr>
                            <th scope="row">Tempat Lahir</th>
                            <td>{{userSegments.birthCity}}</td>
                        </tr>
                        <tr>
                            <th scope="row">Tanggal Lahir</th>
                            <td>{{userSegments.birthDate}}</td>
                        </tr>
                        <tr>
                            <th scope="row">Agama</th>
                            <td>{{userSegments.religion}}</td>
                        </tr>
                        <tr>
                            <th scope="row">Jenis Kelamin</th>
                            <td>{{userSegments.gender}}</td>
                        </tr>
                        <tr>
                            <th scope="row">Pendidikan Terakhir</th>
                            <td>{{userSegments.education}}</td>
                        </tr>
                        <tr>
                            <th scope="row">Alamat Rumah</th>
                            <td>{{userSegments.homeAddrDetails}}</td>
                        </tr>
                        <tr>
                          <th scope="row">Area Alamat</th>
                          <td>
                            <tr>
                              <td>Provinsi</td>
                              <td>: {{userSegments.province}}</td>
                            </tr>
                            <tr>
                              <td>Kota</td>
                              <td>: {{userSegments.city}}</td>
                            </tr>
                            <tr>
                              <td>Kabupaten</td>
                              <td>: {{userSegments.district}}</td>
                            </tr>
                            <tr>
                              <td>Kelurahan</td>
                              <td>: {{userSegments.subdistrict}}</td>
                            </tr>
                            <tr>
                              <td>Desa</td>
                              <td>: {{userSegments.village}}</td>
                            </tr>     
                          </td>
                        </tr>
                        <h5 class="m-2">Nomor Telepon</h5>
                        <hr>
                        <tr v-for="hp in homePhone" v-bind:key="hp.id">
                          <th>Telepon Rumah</th>
                          <td>
                            {{hp.areaCode}} {{hp.phoneNumber}}
                          </td>
                        </tr> 
                        <tr> 
                          <th scope="row">Nomor Telepon Alternatif</th>
                          <td>
                            <tr v-for="althp in altHP" v-bind:key="althp.id">
                              <td>{{userSegments.kodeArea[althp.id]}} </td>
                              <td>{{althp.phoneNumber}}</td>
                            </tr>
                           </td>
                        </tr>
                        
                    </tbody>
                </table>

                <button class="btn btn-info m-2" type="submit" v-on:click="editBorrowerClicked(userSegments.uuidBorrower)">Ubah</button>
            </div>
        </div>
      </div>
    </div>
</div>              
</template>


<script>
import BorrowerDataService from '../service/BorrowerDataService';

export default {
  name: "viewUserSegments",
  data(){
    return{
        userSegments:[],
        homePhone :[],
        homeAddr : [],
        altHP:[],
        errorStatus:"",
        message: null
    };
  },
  computed:{
    uuid(){
        return this.$route.params.uuid;
    }
  },
  methods : {
    refreshUserSegments(){
        BorrowerDataService.viewUserSegments(this.uuid).then(res=> {
            this.userSegments = res.data;
            this.homePhone=res.data.homePhoneList;
            this.altHP = res.data.alternativeMobilePhoneList;
            this.homeAddr=res.data.homeAddrRegionList;
            console.log(this.userSegments.uuidBorrower);
        })
        .catch(error => {
        if (!error.response) {
            // network error
            this.errorStatus = 'Error: Network Error';
        } else {
            this.errorStatus = error.response.data.message;
        }
      });
    },
    editBorrowerClicked(uuid){
      this.$router.push(`/borrower/ubah/UserSegments/${uuid}`);
    }
  },
  created(){
    this.refreshUserSegments();
  }
};
</script>

<style>
@import url(//unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.min.css)
@import url(//unpkg.com/bootstrap/dist/css/bootstrap.min.css)

a .breadc{
  color : black;
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

.side-tab{
  background-color : #03D0B6;
}

.selected{
  color :white;
  text-decoration: none;
}

.selected:hover{
  text-decoration: none;
}

</style>