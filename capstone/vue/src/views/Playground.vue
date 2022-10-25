

<template>
  <body>
    <button type="Get A Token!" v-on:click="spotAuth">Get A Token!</button>
    <!-- <button type="Get A Token!" v-on:click="pause">pause!</button> -->
    <button type="Get A Song!" v-on:click="spotSong">Get A Song!</button>
    <button type="Get A User!" v-on:click="getUsername">WHO ARE YOU?!</button>
    <button type="Get A Playlist!" v-on:click="retrievePlaylist">
      Get A Playlist!
    </button>
    <button type="Get Suggested!" v-on:click="retrieveSuggested">
      Get Suggested!
    </button>
    <button type="Get Suggested!" v-on:click="authorize">AUTH2</button>

    <!-- START OF ADD EVENT -->
    <div>
      <form>
        Event Title:
        <input type="text" class="form-control" v-model="newEvent.eventName" />
        <input
          type="datetime-local"
          class="form-control"
          v-model="newEvent.eventBegin"
        />
        <input
          type="datetime-local"
          class="form-control"
          v-model="newEvent.eventEnd"
        />

        <button class="btn btn-submit" v-on:click.prevent="addEvent">
          Save
        </button>
      </form>
    </div>
    <!-- END OF ADD EVENT FORM -->
    <!-- START ADD SONG FORM -->
    <div>
      <form>
        newSong:
        <input
          placeholder="Title"
          type="text"
          class="form-control"
          v-model="newSong.title"
        />
        <input
          placeholder="Artist"
          type="text"
          class="form-control"
          v-model="newSong.artist"
        />
        <input
          placeholder="Event ID"
          type="text"
          class="form-control"
          v-model="linkEventID"
        />
        <button class="btn btn-submit" v-on:click.prevent="addSong">
          Save
        </button>
      </form>
      <!-- END OF ADD SONG FORM -->
    </div>
    <!-- START Approve/Deny SONG FORM -->
    <div>
      <form>
        newSong:
        <input
          placeholder="EventID"
          type="text"
          class="form-control"
          v-model="linkEventID"
        />
        <input
          placeholder="SongID"
          type="text"
          class="form-control"
          v-model="linkSongID"
        />
        <button class="btn btn-submit" v-on:click.prevent="approveSong">
          Approve
        </button>

        <button class="btn btn-submit" v-on:click.prevent="rejectSong">
          reject
        </button>
      </form>
    </div>
    <!-- END OF ADD SONG FORM -->
    <!-- START ADD Search Song FORM -->
    <div>
      <form>
        newSong:
        <input
          placeholder="Search"
          type="text"
          class="form-control"
          v-model="searchParam"
        />
        <button class="btn btn-submit" v-on:click.prevent="search">Save</button>
      </form>
      <!-- END OF Search SONG FORM -->

      <button class="btn btn-submit" v-on:click.prevent="playSong">
        playSong
      </button>
      <button class="btn btn-submit" v-on:click.prevent="nextSong">
        nextSong
      </button>
      <button class="btn btn-submit" v-on:click.prevent="currentSong">
        currentSong
      </button>
    </div>
    <table class="display-playlist">
      <tr>
        <th class="leftest-cell">Song Title</th>
        <th class="rightest-cell">Artist</th>
      </tr>
      <tr v-for="song in searchResult" v-bind:key="song.spotifySongURI">
        
        <td>{{ song.title }}</td>
        <td>{{ song.artist }}</td>
      </tr>
    
    </table>
  </body>
</template>

<script>
import spotifyService from "../services/SpotifyService";
import eventService from "../services/EventService";
import Search from "../components/Search.vue";

export default {
  components: Search,

  data() {
    return {
      newEvent: {
        eventID: "",
        eventName: "",
        eventBegin: "",
        eventEnd: "",
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
      searchResult: [],
      searchSong: {
        title: "",
        artist: "",
        spotifySongURI: "",
        genre: "",
        album: "",
        albumArt: "",
      },
      newSuggestion: {
        songID: "",
        eventID: "",
      },
      linkEventID: "",
      linkSongID: "",
      searchParam: "",
    };
  },
  computed: {
    //  currentSongArt(){

    // this.currentSong.then(response =>
    // response.data.item.album.images[0]

    // )
    // }
    searchResults() {
      if (this.searchResult.length > 0) {
        return this.searchParam;
      }
      return this.searchResult;
    },
  },
  methods: {
    playSong() {
      spotifyService.playSong();
    },
    nextSong() {
      spotifyService.nextSong();
    },
    currentSong() {
      spotifyService.currentSong();
    },
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
    authorize() {
      spotifyService.authorize();
    },
    spotAuth() {
      alert("Here");
      spotifyService.getAuth();
    },

    spotSong() {
      spotifyService.getSong();
    },

    getUsername() {
      alert("Button WORKS");

      let username = this.$state.user;

      return username;
    },

    addEvent() {
      this.newEvent = {
        eventID: Number(this.$route.params.eventID),
        eventName: this.newEvent.eventName,
        eventBegin: this.newEvent.eventBegin,
        eventEnd: this.newEvent.eventEnd,
      };

      eventService.addEvent(this.newEvent);

      console.log(Response.data);
    },

    addSong() {
      this.newSong = {
        songID: Number(this.$route.params.eventID),
        title: this.newSong.title,
        artist: this.newSong.artist,
        spotifySongURI: this.newSong.spotifySongURI,
        genre: this.newSong.genre,
        album: this.newSong.album,
        albumArt: this.newSong.albumArt,
      };

      eventService.addSong(this.newSong);

      console.log(this.newSong);
    },
    approveSong(eventID, songID) {
      eventID = this.linkEventID;
      songID = this.linkSongID;

      eventService.approveSong(eventID, songID);
    },
    rejectSong(eventID, songID) {
      eventID = this.linkEventID;
      songID = this.linkSongID;

      eventService.rejectSong(eventID, songID);
    },

    retrievePlaylist(eventID) {
      eventID = 1;

      console.log(eventService.playlist(eventID));
      return eventService.playlist(eventID);
    },

    retrieveSuggested(eventID) {
      eventID = 1;
      eventService.playlist(eventID);
      console.log(eventService.suggested(eventID));
      return eventService.suggested(eventID);
    },
  },
};
</script>

