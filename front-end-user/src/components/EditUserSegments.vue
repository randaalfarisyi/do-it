<template>
<div>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb mt-4 mx-4">
          <li class="breadcrumb-item"><a v-bind:href="'/'">Home</a></li>
          <li class="breadcrumb-item active" aria-current="page">{{nama}}</li>
          <li class="breadcrumb-item active" aria-current="page">Edit User Segments</li>
        </ol>
    </nav>

    <div class="card mx-4">
      <div class="card-body">
        <div class="row">
          <div class="col-md-3">
              <h3 class="m-4">{{nama}}</h3>
                <ul class="list-group m-4">
                  <li class="list-group-item">General Information</li>
                  <li class="list-group-item active">User Segments</li>
                  <li class="list-group-item">Income Segments</li>
                  <li class="list-group-item">Productive Segments</li>
                  <li class="list-group-item">Family Segments</li>
                  <li class="list-group-item">Emergency Contact Segments</li>
                  <li class="list-group-item">Bank Segments</li>
                  <li class="list-group-item">Upload Picture</li>
                </ul>
              <button type="button" class="btn btn-outline-info my-3 btn-block">Kembali</button>
              </div>
          <div class="col-md-9 mt-4">
                <h4 class="my-4">User Segments</h4>
                    <form class="mx-4">
                         <input type="hidden" id="uuid" v-model="this.uuid" value="3487">
                        <fieldset class="form-group">
                            <label>Nama Lengkap</label>
                            <input type="text" class="form-control" id="fullName" v-model="borrower.fullName">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Email</label>
                            <input type="email" class="form-control" id="email" v-model="borrower.email">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Tempat Lahir</label>
                            <input type="text" class="form-control" id="birthCity" v-model="borrower.birthCity">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Tanggal Lahir</label>
                            <input type="date" class="form-control" id="birthDate" v-model="borrower.birthDate">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Agama</label>
                            <select class="form-control" id="religion" v-model="borrower.religion">
                                <option>Islam</option>
                                <option>Kristen</option>
                                <option>Protestan</option>
                                <option>Hindu</option>
                                <option>Budha</option>
                            </select>
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Jenis Kelamin</label>
                            <select class="form-control" id="gender" v-model="borrower.gender">
                                <option>Laki-laki</option>
                                <option>Perempuan</option>
                            </select>
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Agama</label>
                            <select class="form-control" id="education" v-model="borrower.education">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </fieldset>
                        <fieldset class="form-group">
                            <label for="exampleFormControlTextarea1">Alamat Rumah</label>
                            <textarea class="form-control" id="homeAddrDetails" rows="3" v-model="borrower.homeAddrDetails"></textarea>
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Provinsi</label>
                            <select class="form-control" id="province" v-model="borrower.province">
                                <option>Jawa Barat</option>
                                <option>Jawa Timur</option>
                                <option>DKI Jakarta</option>
                                <option>Banten</option>
                            </select>
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Kota</label>
                            <select class="form-control" id="city" v-model="borrower.city">
                                <option>Kota Bogor</option>
                                <option>Kota Bandung</option>
                            </select>
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Kabupaten</label>
                            <select class="form-control" id="district" v-model="borrower.district">
                                <option>Kota Bogor</option>
                                <option>Kota Bandung</option>
                            </select>
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Kelurahan</label>
                            <select class="form-control" id="subdistrict" v-model="borrower.subdistrict">
                                <option>Kota Bogor</option>
                                <option>Kota Bandung</option>
                            </select>
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Desa</label>
                            <select class="form-control" id="village" v-model="borrower.village">
                                <option>Kota Bogor</option>
                                <option>Kota Bandung</option>
                            </select>
                        </fieldset>
                        <fieldset class="form-group">
                            <label for="exampleFormControlTextarea1">Nomor Rumah</label>
                                <input type="text" class="form-control" id="kodeArea" v-model="borrower.kodeArea" placeholder="Kode Area">
                                <input type="text" class="form-control" id="nomorRumah" v-model="borrower.nomorRumah" placeholder="Nomor Telepon Rumah">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Nomor Telepon Alternatif</label>
                            <select class="form-control" id="contactType" v-model="borrower.alternativeMobilePhoneList.contactType" placeholder="Tipe Kontak">
                                <option>Handphone</option>
                                <option>Telepon Rumah</option>
                            </select>
                            <input type="text" class="form-control" id="phoneNumber" v-model="borrower.alternativeMobilePhoneList.phoneNumber" placeholder="Nomor Telepon">   
                        </fieldset>
                        <button class="btn btn-outline-info m-2" type="submit" >Batal</button>
                        <button class="btn btn-info m-2" type="submit" v-on:click="editUserSegments() ">Simpan</button>
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
  name: "editUserSegments",
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
        BorrowerDataService.retrieveBorrowerByUuid(this.uuid).then(res=> {
            this.borrower = res.data;
        });
    },
    getNama(){
        BorrowerDataService.getNama(this.uuid).then(res=> {
            this.nama=res.data;
            console.log(this.nama);
        });
    },
    editUserSegments() {
      BorrowerDataService.updateUserSegments(this.uuid, {
        fullName:this.borrower.email,
        email: this.borrower.disabled,
        mobilePhoneNumber : this.borrower.mobilePhoneNumber,
        birthCity : this.borrower.birthCity,
        birthDate:this.borrower.birthDate,
        religion:this.borrower.religion,
        gender:this.borrower.gender,
        education:this.borrower.education,
        homeAddrDetails:this.borrower.homeAddrDetails,
        city:this.borrower.city,
        district:this.borrower.district,
        subdistrict:this.borrower.subdistrict,
        village:this.borrower.village,
        kodeArea:this.borrower.kodeArea,
        nomorRumah:this.borrower.nomorRumah,
        contactType:this.borrower.alternativeMobilePhoneList.contactType,
        phoneNumber:this.borrower.alternativeMobilePhoneList.phoneNumber
      }).then(() => {
            this.$router.push(`/borrower/lihat/UserSegments/${this.uuid}`);
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
@import url(//unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.min.css)
@import url(//unpkg.com/bootstrap/dist/css/bootstrap.min.css)
</style>