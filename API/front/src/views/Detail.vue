<template>
  <v-app class="login">
    <v-container v-if="isLoaded">
      <v-layout
          column
          justify-space-between
          align-center>
        <v-card
            class="pa-4 mb-2"
            tile
            width="500px">
          <v-card-text>
            <h2>{{question.title}}</h2>
            <p class="text-right">{{question.createdDate}}</p>
            <p v-html="question.content"></p>
            <v-spacer></v-spacer>
            <p>{{getTag(question.tagList)}}</p>
          </v-card-text>
        </v-card>
        <template
            v-for="answer in question.answerList">
          <v-card
              class="pa-4 mb-2"
              tile
              width="500px"
              :key="answer.id">
            <v-card-text>
              <h2>{{answer.doctor.name}}의 답변</h2>
              <p class="text-right">{{answer.createdDate}}</p>
              <p v-html="answer.content"></p>
            </v-card-text>
          </v-card>
        </template>
      </v-layout>
    </v-container>
  </v-app>
</template>

<script>
  import axios from 'axios'

  export default {
    name: 'Detail',
    props: [
      'id'
    ],
    data: () => {
      return {
        isLoaded: false,
        question: {}
      }
    },
    async created() {
      axios.defaults.headers.common['Authorization'] = await `Bearer ${localStorage.getItem('accessToken')}`
      axios.defaults.headers.common['Content-Type'] = await 'application/json'
      const response = await axios.get(`http://localhost:8080/api/v1/question/${this.id}`)
      this.question = await response.data
      this.isLoaded = true;
    },
    methods: {
      getTag(tagList) {
        let tagString = '';
        tagList.forEach(tag => {
          tagString += `#${tag.name} `
        })

        return tagString
      }
    },
    computed: {}
  }
</script>
