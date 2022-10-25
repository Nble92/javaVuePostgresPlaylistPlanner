<template>
  <div class="playlist">
    
    <div class="songs">
      <h1 class="playlist-title">Playlist</h1>
      <!-- <div
      class="song"
      > -->
      <table class="display-playlist">
        <tr>
          <th class="leftest-cell">Song Title</th>
          <th class="rightest-cell">Artist</th>
    


        </tr>
        <tr v-for="song in this.$store.state.playlist"
            v-bind:key="song.id">
          <td>{{song.title}}</td>
          <td>{{song.artist}}</td>



        </tr>
          
      </table>
      <!-- /div -->
    </div>
  </div>
</template>



<script>
import EventService from '@/services/EventService.js'
import spotifyService from "../services/SpotifyService";


export default {
  
name: "playlist",
  data() {
    return {
      playlist: []
    }
  },
  created() {
    EventService.getEventPlaylist(this.$route.params.eventID).then ( (response) =>{
      this.playlist = response.data;
      this.$store.commit('SET_PLAYLIST', this.playlist);
    })
  },
  methods: {
playSong(song) {
  
      spotifyService.playSong(song.spotifySongURI)
    },
    playNext(song) {
  
      spotifyService.queueSong(song.spotifySongURI)
    },
    nextSong() {
      spotifyService.nextSong();
    },
    currentSong() {
      spotifyService.currentSong();
    },




  }
};
</script>

<style>
/* .display-playlist {
  max-width: 50%;
  margin: 0 auto;
  border: solid yellow;
  text-align: center;
  padding: 7px;
  border-collapse: collapse;
}

.display-playlist tr th {
  border-bottom: 2px solid;
  padding: 20px;
  border-collapse: collapse;
}

.display-playlist tr td {
  border-bottom: 1px solid;
  border-collapse: collapse;

} */

.playlist-title {
  font-size: 3rem;
  text-align: center;
}

.display-playlist {
margin-left: 20%;
}


</style>
