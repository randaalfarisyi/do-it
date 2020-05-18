<template>
  <div id="tabel">
      <nav aria-label="breadcrumb">
        <ol class="breadcrumb mt-4 mx-4">
          <li class="breadcrumb-item"><a href="/view">Order Summary</a></li>
          <li class="breadcrumb-item active" aria-current="page">Live Metrics</li>
         <!-- <li class="breadcrumb-item active" aria-current="page">UserSegments</li> -->
        </ol>
    </nav>


                  <div class="row" style="margin-top:-5vh ">


                    <div class="col-lg-4 col-md-6 mt-5">
                       <b-form-input type="number"  v-model="borrowingAmount" id="borrowingAmount" placeholder="Enter Borrowing Amount"></b-form-input>
                    </div>
                    <div class="col-lg-4 col-md-6 mt-5">
                       <b-form-select v-model="name" id="name">
                       <template v-slot:first>
                      <b-form-select-option :value="null" disabled>-- Please select an option --</b-form-select-option>
                       </template>
                         <b-form-select-option value="Normal Loan">Normal Loan</b-form-select-option>
                         <b-form-select-option value="Installment Loan">Installment Loan</b-form-select-option>
                      </b-form-select>
                    </div>
                    <div class="col-lg-4 col-md-6 mt-5">

                       <b-button class="searchButton"  variant="primary" v-on:click="searchProduct">Search</b-button>


                    </div>
                  </div>
                  <!-- card on the top -->
                    <div class="row">
                        <div class="col-lg-4 col-md-6 mt-5">
                            <div class="card card-bordered order" v-if="loaded">

                                <img class="rounded float-left img-fluid" style="width:10%; margin:2%" src="../assets/images/box.png" alt="image">


                                <div class="card-body" >
                                    <h5 class="title">All Orders</h5>
                                    <h6 class="card-text">
                                      <strong> {{product.result.order}} </strong>
                                    </h6>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 mt-5">
                            <div class="card card-bordered loan" v-if="loaded">


                                <img class="rounded float-left img-fluid" style="width:10%;margin:2%" src="../assets/images/loan.png" alt="image">


                                <div class="card-body">
                                    <h5 class="title">Total Loan</h5>
                                    <h6 class="card-text">
                                   <strong>   Rp.{{formatPrice(product.result.totalLoan)}} </strong>
                                    </h6>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6 mt-5">
                            <div class="card card-bordered outs" v-if="loaded">


                                <img class="rounded float-left img-fluid" style="width:10%; margin:2%" src="../assets/images/money.png" alt="image">


                                <div class="card-body">
                                    <h5 class="title">Total Outstanding</h5>
                                     <h6 class="card-text">
                                    <strong>  Rp.{{formatPrice(product.result.outstanding)}} </strong>
                                    </h6>
                                </div>
                            </div>
                        </div>
                    </div> 
                    <!-- chart -->
                    <div class="row">
                      <div class="col-lg-9 col-md-5 mt-5">
                         <div class="card card-bordered" v-if="loaded">
                             <div class="card-body">
                                <h5 class="title" style="text-align:center">Overdue Detail</h5>
                        <bar-chart v-if="loaded" :chartdata="chartdata" :options="options"></bar-chart>
                             </div>
                         </div>
                      </div>
                      <div class="col-lg-3 col-md-7 mt-5">
                         <div class="card card-bordered" v-if="loaded">
                           <div class="card-body">
                              <h5 class="title" style="text-align:center">Outstanding Detail</h5>
                          <pie-chart :data="piechart" :options="chartOptions"></pie-chart>
                           </div>
                         </div>
                      </div>
                    </div>
                       <div class="col-md-12" v-if="loaded">
                         <b-button v-on:click="refreshList" style="float: right" >Refresh</b-button>
      
        </div>
  </div>
                
</template>

<script>
import BarChart from "./chart/BarChart.vue";
import PieChart from "./chart/PieChart.vue";
import http from "../http-common";
export default {

  components: {
    BarChart,PieChart

  },
  data: () => ({
    chartdata: null,
    piechart:null,
    product:null,
    options: null,
    chartOptions:null,
    loaded: false
  }),
  async mounted() {
   
  },
  methods:{
    searchProduct(){
   http
      .get(`/view/${this.name}/${this.borrowingAmount}`)
      .then(res => {
        console.log(res);
        this.loaded = true;
        this.product=res.data;
        this.chartdata = {
          labels: ["day 0", "day 1-2","day 3-7","day 8-30","day 31-90","day >91"],
          datasets: [
            {
              data: [res.data.result.d0, res.data.result.d1d2, res.data.result.d3d7, res.data.result.d8d30, res.data.result.d3190, res.data.result.d91],
              backgroundColor: [
                '#EB5757',
                '#EB5757',
                '#EB5757',
                '#EB5757',
                '#EB5757',
                '#EB5757'

              ],
              borderColor: [
               '#f87979',
               '#f87979',
               '#f87979',
               '#f87979',
               '#f87979',
               '#f87979'
              ],
              borderWidth: 1
            }
          ]
        };
        this.piechart={
          hoverBackgroundColor: "red",
          hoverBorderWidth: 10,
          labels: ["Overdue", "Not Overdue"],
          datasets:[
            {
            label:"Outstanding",
            backgroundColor: ["#00DDC7", "#EB5757"],
            data:[res.data.result.overdue, res.data.result.notOverdue]
            }
          ]
        };
        this.chartOptions= {
        hoverBorderWidth: 20
      };

        this.options = {
          scales: {
            yAxes: [
              {
                ticks: {
                  beginAtZero: true
                },
                gridLines: {
							display: false
              }
              }
            ]
          },
          maintainAspectRatio: false,
        };
      })
      
      .catch(()=>{
        alert('Failed to get the data');
      });
  },
  formatPrice(value) {
        let val = (value/1).toFixed(2).replace('.', ',')
        return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".")
    },
      refreshList() {
      this.searchProduct();
    },


    }
};
</script>

<style>
nav {
  background-color : white;
  border-radius: 5px;
}

.breadcrumb{
  background-color : white !important;
}

.breadcrumb-item{
  color : #03D0B6;
}

#tabel {
  margin-top:2%;
  padding-left:3%;
  padding-right: 3%;
}
.order{
   background-color: #93D0EF!important;
}
.outs{
   background-color: #00DDC7!important;
}
.loan{
  background-color:#f87979!important;
}
.card {
  border-radius: 7px !important;
  width: auto;
}
.card-body {
  width: auto;
}
</style>
