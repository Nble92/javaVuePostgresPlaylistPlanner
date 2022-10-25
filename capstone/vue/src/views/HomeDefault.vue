<template>
  <component :is="view"></component>
</template>

<script>

export default {

  name: 'home-default',
  data() {
    return {
        
    }
  },
  computed: {
   view() {
     return (this.$store.state.token !== '') ? 'home-auth' : 'home-guest'
   }  
  }

}

</script>

