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
                  required
                  placeholder="Your email"
                  class="block w-full px-3 py-2 transition duration-150 ease-in-out border border-gray-700 rounded-md appearance-none focus:outline-none focus:shadow-outline-blue focus:border-blue-300 sm:text-sm sm:leading-5"
                />
              </div>
            </div>

            <div class="mt-6">
              <label
                for="password"
                class="block text-md font-medium leading-5 text-gray-900"
              >
                Password
              </label>
              <div class="mt-1 rounded-md shadow-sm">
                <input
                  id="password"
                  type="password"
                  required
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

            <div class="mt-6">
              <span class="block w-full rounded-md shadow-sm">
                <button
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
export default {}
</script>

<style></style>
