<template>
  <div>
    <div class="bg-blue-700 pb-32">
      <nav class="bg-blue-700">
        <div class="max-w-7xl mx-auto sm:px-6 lg:px-8">
          <div class="border-b border-blue-700">
            <div class="flex items-center justify-between h-16 px-4 sm:px-0">
              <div class="flex items-center">
                <div class="flex-shrink-0">
                  <h1 class="text-3xl font-bold text-white">Braintastic 🤯</h1>
                </div>
              </div>
              <div class="hidden md:block">
                <div class="ml-4 flex items-center md:ml-6">
                  <div class="p-1 border-2 border-transparent text-white">
                    <p>Welcome back, {{ username }}!</p>
                  </div>

                  <!-- Profile dropdown -->
                  <div class="ml-3 relative">
                    <div>
                      <button class="max-w-xs flex items-center text-sm rounded-full text-white focus:outline-none focus:shadow-solid" id="user-menu" aria-label="User menu" aria-haspopup="true">
                        <img class="h-8 w-8 rounded-full" src="https://i0.wp.com/a.slack-edge.com/7fa9/img/avatars/ava_0006-512.png?ssl=1" alt="" />
                      </button>
                    </div>
                    <!--
                      Profile dropdown panel, show/hide based on dropdown state.

                      Entering: "transition ease-out duration-100"
                        From: "transform opacity-0 scale-95"
                        To: "transform opacity-100 scale-100"
                      Leaving: "transition ease-in duration-75"
                        From: "transform opacity-100 scale-100"
                        To: "transform opacity-0 scale-95"
                    -->
                    <!--<div class="origin-top-right absolute right-0 mt-2 w-48 rounded-md shadow-lg">
                      <div class="py-1 rounded-md bg-white shadow-xs">
                        <a href="#" class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100">Your Profile</a>
                        <a href="#" class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100">Settings</a>
                        <a href="#" class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100">Sign out</a>
                      </div>
                    </div>-->
                  </div>
                </div>
              </div>
              <div class="-mr-2 flex md:hidden">
                <!-- Mobile menu button -->
                <button class="inline-flex items-center justify-center p-2 rounded-md text-gray-400 hover:text-white hover:bg-gray-700 focus:outline-none focus:bg-gray-700 focus:text-white">
                  <!-- Menu open: "hidden", Menu closed: "block" -->
                  <svg class="block h-6 w-6" stroke="currentColor" fill="none" viewBox="0 0 24 24">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16" />
                  </svg>
                  <!-- Menu open: "block", Menu closed: "hidden" -->
                  <svg class="hidden h-6 w-6" stroke="currentColor" fill="none" viewBox="0 0 24 24">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M6 18L18 6M6 6l12 12" />
                  </svg>
                </button>
              </div>
            </div>
          </div>
        </div>

        <!--
          Mobile menu, toggle classes based on menu state.

          Open: "block", closed: "hidden"
        -->
        <div class="hidden border-b border-gray-700 md:hidden">
          <div class="px-2 py-3 sm:px-3">
            <a href="#" class="block px-3 py-2 rounded-md text-base font-medium text-white bg-gray-900 focus:outline-none focus:text-white focus:bg-gray-700">Dashboard</a>
            <a href="#" class="mt-1 block px-3 py-2 rounded-md text-base font-medium text-gray-300 hover:text-white hover:bg-gray-700 focus:outline-none focus:text-white focus:bg-gray-700">Team</a>
            <a href="#" class="mt-1 block px-3 py-2 rounded-md text-base font-medium text-gray-300 hover:text-white hover:bg-gray-700 focus:outline-none focus:text-white focus:bg-gray-700">Projects</a>
            <a href="#" class="mt-1 block px-3 py-2 rounded-md text-base font-medium text-gray-300 hover:text-white hover:bg-gray-700 focus:outline-none focus:text-white focus:bg-gray-700">Calendar</a>
            <a href="#" class="mt-1 block px-3 py-2 rounded-md text-base font-medium text-gray-300 hover:text-white hover:bg-gray-700 focus:outline-none focus:text-white focus:bg-gray-700">Reports</a>
          </div>
          <div class="pt-4 pb-3 border-t border-gray-700">
            <div class="flex items-center px-5">
              <div class="flex-shrink-0">
                <img class="h-10 w-10 rounded-full" src="https://images.unsplash.com/photo-1472099645785-5658abf4ff4e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=facearea&facepad=2&w=256&h=256&q=80" alt="" />
              </div>
              <div class="ml-3">
                <div class="text-base font-medium leading-none text-white">Tom Cook</div>
                <div class="mt-1 text-sm font-medium leading-none text-gray-400">tom@example.com</div>
              </div>
            </div>
            <div class="mt-3 px-2" role="menu">
              <a href="#" class="block px-3 py-2 rounded-md text-base font-medium text-gray-400 hover:text-white hover:bg-gray-700 focus:outline-none focus:text-white focus:bg-gray-700" role="menuitem">Your Profile</a>
              <a href="#" class="mt-1 block px-3 py-2 rounded-md text-base font-medium text-gray-400 hover:text-white hover:bg-gray-700 focus:outline-none focus:text-white focus:bg-gray-700" role="menuitem">Settings</a>
              <a href="#" class="mt-1 block px-3 py-2 rounded-md text-base font-medium text-gray-400 hover:text-white hover:bg-gray-700 focus:outline-none focus:text-white focus:bg-gray-700" role="menuitem">Sign out</a>
            </div>
          </div>
        </div>
      </nav>
      <header class="pt-10 pb-4 flex">
        <div class=" mx-auto px-4 sm:px-6 lg:px-8 md:w-1/2 w-full">
          <h1 class="text-4xl leading-9 font-bold text-white">
            🏁 Start your idea session
          </h1>
        </div>
      </header>
    </div>

    <main class="-mt-32 flex">
      <div class="max-w-7xl mx-auto pb-12 p-8 m-auto inline-block w-full md:w-1/2 sm:px-6 lg:px-8">
        <!-- Replace with your content -->
        <div class="bg-white rounded-lg shadow px-8 py-6 sm:px-6 flex">
          <div class="w-full">
            <h2 class="text-2xl font-bold text-blue-700">Session name</h2>
            <div class="mt-1 relative rounded-md shadow-sm  border-gray-500">
              <input @change="isTitleEmpty" v-model="sessionTitle" class="outline-none form-input text-gray-700 block border-blue-400 border-b-2 p-4 w-full sm:text-lg sm:leading-5" placeholder="Write a meaningful name."/>
            </div>
            <label
              v-if="titleEmpty"
              class="text-red-700">Please enter a session title.</label>
            <div v-if="sessionCreated" class="flex justify-center py-8">
              <img src="https://media1.tenor.com/images/fa426d4e81cd8112496bb996278183f3/tenor.gif?itemid=15240735" alt="">
            </div>
            <div>
              <div class="flex mt-10">
                <span v-if="!sessionCreated" class="inline-flex rounded-md shadow-sm">
                  <button @click="onGenerateLink" type="button" class="inline-flex items-center px-4 py-2 border border-transparent text-base leading-6 font-medium rounded-md text-white bg-blue-700 hover:bg-blue-600 focus:outline-none focus:border-blue-900 focus:shadow-outline-indigo active:bg-indigo-700 transition ease-in-out duration-150">
                    Generate your link
                  </button>
                </span>
                <div>
                  <p
                  v-if="!sessionCreated && sessionCreated !== null"
                  class="text-red-700 pt-2 pl-4">Something went wrong. Please try again!</p>
                  <p
                  v-if="sessionCreated"
                  class="text-gray-700 text-lg pl-4">Your session link is: <span class="text-green-700 text-xl pl-2">{{ sessionLink }}</span> </p>
                </div>
              </div>

            </div>
          </div>

          <div></div>
        </div>
        <!-- /End replace -->
      </div>
    </main>
  </div>
