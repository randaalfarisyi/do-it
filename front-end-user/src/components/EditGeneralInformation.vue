<template>
<div>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb mt-4 mx-4">
          <li class="breadcrumb-item"><a v-bind:href="'/'">Home</a></li>
          <li class="breadcrumb-item active" aria-current="page">{{nama}}</li>
          <li class="breadcrumb-item active" aria-current="page">Edit General Information</li>
        </ol>
    </nav>

    <div class="card mx-4">
      <div class="card-body">
        <div class="row">
          <div class="col-md-3">
              <h3 class="m-4">{{nama}}</h3>
                <ul class="list-group m-4">
                  <li class="list-group-item active">General Information</li>
                  <li class="list-group-item">User Segments</li>
                  <li class="list-group-item">Income Segments</li>
                  <li class="list-group-item">Productive Segments</li>
                  <li class="list-group-item">Family Segments</li>
                  <li class="list-group-item">Emergency Contact Segments</li>
                  <li class="list-group-item">Bank Segments</li>
                  <li class="list-group-item">Upload Picture</li>
                </ul>
              <button type="button" class="btn btn-outline-info my-3 btn-block">Kembali</button>
              </div>
          <div class="col-md-9 mt-5">
                <h4 class="m-3">General Information</h4>
                    <form>
                        <fieldset class="form-group">
                            <label>Status</label>
                            <select class="form-control" id="disabled" v-model="borrower.disabled">
                              <option>1</option>
                              <option>0</option>
                            </select>
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Email</label>
                            <input type="email" id="email" class="form-control" v-model="borrower.email">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Nomor HP</label>
                            <input type="text" id="mobilePhoneNumber" class="form-control" v-model="borrower.mobilePhoneNumber">
                        </fieldset>
            
                        <button class="btn btn-outline-info m-2">Batal</button>
                        <button class="btn btn-info m-2" type="submit" v-on:click="updateBorrower()">Simpan</button>
                    </form>
            </div>
        </div>
      </div>
    </div>
</div> 
</template>

<script>
import BorrowerDataService from '../service/BorrowerDataService';

export default {
  name: "EditGeneralInformation",
  data(){
    return{
        borrower:[],
        nama : "",
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
            console.log(this.borrower.uuidBorrower);
        });
    },
    getNama(){
        BorrowerDataService.getNama(this.uuid).then(res=> {
            this.nama=res.data;
        });
    },
    updateBorrower() {
      BorrowerDataService.updateBorrower(this.uuid,{
        email:this.borrower.email,
        disabled: this.borrower.disabled,
        mobilePhoneNumber : this.borrower.mobilePhoneNumber
      })
      .then(() => {
        this.$router.push(`/borrower/lihat/${this.uuid}`);
      })
      .catch(e => {
        console.log(e);
      });
    }
  },
  created(){
    this.refreshBorrowerDetails();
    this.getNama();
  }
};
</script>

<style>
@import url(//unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.min.css);
@import url(//unpkg.com/bootstrap/dist/css/bootstrap.min.css);
</style>