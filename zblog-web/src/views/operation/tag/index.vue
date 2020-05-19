<template>
  <div class="el-main">
    <el-table :data="list" style="width: 100%">
      <el-table-column prop="id" label="Id" />
      <el-table-column prop="name" label="name" />
      <el-table-column prop="type" label="type" />
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="page.currPage"
      :page-sizes="[10, 20, 30, 40]"
      :page-size="page.limit"
      :total="total"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
  </div>
</template>
<script>
import CrudTag from '@/api/operation/tag'
export default {
  name: 'Tag',
  data() {
    return {
      page: {
        limit: 0,
        currPage: 1
      },
      total: 0,
      list: [],
      tagType: { 0: '文章', 1: '阅读' }
    }
  },
  created() {
    this.query()
  },
  methods: {
    query() {
      CrudTag.queryPage(this.page).then(response => {
        this.list = response.page.list
        this.total = response.page.totalCount
        this.page.limit = response.page.pageSize
        this.page.currPage = response.page.currPage
        console.log(response.page)
      }).catch(error => {
        console.log(error)
      })
    },
    handleSizeChange(val) {
      this.page.limit = val
      this.query()
    },
    handleCurrentChange(val) {
      this.page.currPage = val
      this.query()
    }
  }
}
</script>

<style scoped>

</style>
