<template>
<div class="" id="tabel">

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb mt-4 mx-4">
          <li class="breadcrumb-item">Product</li>
          <li class="breadcrumb-item active" aria-current="page"><a href="/products">Product List</a></li>
        </ol>
    </nav>

    <div class="row">
        <div class="col-md-12">
          <div class="card">
            <div class="card-body">
            <h4>Product List</h4>
            <ul>
                <table class="table">
                    <thead>
                        <tr>
                            <th style="display:none">UUID</th>
                            <th style="display:none">ID</th>
                            <th>Name</th>
                            <th>Amount Apply</th>
                            <th>Borrowing Term</th>
                            <th>Tenor</th>
                            <th>Service Fee Rate</th>
                            <th>Interest Rate</th>
                            <th>Overdue Fee</th>
                            <th>Penalty Rate</th>
                            <th>Target NPL</th>
                        </tr>
                    </thead>
                <tbody>
                    <tr v-for="product in products" :key="product.uuid">
                        <td style="display:none">{{product.uuid}}</td>
                        <td style="display:none">{{product.id}}</td>
                        <td><router-link :to="{ name: 'product', params: { uuid: product.uuid }}">{{product.name}}</router-link></td>
                        <td>Rp{{formatPrice(product.amountApply)}}</td>
                        <td>{{product.borrowingTerm}} times</td>
                        <td>{{product.tenor}} days</td>
                        <td>{{product.serviceFeeRate}}%</td>
                        <td>{{product.interestRate}}%</td>
                        <td>Rp{{formatPrice(product.overdueRate)}}</td>
                        <td>{{product.penaltyRate}}%</td>
                        <td>{{product.targetNpl}}%</td>
                    </tr>
                </tbody>
                </table>
            </ul>
            <td>
                <router-link :to="{ name: 'addproduct'}">
                  <button class="btn btn-info m-2" type="submit">Tambah Produk</button>
                </router-link>
            </td>
            </div>
          </div>
        </div>
        <div class="col-md-12">
            <router-view @refreshData="refreshList"></router-view>
        </div>
    </div>
</div>
</template>
 
<script>
import http from "../http-common";


export default {
  name: "ProductList",
  data() {
    return {
      products: []
    };
  },
  methods: {
    /* eslint-disable no-console */
    retrieveProducts() {
      http
        .get("/products")
        .then(response => {
          this.products = response.data; // JSON are parsed automatically.
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    refreshList() {
      this.retrieveProducts();
    },
    formatPrice(value) {
        let val = (value/1).toFixed(2).replace('.', ',')
        return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ".")
    }
    
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
