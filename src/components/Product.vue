<template>
    <div>

        <div class="cart">
            <!-- {{getLogInData}} -->
            <div class="theitem" @click="fucn1">
                <!-- {{Product}} -->
                <img style="border-radius: 10px black;" :src="Product.imageUrl">
            </div>
            <div class="details" @click="fucn1">
                {{ Product.name }} ({{ Product.quantity }})<br>
                <!-- {{Product.description}} -->
                <i class="fa-regular fa-star"></i> {{ Product.rating }} <br>
                 <strong>Price $ {{ Product.price }} <s>{{ Product.strikePrice }}</s></strong><br>
            </div>

            <div class="buttonss">
                <button @click="presentInCart">Add To Cart</button>&nbsp;&nbsp;&nbsp;&nbsp;
                <button @click="buynow">Buy Now</button>
            </div>

        </div>

        <!-- <div id="app">

            <transition name="fade" appear>
                <div class="modal-overlay" v-if="showModal" @click="showModal = false"></div>
            </transition>
            <transition name="slide" appear>
                <div class="modal" v-if="showModal">
                    <button class="closebutton" @click="func2">
                        X
                    </button>
                    <div class="modaldetails">
                        <h1> {{ Product.name }}</h1>
                        <div id="photo">
                            <img style="border-radius: 10px black;" :src="Product.imageUrl">
                        </div> <br>
                        <i class="fa-regular fa-star"></i> {{ Product.rating }} &nbsp;&nbsp;
                        <strong>$ {{ Product.price }}</strong> <s>{{ Product.strikePrice }}</s><br>
                        {{ Product.dimension }}
                        {{ Product.weight }}
                        {{ Product.description }}
                        {{ Product.usp }}
                        color : {{ Product.color }}
                    </div>
                </div>
            </transition>
        </div> -->
    </div>
</template>
<script>
import { mapGetters } from 'vuex'
import axios from 'axios'
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
    }
  },
  data () {
    return {
      showModal: false,
      myarray: [],
      cartItmes: [],
      hideModal: true,
      cartProducts: [],
      addedToCart: false,
      isPresent: false,
      cartId: '',
      cartlist: []
    }
  },
  beforemount () {
    // this.getCartList()
  },
  computed: {
    ...mapGetters(['getShowMe', 'getMyArray', 'getCartItems', 'getCurrentValue', 'getLogInData', 'getProductDescription'])
  },
  methods: {
    buynow () {
      if (!this.addedToCart) {
        this.presentInCart()
      }

      this.$router.push('/cart')
    },
    getCartList1 () {
      fetch('http://localhost:8082/cart/' + this.getLogInData)
        .then(response => response.json())
        .then(res => {
          console.log(res)
        })
    },
    getCartList () {
      console.log('get cart list', this.getLogInData)
      fetch('http://localhost:8082/cart/' + this.getLogInData)
        .then(response => response.json())
        .then(res => {
          this.cartlist = res
          console.log(this.cartlist.length, 'cartklenght')
          //   if (this.cartlist.length === 0) {
          //     this.isPresent = false
          //     this.addToCart()
          //   }
          for (var i = 0; i < this.cartlist.length; i++) {
            console.log(this.Product.id, '  sdsfd ', this.cartlist[i].productId, '  sdfsdf ', this.cartlist[i].id)
            if (this.Product.id === this.cartlist[i].productId) {
              this.isPresent = true
              console.log('true')
              this.cartId = this.cartlist[i].id
            }
          }
          this.addToCart()
          console.log(res, 'res inside this')
        }).catch((error) => {
          console.log(error)
        })
    },
    presentInCart () {
      this.getCartList()
      console.log('in preesent')
    },
    addToCart () {
      console.log(this.isPresent, 'valie')
      if (!this.isPresent) {
        console.log('false')
        // console.log(this.cartId)

        this.addedToCart = true
        var obj = {
          productDto: this.Product,
          productId: this.Product.id,
          quantity: 1,
          emailId: this.getLogInData
        }

        console.log('objssss', obj)
        axios.post('http://localhost:8082/cart', obj, {
          'Content-Type': 'application/json; charset=UTF-8'
        })
          .then((res) => {
            console.log(res)

            this.getCartList1()
            window.location.reload()
          })
          .catch((err) => console.log(err))
      } else {
        console.log('true hua hai')
        this.$store.commit('setProductId', this.cartId)
        this.$store.dispatch('actionAddQuantity', {
          success: (res) => {
            console.log('hello  from ++ button', res)
            this.getCartList1()
          }
        })
      }
    },
    fucn1 () {
      this.$store.commit('setProductDescription', this.Product)
      this.$router.push('/productDescription')

      // console.log("thisss",this.getProductDescription)
    }

  }
  // beforeMount: function(){
  // console.log(this.getMyArray)
  // }
}

</script>

<style scoped>
button {

    background-color: rgb(170, 199, 180);
    color: white;
    border: 0;
    border-radius: 5px;
    height: 25px;
    margin-top: 5px;
}

.fa-star {
    color: #d2d82b;
}

.buttonss button:hover {
    background-color: rgb(97, 142, 90);
    color: white;
}

#photo img {
    width: 80%;
}

.cart {
    width: 250px;
    height: 300px;
    /* border-radius: 20px; */
    margin: 15px;
    background-color: rgb(241, 241, 241);
    /* box-shadow: 5px 5px 5px 5px rgb(64, 93, 113); */
}

.theitem img {

    width: 80%;
    height: 95%;
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

    height: 68%;
    /* background-color: aqua; */
}

.buttonss {
    margin-top: 4px;
    height: 10%;
    margin-bottom: 2px;
    /* background-color: rgb(23, 57, 87); */
}

.cart:hover {
    transform: scaleX(1.01);
    background-color: rgb(173, 194, 194);

}
.cart:hover .buttonss button{
    transform: scaleX(1.01);
    background-color: rgb(30, 154, 154);

}

    /* : 70px; */

.theitem img {
    border-radius: 20px;
    height: 100%;
}

/* fade entry css from here exclusive */
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
    background-color: rgb(159, 215, 220);
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

.closebutton {
    background-color: rgb(159, 215, 220);
    height: 40px;
    margin-left: 95%;
    margin-top: -5%;

}

.closebutton[data-v-3cf4ef6f]:hover {
    color: rgb(19, 1, 1);
    height: 40px;
}

.closebutton[data-v-3cf4ef6f] {
    color: rgb(249, 7, 7);
    /* height: 40px; */
    background-color: rgb(246, 249, 251);
    font-size: 32px;
}

.modaldetails {
    margin-top: -15%;
}

/* fade css till here */
</style>
