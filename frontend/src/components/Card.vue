<template>
  <div class="mt-8 bg-white overflow-hidden shadow rounded-lg">
    <div class=" px-4 py-5 sm:px-6">
      <p>{{ text }}</p>
      <!-- Content goes here -->
      <!-- We use less vertical padding on card headers on desktop than on body sections -->
    </div>
  </div>
</template>

<script>
export default {
  props: [
    'text',
    'id'
  ]
}
</script>

<style>

</style>
