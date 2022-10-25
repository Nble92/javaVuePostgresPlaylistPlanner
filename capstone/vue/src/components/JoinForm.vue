<template>
  <div>
    <div class="join">
      <h2>Join an event:</h2>
      </div>
      <form v-on:submit.prevent="goToPage" class="joinEventForm">
          <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
        Event Code:
        <input placeholder="Event Code" type="text" class="form-control" v-model="eventID" />
       
        <button type="submit" class="btn btn-submit">Submit</button>
       </form>
  </div>
</template>

<script>


export default {
  data() {
    return {
     eventID: "",
     errorMsg: ""
  };
},
methods: {
  goToPage() {
                this.$router.push(`/event/${this.eventID}`)
    }
   }}
</script>

<style>
.joinEventForm {

/* display: flex;
flex-direction: column;
max-width: 300px ;
align-items: center;
justify-content: center;
    */

    display: block;
  margin: 0 auto;
  flex-direction: column;
  justify-content: center;
  align-content: center;
  max-width: 200px;
  padding-top: 40px;
}

button {
  background: rgb(168, 56, 168);
  padding: 5px 8px;
  font-family: 'Montserrat', sans-serif;
  margin-top: 5px;
  border-radius: 8px;
  border-color: rgb(82, 8, 82);
}


/* h2 {
  text-align: center;
} */

.join {
  margin-top: 35px;
}



</style>