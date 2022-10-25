<template>

  <div>
      <form class="newEventForm">
        New Event:
        <input placeholder="Event Name" type="text" class="form-control" v-model="newEvent.eventName" />
        Event start:
        <input type="datetime-local" class="form-control" v-model="newEvent.eventBegin" />
        Event end:
        <input type="datetime-local" class="form-control" v-model="newEvent.eventEnd" />

      <button class="btn btn-submit" v-on:click.prevent="addEvent">
          Save
        </button>

       </form>

  </div>
</template>

<script>
import eventService from "../services/EventService";

export default {
  data() {
    return {
      newEvent: {
        eventID: "",
        eventName: "",
        eventBegin: "",
        eventEnd: "",
      },
    };
  },
   methods: {

  addEvent() {
    eventService
    .addEvent(this.newEvent)
    .then(response => {
        this.$router.push(`/event/${response.data.eventID}`)
    })
      this.newEvent = {
        eventID: Number(this.$route.params.eventID),
        eventName: this.newEvent.eventName,
        eventBegin: this.newEvent.eventBegin,
        eventEnd: this.newEvent.eventEnd
        
      }
      
      
    eventService.addEvent(this.newEvent)

  console.log(this.newEvent)
  }
  }
};


</script>

<style>
/* .newEventForm { */

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
}

button {
  background: rgb(168, 56, 168);
  padding: 5px 8px;
  font-family: 'Montserrat', sans-serif;
  margin-top: 5px;
  border-radius: 8px;
  border-color: rgb(82, 8, 82);
}
 */


</style>