<template>
  <div class="w-full max-w-sm mx-auto">
    <div>
      <h1 class="text-4xl font-bold text-gray-900">Braintastic 🤯</h1>
      <h2 class="mt-6 text-3xl font-extrabold leading-9 text-gray-900">
        Register Successful!
      </h2>
    </div>
      <div class="mt-8">
        <div class="mt-6">
          <div class="mt-6">
            <span class="block w-full rounded-md shadow-sm">
              <router-link to="create">
                <button
                  type="submit"
                  class="flex justify-center w-full px-4 py-2 text-md font-medium text-white transition duration-150 ease-in-out bg-blue-700 border border-transparent rounded-md hover:bg-blue-500 focus:outline-none focus:border-indigo-700 focus:shadow-outline-indigo active:bg-indigo-700"
                >
                  Go to Braintastic
                </button>
              </router-link>
            </span>
          </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {

    }
  }
}
</script>

<style></style>
