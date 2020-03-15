<template>
  <v-app>
    <v-app-bar
      app
      color="green"
      dark
    >
      <v-spacer></v-spacer>
      <v-toolbar-title>Doctalk</v-toolbar-title>
      <v-spacer></v-spacer>
    </v-app-bar>
    <v-content>
      <router-view />
    </v-content>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    //
  }),
};
</script>
