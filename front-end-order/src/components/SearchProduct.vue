<template>
  <div id="tabel">
      <nav aria-label="breadcrumb">
        <ol class="breadcrumb mt-4 mx-4">
          <li class="breadcrumb-item"><a href="/view">Order Summary</a></li>
          <li class="breadcrumb-item active" aria-current="page">Live Metrics</li>
         <!-- <li class="breadcrumb-item active" aria-current="page">UserSegments</li> -->
        </ol>
    </nav>

    
   <div class="row">

                        <div class="col-lg-4 col-md-6 mt-5">
                            <div class="card card-bordered order" v-if="loaded">

                                <img class="rounded float-left img-fluid" style="width:10%; margin:2%" src="../assets/images/box.png" alt="image">


                                <div class="card-body" >
                                    <h5 class="title">All Orders</h5>
                                    <h6 class="card-text">
                                      <strong> {{product.result.order_month}} </strong>
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
                                   <strong>   Rp.{{formatPrice(product.result.repaid_month)}} </strong>
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
                                    <strong>  {{product.result.outstanding_over}} </strong>
                                    </h6>
                                </div>
                            </div>
                        </div>
                    </div> 
                    


                    
      





  

  </div>
</template>

<script>
import http from "../http-common";



export default {
  data() {
    return {
      product: null,
      loaded: false,
    };

  },

  
  methods: {
    /* eslint-disable no-console */
    retrieveOrders() {
      http
        .get("/view/Normal%20Loan/1")
        .then(response => {
          this.product = response.data;
          this.loaded = true; // JSON are parsed automatically.
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.retrieveOrders();
    },

    /*viewOrder(uuid) {
      http.get(`order/${uuid}`)
      this.$router.push(`/order/${uuid}`);
    },*/

    formatPrice(value) {
        let val = (value/1).toFixed(2).replace('.', ',')
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
   background-color: #00DDC7!important;
}
.outs{
   background-color: #80EEE3!important;
}
.loan{
  background-color:#BFF7F1!important;
}
.card {
  border-radius: 7px !important;
  width: auto;
}
.card-body {
  width: auto;
}
</style>
