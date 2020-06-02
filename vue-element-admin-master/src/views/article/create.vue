<template>
  <article-detail :is-edit="false" />
</template>

<script>
import ArticleDetail from './components/ArticleDetail'
import { mapGetters } from 'vuex'
export default {
  name: 'Markdown',
  components: { ArticleDetail },
  data() {
    return {
      height: document.documentElement.clientHeight - 200 + 'px'
    }
  },
  computed: {
    ...mapGetters([
      'imagesUploadApi'
    ])
  },
  mounted() {
    const that = this
    window.onresize = function temp() {
      that.height = document.documentElement.clientHeight - 200 + 'px'
    }
  },
  methods: {
  }
}
</script>

<style scoped>
</style>
