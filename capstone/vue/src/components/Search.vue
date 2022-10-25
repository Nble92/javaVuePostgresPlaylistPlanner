<template>
  
 <table class="display-playlist">
        <tr>
          <th class="leftest-cell">Song Title</th>
          <th class="rightest-cell">Artist</th>
        </tr>
        <tr v-for="song in searchResults"
            v-bind:key="song.uri">
       <td>{{song.title}}</td>
        <td>{{song.artist}}</td>
        </tr>
        
    </table>
    
</template>

<script>
import spotifyService from "../services/SpotifyService";


export default {
  components: "",
  
  data() {
    return {
      newSong: {
        songID: "",
        title: "",
        artist: "",
        spotifySongURI: "",
        genre: "",
        album: "",
        albumArt: "",
      },
      searchResult: [
{
title: "Man on The Moon",
artist: "Kid Cudi"

}
      ],
      searchSong: {
        title: "",
        artist: "",
        spotifySongURI: "",
        genre: "",
        album: "",
        albumArt: "",
      }
      ,
      newSuggestion: {
        songID: "",
        eventID: "",
      },
      linkEventID: "",
      linkSongID: "",
      searchParam: "",
    };
  },
  computed:{
//  currentSongArt(){

// this.currentSong.then(response =>
// response.data.item.album.images[0]

// )
// }
searchResults(){
if(this.searchResult.length > 0){
return this.searchParam
}
return this.searchResult
}
},
  methods: {
    playSong(){
spotifyService.playSong()

    },
    nextSong(){
spotifyService.nextSong()

    },
    currentSong(){
spotifyService.currentSong()

    },
    async search() {
      
      await spotifyService.searchSong(this.searchParam).then(response =>{ 
        this.searchResult = []
        for(let i = 0; i < 10; i++){
        this.searchSong = {
        title: response.data.tracks.items[i].name,
        artist: response.data.tracks.items[i].album.artists[0].name,
        spotifySongURI: response.data.tracks.items[i].uri,
        genre: "",
        album: response.data.tracks.items[i].album.name,
        albumArt: response.data.tracks.items[i].album.images[0]
       }
      console.log(this.searchSong);
      this.searchResult.push(this.searchSong)
        }
      console.log(this.searchResult)
      return this.searchResult
       });
    }
    },
  }

</script>

<style>

</style>

