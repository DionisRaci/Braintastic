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
                    <p>Welcome, {{ username }}!</p>
                  </div>
                </div>
              </div>
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
            <div v-if="sessionCreated" class="flex justify-center mt-8">
              <img src="https://media1.tenor.com/images/fa426d4e81cd8112496bb996278183f3/tenor.gif?itemid=15240735" alt="">
            </div>
            <div>
              <div class="flex mt-8">
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
                  class="text-gray-700 text-lg">Your session link is: <span class="text-green-700 text-xl pl-0 sm:pl-2">{{ sessionLink }}</span> </p>
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
      sessionLink: null
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
              this.sessionId = response.data
              this.sessionLink = baseURL + 'join/' + this.sessionId
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
