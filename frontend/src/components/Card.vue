<template>
  <div class="mt-8 bg-white overflow-hidden shadow rounded-lg">
    <div class=" px-4 py-5 sm:px-6">
      <p>{{ text }}</p>
    </div>
  </div>
</template>

<script>
export default {
  props: [
    'text'
  ]
}
</script>
