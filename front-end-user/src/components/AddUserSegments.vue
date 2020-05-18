<template>
    <div>
        <h4 class="m-3">User Segments</h4>
        <form>
            <fieldset class="form-group">
                <label>Nama Lengkap</label>
                <input type="text" class="form-control" v-model="userSegments.fullName">
            </fieldset>
            <fieldset class="form-group">
                <label>Email</label>
                <input type="email" class="form-control" v-model="userSegments.email">
            </fieldset>
            <fieldset class="form-group">
                <label>Tempat Lahir</label>
                <input type="text" class="form-control" v-model="userSegments.birthCity">
            </fieldset>
            <fieldset class="form-group">
                <label>Tanggal Lahir</label>
                <input type="date" class="form-control" v-model="userSegments.birthDate">
            </fieldset>
            <fieldset class="form-group">
                <label>Agama</label>
                <label for="inputState" v-model="userSegments.religion"></label>
                <select id="inputState" class="form-control">
                    <option selected>Islam</option>
                    <option>Kristen</option>
                    <option>Budha</option>
                    <option>Hindu</option>
                </select>
            </fieldset>
            <fieldset class="form-group">
                <label>Jenis Kelamin</label>
                <label for="inputState" v-model="userSegments.gender"></label>
                <select id="inputState" class="form-control">
                    <option selected>Laki-laki</option>
                    <option>Perempuan</option>
                </select>
            </fieldset>
            <fieldset class="form-group">
                <label>Pendidikan Terakhir</label>
                <label for="inputState" v-model="userSegments.education"></label>
                <select id="inputState" class="form-control">
                    <option selected>Sarjana</option>
                    <option>Doktor</option>
                    <option>Sarjana</option>
                    <option>SMA</option>
                    <option>SMP</option>
                    <option>SD</option>
                </select>
            </fieldset>
            <fieldset class="form-group">
                <label>Detail Alamat Rumah</label>
                <input type="textarea" class="form-control" v-model="userSegments.homeAddrDetails">
            </fieldset>
            <h5 class="mt-2">Nomor Telepon</h5>
            <hr/>
            <fieldset class="form-group">
                <label>Telepon Rumah</label>
                <input type="text" class="form-control" v-model="userSegments.areaCode">
                <input type="text" class="form-control" v-model="userSegments.phoneNumber">
            </fieldset>
            <fieldset class="form-group">
                <label>Telepon Alternatif</label>
                <input type="text" class="form-control" v-model="userSegments.areaCode">
                <input type="text" class="form-control" v-model="userSegments.phoneNumber">
            </fieldset>
            <fieldset class="form-group">
                <label>Konfirmasi PIN Baru</label>
                <input type="password" class="form-control">
            </fieldset>
            <button class="btn btn-outline-info m-2" type="submit">Batal</button>
            <button class="btn btn-info m-2" type="submit">Simpan</button>
        </form>
    </div>
</template>

<script>
import BorrowerDataService from '../service/BorrowerDataService';

export default {
  name: "userSegments",
  data(){
    return{
        borrower:[],
        userSegments:[],
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
            this.userSegments = res.data.userSegmentsList;
        });
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
</style>