</template>

<script>
import axios from 'axios'

const baseURL = 'http://localhost:8080/'

export default {
  data () {
    return {
      username: this.$route.params.id,
      sessionTitle: null,
      titleEmpty: false,
      descriptionEmpty: false,
      sessionCreated: null,
      sessionId: null,
      sessionLink: baseURL + 'join/' + this.sessionId
    }
  },
  methods: {
    isTitleEmpty () {
      if (this.sessionTitle === '' || this.sessionTitle === null) {
        this.titleEmpty = true
        return true
      } else {
        this.titleEmpty = false
        return false
      }
    },
    isDescriptionEmpty () {
      if (this.sessionDescription === '' || this.sessionDescription === null) {
        this.descriptionEmpty = true
        return true
      } else {
        this.descriptionEmpty = false
        return false
      }
    },
    onGenerateLink () {
      if (!this.isTitleEmpty() || !this.isDescriptionEmpty()) {
        // eslint-disable-next-line no-unused-vars
        const res = axios.post(baseURL + 'Session', { userName: this.username, name: this.sessionTitle })
          .then(response => {
            console.log(response)
            if (response.status === 200) {
              this.sessionCreated = true
            }
          })
          .catch(error => {
            this.sessionCreated = false
            console.log(error.response)
            console.log(this.usernameAvailable = false)
          })
      }
    }
  }
}
</script>

<style>
</style>
