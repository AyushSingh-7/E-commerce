<template>
    <div>
        <header1></header1>
        <div class="hello">

            <!-- {{getUserCartList}} -->
            <!-- <h1 id="hideThisOnClick">  -->
            <div class="buybar">
                <div class="price">

                    <a>Total Amount : {{ total }}</a>
                </div>
                <div >
                    <button class="buynow" @click="buynow">BUY NOW</button>
                </div>

            </div>
            <!-- {{getProductsList[1].productDto.imageUrl}} -->
            <div class="items">
                <cart-product v-for="data in getUserCartList" :key="data.id" :Product="data">
                    <!-- {{data.productDto.imageUrl}} -->
                </cart-product>
            </div>

        </div>

    </div>

</template>

<script>
import { mapGetters } from 'vuex'
import Product from './Product.vue'
import CartProduct from './cartProduct.vue'
import Header1 from './Header.vue'
import axios from 'axios'
export default {
  name: 'cart',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      showModal: false,
      myCartList: [],
      total: 0
    }
  },
  beforeMount: function () {
    this.$store.dispatch('actionGetCartList', {
      success: (res) => {
        console.log('hellocartlist', res)
        for (var i = 0; i < res.length; i++) {
          this.total = this.total + (res[i].productDto.price) * res[i].quantity
        }
        console.log('total', this.total)

        // this.myCartList=res
        // this.$store.commit('setProductsList',res)
        //   console.log("in cart",this.getProductsList)
      }

    })

    this.$store.dispatch('actionGetAccountDetails', {
      success: (res) => {
        // console.log("hello", res);
        // this.myCartList=res
        // this.$store.commit('setProductsList',res)
        //   console.log("in cart",this.getProductsList)

      }

    })

    this.getCartList()
  },
  computed: {
    ...mapGetters(['getProductsList', 'getLogInData', 'getAccountDetails', 'getUserCartList'])
  },
  methods: {

    buynow () {
      // console.log(obj.cartProducts)

      axios({
        method: 'POST',
        url: 'http://localhost:8082/order',
        data: {
          'cartList': this.cartlist,
          'mailId': this.getLogInData
        },
        headers: {
          'Content-type': 'application/json'
        }
      }).then((res) => {
        console.log(res, 'mail gya')
        alert('thank you for shopping with us')
        this.getCartList()
        location.reload()
        // this.getCartList()
      }).catch((err) => console.log(err))
    },
    getCartList () {
      fetch('http://localhost:8082/cart/' + this.getLogInData)
        .then(response => {
          if (response != null) { return response.json() } else { return response }
        })
        .then(res => {
          console.log(res, 'respomse')
          this.cartlist = res
          console.log(this.cartlist.length, 'size')
          // this.$store.commit('setCartItems', this.cartlist.length)
          console.log('cartitems ka length', this.getCartItems)
          // this.buynow()
        })
    },
    func1 () {
      this.showModal = true
    },
    func2 () {
      this.showModal = false
    }
  },
  components: { Product, CartProduct, Header1 }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.buybar {
    display: flex;
    background-color: #373553;
    justify-content: space-between;
}

.price a{
    /* padding-top: 10px; */
    color: #FFF;

}
.price {
    padding-top: 15px;
    padding-left: 10px;
    color: #FFF;

}

h1 {
    font-weight: normal;
}

.items {
    display: flex;
    flex-wrap: wrap;
}

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body {
    font-family: 'montserrat', sans-serif;
}

#app {
    position: relative;

    display: flex;
    justify-content: center;
    align-items: center;

    width: 100vw;
    min-height: 100vh;
    overflow-x: hidden;
}

.button {
    appearance: none;
    outline: none;
    border: none;
    background: none;
    cursor: pointer;

    display: inline-block;
    padding: 15px 25px;
    background-image: linear-gradient(to right, #CC2E5D, #FF5858);
    border-radius: 8px;

    color: #FFF;
    font-size: 18px;
    font-weight: 700;

    box-shadow: 3px 3px rgba(0, 0, 0, 0.4);
    transition: 0.4s ease-out;

}

.modal-overlay {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    z-index: 98;
    background-color: rgba(0, 0, 0, 0.3);
}

.modal {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    z-index: 99;

    width: 100%;
    max-width: 400px;
    background-color: #FFF;
    border-radius: 16px;

    padding: 25px;

}

.modal p {
    color: #666;
    font-size: 18px;
    font-weight: 400;
    margin-bottom: 15px;
}

.modal h1 {

    color: #222;
    font-size: 32px;
    font-weight: 900;
    margin-bottom: 15px;

}

.fade-enter-active,
.fade-leave-active {
    transition: opacity .5s;
}

.fade-enter,
.fade-leave-to {
    opacity: 0;
}

.slide-enter-active,
.slide-leave-active {
    transition: transform .5s;
}

.slide-enter,
.slide-leave-to {
    transform: translateY(-50%) translateX(100vw);
}

.buynow {
    background-color: rgb(226, 223, 218);
    border: 0;
    width: fit-content;
    margin: 10px 10px 10px 10px;
    padding: 10px 10px 10px 10px;

}

.buynow:hover {
    background-color: rgb(200, 198, 194);
    border: 0;
}
</style>
