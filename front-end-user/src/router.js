import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);
const router = new Router({
    mode: "history",
    routes: [
      {
        path: "/",
        name: "Home",
        component: () => import ("./components/Home.vue")
      },
      {
        path: "/borrower/:uuid",
        name: "Borrower Details",
        component: () => import ("./components/BorrowerComponent.vue")
      }
      ,
      {
        path: "/borrower/ubah/:uuid",
        name: "Change Borrower Details",
        component: () => import ("./components/EditGeneralInformation.vue")
      },
      {
        path: "/borrower/ubah/UserSegments/:uuid",
        name: "Change Borrower User Segments",
        component: () => import ("./components/EditUserSegments.vue")
      }
      ,
      {
        path: "/borrower/lihat/:uuid",
        name: "View Borrower General Information",
        component: () => import ("./components/ViewBorrower.vue")
      }
      ,
      {
        path: "/borrower/lihat/UserSegments/:uuid",
        name: "View Borrower User Segments",
        component: () => import ("./components/ViewUserSegments.vue")
      },
      {
        path: "/borrower/lihat/IncomeSegments/:uuid",
        name: "View Borrower Income Segments",
        component: () => import ("./components/ViewIncomeSegments.vue")
      },
      {
        path: "/borrower/lihat/ProductiveSegments/:uuid",
        name: "View Borrower Productive Segments",
        component: () => import ("./components/ViewProductiveSegments.vue")
      },
      {
        path: "/borrower/lihat/FamilySegments/:uuid",
        name: "View Borrower Family Segments",
        component: () => import ("./components/ViewFamilySegments.vue")
      },
      {
        path: "/borrower/lihat/EmergencyContactSegments/:uuid",
        name: "View Borrower Emergency Contact Segments",
        component: () => import ("./components/ViewEmergencyContactSegments.vue")
      },
      {
        path: "/borrower/lihat/BankSegments/:uuid",
        name: "View Borrower Bank Segments",
        component: () => import ("./components/ViewBankSegments.vue")
      },
      {
        path: "/borrower/lihat/UploadPicture/:uuid",
        name: "View Borrower Upload Picture Segments",
        component: () => import ("./components/ViewUploadPictures.vue")
      },
      {
        path: "/tambah",
        name: "Create Borrower",
        component: () => import ("./components/AddBorrower.vue")
      }
    ]
});

export default router;

