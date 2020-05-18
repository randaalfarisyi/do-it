<template>
<div class="" id="tabel">
  <nav aria-label="breadcrumb">
        <ol class="breadcrumb mt-4 mx-4">
          <li class="breadcrumb-item"><a href="/orders">Order</a></li>
          <li class="breadcrumb-item active" aria-current="page"><a href="/orders">Order List</a></li>
          <li class="breadcrumb-item active" aria-current="page">Detail Order {{order.borrowerName}}</li>
        </ol>
    </nav>
    <div class="row">
        <div class="col-md-12">
          <div class="card">
            <div class="card-body">
            
            <div class="card-body">
                <div class="row">
                  <div class="col-md-3">Nama</div><div class="col-md-2">{{order.borrowerName}}</div>
                </div>
                <div class="row">
                  <div class="col-md-3">Id Borrower</div><div class="col-md-6">{{order.uuidBorrower}}</div>
                </div>
                <div class="row">
                  <div class="col-md-3">Product Category</div><div class="col-md-4">{{order.nameProductCategory}}</div>
                </div>
                <div class="row">
                  <div class="col-md-3">Disbursed Date</div><div class="col-md-2">{{order.createdTime | formatDate}}</div>
                </div>
                 <div class="row">
                  <div class="col-md-3">Repaid Date</div><div class="col-md-2">{{order.dueDate | formatDate}}</div>
                </div>
                <div class="row">
                  <div class="col-md-3">Disbursed Amount</div><div class="col-md-2">{{formatPrice(order.borrowingAmount)}}</div>
                  </div>
                  <div class="row">
                    <div class="col-md-3" style="float : right !important;">Repaid Amount</div><div class="col-md-2">{{formatPrice(order.repayAmount)}}</div>
                  </div>
                <div class="row">
                  <div class="col-md-3">Product Type</div><div class="col-md-2">{{order.nameProductType}}</div>
                </div>
                <div class="row">
                  <div class="col-md-3">Status</div><div class="col-md-3"><b>{{order.status}}</b></div>
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
                    <th>Product Category</th>
                    <th>Status</th>
                    <th>Overdue</th>
                    
                  </tr>
                </thead>
                <tbody>
                <tr v-for="orderB in order.listOrderBorrower.slice().reverse()" v-bind:key="orderB.uuid" >
                  
                    <td style="display:none"></td>
                    <td style="display:none">{{orderB.uuid}}</td>
                    <!--<td><router-link :to="{ name: 'order', params: { uuid: orderB.uuid }}">{{orderB.borrowerName}}</router-link></td>-->
                    <td>{{orderB.createdTime | formatDateV1}}</td>
                    <td>{{orderB.dueDate | formatDateV1}}</td>
                    <td>{{formatPrice(orderB.borrowingAmount)}}</td>
                    <td>{{formatPrice(orderB.repayAmount)}}</td>
                    <td>{{orderB.nameProductType}}</td>
                    <td>{{orderB.nameProductCategory}}</td>
                    <td><b>{{orderB.status}}</b></td>
                    <td>{{orderB.overdue_day}} day</td>
                    
              

                </tr>
                </tbody>
              </table>
            
            </div>


          </div>
          <div class="card-body">
            <h5 class="title">Data Borrower</h5>
            <div class="card-body">
                <div class="row">
                  <div class="col-md-3">Nama</div><div class="col-md-2">{{order.borrowerName}}</div>
                </div>
                <div class="row">

                  <div class="col-md-3">Tempat/Tanggal Lahir</div><div class="col-md-4">{{order.borrowerBirthPlace}}/{{order.borrowerBirthDate | formatDate}}</div>
                </div>
                <div class="row">
                  <div class="col-md-3">Umur</div><div class="col-md-6">{{order.borrowerAge}} Tahun</div>
                </div>
                <div class="row">
                  <div class="col-md-3">Jenis Kelamin</div><div class="col-md-2">{{order.borrowerGender}}</div>
                </div>
                 <div class="row">
                  <div class="col-md-3">Email</div><div class="col-md-4">{{order.borrowerEmail}}</div>
                </div>
                <div class="row">
                  <div class="col-md-3">Nomor Hp</div><div class="col-md-2">{{order.borrowerNumber}}</div>
                </div>
                <div class="row">
                  <div class="col-md-3">Alamat</div><div class="col-md-6">{{order.borrowerAddress}}</div>
                </div>
                <div class="row">
                  <div class="col-md-3">Tempat Kerja</div><div class="col-md-4">{{order.borrowerWorkPlace}}</div>

                </div>
                <div class="row">
                  <div class="col-md-3"></div><div class="col-md-3"><b></b></div>
                </div>
            </div>
          </div>
          <div class="col-md-12 card-body">
            <h5 class="title">List Emergency Call</h5>
              <div class="col-12" style="overflow-x:auto;">
            
            
              <table class="table" id="">
                <thead>
                  <tr>
                    <th style="display:none">id</th>
                    <th style="display:none">uuid</th>
                    <th>Hubungan</th>
                    <th>Nama</th>
                    <th>Jenis Kelamin</th>
                    <th>Tipe Kontak</th>
                    <th>Nomor Hp</th>
                    
                  </tr>
                </thead>
                <tbody>
                <tr v-for="orderC in order.listContactEmergency" v-bind:key="orderC.uuid" >
                  
                    <td style="display:none"></td>
                    <td style="display:none">{{orderC.uuid}}</td>
                    <!--<td><router-link :to="{ name: 'order', params: { uuid: orderB.uuid }}">{{orderB.borrowerName}}</router-link></td>-->
                    <td>{{orderC.relationship}}</td>
                    <td>{{orderC.name}}</td>
                    <td>{{orderC.gender}}</td>
                    <td>{{orderC.contactType}}</td>
                    <td>{{orderC.phoneNumber}}</td>
                    
              

                </tr>
                </tbody>
              </table>
            
            </div>
            
          </div>
        </div>
       
        <!--<div class="col-md-12">
            <router-view @refreshData="refreshList"></router-view>
        </div>-->
        </div>
    </div>
    <br>
</div>
</template>
 
<script>
import http from "../http-common";


export default {
  name: "OrderDetail",
  data() {
    return {
      order: [],
      items: [
          { age: 40, first_name: 'Dickerson', last_name: 'Macdonald' },
          { age: 21, first_name: 'Larsen', last_name: 'Shaw' },
          { age: 89, first_name: 'Geneva', last_name: 'Wilson' },
          { age: 38, first_name: 'Jami', last_name: 'Carney' }
        ]
    
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
        .get(`/order/${this.uuid}`)
        .then(response => {
          this.order = response.data; // JSON are parsed automatically.
        })
        this.$router.get(`/order/${this.uuid}`);
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
 </style>


