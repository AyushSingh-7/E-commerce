<template>
  <div class="hello">
<Header></Header>
<Main></Main>
  </div>
</template>

<script>
import Header from './Header.vue'
import Main from './Main.vue'

export default {
  name: 'Products',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  components: { Header, Main }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
