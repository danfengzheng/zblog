<template>
  <div class="app-container">
    <div class="el-header">
      <el-input v-model="listQuery.name" placeholder="名称" style="width: 230px" />
      <el-button @click="getList">查询</el-button>
    </div>
    <el-table v-loading="listLoading" :data="list" border fit highlight-current-row style="width: 100%; margin-top:15px;">
      <el-table-column align="center" label="ID" prop="id" width="80" />
      <el-table-column prop="name" label="Name" />
      <el-table-column :formatter="formatType" prop="type" label="类型" />
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.currPage" :limit.sync="listQuery.limit" @pagination="getList" />
  </div>
</template>

<script>
import curdTag from '@/api/operation/tag/tag'
import Pagination from '@/components/Pagination'
export default {
  name: 'TagInfo',
  components: { Pagination },
  data() {
    return {
      tagType: { 0: '文章', 1: '阅读' },
      list: null,
      total: 0,
      listLoading: true,
      listQuery: {
        currPage: 1,
        limit: 10
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      this.listLoading = true
      curdTag.getList(this.listQuery).then(data => {
        this.list = data.list
        this.total = data.totalCount
        this.listLoading = false
      })
    },
    formatType(row) {
      return this.tagType[row.type]
    }
  }
}
</script>

<style scoped>

</style>
