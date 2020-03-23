<template>
  <div>
    <div class="bg-indigo-600">
      <div class="max-w-screen-xl px-3 py-3 mx-auto sm:px-6 lg:px-8">
        <div class="flex flex-wrap items-center justify-between">
          <div class="flex items-center flex-1 w-0">
            <span class="flex p-2 bg-indigo-800 rounded-lg">
              <svg
                class="w-6 h-6 text-white"
                stroke="currentColor"
                fill="none"
                viewBox="0 0 24 24"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M11 5.882V19.24a1.76 1.76 0 01-3.417.592l-2.147-6.15M18 13a3 3 0 100-6M5.436 13.683A4.001 4.001 0 017 6h1.832c4.1 0 7.625-1.234 9.168-3v14c-1.543-1.766-5.067-3-9.168-3H7a3.988 3.988 0 01-1.564-.317z"
                />
              </svg>
            </span>
            <p class="ml-3 font-medium text-white truncate">
              <span class="md:hidden">
                We announced a new product!
              </span>
              <span class="hidden md:inline">
                Big news! Braintastic is excited to announce a brand new
                product.
              </span>
            </p>
          </div>
          <div
            class="flex-shrink-0 order-3 w-full mt-2 sm:order-2 sm:mt-0 sm:w-auto"
          >
            <div class="rounded-md shadow-sm">
              <a
                href="#"
                class="flex items-center justify-center px-4 py-2 text-sm font-medium leading-5 text-indigo-600 transition duration-150 ease-in-out bg-white border border-transparent rounded-md hover:text-indigo-500 focus:outline-none focus:shadow-outline"
              >
                Learn more
              </a>
            </div>
          </div>
          <div class="flex-shrink-0 order-2 sm:order-3 sm:ml-3">
            <button
              type="button"
              class="flex p-2 -mr-1 transition duration-150 ease-in-out rounded-md hover:bg-indigo-500 focus:outline-none focus:bg-indigo-500 sm:-mr-2"
            >
              <svg
                class="w-6 h-6 text-white"
                stroke="currentColor"
                fill="none"
                viewBox="0 0 24 24"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M6 18L18 6M6 6l12 12"
                />
              </svg>
            </button>
          </div>
        </div>
      </div>
    </div>
    <div
      id="login"
      class="flex items-center justify-center min-h-screen px-4 py-12 bg-gray-50 sm:px-6 lg:px-8"
    >
      <div class="w-full max-w-md">
        <div>
          <img
            class="w-auto h-12 mx-auto"
            src="../img/braintastic-logo.png"
            alt="Workflow"
          />
          <h2
            class="mt-6 text-3xl font-extrabold leading-9 text-center text-gray-900"
          >
            Sign-in to your account
          </h2>
          <p class="mt-2 text-sm leading-5 text-center text-gray-600">
            Or
            <a
              href="#register"
              class="font-medium text-indigo-600 transition duration-150 ease-in-out hover:text-indigo-500 focus:outline-none focus:underline"
            >
              Sign-up for a new account
            </a>
          </p>
        </div>
        <form class="mt-8" action="#" method="POST">
          <input type="hidden" name="remember" value="true" />
          <div class="rounded-md shadow-sm">
            <div>
              <input
                aria-label="Email address"
                name="email"
                type="email"
                required
                class="relative block w-full px-3 py-2 text-gray-900 placeholder-gray-500 border border-gray-300 rounded-none appearance-none rounded-t-md focus:outline-none focus:shadow-outline-blue focus:border-blue-300 focus:z-10 sm:text-sm sm:leading-5"
                placeholder="Email address"
              />
            </div>
            <div class="-mt-px">
              <input
                aria-label="Password"
                name="password"
                type="password"
                required
                class="relative block w-full px-3 py-2 text-gray-900 placeholder-gray-500 border border-gray-300 rounded-none appearance-none rounded-b-md focus:outline-none focus:shadow-outline-blue focus:border-blue-300 focus:z-10 sm:text-sm sm:leading-5"
                placeholder="Password"
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
                class="block ml-2 text-sm leading-5 text-gray-900"
              >
                Remember me
              </label>
            </div>

            <div class="text-sm leading-5">
              <a
                href="#"
                class="font-medium text-indigo-600 transition duration-150 ease-in-out hover:text-indigo-500 focus:outline-none focus:underline"
              >
                Forgot your password?
              </a>
            </div>
          </div>

          <div class="mt-6">
            <button
              type="submit"
              class="relative flex justify-center w-full px-4 py-2 text-sm font-medium leading-5 text-white transition duration-150 ease-in-out bg-indigo-600 border border-transparent rounded-md group hover:bg-indigo-500 focus:outline-none focus:border-indigo-700 focus:shadow-outline-indigo active:bg-indigo-700"
            >
              <span class="absolute inset-y-0 left-0 flex items-center pl-3">
                <svg
                  class="w-5 h-5 text-indigo-500 transition duration-150 ease-in-out group-hover:text-indigo-400"
                  fill="currentColor"
                  viewBox="0 0 20 20"
                >
                  <path
                    fill-rule="evenodd"
                    d="M5 9V7a5 5 0 0110 0v2a2 2 0 012 2v5a2 2 0 01-2 2H5a2 2 0 01-2-2v-5a2 2 0 012-2zm8-2v2H7V7a3 3 0 016 0z"
                    clip-rule="evenodd"
                  />
                </svg>
              </span>
              Sign in
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style></style>
