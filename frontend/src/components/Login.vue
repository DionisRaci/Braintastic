<template>
  <div class="w-full max-w-sm mx-auto">
    <div>
      <h1 class="text-4xl font-bold text-gray-900">Braintastic 🤯</h1>
      <h2 class="mt-6 text-3xl font-extrabold leading-9 text-gray-900">
        Sign-in to your account
      </h2>
    </div>
      <div class="mt-8">
        <div class="mt-6">
            <div>
              <label
                for="email"
                class="block text-md font-medium leading-5 text-gray-900"
              >
                Email address
              </label>
              <div class="mt-1 rounded-md shadow-sm">
                <input
                  id="email"
                  type="email"
                  @change="validateEmail(username)"
                  required
                  v-model="username"
                  placeholder="Your email"
                  class="block w-full px-3 py-2 transition duration-150 ease-in-out border border-gray-700 rounded-md appearance-none focus:outline-none focus:shadow-outline-blue focus:border-blue-300 sm:text-sm sm:leading-5"
                />
              </div>
              <label
              v-if="!isValidEmail"
              class="text-red-700">Enter a valid E-mail adress</label>
            </div>

            <div class="mt-6">
              <label
                for="password"
                class="block text-md font-medium leading-5 text-gray-900"
              >
                Password {{password}}
              </label>
              <div class="mt-1 rounded-md shadow-sm">
                <input
                  id="password"
                  type="password"
                  required
                  v-model="password"
                  placeholder="Your password"
                  class="block w-full px-3 py-2 transition duration-150 ease-in-out border border-gray-700 rounded-md appearance-none focus:outline-none focus:shadow-outline-blue focus:border-blue-300 sm:text-sm sm:leading-5"
                />
              </div>
            </div>

            <div class="flex items-center justify-between mt-6">
              <div class="flex items-center">
                <input
                  id="remember_me"
                  type="checkbox"
                  class="w-4 h-4 text-indigo-600 transition duration-150 ease-in-out form-checkbox"
                />
                <label
                  for="remember_me"
                  class="block ml-2 text-md leading-5 text-gray-900"
                >
                  Remember me
                </label>
              </div>
            </div>

            <div v-if="!filledAllFields" class="mt-6 bg-red-100 border border-red-400 text-red-700 px-4 py-2 rounded relative" role="alert">
              <strong class="font-bold">Stop! </strong>
              <span class="block sm:inline">First fill in all the fields</span>
            </div>

            <div v-if="!userIsCorrect" class="mt-6 bg-red-100 border border-red-400 text-red-700 px-4 py-2 rounded relative" role="alert">
              <strong class="font-bold">Sorry! </strong>
              <span class="block sm:inline">Wrong username or password.</span>
            </div>

            <div class="mt-6">
              <span class="block w-full rounded-md shadow-sm">
                <button
                  @click="onSignIn"
                  type="submit"
                  class="flex justify-center w-full px-4 py-2 text-md font-medium text-white transition duration-150 ease-in-out bg-blue-700 border border-transparent rounded-md hover:bg-blue-500 focus:outline-none focus:border-indigo-700 focus:shadow-outline-indigo active:bg-indigo-700"
                >
                  Sign in
                </button>
              </span>
            </div>
            <p class="mt-2 text-md leading-5 text-gray-900 max-w">
          Don't have an account?
          <router-link
            to="register"
            class="font-medium text-blue-700 transition duration-150 ease-in-out hover:text-blue-500 focus:outline-none focus:underline"
          >
            Sign up
          </router-link>
        </p>
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
          this.token = response.data
        })
        .catch(error => {
          console.log(error.response)
        })
    }
  }
}
</script>

<style></style>
