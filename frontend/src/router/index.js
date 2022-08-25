import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '@/components/HelloWorld'
import Header from '@/components/Header'
import Main from '@/components/Main'
import Home from '@/components/Home'
import Product from '@/components/Product'
import Cart from '@/components/Cart'
import Catalouge from '@/components/Catalouge'
import Products from '@/components/Products'
import Footer from '@/components/Footer'
import Login from '@/components/Login'
import Signup from '@/components/Signup'
import Account from '@/components/Account'
import Order from '@/components/orderHistory'
import ProductDescription from '@/components/ProductDescription'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/header',
      name: 'Header',
      component: Header
    },
    {
      path: '/main',
      name: 'Main',
      component: Main
    },
    {
      path: '/home',
      name: 'Home',
      component: Home
    },
    {
      path: '/product',
      name: 'Product',
      component: Product
    },
    {
      path: '/cart',
      name: 'Cart',
      component: Cart
    },
    {
      path: 'cat',
      name: '/Catalouge',
      components: Catalouge
    },
    {
      path: '/products',
      name: 'Products',
      component: Products
    },
    {
      path: '/footer',
      name: 'Footer',
      component: Footer
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/',
      name: 'Signup',
      component: Signup
    },
    {
      path: '/account',
      name: 'Account',
      component: Account
    },
    {
      path: '/orderhistory',
      name: 'Order',
      component: Order
    },
    {
      path: '/productDescription',
      name: 'ProductDescription',
      component: ProductDescription
    }
  ]
})
