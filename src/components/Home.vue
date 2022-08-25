<template>
  <div class="hello">
    <!-- {{getLogInData}} -->
    <Header></Header>

    <div class="catalouge">
      <router-link  to='/products' >
    <!-- <button > -->
        <div class="furniture" @click='setChairValue'>
          <img src="https://www.freepnglogos.com/uploads/chair-png/chair-table-clipart-brown-objects-pencil-and-color-table-17.png" alt="not found">
          CHAIR
        </div>
        <!-- </button> -->
      </router-link>
      <router-link  to='/products' >
        <div @click="setTableValue" class="furniture" >
          <img src="https://freepngimg.com/thumb/table/7-2-table-high-quality-png-thumb.png" alt="">
          TABLE
        </div>
      </router-link>
     <router-link  to='/products' >
        <div  @click="setSofaValue" class="furniture">
          <img src="https://www.freepnglogos.com/uploads/sofa-png/sofa-png-image-purepng-transparent-png-image-16.png"
            alt="">
          SOFA
        </div>
      </router-link>
      <router-link  to='/products' >
        <div @click="setWardrobeValue" class="furniture" >
          <img
            src="https://www.freepnglogos.com/uploads/openclipart/cupboard-definition-meaning-english-picture-dictionary-31.png"
            alt="">
          WARDROBE
        </div>
      </router-link>
      <router-link  to='/products' >
        <div  @click="setBedValue" class="furniture" >
          <img
            src="https://www.freepnglogos.com/uploads/bed-png/bed-download-mattress-png-transparent-image-and-clipart-36.png"
            alt="">
          BED
        </div>
       </router-link>
    </div>

    <div class="recommended">

      <div class="slider">
<h2>Recommended Items</h2>
        <a href="Products">
          <div class="slides">
            <div class="item" v-for="data in getProductsList" :key="data.id">
              <div>
                <img :src="data.imageUrl">
              </div>
              <div class="title">
                {{ data.name }}
              </div>
            </div>

          </div>
        </a>
      </div>

    </div>

    <footer>
      <Footer></Footer>
    </footer>

  </div>
</template>

<script>
import Header from './Header.vue'
import { mapGetters } from 'vuex'
import Footer from './Footer.vue'

export default {
  name: 'Home',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  components: {
    Header,
    Footer
  },
  methods: {
    // var value=document.getElementById

    setChairValue () {
      console.log('chair')
      this.$store.commit('setCurrentValue', 'chairs')
      //  console.log(this.getCurrentValue,"curr")
    },
    setSofaValue () {
      console.log('sofa')
      this.$store.commit('setCurrentValue', 'sofas')
    },
    setBedValue () {
      console.log('bed')
      this.$store.commit('setCurrentValue', 'beds')
    },
    setTableValue () {
      console.log('table')
      this.$store.commit('setCurrentValue', 'tables')
    },
    setWardrobeValue () {
      console.log('ward')
      this.$store.commit('setCurrentValue', 'wardrobes')
    }
  },
  computed: {
    ...mapGetters(['getProductsList', 'getCurrentValue', 'getLogInData'])
  },
  beforeMount: function () {
    this.$store.dispatch('actionGetRecommendedList', {
      success: (res) => {
        console.log('hello', res)
      }
    })
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
footer {
  margin-top:15px;
  position: fixed;
  width: 100%;
}

.catalouge {
  margin-top: 30px;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
  margin-left: 50px;

}

a {
  text-decoration: none;
  color: black;
}

.furniture:hover {
  box-shadow: 2px 2px 2px 2px rgb(217, 223, 217);
}

.furniture {
  display: flex;
  flex-direction: column;
}

.furniture img {
  height: 50px;
  width: 50px;
  padding: 10px 10px 10px 10px;
}

.recommended {
  margin-top: 40px;

}

.slider {
  margin-left: 21%;
  width: 60%;
  text-align: center;
  overflow: hidden;
  box-shadow: 4px 4px 4px 4px rgb(212, 218, 221);

}

.slides {
  /* background-color: blue; */
  display: flex;
  overflow-x: auto;
  scroll-snap-type: x mandatory;
  scroll-behavior: smooth;
  -webkit-overflow-scrolling: touch;

}

.slides::-webkit-scrollbar {

  height: 10px;
}

.slides::-webkit-scrollbar-thumb {
  background: black;
  border-radius: 10px;
}

.slides::-webkit-scrollbar-track {
  background: transparent;
}

.slides .item {
  scroll-snap-align: start;
  flex-shrink: 0;
  width: 350px;
  height: 400px;
  border-radius: 10px;
  background: rgb(255, 255, 255);
  transform-origin: center center;
  transform: scale(1);
  transition: transform 0.5s;
  position: relative;
  align-items: center;
  font-size: 30px;
  color: rgb(184, 66, 33);
}

.item .title {
  margin-top: 50px;
}

.item img {
  height: 200px;
  width: 200px;
  padding-top: 40px;
}
</style>
