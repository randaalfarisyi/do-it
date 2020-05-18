<template>
  <div class="m-4">
    <table class="table">
      <thead>
        <th>Nama</th>
        <th>Email</th>
        <th>Nomor HP</th>
        <th>Status</th>
        <th>Last Update</th>
        <th></th>
      </thead>
      <tbody>
        <tr v-for="borrower in borrowers" v-bind:key="borrower.id">
          <td>{{borrower.name}}</td>
          <td>{{borrower.email}}</td>
          <td>{{borrower.mobilePhoneNumber}}</td>
          <td>
          <div v-if="borrower.disabled == 0">
            <p>Aktif</p>
          </div>
          <div v-else>
            <p>Nonaktif</p>
          </div>
          </td>
          <td>{{borrower.updatedTime}}</td>
          <td><button class="btn btn-info" v-on:click="viewBorrowerClicked(borrower.uuid)">Lihat</button></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import BorrowerDataService from '../service/BorrowerDataService';
export default {
  name: "BorrowerList",
  data(){
    return{
        borrowers:[],
        nama : "",
        message: null
    };
  },
  methods: {
    refreshBorrower() {
      BorrowerDataService.retrieveAllBorrower()
        .then(response => {
          this.borrowers = response.data;
        });
    }, 
      viewBorrowerClicked(uuid){
        BorrowerDataService.viewBorrower(uuid);
        this.$router.push(`/borrower/lihat/${uuid}`);
    },
  },
  created() {
    this.refreshBorrower();
  }
};
</script>

<style>
@import url(https://unpkg.com/bootstrap@4.1.0/dist/css/bootstrap.min.css)
</style>