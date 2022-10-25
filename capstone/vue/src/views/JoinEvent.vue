<template>
  <div>
  
    <div class="header">
    <h2 class="knowledge">Know your code?</h2>
    </div>

  <div class="second-row">

    <!-- <form class="joinEventForm">
          <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
        Event Code:
        <input placeholder="Event Code" type="text" class="form-control" v-model="this.eventID" />
       
        <button class="btn btn-submit" v-on:click.prevent="submit">
          Submit
          </button>
       </form> -->
  </div>
  <div class="join-pahty">  
    <join-form></join-form>
  <img  class="joinDisco" src="@/images/disco_ball_2.png" alt="">
</div>
  </div>
</template>


<script>
import eventService from "../services/EventService";
import JoinForm from "@/components/JoinForm"


export default {
  components: {
    JoinForm
  },
  data() {
    return {
     eventID: "",
     errorMsg: ""
  };
},
methods: {
   submit() {
     eventService
        .getEvent(this.eventID)
        .then(response => {
            if (response.status === 200) {
                this.$router.push(`/events/${this.eventID}`)
            } else {
                this.errorMsg = "Invalid Event Code"
            }
        });
    }
   }}
</script>

<style>

/* .knowledge {
font-size: 3.5rem;
border: 4px solid rgb(31, 11, 31);
border-radius:15px;
padding-bottom: 35px;
margin-left:20%;
margin-right:20%;
background:rgba(47, 17, 47, 0.5);
} */

/* .header {
  text-align: center;
  padding-top: 20px;
  padding-bottom: 12px;
}

.joinDisco {
  max-width: 200px;
  max-height: 200px;
  margin-top: 45px;
}

.join-pahty {
  display: flex;
  justify-content: space-around;
  margin-left:25%;
  margin-right:25%;
  padding: 15px;
  
} */

/* .second-row {
  display: flex;
  justify-content: space-evenly;
} */

/* .joinEventForm { */

/* display: flex;
flex-direction: column;
max-width: 300px ;
align-items: center;
justify-content: center;
    */

    /* display: block;
  margin: 0 auto;
  flex-direction: column;
  justify-content: center;
  align-content: center;
  max-width: 200px;
  padding-top: 40px;
} */

/* button {
  background: rgb(168, 56, 168);
  padding: 5px 8px;
  font-family: 'Montserrat', sans-serif;
  margin-top: 5px;
  border-radius: 8px;
  border-color: rgb(82, 8, 82);
} */




</style>