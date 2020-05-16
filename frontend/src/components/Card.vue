<template>
  <div class="mt-8 bg-white overflow-hidden shadow rounded-lg">
    <div class="border-b border-gray-200 px-4 py-5 sm:px-6">
      <p>{{ text }}</p>
      <!-- Content goes here -->
      <!-- We use less vertical padding on card headers on desktop than on body sections -->
    </div>
    <div class="border-t-1 border-gray-200 px-4 py-4 sm:px-6">
      <!-- Content goes here -->
      <!-- We use less vertical padding on card footers at all sizes than on headers or body sections -->
    </div>
  </div>
</template>

<script>
export default {
  props: [
    'text',
    ''
  ]

}
</script>

<style>

</style>
