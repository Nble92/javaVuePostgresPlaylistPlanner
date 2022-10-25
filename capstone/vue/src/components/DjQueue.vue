<template>

  <div class="queue">
     <h1 class="queue-title">Suggested Songs</h1>
    <div class="songs">
      <table class="display-queue">
        <tr>
          <th class="leftest-cell">Song Title</th>
          <th class="rightest-cell">Artist</th>

          <!-- <th>Song ID</th> -->
          <th>Approve?</th>
          <th>Reject?</th>
        </tr>
        <tr v-for="song in dj_queue"
            v-bind:key="song.id">
          <td>{{song.title}}</td>
          <td>{{song.artist}}</td>
          <!-- <td>{{song.songID}}</td> -->
          <td><button type="submit" class="djq btn btn-submit" v-on:click.prevent="approveSong(song.songID)">+</button></td>
          <td><button type="submit" class="djq btn btn-submit" v-on:click.prevent="rejectSong(song.songID)">-</button></td>
        </tr>
      </table>
    </div>
  </div>

</template>

<script>
import EventService from '@/services/EventService.js'
export default {
name: "dj-queue",
  data() {
    return {
      dj_queue: []
    }
  },
  created() {
    
    EventService.getSuggestedQueue(this.$route.params.eventID).then ( (response) =>{
      this.dj_queue = response.data
    })
  },
  methods: {
      approveSong(input) {
          let eventID = this.$route.params.eventID;
          EventService.approveSong(eventID, input);
          window.location.reload();
      },
      rejectSong(input) {
          let eventID = this.$route.params.eventID;
          EventService.rejectSong(eventID, input);
          window.location.reload();
      }
  }
}
</script>

<style>
/* .display-queue {
  max-width: 50%;
  margin: 0 auto;
  border: solid yellow;
  text-align: center;
  padding: 7px;
  border-collapse: collapse;
}
.display-queue tr th {
  border-bottom: 2px solid;
  padding: 20px;
  border-collapse: collapse;
}
.display-queue tr td {
  border-bottom: 1px solid;
  border-collapse: collapse;
}
.queue-title {
  font-size: 3rem;
  padding-bottom: 17px;
} */

.queue-title {
  font-size: 3rem;
  text-align: center;
}
th{

font-weight: bolder;
}

/* .djq {
  min-width: 20px;
} */
</style>