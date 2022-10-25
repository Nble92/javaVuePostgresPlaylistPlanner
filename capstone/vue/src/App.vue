<template>



  <div id="app">
    <div id="nav">
      
      <ul>
         <li><img src="@/images/disco_ball_2.png" alt="" class="disco"></li>
        <!-- <span class="router-span"> -->
        <li class="home">
          <router-link  v-bind:to="{ name: 'home' }" class="routerlink">Home</router-link>
        </li>
        <!-- </span> -->
        <!-- <span class="router-span" v-if="$store.state.token != ''"> -->
        <li class="logout">
          <router-link v-bind:to="{ name: 'logout' }" class="routerlink" v-if="$store.state.token != ''">Logout</router-link>
        </li>
        <!-- </span> -->
        <!-- <span class="router-span" v-if="$store.state.token != ''"> -->
        <!-- <li class="my-events">
          <router-link v-bind:to="{ name: 'my-events' }" v-if="$store.state.token != ''">My Events</router-link>
        </li> -->
        <!-- </span> -->
       
      </ul>
     
    </div>
    <router-view />
  </div>
</template>

<style>

@import 'https://cdn.jsdelivr.net/npm/water.css@2/out/dark.css';
*{
  font-family: "comfortaa";
  src: local("comfortaa"),
   url(./fonts/Comfortaa-Regular.ttf) format("truetype");
}

/* {
  color: rgb(255, 219, 17);
  margin: 0;
  padding: 0;
} */

.routerlink {
  color: rgb(160, 138, 196);
}

.app {
  background-image: linear-gradient(rgb(82, 8, 82), rgb(144, 64, 144));
}


input {
  color: rgb(82, 8, 82);
}
*/
#nav {
  margin: 0;
  padding: 0;
}

ul {
  display: flex;
  list-style-type: none;
  border: 0px;
  background-color: rgb(54, 20, 54);
  background-image: linear-gradient( rgb(54, 20, 54),  rgb(12, 11, 12));
  overflow: hidden;
  justify-content: flex-start;
  align-items: center;
}

li {
  padding: 5px;
}

.disco {
  max-width: 50px;
}
/*
.router-span {
  padding: 12px 17px;
  background: rgb(31, 30, 31);
  border: solid;
  border-radius: 8px;
  border-color: rgb(82, 8, 82);
  margin: 10px;
}

.routerlink {
  text-decoration: none;
} */

.form-control {

  color: aliceblue;



}

.btn-submit {

background-color: rgb(160, 138, 196);
color: rgb(12, 11, 12);
font-family: "comfortaa";
  src: local("comfortaa"),
   url(./fonts/Comfortaa-Regular.ttf) format("truetype");
   font-weight: bold;



}
</style>

