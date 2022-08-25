<template>
    <div class="wrapper">
         <a href="home"   >
        <img
            src="https://www.freepnglogos.com/uploads/logo-3d-png/3d-best-logo-maker-online-triangle-logo-design-17.png">
            </a>
        <input type="checkbox" id="check" />
        <div class="buttonandmenu">

            <label for="check" class="menu-btn">
                <i class="fa-solid fa-bars"></i>
            </label>
            <div class="buttons">
                <ul>

                    <li><a href="home">Home</a></li>
                    <li><a href="products">Products</a></li>
                    <li><a href="account" >Account</a></li>
                    <li><a href="cart">Cart</a>
                        <a class="badge" href="#">{{ getCartItems }}</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: 'Header',
  data () {
    return {}
  },
  computed: {
    ...mapGetters(['getCartItems', 'getProductsList'])
  },
  beforeMount: function () {
    this.$store.dispatch('actionGetCartList', {
      success: (res) => {
        // console.log("hellocartlist", res);
        // this.myCartList=res
        // this.$store.commit('setProductsList',res)
        //   console.log("in cart",this.getProductsList)

      }

    })
  },
  methods: {

  }
}
</script>

<style scoped>
.wrapper {
    display: flex;
    box-shadow: 4px 4px 4px 2px rgb(212, 218, 221);
    width: 100%;
    height: 80px;
    background-color: rgb(200, 215, 205);
    justify-content: space-between;

}

.wrapper ul {
    display: flex;
    flex-wrap: wrap;
    list-style: none;
}

.menu-btn {
    color: rgb(20, 18, 18);
    font-size: 22px;
    cursor: pointer;
    display: none;
}

.buttonandmenu {
    margin-right: 10px;
}

.buttons a {
    /* width: 100%; */
    color: #000;
    font-weight: 400;
    text-transform: uppercase;
    text-decoration: none;
    letter-spacing: 0.15em;
    display: inline-block;
    padding: 15px 20px;
    position: relative;
}

a:hover {
    background-color: rgb(200, 215, 205);
}

a::before {
    content: "";
    position: absolute;
    display: block;
    width: 100%;
    height: 2px;
    bottom: 0;
    left: 0;
    background-color: #000;
    transform: scaleX(0);
    transition: transform 0.3s ease;
}

a:hover::before {
    transform: scaleX(1);
    /* background-color: rgb(220, 234, 225); */
}

img {
    height: 80px;
    width: 100px;

}

.buttons {
    position: relative;
}

.buttons .badge {
    padding-bottom: 2px;
    position: absolute;
    font-size: 14px;
    top: -5px;
    right: 0px;
    padding-top: 2px;
    padding-left: 8px;
    padding-right: 5px;
    border-radius: 50%;
    background-color: rgb(255, 40, 40);
    color: white;
    /* display: none; */
}

.wrapper ul li a.active,
.wrapper ul li a:hover {
    color: #111;
    /* background: #fff; */
}

input[type="checkbox"]:checked~* .buttons {
    margin-top: 100px;
}

input[type="checkbox"] {
    display: none;
}

/* input[type="checkbox"]:checked {
  box-shadow: 0 0 0 3px hotpink;
} */
@media (min-width: 680px) {

    input[type="checkbox"]:checked~* .buttons {
        margin-top: 0%;
        /* transition: all 00.3s ease; */
    }
}

@media (max-width: 680px) {

    .buttons .badge {
        padding-bottom: 2px;
        position: absolute;
        font-size: 14px;
        top: 160px;
        right: 4px;
        padding-top: 2px;
        padding-left: 8px;
        padding-right: 5px;
        border-radius: 50%;
        background-color: rgb(204, 27, 27);
        color: white;
        /* display: none; */
    }

    .menu-btn {
        display: block;
        margin-left: 40%;
        margin-top: 15%;
    }

    .buttons {
        /* margin-top: 10%; */
        margin-right: 10%;
        /* background-color: rgb(227, 207, 207); */
    }

    ul {
        margin-top: -300%;
    }

    .buttons ul {
        display: block;
    }

    input[type="checkbox"]:checked~* .buttons {
        margin-top: 280%;
        transition: all 00.3s ease;
    }
}
</style>
