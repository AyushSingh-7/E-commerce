<template>
    <div class="wrapper">
        <!-- {{getProductsList[0].imageUrl}} -->

        <div class="main">
            <div class="searchbar">
                <div class="items">
                    <input v-model="searchbar" placeholder="PRODUCT NAME....">
                    <button class="icon" @click="getfilter">
                       SEARCH
                    </button>
                </div>
            </div>
            <div class="displaypage">
                <Product v-for="data in getProductsList" :key="data.id" :Product="data">
                    <!-- {{ data.imageUrl }} -->
                </Product>
            </div>
        </div>
        <Footer></Footer>
    </div>
</template>

<script>
import { mapGetters } from 'vuex'
import Header from './Header.vue'
import Product from './Product.vue'
import Catalouge from './Catalouge.vue'
import Footer from './Footer.vue'
export default {
  name: 'Main',
  data () {
    return {
      fetchthis: 'actionGetFurnitureList',
      searchbar: ''
    }
  },
  computed: {
    ...mapGetters(['getProductsList', 'getShowMe', 'getCurrentValue'])
  },
  beforeMount: function () {
    this.$store.dispatch('actionGetCartList', {
      success: (res) => {
        console.log('res from cat', res)
      }
    })
    // actionGetCartList: ({ commit, getters }, { success }) => {

    // console.log("hello", this.getCurrentValue);
    if (this.getCurrentValue === '') {
      this.$store.dispatch(this.fetchthis, {
        success: (res) => {
          // console.log("hello", res);
        }
      })
    } else {
      // console.log("bee")
      // this.fetchthis = 'actionGetCategoryList'
      this.$store.dispatch('actionGetCategoryList', {
        success: (res) => {
          console.log('res from cat', res)
        }
      })
    }
  },
  components: { Header, Product, Catalouge, Footer },
  watch: {
    searchbar: function (value) {
      if (value === '') {
        this.$store.dispatch('actionGetFurnitureList', {
          success: (res) => {
            console.log('hello', res)
          }
        })
      }
    }
  },
  methods: {
    getfilter () {
      console.log(this.searchbar)

      this.$store.commit('setFilterBy', this.searchbar)

      this.fetchthis = 'actionGetFilteredList'
      this.$store.dispatch(this.fetchthis, {
        success: (res) => {
          console.log('hello', res)
        }
      })
    }
  }
}
</script>

<style scoped>

button{
    background-color: rgb(226, 223, 218);
    border: 0;
    width: fit-content;
    margin: 0px 10px 10px 10px;
    padding: 10px 10px 10px 10px;
}
button:hover{
    background-color: #d5d4d4;
}
.wrapper {
    margin-top: 8px;

    height: 100vh;
    width: 100%
}

.main {

    /* background-color: rgb(243, 194, 194); */
    margin-left: 1%;
    width: 100%;
}

.displaypage {
    /* background-color: rgb(163, 211, 211); */
    height: 90%;
}

.searchbar {
    /* background-color: rgb(213, 175, 175); */
    margin-top: 20px;
    height: 10%;
    align-content: center;

}

.items {
    margin-left: 30%;
    display: flex;
}

.fa-magnifying-glass {
    margin-top: 10px;
    height: 30px;

}

.searchbar input {
    height: 60px;
    width: 60%;
    margin-bottom: 0;
    padding: 0;
    border-style: none none solid;
    border-width: 1px;
    border-color: #000 #000 #ebebeb;
    color: #7e7e7e;
    font-size: 30px;
    line-height: 30px;
    font-weight: 300;
    outline: 0;
}
.displaypage {
    display: flex;
    flex-wrap: wrap;
    width: 100%;
    overflow: scroll;
}

@media (max-width: 620px) {
    .main {
        /* background-color: rgb(243, 194, 194); */
        margin-left: 20%;
        width: 100%;
    }

    .catalouge {
        width: 40%;
    }

    .icon {
        margin-left: 15px;
        margin-top: 5px;

    }

    .searchbar {
        margin-left: -80px;
    }

    .searchbar input {
        font-size: 18px;
        transition: all 00.3s ease;
    }
}
</style>
