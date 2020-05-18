<template>
<div class="" id="tabel">

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb mt-4 mx-4">
          <li class="breadcrumb-item">Products</li>
          <li class="breadcrumb-item active"><a href="/products">Product List</a></li>
          <li class="breadcrumb-item active" aria-current="page">Tambah Produk</li>
        </ol>
    </nav>

    <div class="row">
        <div class="col-md-12">
          <div class="card">
            <div class="card-body">
            <h4>Tambah Produk</h4>
            <b-row>
              <b-col cols="8">
               <div class="card-body">
                <form>
                <div class="row">
                  <div class="col-md-4">Product Type Name:</div>
                  <select v-model="product.name" name="name">
                    Pilih Tipe Produk
                    <option value="Normal Loan">Normal Loan</option>
                    <option value="Installment Loan">Installment Loan</option>
                  </select>
                </div>
                <div class="row">
                  <div class="col-md-4">Amount Apply (Rp):</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="amountApply" required v-model.number="product.amountApply" name="amountApply"/>
                </div>
                <div class="row">
                  <div class="col-md-4">Amount Disbursed (Rp):</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="amountDisbursed" required v-model.number="product.amountDisbursed" name="amountDisbursed"/>
                </div>
                <div class="row">
                  <div class="col-md-4">Borrowing Term:</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="borrowingTerm" required v-model.number="product.borrowingTerm" name="borrowingTerm"/>
                </div>
                 <div class="row">
                  <div class="col-md-4">Tenor:</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="tenor" required v-model.number="product.tenor" name="tenor"/>
                </div>
                <div class="row">
                  <div class="col-md-4">Installment (Rp):</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="installment" required v-model.number="product.installment" name="installment"/>
                </div>
                <div class="row">
                  <div class="col-md-4">Service Fee Rate (%):</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="serviceFeeRate" required v-model.number="product.serviceFeeRate" name="serviceFeeRate"/>
                </div>
                <div class="row">
                  <div class="col-md-4">Interest Rate (%):</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="interestRate" required v-model.number="product.interestRate" name="interestRate"/>
                </div>
                <div class="row">
                  <div class="col-md-4">Overdue Fee (Rp):</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="overdueRate" required v-model="product.overdueRate" name="overdueRate"/>
                </div>
                <div class="row">
                  <div class="col-md-4">Penalty Rate (%):</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="penaltyRate" required v-model="product.penaltyRate" name="penaltyRate"/>
                </div>
                <div class="row">
                  <div class="col-md-4">Target NPL (%):</div>
                  <input class="col-sm-6 form-control input-sm" type="text" id="targetNpl" required v-model="product.targetNpl" name="targetNpl"/>
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
</div>
</template>
 
<script>
import http from "../http-common";

export default {
  name: "AddProduct",
  data() {
    return {
      product:{
        name : "",
        createdTime : new Date(),
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
        createdTime : new Date(),
        updatedTime : new Date(),
        name : this.product.name,
        amountApply : this.product.amountApply,
        amountDisbursed : this.product.amountDisbursed,
        borrowingTerm : this.product.borrowingTerm,
        tenor : this.product.tenor,
        installment : this.product.installment,
        serviceFeeRate : this.product.serviceFeeRate,
        interestRate : this.product.interestRate,
        overdueRate : this.product.overdueRate,
        penaltyRate : this.product.penaltyRate,
        targetNpl : this.product.targetNpl,
        ojkRate : 0.8
      };
      http
        .post("/addProd", data)
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
    formatPrice(value) {
        let val = (value/1).toFixed(2).replace('.', ',')
        return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".")
    }
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
