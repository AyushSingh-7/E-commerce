import Vue from 'vue'
import Vuex from 'vuex'
import NewModule from './modules/NewModule'

Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    NewModule
  }
})
