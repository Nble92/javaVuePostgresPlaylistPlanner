<template>
     <!-- <div> -->
      <!-- <form id="song_form">
      <h2> Submit a song to your DJ: </h2>
        <input placeholder="Title" type="text" class="form-control" v-model="newSong.title" />
        <input
        placeholder="Artist"
          type="text"
          class="form-control"
          v-model="newSong.artist"
        /> -->
        <!-- <input
          placeholder="Event ID"
          type="text"
          class="form-control"
          v-model="linkEventID"
        /> -->
        <!-- <button class="btn btn-submit" v-on:click.prevent="addSong">
          Save
        </button>
         <table class="display-playlist">
      <tr>
        <th class="leftest-cell">Song Title</th>
        <th class="rightest-cell">Artist</th>
      </tr> -->
      <div>
       <form>
        Suggest a Song:
        <input
          placeholder="Search"
          type="text"
          class="form-control"
          v-model="searchParam"
        />
        
        <button class="btn btn-submit" v-on:click.prevent="search">Search</button>
      <tr v-for="song in searchResult" v-bind:key="song.spotifySongURI">

        
        <td>{{ song.title }}</td>
        <td>{{ song.artist }}</td>
        <td><button class="btn btn-submit" v-on:click.prevent="addSong(song)">
          Save
        </button></td>
      </tr>
      </form>
  </div>
</template>

<script>
import eventService from "../services/EventService";
import spotifyService from "../services/SpotifyService";

export default {
  name: "song-form",
  data() {
    return {
      newEvent: {
        eventID: "",
        eventName: "",
        eventBegin: "",
        eventEnd: "",
      },
      searchResult: [],
      searchSong: {
        title: "",
        artist: "",
        spotifySongURI: "",
        genre: "",
        album: "",
        albumArt: "",
      },
      newSong: {
        songID: "",
        title: "",
        artist: "",
        spotifySongURI: "",
        genre: "",
        album: "",
        albumArt: "",
      },
      newSuggestion: {
        songID: "",
        eventID:""
      },
     eventID: this.$route.params.eventID,

    };
  },
  methods: {
async search() {
      await spotifyService.searchSong(this.searchParam).then((response) => {
        this.searchResult = [];
        for (let i = 0; i < 10; i++) {
          this.searchSong = {
            title: response.data.tracks.items[i].name,
            artist: response.data.tracks.items[i].album.artists[0].name,
            spotifySongURI: response.data.tracks.items[i].uri,
            genre: "",
            album: response.data.tracks.items[i].album.name,
            albumArt: response.data.tracks.items[i].album.images[0],
          };
          // console.log(this.searchSong);
          this.searchResult.push(this.searchSong);
        }
        this.$store.commit("SET_SEARCH_RESULTS", this.searchResult);
        console.log(this.$store.state.searchResults);
        // this.$forceUpdate()
       // return this.searchResult;
      });
    },
    addSong(song) {
      this.newSong = {
        title: song.title,
        artist: song.artist,
        spotifySongURI: song.spotifySongURI,
        genre: song.genre,
        album: song.album,
      };
      eventService.suggestSong(this.newSong, this.eventID).then((response) =>{
if(response.status === 201){
alert("Noted!")

}


      });
      this.searchParam = null
      this.searchResult = []


      // eventService.addSong(this.newSong);

            console.log(this.newSong);
      
      // const inputs = document.querySelectorAll('input');
      //   inputs.forEach(input => {
      //     input.value = '';
      //   });
    }
  },
};
</script>

<style>
/* body {
  background: rgb(82, 8, 82);
  height: 500px;
  font-family: "Montserrat", sans-serif;
} */
/* body {
  color: lavender);
} */
/* .inputs {
  display: block;
  margin: 0 auto;
  flex-direction: column;
  justify-content: center;
  align-content: center;
  max-width: 200px;
  padding-top: 40px;
} */
/* .sign-in {
  padding-top: 20px;
  display: block;
  text-align: center; */
/* } */
/* label.sr-only {
  margin: 5px;
} */
/* button {
  background: rgb(168, 56, 168);
  padding: 5px 8px;
  font-family: "Montserrat", sans-serif;
  margin-top: 5px;
  border-radius: 8px;
  border-color: rgb(255, 219, 17); */
/* } */
/* .form-control {
  margin-top: 7px;
  margin-bottom: 10px;
} */
</style>

