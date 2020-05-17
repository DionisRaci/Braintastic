<template>
  <div class="w-full max-w-sm mx-auto">
    <div>
      <h1 class="text-4xl font-bold text-gray-900">Braintastic 🤯</h1>
      <h2 class="mt-6 text-3xl font-extrabold leading-9 text-gray-900">
        Join <span class="text-blue-700">{{ sessionName }}</span>
      </h2>
      <p class="mt-2 text-lg font-medium">Created by <span class="text-blue-700">{{ sessionHost }}</span></p>
    </div>
    <div class="mt-8">
      <div class="mt-6">
        <div>
          <label
            for="email"
            class="block text-md font-medium leading-5 text-gray-900"
          >
            Your name
          </label>
          <div class="mt-1 rounded-md shadow-sm">
            <input
              id="name"
              type="name"
              required
              v-model="username"
              placeholder="Your name"
              class="block w-full px-3 py-2 transition duration-150 ease-in-out border border-gray-700 rounded-md appearance-none focus:outline-none focus:shadow-outline-blue focus:border-blue-300 sm:text-sm sm:leading-5"
            />
          </div>
        </div>
        <div v-if="!filledAllFields" class="mt-6 bg-red-100 border border-red-400 text-red-700 px-4 py-2 rounded relative" role="alert">
          <strong class="font-bold">Stop! </strong>
          <span class="block sm:inline">Please fill in your name.</span>
        </div>

        <div class="mt-6">
          <span class="block w-full rounded-md shadow-sm">
            <button
              @click="onJoin"
              type="submit"
              class="flex justify-center w-full px-4 py-2 text-md font-medium text-white transition duration-150 ease-in-out bg-blue-700 border border-transparent rounded-md hover:bg-blue-500 focus:outline-none focus:border-indigo-700 focus:shadow-outline-indigo active:bg-indigo-700"
            >
              Join now
            </button>
          </span>
        </div>
      </div>
    </div>
  </div>
</template>>

<script>
import axios from 'axios'

import router from '@/router'

const baseURL = 'http://localhost:8080/'

export default {
  data () {
    return {
      sessionId: this.$route.params.id,
      sessionHost: '',
      sessionName: '',
      username: '',
      password: null,
      filledAllFields: true
    }
  },
  async created () {
    axios.get(baseURL + 'Session/id/' + this.sessionId)
      .then(res => {
        console.log(res.data)
        this.sessionHost = res.data.host.name
        this.sessionName = res.data.name
      })
      .catch(error => {
        console.error('Session not existing: ' + error)
        router.push({ name: 'register' })
      })
    // next(isUndefined ? { name: 'register' } : true)
  },
  methods: {
    onJoin () {
      if (this.username == null) {
        this.filledAllFields = false
      } else {
        this.filledAllFields = true
        // eslint-disable-next-line no-unused-vars
        const res = axios.post(baseURL + 'Participant', { name: this.username })
          .then(response => {
            console.log(response)
            if (response.status === 200) {
              console.log(axios.post(baseURL + 'Session/addParticipant/' + this.sessionId, { name: this.username }))
              router.push('/session/' + this.sessionId + '/' + this.username)
            } else {
              this.userIsCorrect = false
            }
          })
          .catch(error => {
            this.userIsCorrect = false
            console.log(error.response)
            console.log(this.usernameAvailable = false)
          })
      }
    }
  }
}
</script>

<style></style>
