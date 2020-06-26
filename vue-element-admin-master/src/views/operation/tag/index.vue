<template>
  <div class="app-container">
    <div class="el-header">
      <div>
        <el-input v-model="listQuery.name" placeholder="名称" size="small" class="filter-item" style="width: 230px" />
        <el-button class="filter-item" size="mini" type="success" icon="el-icon-search" @click="getList">查询</el-button>
      </div>
      <div style="padding-top: 10px;">
        <el-button class="filter-item" size="mini" type="primary" icon="el-icon-plus">新增</el-button>
      </div>
    </div>
    <el-table v-loading="listLoading" default-expand-all :data="list" row-key="id" border fit highlight-current-row style="width: 100%; margin-top:15px;">
      <el-table-column align="center" label="ID" prop="id" width="80" />
      <el-table-column prop="name" label="Name" />
      <el-table-column :formatter="formatType" prop="type" label="类型" />
      <el-table-column
        fixed="right"
        label="操作"
        width="100"
      >
        <el-button type="text" size="small">查看</el-button>
        <el-button type="text" size="small">编辑</el-button>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.currPage" :limit.sync="listQuery.limit" @pagination="getList" />
  </div>
</template>

<script>
import curdTag from '@/api/operation/tag'
import Pagination from '@/components/Pagination'
export default {
  name: 'TagInfo',
  components: { Pagination },
  data() {
    return {
      tagType: { 0: '文章', 1: '图书' },
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
