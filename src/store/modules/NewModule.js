import axios from 'axios'
export default {
  state: {
    productsList: [],
    filterby: '',
    currentvalue: '',
    myarray: [],
    cartitems: 0,
    userCartList: [],
    useremail: '',
    accountDetails: [],
    orderHistory: [],
    productDescription: [],
    productId: ''
  },
  getters: {
    getProductsList: state => state.productsList,
    getUserCartList: state => state.userCartList,
    getFilterBy: state => state.filterby,
    getCurrentValue: state => state.currentvalue,
    getMyArray: state => state.myarray,
    getCartItems: state => state.cartitems,
    getUserEmail: state => state.useremail,
    getProductId: state => state.productId,
    getAccountDetails: state => state.accountDetails,
    getorderHistory: state => state.orderHistory,
    getProductDescription: state => state.productDescription,
    getLogInData: state => {
      return JSON.parse(localStorage.getItem('logInData'))
    }
  },
  mutations: {
    setProductsList: function (state, value) {
      state.productsList = value
    },
    setUserCartList: function (state, value) {
      state.userCartList = value
    },
    setProductId: function (state, value) {
      state.productId = value
    },
    setFilterBy: function (state, value) {
      state.filterby = value
    },
    setCurrentValue: function (state, value) {
      state.currentvalue = value
    },
    setMyArray: function (state, value) {
      state.myarray = value
    },
    setCartItems: function (state, value) {
      state.cartitems = value
    },
    setAccountDetails: function (state, value) {
      state.accountDetails = value
    },
    setUserEmail: function (state, value) {
      state.useremail = value
    },
    setorderHistory: function (state, value) {
      state.orderHistory = value
    },
    setProductDescription: function (state, value) {
      state.productDescription = value
    },
    setLogInData: (state, value) => {
      localStorage.setItem('logInData', JSON.stringify(value))
      console.log(value, 'sotre')
      state.logInData = value
      console.log(state.logInData)
      state.logInData = value
    }
  },
  actions: {
    actionGetProductList: ({ commit }, { success }) => {
      fetch('https://dummyjson.com/products')
        .then(response => response.json())
        .then(res => {
          commit('setProductsList', res)
          success && success(res)
        })
    },
    actionGetCategoryList: ({ commit, getters }, { success }) => {
      // console.log(getters.getCurrentValue,"sadasasdsadasadas")
      fetch(
        'http://localhost:8080/product/categoryname/' +
          getters.getCurrentValue
      )
        .then(response => response.json())
        .then(res => {
          commit('setProductsList', res)
          console.log('cat', res)
          success && success(res)
        })
    },
    actionGetRecommendedList: ({ commit }, { success }) => {
      fetch('http://localhost:8080/product/rec')
        .then(response => response.json())
        .then(res => {
          commit('setProductsList', res)
          success && success(res)
        })
    },

    actionGetFilteredList: ({ commit, getters }, { success }) => {
      fetch(
        'http://localhost:8080/product/productname/' + getters.getFilterBy
      )
        .then(response => response.json())
        .then(res => {
          console.log('asd')
          commit('setProductsList', res)
          success && success(res)
        })
    },
    actionGetCartList: ({ commit, getters }, { success }) => {
      fetch('http://localhost:8082/cart/' + getters.getLogInData)
        .then(response => response.json())
        .then(res => {
          commit('setUserCartList', res)
          let sum = 0
          for (var i = 0; i < res.length; i++) {
            sum = sum + res[i].quantity
            // console.log('res items', res[i].quantity, 'sum', sum)
          }
          // console.log(sum, 'sum')
          commit('setCartItems', sum)
          console.log('total ', getters.getCartItems)

          // console.log("response from store",res)
          // this.setCartItems.push(this.getProductsList)
          // console.log("mylist from cart",getters.getProductsList)
          success && success(res)
        })
    },
    actionGetAccountDetails: ({ commit, getters }, { success }) => {
      fetch('http://localhost:8081/customer/' + getters.getLogInData)
        .then(response => response.json())
        .then(res => {
          console.log(res, 'respomsecustomer')

          // this.cartlist = res
          // console.log(this.cartlist.length, "size")
          commit('setAccountDetails', res)
          // console.log("cartitems ka length", this.getCartItems)
        })
    },
    actionGetOrderHistory: ({ commit, getters }, { success }) => {
      fetch('http://localhost:8082/order/' + getters.getLogInData)
        .then(response => response.json())
        .then(res => {
          console.log(res, 'respomsecustomer')

          // this.cartlist = res
          console.log(res.length, 'size')
          commit('setorderHistory', res)
          // console.log("cartitems ka length", this.getCartItems)
        })
    },
    actionGetFurnitureList: ({ commit }, { success }) => {
      fetch('http://localhost:8080/product')
        .then(response => response.json())
        .then(res => {
          commit('setProductsList', res)
          success && success(res)
        })
    },

    actionAddQuantity: ({ commit, getters }, { success }) => {
      axios.put('http://localhost:8082/cart/add/' + getters.getProductId, {
        headers: {
          'Access-Control-Allow-Origin': '*'
        },
        'mode': 'no-cors',
        'Content-Type': 'application/json; charset=UTF-8'
      })
        .then((res) => {
          window.location.reload()
        })
        .catch((err) => console.log(err))
    },
    actionSubQuantity: ({ commit, getters }, { success }) => {
      axios.put('http://localhost:8082/cart/sub/' + getters.getProductId, {
        headers: {
          'Access-Control-Allow-Origin': '*'
        },
        'mode': 'no-cors',
        'Content-Type': 'application/json; charset=UTF-8'
      })
        .then((res) => {
          window.location.reload()
        })
        .catch((err) => console.log(err))
    }
  }
}
