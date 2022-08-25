<template>
    <div class="hello">
        <div class="catalouge">
            <label for="cars"></label>
                <select name="cars" id="cars">
                <option value="volvo">Electronics</option>
                <option value="saab">Saab</option>
                <option value="mercedes">Mercedes</option>
                <option value="audi">Audi</option>
            </select><br>
            <label for="cars"></label>
                <select name="cars" id="cars">
                <option value="volvo">Furniture</option>
                <option value="saab">Saab</option>
                <option value="mercedes">Mercedes</option>
                <option value="audi">Audi</option>
            </select><br>
            <label for="cars"></label>
                <select name="cars" id="cars">
                <option value="volvo">Sports</option>
                <option value="saab">Saab</option>
                <option value="mercedes">Mercedes</option>
                <option value="audi">Audi</option>
            </select><br>
            <label for="cars"></label>
                <select name="cars" id="cars">
                <option value="volvo">Cloths</option>
                <option value="saab">Saab</option>
                <option value="mercedes">Mercedes</option>
                <option value="audi">Audi</option>
            </select><br>
            <label for="cars"></label>
                <select name="cars" id="cars">
                <option value="volvo">Grocery</option>
                <option value="saab">Saab</option>
                <option value="mercedes">Mercedes</option>
                <option value="audi">Audi</option>
            </select>

        </div>
    </div>
</template>

<script>
export default {
  name: 'Catalouge',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1 {
    font-weight: normal;
}
.catalouge{
    margin-top: 200px;
}

select {
    width: 250px;
    height: 40px;
    justify-content: space-between;
    border: 0;
    /* border-bottom: 20px black; */
    margin-bottom: 10px;
    font-size: 20px;
    line-height: 30px;
    font-weight: 300;
    outline: 0;

}
</style>
