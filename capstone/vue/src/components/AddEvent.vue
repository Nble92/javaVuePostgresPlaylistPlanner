<template>
  <div class="create">
  
    <div >
    <h2 class="header">Create New Event</h2>
    </div>

  <div class="second-row">
    <div class="discoball">
      <img src="@/images/disco_ball_2.png" alt="disco_ball_purple" />
    </div>
    <event-form class="form"></event-form>
  </div>
  </div>
</template>

<script>
import eventService from "../services/EventService";
import eventForm from "@/components/EventForm";

export default {
  components: {
    eventForm,
  },
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
      this.newEvent = {
        eventID: Number(this.$route.params.eventID),
        eventName: this.newEvent.eventName,
        eventBegin: this.newEvent.eventBegin,
        eventEnd: this.newEvent.eventEnd,
        //need to pass in the hostid from the logged in user **roadblock**
      };

      console.log(eventService.addEvent(this.newEvent));
      

      console.log(this.newEvent);
      
    },
  },
};
</script>

<style>
.header {
  text-align: center;
  padding-top: 20px;
  padding-bottom: 12px;
}

.discoball {
  width: 250px;
  padding-right: 10%;
}

.second-row {
  display: flex;
  justify-content: space-evenly;
  margin-left: 20%;
  margin-right: 20%;
} 

/* .form {
  padding-bottom: 100px;
} */


</style>