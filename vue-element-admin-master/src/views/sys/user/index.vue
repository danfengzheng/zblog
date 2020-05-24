<template>
  <div class="app-container">
    <el-table v-loading="listLoading" :data="list" border fit highlight-current-row style="width: 100%; margin-top:15px;">
      <el-table-column align="center" prop="userId" label="ID" width="80" />
      <el-table-column align="center" prop="username" label="UserName" width="180" />
      <el-table-column align="center" prop="email" label="Email" width="180" />
      <el-table-column align="center" prop="status" label="状态" width="180">
        <template slot-scope="scope">

          <el-switch
            v-model="scope.row.status"
            active-color="#409EFF"
            :active-value="1"
            inactive-color="#F56C6C"
            :inactive-value="0"
            @change="changeStatus"
          />
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />
  </div>
</template>

<script>
/* eslint-disable */
import curdUser from '@/api/sys/user'
import Pagination from '@/components/Pagination'
export default {
  name: 'UserInfo',
  components: { Pagination },
  data() {
    return {
      list: null,
      total: 0,
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 20
      }
    }
  },
  created() {
    this.getList()
  },
  methods: {
    changeStatus() {
      console.log('切换状态')
    },
    getList() {
      this.listLoading = true
      curdUser.getList(this.listQuery).then(data => {
        this.list = data.list
        this.total = data.totalCount
        this.listLoading = false
      })
    }
  }
}
</script>

<style scoped>

</style>
