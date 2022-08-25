<template>
    <div>

        <div class="cart">
            <!-- {{getLogInData}} -->
            <div class="theitem">
                <!-- hey -->
                <!-- <br> -->
                <!-- {{Product}} -->
                <img style="border-radius: 10px black;" :src="Product.productDto.imageUrl">
            </div>
            <div class="details">
                {{ Product.productDto.name }} ({{ Product.productDto.quantity }})<br>
                <!-- {{Product.description}} -->
                <i class="fa-regular fa-star"></i> {{ Product.productDto.rating }} <br>
                quantity bought: {{Product.quantity}}<br>
                <strong>$ {{ Product.productDto.price }} {{ Product.productDto.strikePrice }}</strong><br>
            </div>
            <!-- {{ Input }}
               {{ getMyInput }}
                {{ callme() }} -->

            <!-- <div class="buttonss"> -->
            <!-- <button @click="addToCart">Add To Cart</button>&nbsp;&nbsp;&nbsp;&nbsp; -->
            <!-- <button @click="removeFromCart">Remove</button> -->
            <!-- </div> -->

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
      default: '' },
    Product: {
      type: Object
    }
  },
  data () {
    return {
      myarray: [],
      cartItmes: [],
      cartlist: []
    }
  },
  computed: {
    ...mapGetters(['getShowMe', 'getMyArray', 'getCartItems', 'getCurrentValue', 'getLogInData'])
  },
  methods: {
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
          this.cartlist = res
          this.removeFromCart1()
        })
    },
    removeFromCart1 () {
      let cartid

      for (var i = 0; i < this.cartlist.length; i++) {
        if (this.cartlist[i].productId === this.Product.id) {
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
    height: 300px;
    /* border-radius: 20px; */
    margin: 15px;
    background-color: rgb(238, 251, 251);
    /* box-shadow: 5px 5px 5px 5px rgb(64, 93, 113); */
}

.theitem img {

    width: 80%;
    height: 100%;
    margin-top: 5px;
    /* padding: 0px 10px 0px 10px; */
    border-radius: 10px;
}

.theitem img[data-v-3cf4ef6f] {
    height: 95%;
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
    height: 10%;
    /* background-color: rgb(23, 57, 87); */
}

.cart:hover {
    transform: scaleX(1.01);
    background-color: rgb(173, 194, 194);
    /* : 70px; */
}

.theitem img {
    border-radius: 20px;
    height: 100%;
}
/* fade css till here */
</style>
