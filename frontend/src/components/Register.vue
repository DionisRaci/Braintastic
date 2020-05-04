<template>
  <div class="w-full max-w-sm mx-auto">
    <div>
      <h1 class="text-4xl font-bold text-gray-900">Braintastic 🤯</h1>
      <h2 class="mt-6 text-3xl font-extrabold leading-9 text-gray-900">
        Sign-up a new account
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
                  v-model="username"
                  @change="validateEmail(username)"
                  id="email"
                  type="email"
                  required
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
                Password {{ password }}
              </label>
              <div class="mt-1 rounded-md shadow-sm">
                <input
                  v-model="password"
                  id="password"
                  type="password"
                  required
                  placeholder="Your password"
                  class="block w-full px-3 py-2 transition duration-150 ease-in-out border border-gray-700 rounded-md appearance-none focus:outline-none focus:shadow-outline-blue focus:border-blue-300 sm:text-sm sm:leading-5"
                />
              </div>
            </div>

            <div class="mt-6">
              <label
                for="password"
                class="block text-md font-medium leading-5 text-gray-900"
              >
                Repeat Password {{ repPassword }}
              </label>
              <div class="mt-1 rounded-md shadow-sm">
                <input
                  v-model="repPassword"
                  @change="checkIfPasswordsMatch"
                  id="repPassword"
                  type="password"
                  required
                  placeholder="Repeat password"
                  class="block w-full px-3 py-2 transition duration-150 ease-in-out border border-gray-700 rounded-md appearance-none focus:outline-none focus:shadow-outline-blue focus:border-blue-300 sm:text-sm sm:leading-5"
                />
              </div>
              <label
              v-if="passwordsDontMatch"
              class="text-red-700">Repeated password does not match.</label>
            </div>

            <div v-if="!filledAllFields" class="mt-6 bg-red-100 border border-red-400 text-red-700 px-4 py-2 rounded relative" role="alert">
              <strong class="font-bold">Stop! </strong>
              <span class="block sm:inline">First fill in all the fields</span>
            </div>
            <div v-if="!usernameAvailable" class="mt-6 bg-red-100 border border-red-400 text-red-700 px-4 py-2 rounded relative" role="alert">
              <span class="block sm:inline">Username is not available!</span>
            </div>

            <div class="mt-6">
              <span class="block w-full rounded-md shadow-sm">
                <button
                  @click="onSignUp"
                  type="submit"
                  class="flex justify-center w-full px-4 py-2 text-md font-medium text-white transition duration-150 ease-in-out bg-blue-700 border border-transparent rounded-md hover:bg-blue-500 focus:outline-none focus:border-indigo-700 focus:shadow-outline-indigo active:bg-indigo-700"
                >
                  Sign up
                </button>
              </span>
            </div>
            <p class="mt-2 text-md leading-5 text-gray-900 max-w">
          Already have an account?
          <router-link
            to="login"
            class="font-medium text-blue-700 transition duration-150 ease-in-out hover:text-blue-500 focus:outline-none focus:underline disabled"
          >
            Sign in
          </router-link>
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

import router from '@/router'

const baseURL = 'http://localhost:8080/'

export default {
  data () {
    return {
      username: '',
      password: null,
      repPassword: null,
      isValidEmail: true,
      passwordsDontMatch: false,
      filledAllFields: true,
      usernameAvailable: true,
      givenResponse: null
    }
  },
  methods: {
    onSignUp () {
      if (this.username == null || this.password == null || this.repPassword == null) {
        this.filledAllFields = false
      } else {
        this.filledAllFields = true
        if (this.checkIfPasswordsMatch() || this.validateEmail(this.username)) {
          // eslint-disable-next-line no-unused-vars
          const res = axios.post(baseURL + 'user', { name: this.username, password: this.password })
            .then(response => {
              console.log(response.status)
              console.log(response)
              if (response.status === 200) {
                router.push('register-successful')
              }
            })
            .catch(error => {
              console.log(error.response)
              console.log(this.usernameAvailable = false)
            })
        }
      }
    },
    checkIfPasswordsMatch () {
      if (this.password !== this.repPassword) {
        this.passwordsDontMatch = true
        return false
      } else {
        this.passwordsDontMatch = false
        return true
      }
    },
    validateEmail (email) {
      var re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
      this.isValidEmail = re.test(String(email).toLowerCase())
      return re.test(String(email).toLowerCase())
    }
  }
}
</script>

<style></style>
