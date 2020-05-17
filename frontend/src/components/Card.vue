<template>
  <div class="mt-8 bg-white overflow-hidden shadow rounded-lg">
    <div class=" px-4 py-5 sm:px-6">
      <p>{{ text }}</p>
      <!-- Content goes here -->
      <!-- We use less vertical padding on card headers on desktop than on body sections -->
    </div>
  </div>
</template>

<script>
import axios from 'axios'

const baseURL = 'http://localhost:8080/'

export default {
  props: [
    'text',
    'id'
  ],
  created () {
    axios.get(baseURL + 'Session/' + this.sessionId + '/ideas')
      .then(res => {
        this.ideas = res.data
      })
  }

}
</script>

<style>

</style>
