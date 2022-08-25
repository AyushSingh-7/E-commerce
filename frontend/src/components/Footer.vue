<template>
   <div class="footer">

        <ul>
            <li>Contact Us</li>
            <li>About us</li>

            <li>Login</li>
        </ul>
        <ul>
            <li>Career</li>
            <li>Support</li>
             <li>Pricing</li>

        </ul>
    </div>
</template>

<script>
// import { computed } from 'vue'

export default {
  name: 'Footer',
  data () {
    return {
      msg: ''
    }
  }
}
</script>

<style scoped>
.footer{
    border: 1px solid;
   padding: 10px;
   box-shadow: 15px 15px 28px rgb(23, 22, 22);
    display: flex;
    justify-content: center;
    background-color: rgb(216, 235, 223);

}
.buttons {
    padding-top: 5px;
    padding-right: 20px;
}.buttons a {

    text-decoration: none;
    color: black;
    padding-right: 5px;
}
li{
    list-style-type: none;
}
ul{
    margin-top: 5px;
}
</style>
