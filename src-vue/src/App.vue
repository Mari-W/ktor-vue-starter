<template>
  <div id="app">
    <div>
      <h1>Welcome to Ktor with VueJS</h1>
      <h2>{{ apiVersion }}</h2>
    </div>
  </div>
</template>

<script>


import axios from "axios";

export default {
  name: 'App',
  data() {
    return {
      apiVersion: ''
    }
  },
  mounted() {
    this.getApiVersion()
  },
  methods: {
    getApiVersion() {
      axios.get("/").then(res => { // /api/ extended to every call, see main.js
            this.apiVersion = res.data
          }
      ).catch(() =>
          this.apiVersion = "Could not resolve API version."
      )
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
