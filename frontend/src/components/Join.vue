<template>
  <div class="w-full max-w-sm mx-auto">
    <div>
      <h1 class="text-4xl font-bold text-gray-900">Braintastic 🤯</h1>
      <h2 class="mt-6 text-3xl font-extrabold leading-9 text-gray-900">
        Join the brainstorming session
      </h2>
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
          <span class="block sm:inline">First fill in all the fields</span>
        </div>

        <div v-if="!userIsCorrect" class="mt-6 bg-red-100 border border-red-400 text-red-700 px-4 py-2 rounded relative" role="alert">
          <strong class="font-bold">Sorry! </strong>
          <span class="block sm:inline">Name already taken!</span>
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
      username: '',
      password: null,
      isValidEmail: true,
      filledAllFields: true,
      usernameAvailable: true,
      givenResponse: null,
      userIsCorrect: true,
      token: ''
    }
  },
  methods: {
    onSignIn () {
      if (this.username == null || this.password == null) {
        this.filledAllFields = false
      } else {
        this.filledAllFields = true
        if (this.validateEmail(this.username)) {
          // eslint-disable-next-line no-unused-vars
          const res = axios.post(baseURL + 'user/login', { name: this.username, password: this.password })
            .then(response => {
              console.log(response.status)
              console.log(response.headers.sessionId)

              console.log(response)
              if (response.status === 200) {
                router.push('/create/' + this.username)
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
    },
    validateEmail (email) {
      var re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
      this.isValidEmail = re.test(String(email).toLowerCase())
      return re.test(String(email).toLowerCase())
    },
    getToken () {
      // eslint-disable-next-line no-unused-vars
      const res = axios.get(baseURL + 'user/Token')
        .then(response => {
          console.log(response.status)
          console.log(response.data)
          this.token = response.data
          console.error(this.token)
          console.log(response)
        })
        .catch(error => {
          console.log(error.response)
        })
    }
  }
}
</script>

<style></style>
