<template>
  <el-cascader
    v-model="cascaderArr"
    :options="allList"
    clearable
    :disabled="disabled"
    width="300px"
  />
</template>
<script>
export default {
  name: 'ArticleCategroy',
  props: {
    dataStr: {
      type: String,
      default: ''
    },
    disabled: {
      type: Boolean,
      default: false
    },
    allList: {
      type: Array,
      default: () => []
    }
  },
  data() {
    return {
      cascaderArr: []
    }
  },
  watch: {
    dataStr: {
      handler(val) {
        const arr = val.split(',')
        arr.forEach(element => {
          this.cascaderArr.push(parseInt(element))
        })
      },
      deep: true,
      immediate: true
    }
  }
}
</script>
