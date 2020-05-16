<template>
  <div>
    <nav class="bg-blue-700">
      <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div class="flex items-center justify-between h-16">
          <div class="flex items-center">
            <div class="flex-shrink-0">
              <h1 class="text-3xl font-bold text-white">Braintastic 🤯</h1>
            </div>
          </div>
          <div class="hidden md:block">
            <div class="ml-4 flex items-center md:ml-6">
              <div class="p-1 border-2 border-transparent text-white">
                <p>Thank you for your participation, <span class="font-bold">{{ username }}</span> !</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </nav>

    <header class="bg-white shadow-md">
      <div class="max-w-7xl mx-auto py-4 px-4 sm:px-6 lg:px-8">
        <p class="md:float-right text-gray-700 font-medium">There are {{participantsCount}} participants</p>
        <h1 class="text-lg sm:text-xl md:text-2xl leading-6 font-semibold text-gray-700">
          {{ sessionName }}
        </h1>
      </div>
    </header>
    <main>
      <div class="max-w-7xl bg-gray-200 h-screen mx-auto px-4 sm:px-6 lg:px-8">
        <div class="grid grid-cols-1 sm:gap-4 md:gap-10 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-5">
          <app-card></app-card>
        </div>

      </div>
    </main>
  </div>
</template>

<script>
import Card from '../components/Card.vue'
import axios from 'axios'

const baseURL = 'http://localhost:8080/'
export default {
  components: {
    'app-card': Card
  },
  data () {
    return {
      sessionId: this.$route.params.id,
      sessionName: '',
      username: this.$route.params.name,
      ideas: [],
      participantsCount: 0
    }
  },
  async created () {
    await axios.get(baseURL + 'Session/id/' + this.sessionId)
      .then(res => {
        this.sessionName = res.data.name
      })
  },
  mounted () {
    this.$nextTick(function () {
      window.setInterval(() => {
        axios.get(baseURL + 'Session/' + this.sessionId + '/ideas')
          .then(res => {
            this.id = res.data
          })
      }, 1000)
    })
  }
}
</script>

<style>

</style>
