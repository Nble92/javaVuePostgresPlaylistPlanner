<template>
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
</template>

<script>
export default 

{

}
</script>

<style>

</style>