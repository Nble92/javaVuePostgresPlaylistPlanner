<template>
<body>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">

      <div class="sign-in">
      <h2 class="sign-in">Please Sign In</h2>
      </div>
      
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <div class="inputs">
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <button type="submit">Sign in</button>
      <div class="register-link">
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      </div>
      </div>
    </form>
  </div>


  </body>

</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
    
  }
};

</script>

<style>

body {

 background: rgb(82, 8, 82);
  height: 500px;
  font-family: 'Montserrat', sans-serif;
}

body {
  color: rgb(160, 138, 196);
 
}

h2 {
  padding-top: 35px;
  text-align: center;
  margin-top: 35px;
  text-shadow: 5px 5px rgb(31, 11, 31);
  font-size: 2rem;
}

form {
  display: block;
  margin: 0 auto;
  max-width: 400px;
}


.inputs {
 
  /* display: block;
  margin: 0 auto; */
  /* flex-direction: column;
  justify-content: center;
  align-content: center; */
  /* max-width: 200px; */
  padding-top: 40px;
}

.sign-in {
  padding-top: 20px;
  text-align: center;
}

label.sr-only {
  margin: 5px;
}

button {
  background: rgb(168, 56, 168);
  padding: 5px 8px;
  font-family: 'Montserrat', sans-serif;
  margin-top: 5px;
  border-radius: 8px;
  border-color: rgb(255, 219, 17);
}

.form-control{

margin-top: 7px;
margin-bottom: 10px;

}

.register-link {
  padding-top: 7px;
}

</style>

