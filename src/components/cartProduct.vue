<template>
    <div>

        <div class="cart">
            <!-- {{cartlist}} -->
            <div class="theitem">
                <!-- {{Product}} -->
                <img style="border-radius: 10px black;" :src="Product.productDto.imageUrl">
            </div>
            <div class="details">

                {{ Product.productDto.name }} <br>
                <!-- {{Product.description}} -->
                <i class="fa-regular fa-star"></i> {{ Product.productDto.rating }} <br>
                <strong>$ {{ Product.productDto.price }} <s>{{ Product.productDto.strikePrice }}</s></strong><br>
                <button @click="additem"> + </button> &nbsp; {{ Product.quantity }} &nbsp;<button @click="subitem">-</button>

            </div>
            <!-- {{ Input }}
               {{ getMyInput }}
                {{ callme() }} -->

            <div class="buttonss">

                <button @click="removeFromCart">Remove</button>
            </div>

        </div>

    </div>
</template>
<script>
import { mapGetters } from 'vuex'
import axios from 'axios'
// ...mapGetters(['getMyInput'])
export default {

  name: 'Product',

  props: {
    Input: {
      type: String,
      required: false,
      default: ''
    },
    Product: {
      type: Object
      // required: false,
      // default: 0
    }
  },
  data () {
    return {
      myarray: [],
      cartItmes: [],
      cartlist: []
    }
  },
  beforeMount: function () {
    this.getCartList()
  },
  computed: {
    ...mapGetters(['getShowMe', 'getMyArray', 'getCartItems', 'getCurrentValue', 'getLogInData', 'getProductId'])
  },
  methods: {

    additem () {
      this.$store.commit('setProductId', this.Product.id)
      this.$store.dispatch('actionAddQuantity', {
        success: (res) => {
          console.log('hello  from plus button', res)
          this.getCartList()
        }
      })
    },
    subitem () {
      this.$store.commit('setProductId', this.Product.id)
      this.$store.dispatch('actionSubQuantity', {
        success: (res) => {
          console.log('hello  from minus button', res)
          this.getCartList()
        }
      })
    },
    getCartList () {
      fetch('http://localhost:8082/cart/' + this.getLogInData)
        .then(response => response.json())
        .then(res => {
          console.log(res, 'respomse')
          this.cartlist = res
          console.log(this.cartlist.length, 'size')
          // this.$store.commit('setCartItems', this.cartlist.length)
          //   window.location.reload()
          console.log('cartitems ka length', this.getCartItems)
        })
    },

    removeFromCart () {
      fetch('http://localhost:8082/cart/' + this.getLogInData)
        .then(response => response.json())
        .then(res => {
          console.log('removed', res)
          this.cartlist = res
          this.removeFromCart1()
          window.location.reload()
        })
    },
    removeFromCart1 () {
      let cartid

      for (var i = 0; i < this.cartlist.length; i++) {
        if (this.cartlist[i].id === this.Product.id) {
          cartid = this.cartlist[i].id
        }
      }
      console.log(cartid, 'deleyte')
      axios.delete('http://localhost:8082/cart/' + cartid, {
        'Content-Type': 'application/json; charset=UTF-8'
      }).then(res => {
        console.log('return response', res)

        this.$store.dispatch('actionGetCartList', {
          success: (res) => {
            // console.log("hello  from remove button", res);
            this.getCartList()
          }
        })
      })
        .catch((err) => console.log(err))

      // this.getCartList()
    }

  }
}

</script>

<style scoped>
button {
    background-color: rgb(255, 255, 255);
    border: 0;
    border-radius: 5px;
    height: 25px;
    margin-top: 5px;
}

/* button:hover{
    background-color: #d2d82b;
} */

.fa-star {
    color: #d2d82b;
}

.buttonss button:hover {
    background-color: rgb(18, 144, 234);
}

#photo img {
    width: 80%;
}

.cart {
    width: 250px;
    height: 400px;
    /* border-radius: 20px; */
    margin: 15px;
    background-color: rgb(238, 251, 251);
    /* box-shadow: 5px 5px 5px 5px rgb(64, 93, 113); */
}

.theitem img {

    width: 80%;
    height: 90%;
    margin-top: 5px;
    /* padding: 0px 10px 0px 10px; */
    border-radius: 10px;
}

.theitem img[data-v-3cf4ef6f] {
    height: 90%;
    border-radius: 10px;
}

.details {
    margin-top: -5px;
    height: 20%;
    /* background-color: #a095e4; */
}

.theitem {
    /* border-radius: 10px; */

    height: 70%;
    /* background-color: aqua; */
}

.buttonss {
    margin-top: 15px;
    height: 10%;
    /* background-color: rgb(23, 57, 87); */
}

/* fade css till here */
</style>
