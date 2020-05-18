<template>
<div class="col-md-10" id="tabel">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb mt-4 mx-4">
          <li class="breadcrumb-item">Products</li>
          <li class="breadcrumb-item active"><a href="/products">Product List</a></li>
          <li class="breadcrumb-item active"><router-link :to="{ name: 'product', params: { uuid: product.productType.uuid }}">Rincian Produk</router-link></li>
          <li class="breadcrumb-item active" aria-current="page">Ubah Rincian</li>
        </ol>
    </nav>
    <div class="row">
        <div class="col-md-12">
          <div class="card">
            <div class="card-body">
            <h4>Ubah Produk</h4>
            <b-row>
              <b-col cols="8">
               <div class="card-body">
                <form>
                <div class="row">
                  <div class="col-md-4">Product Type Name:</div>
                  <select v-model="product.productType.name" name="name">
                    Pilih Tipe Produk
                    <option value="Normal Loan">Normal Loan</option>
                    <option value="Installment Loan">Installment Loan</option>
                  </select>
                </div>
                <div class="row">
                  <div class="col-md-4">Amount Apply (Rp):</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="amountApply" v-model="product.productType.amountApply" name="amountApply"/>
                </div>
                <div class="row">
                  <div class="col-md-4">Amount Disbursed (Rp):</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="amountDisbursed" v-model="product.productType.amountDisbursed" name="amountDisbursed"/>
                </div>
                <div class="row">
                  <div class="col-md-4">Borrowing Term:</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="borrowingTerm" v-model="product.productType.borrowingTerm" name="borrowingTerm"/>
                </div>
                 <div class="row">
                  <div class="col-md-4">Tenor:</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="tenor" v-model="product.productType.tenor" name="tenor"/>
                </div>
                <div class="row">
                  <div class="col-md-4">Installment (Rp):</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="installment" v-model="product.productType.installment" name="installment"/>
                </div>
                <div class="row">
                  <div class="col-md-4">Service Fee Rate (%):</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="serviceFeeRate" v-model="product.productType.serviceFeeRate" name="serviceFeeRate"/>
                </div>
                <div class="row">
                  <div class="col-md-4">Interest Rate (%):</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="interestRate" v-model="product.productType.interestRate" name="interestRate"/>
                </div>
                <div class="row">
                  <div class="col-md-4">Overdue Fee (Rp):</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="overdueRate" v-model="product.productType.overdueRate" name="overdueRate"/>
                </div>
                <div class="row">
                  <div class="col-md-4">Penalty Rate (%):</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="penaltyRate" v-model="product.productType.penaltyRate" name="penaltyRate"/>
                </div>
                <div class="row">
                  <div class="col-md-4">Target NPL (%):</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="targetNpl" v-model="product.productType.targetNpl" name="targetNpl"/>
                </div>
                <div class="row">
                  <div class="col-md-4">OJK Rate (%):</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="ojkRate" value="0,8" name="ojkRate" disabled/>
                </div>
                </form>
            </div>
            </b-col>
            <b-col>
              <div class="col-md-10">
                <div class="card">
                  <div class="card-body">
                    <h5><b>CALCULATION:</b></h5>
                    <h6>Allowed Fee:</h6>
                    <h6><b>Rp{{formatPrice(calcFee)}}</b></h6>
                    <h6>OJK Max. Allowed Fee:</h6>
                    <h6><b>Rp{{formatPrice(calcOJK)}}</b></h6>
                    <h6>Service Fee:</h6>
                    <h6><b>Rp{{formatPrice(calcSer)}}</b></h6>
                    <h6>Interest:</h6>
                    <h6><b>Rp{{formatPrice(calcInt)}}</b></h6>
                    <h6>Total Fee:</h6>
                    <h6><b>Rp{{formatPrice(calcSer+calcInt)}}</b></h6>
                    <h6>Please ensure that: </h6> 
                    <h6>- Total fee is <b>the same</b> with allowed fee</h6>
                    <h6>- Total fee <b>does not exceeding</b> OJK maximum allowed fee.</h6>
                  </div>
                </div>
              </div>
            </b-col>
            <b-modal v-model="modalShow" ok-variant="info" centered ok-only>
              <router-link :to="{ name: 'products'}">Product berhasil disimpan</router-link>
            </b-modal>
            <td>
              <router-link :to="{ name: 'products'}">
                <button class="btn btn-outline-info m-2" type="submit">Batal</button>
              </router-link>
              <button class="btn btn-info m-2" type="submit" v-on:click="saveProduct">Simpan</button>
            </td>
            </b-row>
          </div>
          </div>
        </div>
    </div>
    <div class="col-md-12">
      <router-view @refreshData="refreshList"></router-view>
    </div>
</div>
</template>
 
<script>
import http from "../http-common";

export default {
  name: "UpdateProduct",
  data() {
    return {
      product:{
        name : "",
        updatedTime : new Date(),
      },
      submitted: false,
      modalShow: false,
      errors:[],
      message: null
    };
  },
  methods: {
    /* eslint-disable no-console */
    saveProduct() {
      var data = {
        product : this.product,
        updatedTime : new Date(),
        name : this.product.name,
        borrowingAmount : this.product.borrowingAmount,
        borrowingTerm : this.product.borrowingTerm,
        tenor : this.product.tenor,
        serviceFeeRate : this.product.serviceFeeRate,
        interestRate : this.product.interestRate,
        overdueRate : this.product.overdueRate,
        penaltyRate : this.product.penaltyRate,
        targetNpl : this.product.targetNpl,
        ojkRate : 0.8
      };
      http
        .put("/updateProd", data)
        .then(response => {
          this.product = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
        this.submitted = true
        this.modalShow = true
    },
    newCustomer() {
      this.submitted = false;
      this.customer = {};
    },
    retrieveProducts() {
      http
        .get(`/product/${this.uuid}`)
        .then(response => {
          this.product = response.data; // JSON are parsed automatically.
        })
        this.$router.get(`/product/${this.uuid}`);
    },
    refreshList() {
      this.retrieveProducts();
    },
    computed: {
      calcFee: function(){
        var fee = this.product.amountApply-this.product.amountDisbursed;
        if(isNaN(fee)){
            fee=0;
        }
        return fee;
      },
      calcOJK: function(){
        var ojkFee = this.product.amountDisbursed*this.product.tenor*0.8/100;
        if(isNaN(ojkFee)){
            ojkFee=0;
        }
        return ojkFee;
      },
      calcInt: function(){
        var inter = this.product.amountApply*this.product.tenor*this.product.interestRate/100;
        if(isNaN(inter)){
            inter=0;
        }
        return inter;
      },
      calcSer: function(){
        var serv = this.product.amountApply*this.product.tenor*this.product.serviceFeeRate/100;
        if(isNaN(serv)){
            serv=0;
        }
        return serv;
      }
    }
  },
  mounted() {
    this.retrieveProducts();
  }
};

</script>
 
<style>
.list {
  text-align: left;
  max-width: 450px;
  margin: none;
}

#tabel {
  margin-top:2%;
  margin-left:2%;
}

.tombol {
  border: none;
  padding: 14px 28px;
  font-size: 16px;
  cursor: pointer;
  display: inline-block;
  color: white;
  margin: right;
}

.card {
  width: auto;
}

</style>
