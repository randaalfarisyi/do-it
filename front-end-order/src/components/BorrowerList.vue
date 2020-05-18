<template>
<div class="" id="tabel">
  <nav aria-label="breadcrumb">
        <ol class="breadcrumb mt-4 mx-4">
          <li class="breadcrumb-item"><a href="/borrowerList">Borrower</a></li>
          <li class="breadcrumb-item active" aria-current="page">List of Borrower</li>
         <!-- <li class="breadcrumb-item active" aria-current="page">UserSegments</li> -->
        </ol>
    </nav>

    <div class="row">
        <div class="col-md-12">
          <div class="card">
            <div class="card-body">
              <div class="col-md-12">
                 <h4>List of Borrower</h4>
              </div>
              <div class="col-12" style="overflow-x:auto;">
                <template >
                  <div>
                                  <b-container fluid>
                                    <b-row>
                                    <b-col b-col lg="4" class="my-1">
                                      <h5>Filter</h5>
                                          <b-form-group>
                                            <b-input-group size="sm" label="Filter">
                                              <b-form-input
                                                v-model="filter"
                                                type="search"
                                                id="filterInput"
                                                placeholder="Type to Search"
                                              ></b-form-input>
                                              <b-input-group-append>
                                                <b-button :disabled="!filter" @click="filter = ''">Clear</b-button>
                                              </b-input-group-append>
                                            </b-input-group>
                                          </b-form-group>
                                        </b-col>
                                    
                                    </b-row>
                                  <div style="overflow-x:auto;">
                                    <b-table striped hover :items="items" :fields="fields" :current-page="currentPage"
                                    :per-page="perPage" :filter="filter" :filterIncludedFields="filterOn">
                                    <template v-slot:cell(uuid)="data">
                                      <a :href="`borrower/${data.value}`">{{ data.value }}</a>
                                    </template>
                                    </b-table>
                                  </div>
                                    <b-row style="float:right">
                                      <p style="padding-top:3vh">Rows per Page</p>
                                      <b-col b-col lg="3" class="my-1">
                                              <b-form-group>
                                                <b-form-select
                                                  v-model="perPage"
                                                  id="perPageSelect"
                                                  size="sm"
                                                  :options="pageOptions"
                                                ></b-form-select>
                                              </b-form-group>
                                            </b-col>
                                      <b-col md="5" class="my-1">
                                            <b-pagination
                                                v-model="currentPage"
                                                :total-rows="rows"
                                                :per-page="perPage"
                                                aria-controls="my-table"
                                              ></b-pagination>
                                          </b-col>
                                    </b-row>
                                   
                                  </b-container>
                  </div>
                                </template>

            </div>
          </div>
          </div>
        </div>
<!--
        <div class="col-md-12">
            <router-view @refreshData="refreshList"></router-view>
        </div>-->

    </div>
    <br>
</div>
</template>
 
<script>
import http from "../http-common";


export default {
  name: "BorrowerList",
  data() {
    return {
      totalRows: 1,
        currentPage: 1,
        perPage: 5,
        pageOptions: [5, 10, 20, 50, 100],
        filter: null,
        filterOn: [],
      items: [],
      
    };
  },
 
  computed: {
      rows() {
        return this.items.length
      }
    },
  methods: {
    /* eslint-disable no-console */
    retrieveOrders() {
      http
        .get("/borrowers")
        .then(response => {
          this.items = response.data; // JSON are parsed automatically.
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
@import url(//unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.min.css);
@import url(//unpkg.com/bootstrap/dist/css/bootstrap.min.css);

a{
  text-decoration:none;
}

.container{
  background-color : white;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}

.orderList {
  align-content: center !important;
}

.list-group-item .active{
  background-color : #03D0B6;
  color : white;
}

nav {
  background-color : white;
  border-radius: 5px;
}

ol {
  background-color : white;
}

.background{
  background-color : white;
}

.breadcrumb{
  background-color : white !important;
}

.breadcrumb-item{
  color : #03D0B6;
}

.list {
  text-align: left;
  max-width: 450px;
  margin: none;
}

#tabel {
  margin-top:2%;
  padding-left:3%;
  padding-right: 3%;
}

.card {
  border-radius: 7px !important;
  width: auto;
}

.card-body {
  width: auto;
}

.table {
  width: auto;
}
th {
    font-size: 10pt;
  }
td {
  font-size: 10pt;
}


</style>


