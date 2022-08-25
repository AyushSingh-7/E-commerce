<template>
  <!-- <div> -->
  <div class="login-page">

    <!-- <div class="logform"> -->

    <!-- <button @click="callme">press</button> -->

    <div class="form">
      <form class="login-form" @submit="login">
        <h3 style="padding-top: 50px; text-align: left;">Hey Merchant..!! Please login for access!!</h3>
        <input type="email" style="width: 350px;" v-model="email"
          placeholder="Please enter your mail id for us to verify!!" required autofocus /><br /><br />
        <input type="password" style="width: 350px;" v-model="password"
          placeholder="But how can we verify it's u.. give ur password too!!" required /><br /><br />
        <!-- <div class='err'>{{ passwordError }}</div> -->
        <button @click="login" style="width: 250px; margin-top: 30px; border-radius: 15px;">login</button>
        <p class="message">Not registered? <router-link to="/signup">Signup</router-link>
        </p>
      </form>
    </div>
    <div class="image">
      <!-- <img src = "../assets/ecommerce.jpeg"><br/> -->
    </div>
  </div>
  <!-- </div> -->
  <!-- </div> -->
</template>

<script>
import axios from 'axios'
import { mapGetters } from 'vuex'
export default {
  name: 'login',
  data () {
    return {
      email: '',
      password: ''
    }
  },
  computed: {
    ...mapGetters(['getLogInData'])
  },

  // async getme () {
  // const res = await axios.post('http://localhost:8086/auth/login', obj, {
  //           'Content-Type': 'application/json; charset=UTF-8'
  //         })

  // console.log(res.json())

  //         this.$router.push('/home')

  // }

  methods: {
    callme () {
      console.log('hi')
      this.$router.push('/home')
    },

    login () {
      console.log('caleed')
      var obj = {
        mailId: this.email,
        password: this.password
      }
      console.log('thi ka email')
      console.log(obj.mailId)
      this.$store.commit('setLogInData', obj.mailId)

      axios.post('http://localhost:8086/auth/login', obj, {
        'Content-Type': 'application/json; charset=UTF-8'
      })
        .then((res) => {
          console.log('hello')
          console.log(res.mailId)
          if (res.data.mailId != null) {
            console.log(res)
            console.log('sucess')
            this.$router.push('/home')
          } else {
            alert('unsucessfull')
          }
        })
        .catch((err) => console.log(err))

      console.log(obj)
      this.email = ''
      this.password = ''
    }

  }
}

</script>

<style>
.login-page {
  margin-top: 90px;
  display: flex;
  margin-top: 80px;
}

.form input {
  font-family: math;
  font-style: italic;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}

.form button {
  font-family: math;
  text-transform: uppercase;
  outline: 0;
  background: #6aa2c1;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  transition: all 0.3 ease;
  cursor: pointer;
}

.form button:hover,
.form button:active,
.form button:focus {
  background: green;
}

body {
  font-family: math;
  font-style: italic;
  background-color: azure;
}

.form .message {
  margin: 15px 0 0;
  font-size: 18px;
  font-family: math;
  font-style: italic;
}

img {

  /* float:"left"; */
  width: 45vw;
  height: 50vh;
  /* border: 10px; */
  border-radius: 10px
}

.image {
  width: 45vw;
  height: 50vh;
  margin-top: 100px;
  border-radius: 12px;
}

.form {
  width: 50vw;
  /* border-radius: 10px; */
  /* border: 2px solid black; */
}

.logform {
  width: 50vw;
  margin-top: 50px;
}

.login-page {
  display: flex;
  margin-top: 100px;
}

.login-form {
  max-width: 360px;
  margin: 0 auto 100px;
  /* padding: 45px; */
}

h3 {
  text-align: center;
}
</style>
