<template>
  <el-dialog :visible.sync="visible" :title="dataForm.id === null ?'新增': '修改'" :close-on-click-modal="false">
    <div>
      <treeselect
        v-model="value"
        :multiple="true"
        :options="options"
        placeholder="Select your favourite(s)..."
      />
      <span>{{ value }}</span>
    </div>
  </el-dialog>
</template>

<script>
import Treeselect from '@riophae/vue-treeselect'
// import the styles
import '@riophae/vue-treeselect/dist/vue-treeselect.css'
export default {
  name: 'Category',
  components: { Treeselect },
  data() {
    return {
      visible: false,
      dataForm: {
        rank: 0,
        type: '',
        parentId: 0,
        parentName: ''
      },
      value: [],
      options: [{
        id: 'fruits',
        label: 'Fruits',
        children: [{
          id: 'apple',
          label: 'Apple 🍎',
          isNew: true
        }, {
          id: 'grapes',
          label: 'Grapes 🍇'
        }, {
          id: 'pear',
          label: 'Pear 🍐'
        }, {
          id: 'strawberry',
          label: 'Strawberry 🍓'
        }, {
          id: 'watermelon',
          label: 'Watermelon 🍉'
        }]
      }, {
        id: 'vegetables',
        label: 'Vegetables',
        children: [{
          id: 'corn',
          label: 'Corn 🌽'
        }, {
          id: 'carrot',
          label: 'Carrot 🥕'
        }, {
          id: 'eggplant',
          label: 'Eggplant 🍆'
        }, {
          id: 'tomato',
          label: 'Tomato 🍅'
        }]
      }]
    }
  },
  methods: {
    init() {
      this.visible = true
    }
  }
}
</script>

<style scoped>

</style>
