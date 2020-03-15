<template>
  <v-app class="login">
    <v-container>
      <v-layout column
                justify-space-between
                align-center>
        <v-card class="pa-4"
                tile>
          <v-form>
            <v-text-field prepend-icon="person"
                          light
                          filled
                          color="loginform"
                          v-model="id"
                          name="ID"
                          label="Id"
                          :rules="[rules.required]">
            </v-text-field>
            <v-text-field prepend-icon="lock"
                          filled
                          color="loginform"
                          :append-icon="visiblePassword ? 'visibility_off' : 'visibility'"
                          v-model="password"
                          @keydown.enter="onClickLogin(id, password)"
                          name="Password"
                          label="Password"
                          @click:append="visiblePassword = !visiblePassword"
                          :type="visiblePassword ? 'text' : 'password'">
            </v-text-field>
            <v-card-actions>
              <v-btn @click="onClickLogin(id, password)"
                     :disabled="id === ''"
                     primary
                     large
                     block>Login
              </v-btn>
            </v-card-actions>
          </v-form>
        </v-card>
      </v-layout>
    </v-container>
  </v-app>
</template>
<script>
  import axios from 'axios'

  export default {
    data: () => {
      return {
        id: '',
        password: '',
        visiblePassword: false,
        isActiveLoginButton: false,
        rules: {
          required: value => !!value || '필수 입력',
        }
      }
    },
    methods: {
      async onClickLogin(id, password) {
        const obj = {
          email: id,
          password: password
        }

        const response = await axios.post('http://localhost:8080/api/v1/login', obj)
        if (response.data.accessToken) {
          await localStorage.setItem('accessToken', response.data.accessToken)
          this.$router.push('/')
        }
      },
    }
  }
</script>
