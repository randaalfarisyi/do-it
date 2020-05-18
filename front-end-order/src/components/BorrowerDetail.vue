<template>
<div class="" id="tabel">
  <nav aria-label="breadcrumb">
        <ol class="breadcrumb mt-4 mx-4">
          <li class="breadcrumb-item"><a href="/borrowerList">Borrower</a></li>
          <li class="breadcrumb-item active" aria-current="page"><a href="/borrowerList">Borrower List</a></li>
          <li class="breadcrumb-item active" aria-current="page">Detail Order {{borrower.name}}</li>
        </ol>
    </nav>

    <div class="row">
       <div class="col-md-12">
           <div class="card">
               <div class="card-body">
                        <h4>Detail Borrower</h4>
                   <div class="card-body">
                <div class="row">
                  <div class="col-md-3">Nama</div><div class="col-md-2">{{borrower.name}}</div>
                </div>
                <div class="row">
                  <div class="col-md-3">Umur</div><div class="col-md-6">{{borrower.age}} Tahun</div>
                </div>
                <div class="row">
                  <div class="col-md-3">Jenis Kelamin</div><div class="col-md-2">{{borrower.gender}}</div>
                </div>
                 <div class="row">
                  <div class="col-md-3">Email</div><div class="col-md-4">{{borrower.email}}</div>
                </div>
                <div class="row">
                  <div class="col-md-3">No Handphone</div><div class="col-md-2">{{borrower.number}}</div>
                </div>
                <div class="row">
                  <div class="col-md-3">Alamat</div><div class="col-md-6">{{borrower.address}}</div>
                </div>
               
                <div class="row">
                  <div class="col-md-3">Tempat Kerja</div><div class="col-md-6">{{borrower.workPlace}}</div>

                </div>
                <div class="row">
                  <div class="col-md-3">Alamat Tempat Kerja</div><div class="col-md-6">{{borrower.workAddress}}</div>

                </div>
            </div>
            <div class="row">
                <div class="col-lg-2">
                            <div class="card card-bordered loan">
                                <div class="card-body">
                                    <h6 class="title">Total Order</h6>
                                    <h4 class="card-text">
                                   <strong style="float:right">   {{borrower.totalOrder}} </strong>
                                    </h4>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="card card-bordered loan">
                                <div class="card-body">
                                    <h6 class="title">Installment Loan</h6>
                                    <h4 class="card-text">
                                   <strong style="float:right">  {{borrower.countInstallment}} </strong>
                                    </h4>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-2">
                            <div class="card card-bordered loan">
                                <div class="card-body">
                                    <h6 class="title">Normal Loan</h6>
                                    <h4 class="card-text">
                                   <strong style="float:right">   {{borrower.countNormal}} </strong>
                                    </h4>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3">
                            <div class="card card-bordered loan">
                                <div class="card-body">
                                    <h6 class="title">Total Overdue Order</h6>
                                    <h4 class="card-text">
                                   <strong style="float:right">   {{borrower.overdueCount}} </strong>
                                    </h4>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-2">
                            <div class="card card-bordered loan">
                                <div class="card-body">
                                    <h6 class="title">Order Finish</h6>
                                    <h4 class="card-text">
                                   <strong style="float:right">   {{borrower.countFinish}} </strong>
                                    </h4>
                                </div>
                            </div>
                        </div>
            </div>
             <div class="col-md-12 card-body">
            <h5 class="title">Riwayat Order</h5>
              <div class="col-12" style="overflow-x:auto;">
            
            
              <table class="table" id="">
                <thead>
                  <tr>
                    <th style="display:none">id</th>
                    <th style="display:none">uuid</th>
                    <th>Disbursed Date</th>
                    <th>Repaid Date</th>
                    <th>Disbursed Amount</th>
                    <th>Repaid Amount</th>
                    <th>Product Type</th>
                    <th>Status</th>
                    <th>Overdue</th>
                    
                  </tr>
                </thead>
                <tbody>
                <tr v-for="orderB in borrower.orderHistory.slice().reverse()" v-bind:key="orderB.uuid" >
                  
                    <td style="display:none"></td>
                    <td style="display:none">{{orderB.uuid}}</td>
                    <!--<td><router-link :to="{ name: 'order', params: { uuid: orderB.uuid }}">{{orderB.borrowerName}}</router-link></td>-->
                    <td>{{orderB.lending_date | formatDateV1}}</td>
                    <td>{{orderB.repaid_date | formatDateV1}}</td>
                    <td>{{formatPrice(orderB.disbursed_amount)}}</td>
                    <td>{{formatPrice(orderB.repaid_amount)}}</td>
                    <td>{{orderB.product_type}}</td>
                    <td><b>{{orderB.status}}</b></td>
                    <td>{{orderB.overdue_day}} day</td>
                    
              

                </tr>
                </tbody>
              </table>
            
            </div>


          </div>
               </div>
            </div>
        </div>
   </div>
</div>
</template>
 
<script>
import http from "../http-common";


export default {
  name: "BorrowerDetail",
  data() {
    return {
      borrower: [],
    
    };
  },
  computed:{
    uuid(){
        return this.$route.params.uuid;
    }
  },
  methods: {
    /* eslint-disable no-console */
    retrieveOrders() {
      http
        .get(`/borrower/${this.uuid}`)
        .then(response => {
          this.borrower = response.data; // JSON are parsed automatically.
        })
        this.$router.get(`/borrower/${this.uuid}`);
    },

    refreshList() {
      this.retrieveOrders();
    },
    formatPrice(value) {
        let val = (value/1).toFixed(0).replace('.', ',')
        return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".")
    }
    
    /* eslint-enable no-console */
  },
  mounted() {
    this.retrieveOrders();
  }
};

</script>
 <style>
  h5.title{
    font-weight: 700 !important;
  }

  h6 {
      font-weight: 700 !important;
  }

  .loan{
  background-color:#33E4D2!important;
}
 </style>


