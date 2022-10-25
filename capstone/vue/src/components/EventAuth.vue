<template>
<div>
  <h1 class="DJ">Welcome DJ!</h1>
  <song-form/>
  <div id="tables">
  <dj-queue id="event-auth-queue"/>
  <playlist-auth/>

  </div>

  </div>

  
</template>

<script>

import DjQueue from "./DjQueue.vue";
import SongForm from "@/components/SongForm.vue";
import PlaylistAuth from './Playlist Auth.vue';

export default {
  name: "event-auth",
  components: {
    PlaylistAuth,
    DjQueue,
    SongForm,
   
  }
};
</script>

<style>
/* #event-auth-queue {
  margin-bottom: 35px;

}

#tables {
display: flex;
justify-content: space-around;
margin-right: 20%;
margin-left: 20%;

} */
.DJ {
  font-size: 2.5rem;
}
</style>