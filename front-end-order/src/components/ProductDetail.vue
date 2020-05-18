<template>

<div class="" id="tabel">

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb mt-4 mx-4">
          <li class="breadcrumb-item">Products</li>
          <li class="breadcrumb-item active"><a href="/products">Product List</a></li>
          <li class="breadcrumb-item active" aria-current="page">Rincian Produk</li>
        </ol>
    </nav>

    <div class="row">
        <div class="col-md-12">
          <div class="card">
            <div class="card-body">
            <h4>Rincian Produk</h4>
            <b-row>
              <b-col cols="7">
                <div class="card-body">
                  <div class="row">
                    <div class="col-md-4">Name</div><div class="col-md-4">: {{product.productType.name}}</div>
                  </div>
                  <div class="row">
                    <div class="col-md-4">Amount Apply</div><div class="col-md-4">: Rp{{formatPrice(product.productType.amountApply)}}</div>
                  </div>
                  <div class="row">
                    <div class="col-md-4">Amount Disbursed</div><div class="col-md-4">: Rp{{formatPrice(product.productType.amountDisbursed)}}</div>
                  </div>
                  <div class="row">
                    <div class="col-md-4">Borrowing Term</div><div class="col-md-4">: {{product.productType.borrowingTerm}} times</div>
                  </div>
                  <div class="row">
                    <div class="col-md-4">Tenor</div><div class="col-md-4">: {{product.productType.tenor}} days</div>
                  </div>
                  <div class="row">
                    <div class="col-md-4">Installment</div><div class="col-md-4">: Rp{{formatPrice(product.productType.installment)}}</div>
                  </div>
                  <div class="row">
                    <div class="col-md-4">Service Fee Rate</div><div class="col-md-4">: {{product.productType.serviceFeeRate}}%</div>
                  </div>
                  <div class="row">
                    <div class="col-md-4">Interest Rate</div><div class="col-md-4">: {{product.productType.interestRate}}%</div>
                  </div>
                  <div class="row">
                    <div class="col-md-4">Overdue Fee</div><div class="col-md-4">: Rp{{formatPrice(product.productType.overdueRate)}}</div>
                  </div>
                  <div class="row">
                    <div class="col-md-4">Penalty Rate</div><div class="col-md-4">: {{product.productType.penaltyRate}}%</div>
                  </div>
                  <div class="row">
                    <div class="col-md-4">Target NPL</div><div class="col-md-4">: {{product.productType.targetNpl}}%</div>
                  </div>
                  <div class="row">
                    <div class="col-md-4">OJK Rate</div><div class="col-md-4">: {{product.productType.ojkRate}}%</div>
                  </div>
                </div>
              </b-col>
              <!-- Scheduler -->
              <b-col>
                <div class="col-md-12">
                  <div class="card">
                    <div class="card-body">
                      <h6><b>Scheduler</b></h6>
                      <div v-for="schedulers in product.scheduler" :key="schedulers.uuid">
                        <br>
                        <div class="card">
                          <b-row class="justify-content-md-center">
                            <b-col lg="8">
                              <div>H-{{schedulers.day}}</div>
                              <div><b>{{schedulers.time}}</b></div>
                            </b-col>
                            <b-col md="auto">
                              <div v-bind:style="{ margin: `3px 0` }" ></div>
                              <!-- Change Scheduler -->
                              <div>
                                <b-button @click="resetModal(schedulers)" class="fa fa-edit fa-sm btn btn-info" v-bind:style="{ color: `#FFFFFF` }" v-b-modal.modal-prevent-closing></b-button>
                              </div>
                              <!-- Change Scheduler -->
                            </b-col>
                          </b-row>
                        </div>
                      </div>

                      <!-- Modal Change Scheduler -->
                      <b-modal
                        id="modal-prevent-closing"
                        ref="modal"
                        title="Ubah Scheduler"
                        ok-title="Simpan"
                        ok-variant="info"
                        cancel-title="Batalkan"
                        cancel-variant="outline-info"
                        @ok="handleOk"
                        centered
                      >
                        <form ref="form" @submit.stop.prevent="handleSubmit">
                          <b-form-group v-show="hidden">
                            <b-form-input
                              id="uuidSched-input"
                              v-model="uuidSched"
                              :state="uuidSchedState"
                              required
                            ></b-form-input>
                          </b-form-group>
                          <b-form-group
                            :state="dayState"
                            label="Hari (H-)"
                            label-for="day-input"
                            invalid-feedback="Isian hari harus benar"
                          >
                            <b-form-input
                              id="day-input"
                              type="number"
                              v-model="day"
                              :state="dayState"
                              required
                            ></b-form-input>
                          </b-form-group>
                          <b-form-group
                            :state="timeState"
                            label="Jam"
                            label-for="time-input"
                            invalid-feedback="Isian jam harus benar"
                          >
                            <b-form-input
                              id="time-input"
                              type="time"
                              v-model="time"
                              :state="timeState"
                              required
                            ></b-form-input>
                          </b-form-group>
                        </form>
                      </b-modal>
                    </div>
                  </div>
                </div>
              </b-col>
              <!-- Scheduler -->

              <!-- Notification -->
              <b-modal v-model="modalShow" ok-variant="info" centered ok-only>Perubahan scheduler berhasil disimpan</b-modal>
              <!-- Notification -->
            </b-row>
            </div>
            <td>
              <router-link :to="{ name: 'products'}">
                <button class="btn btn-outline-info m-2" type="submit">Kembali</button>
              </router-link>
              <router-link :to="{ name: 'update'}">
                <button class="btn btn-info m-2" type="submit">Ubah Rincian Produk</button>
              </router-link>
            </td>
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
import axios from "../axios-store";

export default {
  name: "ProductDetail",
  data() {
    return {
      product: [],
      day: '',
      dayState: null,
      time: '',
      timeState: null,
      uuidSched: '',
      uuidSchedState: null,
      modalShow: false
    };
  },
  computed:{
    uuid(){
        return this.$route.params.uuid;
    }
  },
  methods: {
    /* eslint-disable no-console */
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
    formatPrice(value) {
        let val = (value/1).toFixed(2).replace('.', ',')
        return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".")
    },

    /** Scheduler Day */
    checkFormValidity() {
      const valid = this.$refs.form.checkValidity()
      // this.dayState = valid
      // this.timeState = valid
      return valid
    },

    resetModal(schedulers) {
      this.day = schedulers.day
      this.dayState = null
      this.time = schedulers.time
      this.timeState = null
      this.uuidSched = schedulers.uuid
      this.uuidSchedState = null
    },

    handleOk(bvModalEvt) {
      // Prevent modal from closing
      bvModalEvt.preventDefault()
      // Trigger submit handler
      this.handleSubmit()
    },

    async handleSubmit() {
      // Exit when the form isn't valid
      if (!this.checkFormValidity()) {
        return
      }
      // Push the name to submitted names
      const schedulerToSubmit = {
        day: this.day,
        time: this.time
      }
      // Hide the modal manually
      this.$nextTick(() => {
        this.$bvModal.hide('modal-prevent-closing')
      })

      await axios.put("/scheduler/" + this.uuidSched, schedulerToSubmit)
      this.modalShow = true
      await this.refreshList()
    }
    
    /** Scheduler */

    /* eslint-enable no-console */
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
