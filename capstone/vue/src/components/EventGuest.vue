<template>
<div class = 'container'>
  
  <h1 class="event-guest-h1">Welcome</h1>

  <div class="two-items">
  <song-form class="search"/>
  <!-- <div> -->
  <playlist class="songlist"/>
  </div>
    

</div>
</template>

<script>
import SongForm from '../components/SongForm.vue'
import Playlist from './Playlist.vue'
export default {
    name: 'event_guest',
    components: {
        SongForm,
        Playlist
    },
    }
</script>

<style>
 

/* .container {
  display: flex;
  flex-direction: column;
        
} */

.two-items {
  display: flex;
  align-content: space-around;
}

/* .search {
  align-self: center;
}

.songlist {
  justify-content: center;
} */
 .event-guest-h1 {
  font-size: 3rem;
  text-align: center;
}
/* .border {
border: 4px solid rgb(31, 11, 31);
border-radius:15px;
margin-left:20%;
margin-right:20%;
background:rgba(31, 11, 31, 0.5);
max-width: 700px;
padding-left: 30px;
padding-right: 30px;
margin-top: 50px;

} */

</style>

