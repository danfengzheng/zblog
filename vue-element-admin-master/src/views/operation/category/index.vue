<template>
  <div class="mod-config">
    category
    {{ addOrUpdateVisible }}
    <el-button type="text" size="small" @click="addOrUpdateHandle()">增加</el-button>
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" />
    <div class="app-container">
      <div class="app-table">
        <el-table border width="100%" :data="data" :tree-props="{children: 'children', hasChildren: 'hasChildren'}" row-key="id">
          <el-table-column
            prop="id"
            header-align="center"
            width="150"
            label="ID"
          />
          <el-table-column prop="pId" label="父ID" />
          <el-table-column prop="name" label="姓名" />
        </el-table>
      </div>
    </div>
  </div>
</template>

<script>
import AddOrUpdate from './category'
export default {
  name: 'Category', components: { AddOrUpdate },
  data() {
    return {
      addOrUpdateVisible: false,
      data: [
        {
          'id': 1,
          'pId': 0,
          'name': '郑单峰',
          'children': [
            {
              'id': 2,
              'pId': 1,
              'name': '张三'
            }
          ]
        }
      ]
    }
  },
  methods: {
    addOrUpdateHandle() {
      this.addOrUpdateVisible = true
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init()
      })
    }
  }
}
</script>

<style scoped>

</style>
