<template>
    <div>
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
                    <h3 class="my-4">{{userSegments[0].fullName}}</h3>
                        <a class="nav-link active" id="v-pills-GI-tab" data-toggle="pill" href="#v-pills-GI" role="tab" aria-controls="v-pills-GI" aria-selected="true">General Information</a>
                        <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false">User Segments</a>
                        <a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false">Income Segments</a>
                        <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab" aria-controls="v-pills-settings" aria-selected="false">Productive Segments</a>
                        <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab" aria-controls="v-pills-settings" aria-selected="false">Family Segments</a>
                        <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab" aria-controls="v-pills-settings" aria-selected="false">Emergency Contact Segment</a>
                        <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab" aria-controls="v-pills-settings" aria-selected="false">Bank Segments</a>
                        <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab" aria-controls="v-pills-settings" aria-selected="false">Upload Picture</a>
                    </div>
                    <template>
                        <div class="custom-control custom-switch">
                            <label class="custom-control-label" for="customSwitch1">Status</label>
                            <input type="checkbox" class="custom-control-input" id="customSwitch1" checked>
                        </div>
                    </template>
                </div>
                <div class="col-md-9 mt-4">
                    <div class="tab-content" id="v-pills-tabContent">
                        <div class="tab-pane fade show active" id="v-pills-GI" role="tabpanel" aria-labelledby="v-pills-GI-tab"><EditGeneralInformation></EditGeneralInformation></div>
                        <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">...</div>
                        <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">...</div>
                        <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab">...</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import BorrowerDataService from '../service/BorrowerDataService';
import EditGeneralInformation from './EditGeneralInformation';

export default {
  name: "borrowerDetails",
  components:{
    EditGeneralInformation
  },
  data(){
    return{
        borrower:[],
        userSegments:[],
        errors:[],
        message: null
    };
  },
  computed:{
    uuid(){
        return this.$route.params.uuid;
    }
  },
  methods : {
    refreshBorrowerDetails(){
        BorrowerDataService.retrieveBorrowerByUuid(this.uuid).then(res=> {
            this.borrower = res.data;
            this.userSegments = res.data.userSegmentsList;
        });
    },
  },
  created(){
    this.refreshBorrowerDetails();
  }
};
</script>

<style>
@import url(//unpkg.com/bootstrap-vue@latest/dist/bootstrap-vue.min.css)
@import url(//unpkg.com/bootstrap/dist/css/bootstrap.min.css)
</style>