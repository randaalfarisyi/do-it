<template>

    <div id="app" class="">
        <navbar/>
        <BootstrapSideBar :sidenavConfig="sidenavConfig" :header="header" :hasNavbar="hasNavbar" :links="sidelinks" :navs="headerLinks">
          
    <router-view/>
    
    
</BootstrapSideBar>

    </div>
</template>
 
<script>
import BootstrapSideBar from 'b-sidebar';
import navbar from './components/Navbar';
export default {
  name: "app",
  components : {
    BootstrapSideBar,
    navbar
  },
  data(){
    return {
      sidenavConfig:{
        sidenavMainColor:'bg-light',
        sidenavBgColor:'navbar-light',
        navbarClass:'custom-one',
        sidenavClass:'sidenav-custom-class'
      },
      header: false,
      hasNavbar : false,
      sidelinks:[
        {label:'Order',href:'#',icon:'fa-list-alt',links:[
            {label:'Lihat Semua Order', href:'/orders'}
        ]}, 
         {label:'Order Summary',href:'#',icon:'fa-th-large',links:[
            {label:'Live Metrics',href:'/view'}
        ]},
        {label:'Product',href:'#',icon:'fa-briefcase',links:[
            {label:'Product Type', href:'/products'},
            
        ]},
        {label:'Borrower',href:'#',icon:'fa-users',links:[

            {label:'List Borrower', href:'/borrowerList'},
         
        ]}, 
      ]
    }
  }
};

</script>
 
<style>
.site-info {
  color: blue;
  margin-bottom: 20px;
}
 
.btn-primary {
  margin-right: 5px;
}
 
.container-fluid {
  text-align: none;
}
#app {
  padding-left: none !important;
  padding-right: none !important;
  margin-left: none !important;
  margin-right: none !important;
}
.nav-link:hover {
      color:#03D0B6 !important;
      cursor: pointer;
}
.nav-link:active{
      color:#03D0B6 !important;
      cursor: pointer;
  }

.bg-light {
  background-color: white !important;
}
#sidebar .sidebar-header[data-v-6a4cb5c4] {
    display: contents;
}

i [data-v-6a4cb5c4] .ml-1 .fa ::before {
  content: "\f015" !important ;

}



</style>

