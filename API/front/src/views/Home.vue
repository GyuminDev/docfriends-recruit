<template>
  <v-app class="login">
    <v-container v-if="isLoaded">
      <v-layout
          column
          justify-space-between
          align-center>
        <template
            v-for="question in questionList">
          <v-card
              class="pa-4 mb-2"
              tile
              width="500px"
              :key="question.id">
            <v-card-text>
              <h2>{{question.title}}</h2>
              <p>{{getTag(question.tagList)}}</p>
              <p v-html="question.content"></p>
              <v-layout
                  justify-space-between
                  align-center>
                <p class="green--text">답변{{question.answerList.length}}</p>
                <p class="text-right">{{question.createdDate}}</p>
              </v-layout>
            </v-card-text>
            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn
                  text
                  color="green"
                  :to="{name: 'detail', params: {id: question.id}}"
              >
                자세히 보기
              </v-btn>
            </v-card-actions>
          </v-card>
        </template>

      </v-layout>
    </v-container>
  </v-app>
</template>

<script>
  import axios from 'axios'

  export default {
    name: 'Home',
    data: () => {
      return {
        isLoaded: false,
        questionList: []
      }
    },
    async created() {
      axios.defaults.headers.common['Authorization'] = await `Bearer ${localStorage.getItem('accessToken')}`
      axios.defaults.headers.common['Content-Type'] = await 'application/json'
      const response = await axios.get('http://localhost:8080/api/v1/questions')
      this.questionList = await response.data
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
    computed: {

    }
  }
</script>
