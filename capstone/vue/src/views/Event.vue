<template>
<body>
  <div>
      <component :is="view"></component>
  </div>


<!-- components: add song form, suggested song queue, playlist, song? -->

</body>
</template>

<script>

import EventAuth from '../components/EventAuth.vue';
import EventGuest from '../components/EventGuest.vue';

export default {
  name: "event",
  components: {
    EventAuth,
    EventGuest
  },
  data() {
    return {
     eventID: 0
    };
  },
  created() {
    this.eventID = parseInt(this.$route.params.id);
    this.$store.commit("SET_ACTIVE_EVENT", this.eventID)
  },
  computed: {
    view() {
      return (this.$store.state.token !== '') ? 'event-auth' : 'event-guest'
    }
  }
};
// 
</script>


<style>
body {

 background: rgb(12, 11, 12);
  height: 500px
}


/*  */
</style>