<template>
<div>
<div class="header">
  <h1>ViBe PHL</h1>
</div>
<img src="@/images/disco_ball_2.png" alt="" class="home-guest-disco">
<div class="second-row">
  <!-- <h2> Join an event as a guest! </h2> -->
  <h3><router-link v-bind:to="{ name: 'join-event' }" class="routerlink">Click to Join an Event as Guest</router-link></h3>
</div>
<div class="third-row">
  <!-- <h2> Login to host events! </h2> -->
  <h3 ><router-link v-bind:to="{ name: 'login' }" class="routerlink">Log In to Join as Host/DJ</router-link></h3>
</div>  
</div>
</template>

<script>



export default {
    name: "home-guest",
    components: {
        
    },
    
        
    }
</script>

<style>

/* .vibe {
  text-align: center;
  margin-top: 25px;
  text-shadow: 5px 5px rgb(46, 41, 46);
  font-size: 5rem;
  letter-spacing: .4rem;
} */



h3 {
  text-align: center;
  /* margin-top: 75px; */
  text-shadow: 2px 2px rgb(31, 11, 31);
  font-size: 1.5rem;
  letter-spacing: .15rem;
  
}

.header {
  text-align: center;
  padding-top: 0px;
  padding-bottom: 15px;
}

.second-row {
  display: flex;
  justify-content: space-evenly;
  padding-bottom: 15px;
}

.third-row {
  display: flex;
  justify-content: space-evenly;
  padding-bottom: 40px;
}

.home-guest-disco {
  display: block;
  margin: 0 auto;
  padding-bottom: 17px;
  max-width: 200px;
}

/* .border {
border: 4px solid rgb(31, 11, 31);
border-radius:15px;
margin-left:20%;
margin-right:20%;
background:rgba(31, 11, 31, 0.5);
max-width: 700px;
padding-left: 30px;
padding-right: 30px;
margin-top: 50px;

} */

.button {
  border: 4px solid rgb(31, 11, 31);
border-radius:15px;
margin-left:0;
margin-right:0;
background:#b90b51;
max-width: 700px;
padding-left: 30px;
padding-right: 30px;

}

h1 {
  font-size: 5rem
}

</style>
