<template>
    <div class="wrapper">
        <!-- {{getorderHistory[1].cartList[0].productDto}} -->
        <Header></Header>

        <div class="logout">
            <li><a href="#" @click="logout">Logout</a></li>
        </div>

        <div class="userdetails">
            <!-- <h1>Customer Details</h1÷> -->
            <div class="image">
                <img
                    src="https://www.kindpng.com/picc/m/150-1503993_check-man-user-avatar-person-done-complete-tick.png">
            </div>
            <div class="details">
                <b>Name: {{ getAccountDetails.name }}</b>
                <br>
                <div>Email: <b>{{ getAccountDetails.emailId }}</b></div>
                <div>Address: <b>{{ getAccountDetails.address }}</b><br></div>
                <div>contactNumber: <i>{{ getAccountDetails.contactNumber }}</i><br></div>
            </div>
        </div>
        <h1>Order History</h1>
        <!-- {{getorderHistory[0]}} -->
        <div class="ordereditems">
            <div v-for="data in getorderHistory" :key="data.id">
                <div class="date">
                    <h4>Your Items <b><i>{{ data.date }}</i></b></h4>
                </div>
                <div class="onedateitems">
                    <!-- {{data}} -->
                    <div class="together" v-for="cart in data.cartList" :key="cart.id">
                        <!-- {{cart}} -->
                        <OrderHistory :Product="cart"></OrderHistory>

                    </div>
                    <div clas="price">
                        <a> Total : <b>{{ data.price }}</b></a>
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
import { mapGetters } from 'vuex'
import OrderHistory from './orderHistory.vue'
import Footer from './Footer.vue'

export default {
  name: 'Account',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  computed: {
    ...mapGetters(['getLogInData', 'getAccountDetails', 'getorderHistory'])

  },
  beforeMount: function () {
    console.log(this.getorderHistory, 'orderhistiry')

    this.$store.dispatch('actionGetOrderHistory', {
      success: (res) => {
        console.log('hello', res)
      }
    })

    this.$store.dispatch('actionGetAccountDetails', {
      success: (res) => {
        console.log('hello', res)
      }
    })
  },
  components: { Header, Main, OrderHistory, Footer },
  methods: {
    logout () {
      console.log('logout')
      this.$store.commit('setLogInData', '')
      this.$router.push('/login')
      window.location.reload()
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.onedateitems {

    display: flex;
    flex-wrap: wrap;
    flex-direction: row;
    overflow: scroll;
    /* display: flex; */
    align-items: center;

}
.onedateitems a{

   margin-left: 40px;

}
.price{
    color: greenyellow;
    margin-left: 20px;
}
.date {
    /* height: 40px; */
    padding: 10px 10px 10px 10px;
    width: 50%;
    text-align: left;
    /* background-color: rgb(216, 230, 230); */
}

.together {
    /* background-color: rgb(233, 242, 242); */
    box-shadow: 4px 4px 4px 2px rgb(212, 218, 221);

}

.ordereditems {
    display: block;
    /* flex-wrap: wrap; */
}

.userdetails {
    box-shadow: 4px 4px 4px 2px rgb(212, 218, 221);
    width: 60%;
    margin-left: 25%;
    margin-top: 10px;
    display: flex;
    justify-content: center;
    padding: 10px 10px 10px 10px;

    /* flex-direction: row; */
}

img {
    height: 80px;
    width: 80px;
}

.image {
    /* width: 50vw; */
    box-shadow: 4px 4px 4px 2px rgb(212, 218, 221);

}

.details {
    margin-left: 50px;
    /* width: 50vw; */
    display: block;
    float: left;
}

.details div {
    /* align-self: flex-start; */
}

.logout {
    background-color: rgb(226, 223, 218);
    border: 0;
    width: fit-content;
    margin: 10px 10px 10px 10px;
    padding: 10px 10px 10px 10px;

}

.logout:hover {
    background-color: rgb(200, 198, 194);
    border: 0;
}

.logout a {
    text-decoration: none;
    color: black;
}

.logout li {
    list-style: none;
    color: black;
}
</style>
