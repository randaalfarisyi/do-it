<template>
  <div class="col-md-12 bv-example-row text-center">
    <div class="bv-example-row">
      <b-row>
        <b-col v-bind:style="{ margin: `90px 0` }"></b-col>
        <b-col v-bind:style="{ margin: `90px 0` }"></b-col>
        <b-col v-bind:style="{ margin: `90px 0` }"></b-col>
        <div class="w-100"></div>
        <b-col></b-col>
        <b-col>
          <div class="card">
            <div class="card-body">
              <!-- Material form login -->
              <form>
                <img src="../assets/LogoDoIt.png" width="140" height="76" alt="">
                <br><br>
                <p class="h4 text-center mb-4">Login Order Microservice</p>
                <!-- Check that the SDK client is not currently loading before accessing is methods -->
                <div v-if="!$auth.loading">
                  <!-- show login when not authenticated -->
                  <button class="btn btn-info m-2" v-if="!$auth.isAuthenticated" @click="login">Login</button>
                  <!-- show logout when authenticated -->
                  <button class="btn btn-info m-2" v-if="$auth.isAuthenticated" @click="logout">Log out</button>
                </div>
              </form>
              <!-- Material form login -->
            </div>
          </div>
        </b-col>
        <b-col></b-col>
      </b-row>
    </div>
    
  </div>
</template>

<script>
// .. imports removed for brevity

export default {
  name: "home",
  components: {
    //HelloWorld
  },
  methods: {
    // Log the user in
    login() {
      this.$auth.loginWithRedirect();
      console.log(this.$auth.context);
    },
    // Log the user out
    logout() {
      this.$auth.logout({
        returnTo: window.location.origin
      });
    }
  }
};
</script>