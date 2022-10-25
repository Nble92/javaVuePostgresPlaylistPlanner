<template>
<div>
  <h1 class="welcome">Welcome!</h1>
 
  <add-event/>
  <join-form class="home-auth-join-form"/>

  </div>
</template>

<script>
import AddEvent from './AddEvent.vue'
import JoinForm from './JoinForm.vue'



export default {
    name: 'home-auth',
    components: {
        AddEvent,
        JoinForm
        
    },
    
        
    }
</script>
<style>

.welcome {
  text-align: center;
}
/* h1 {
  text-align: center;
  margin-top: 75px;
  text-shadow: 5px 5px rgb(31, 11, 31);
  font-size: 5rem;
  letter-spacing: .4rem;
} */
/* 
h2 {
  text-shadow: 3px 3px rgb(31, 11, 31);
} */

.home-auth-join-form {
  padding-bottom: 100px;
}

</style>