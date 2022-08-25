<template>
  <div>
    <!-- <h2 style="text-align: center;">Hey New Merchant..!! Welcome to the Merchant's Family..!!</h2> -->
    <div class="signup">

      <div class="two">
        <h3>Hey New Customer..!! Welcome to the Family..!!</h3>

        <form class="form" action="/homepage" @submit="signup">
          <input type="text" style="width: 330px;" v-model="name" placeholder="Your sweet name here!!" required />

          <input type="password" style="width: 330px;" v-model="password"
            placeholder="Give a password to keep ur orders confidential!!" required @change="handle1" />
          <div v-if="passwordError" class='error'>{{ passwordError }}</div>

          <input type="password" style="width: 330px;" v-model="confirmpassword"
            placeholder="Confirm ur Password again :)" required @change="handle2" />
          <div v-if="confirmpasswordError" class='error'>{{ confirmpasswordError }}</div>

          <input type="email" style="width: 330px;" v-model="email"
            placeholder="Give ur Email to send ur order results!!" required />

          <input type="number" style="width: 330px;" v-model="phone"
            placeholder="How can we contact u? Give us ur Phone number!!" required @change="handle" />
          <div v-if="phoneError" class='error'>{{ phoneError }}</div>

          <button style="width: 100px; border-radius: 20px;">create</button>
          <p class="message">Already registered? <router-link to="/login">Sign In</router-link>
          </p>
        </form>
      </div>
      <div class="one">
        <!-- <img src = "../assets/ecommerce.jpeg"><br/> -->
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'Signup',
  data () {
    return {

      name: '',
      email: '',
      password: '',
      passwordError: '',
      confirmpassword: '',
      confirmpasswordError: ' ',
      phone: '',
      phoneError: ''

    }
  },
  methods: {

    signup (e) {
      e.preventDefault()
      var obj = {
        mailId: this.email,
        password: this.password,
        isMerchant: false,
        isCustomer: true
      }
      var obj2 = {
        name: this.name,
        emailId: this.email,
        address: 'banglore',
        contactNumber: this.phone
      }
      // const headers = {
      //   'Content-Type': 'application/json'
      // };

      console.log(obj, 'obj')
      axios.post('http://localhost:8086/auth/registration', obj,
        {
          headers: {
            'Access-Control-Allow-Origin': '*'
          },
          'mode': 'no-cors',
          'Content-Type': 'application/json; charset=UTF-8'
        }
        //  {
        //   'Content-Type': 'application/json; charset=UTF-8'
        // }
      )

        .then((res) => {
          console.log(res, 'out')
          if (res != null) {
            console.log(res)

            axios.post('http://localhost:8081/customer', obj2,
              {
                headers: {
                  'Access-Control-Allow-Origin': '*'
                },
                'mode': 'no-cors',
                'Content-Type': 'application/json; charset=UTF-8'
              }
              // {
              //   'Content-Type': 'application/json; charset=UTF-8'
              // }
            )

              .then((res) => {
                console.log(res, 'out')
              })
              .catch((err) => console.log(err))

            this.$router.push('/login')
          } else {
            alert('unsucessfull')
          }
        })
        .catch((err) => console.log(err))

      // console.log(obj, 'signup success')
      this.name = ''
      this.email = ''
      this.password = ''
      this.confirmpassword = ''
      this.phone = ''
    },
    handle () {
      this.phoneError = this.phone.match('^[1-9]{1}[0-9]{9}$') ? '' : 'Enter a valid phone number'
    },
    handle1 () {
      this.passwordError =
        this.password.length > 6
          ? ''
          : 'Password should be more than 6 characters long!'
    },
    handle2 () {
      this.confirmpasswordError =
        this.password === this.confirmpassword ? '' : 'Password does not match'
    }

  }

}
</script>
<style scoped>
.form {
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
}

.form input {
  font-family: math;
  font-style: italic;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  font-size: 14px;
}

.form button {
  font-family: math;
  text-transform: uppercase;
  color: white;
  width: 100%;
  border: 0;
  padding: 15px;
  font-size: 14px;
  cursor: pointer;
  background: #6aa2c1;
}

.form button:hover,
.form button:active,
.form button:focus {
  background: green;
}

.form .message {
  margin: 15px 0 0;
  font-size: 18px;
}

form {
  font-family: math;
  font-style: italic;
  /* border-radius: 20px ;
    border: 2px solid; */
}

.signup {

  display: flex;
  margin-top: 100px;

}

.one {
  width: 50vw;

}

.two {
  width: 50vw;
  margin-top: 50px;

}

img {
  float: "left";
  width: 45vw;
  height: 50vh;

  margin-top: 100px;

  border-radius: 12px;

}

h3 {
  font-family: math;
  font-style: italic;

  text-align: center;

}

body {
  background-color: azure;
}
</style>
