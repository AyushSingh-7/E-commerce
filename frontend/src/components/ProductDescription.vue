<template>
    <div >
        <Header></Header>
        <div class="hello">
            <!-- {{ getProductDescription }} -->

             <div class="modaldetails">
                <div id="photo">
                    <img style="border-radius: 10px black;" :src="getProductDescription.imageUrl">
                </div> <br>
                <div class="alldetails">
                <div class="details">
                   <div style="color:blueviolet" >{{ getProductDescription.categoryName }}</div>
                <h1> {{ getProductDescription.name }}</h1>
                  {{ getProductDescription.description }}
                {{ getProductDescription.usp }}<br>
                 sold by Merchant : {{ getProductDescription.merchantId }}<br>

                {{ getProductDescription.dimension }}<br>
                {{ getProductDescription.weight }}<br>

                  {{ getProductDescription.color }}<br>
                   <i class="fa-regular fa-star"></i> {{ getProductDescription.rating }} &nbsp;&nbsp;
                <strong>$ {{ getProductDescription.price }}</strong> <s>{{ getProductDescription.strikePrice }}</s><br>
                </div>
                 <div class="buy">
                    <button class="buynow" @click="addToCart">ADD TO CART</button>
                     <button class="buynow" @click="buynow">BUY NOW</button>
                    </div>
                    </div>

            </div>

            </div>

        <Footer></Footer>

    </div>
</template>

<script>
import Header from './Header.vue'
import Main from './Main.vue'
import Footer from './Footer.vue'
import { mapGetters } from 'vuex'
import axios from 'axios'

export default {
  name: 'Products',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      addedToCart: false
    }
  },
  computed: {
    ...mapGetters(['getProductDescription', 'getLogInData'])
  },
  components: { Header, Main, Footer },
  methods: {
    buynow () {
      if (!this.addedToCart) { this.addToCart() }
      this.$router.push('/cart')
    },
    getCartList () {
      fetch('http://localhost:8082/cart/' + this.getLogInData)
        .then(response => {
          if (response != null) { return response.json() } else { return response }
        })
        .then(res => {
          // console.log(res, "respomse")
          this.cartlist = res
          console.log(this.cartlist.length, 'size')
          // this.$store.commit('setCartItems', this.cartlist.length)
          console.log('cartitems ka length', this.getCartItems)
        })
    },
    addToCart () {
      this.addedToCart = true
      var obj = {
        product: this.getProductDescription,
        productId: this.getProductDescription.id,
        quantity: 1,
        emailId: this.getLogInData
      }
      axios.post('http://localhost:8082/cart', obj, {
        'Content-Type': 'application/json; charset=UTF-8'
      })
        .then((res) => {
          console.log('add to cart', res)
          this.getCartList()
          this.$router.push('/cart')
        })
        .catch((err) => console.log(err))
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.hello{
    background-color: rgb(255, 255, 255);
    height: 80vh;
}
#photo{
    height: 100%;
    width: 50%;
    /* align-content: center; */
        display: flex;
    justify-content: center;
    align-items: center;
}
#photo img{
    height: 70%;
    width: 80%;
}
.modaldetails{
    display: flex;
    height: 100%;
    width: 100%;
}
.buy{
    margin-top:20px;
}
.details{
text-align: left;
margin-left: 40px;

}
.alldetails{
    border-left: 1.5px solid rgba(0, 0, 0, 0.068);
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;

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
