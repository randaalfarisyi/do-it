import Vue from "vue";
import Router from "vue-router";
import OrderList from "./components/OrderList.vue";
import ProductList from "./components/ProductList.vue";
import OrderDetail from "./components/OrderDetail.vue";
import ProductDetail from "./components/ProductDetail.vue";
import AddProduct from "./components/AddProduct.vue";
import UpdateProduct from "./components/UpdateProduct.vue";
import Home from "./components/Home.vue";
import SearchProduct from "./components/SearchProduct.vue";
import BorrowerList from "./components/BorrowerList.vue";
import BorrowerDetail from "./components/BorrowerDetail.vue";


Vue.use(Router);
export default new Router({
    mode: "history",
    routes: [
      {
        path: "/orders",
        name: "orders",
        //alias: "/order",
        component: OrderList,
      },
      {
        path: "/products",
        name: "products",
        //alias: "order",
        component: ProductList,
      },
      {
        path: "/product/addproduct",
        name: "addproduct",
        //alias: "/order",
        component: AddProduct,
      },
      {
        path: "/order/:uuid",
        name: "order",
        //alias: "/order",
        component: OrderDetail,
      },

      {

        path: "/product/:uuid",
        name: "product",
        //alias: "/order",
        component: ProductDetail,
      },
      {
        path: "/product/:uuid/update",
        name: "update",
        //alias: "/order",
        component: UpdateProduct,
      },
      {
        path:"/home",
        name:"home",
        component: Home
      }, 
      {
        path: "/view",
        name: "view",
        alias: "/",
        component: SearchProduct
      },
      {
        path: "/borrowerList",
        name: "borrowerList",
        component:BorrowerList

      },
      {
        path: "/borrower/:uuid",
        name: "borrower",
        component: BorrowerDetail,
      }, 

    ]
  });

