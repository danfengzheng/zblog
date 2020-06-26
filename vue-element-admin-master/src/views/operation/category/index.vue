<template>
  <div class="mod-config">
    category
    {{ addOrUpdateVisible }}
    <el-button type="text" size="small" @click="addOrUpdateHandle()">增加</el-button>
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" />
    <div class="app-container">
      <div class="app-table">
        <el-table v-loading="listLoading" border width="100%" :data="list" :tree-props="{children: 'children', hasChildren: 'hasChildren'}" row-key="value">
          <el-table-column
            prop="label"
            header-align="center"
            width="150"
            label="名称"
          />
          <el-table-column prop="type" :formatter="formatType" label="类型" />
          <el-table-column prop="rank" :formatter="formatRankType" label="级别" />
        </el-table>
        <pagination v-show="total>0" :total="total" :page.sync="listQuery.currPage" :limit.sync="listQuery.limit" @pagination="getList" />
      </div>
    </div>
  </div>
</template>

<script>
import AddOrUpdate from './category'
import curdCategory from '@/api/operation/category'
export default {
  name: 'Category', components: { AddOrUpdate },
  data() {
    return {
      tagType: { 0: '文章', 1: '图书' },
      rankType: { 0: '一级', 1: '二级', 2: '三级' },
      addOrUpdateVisible: false,
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
      curdCategory.query(this.listQuery).then(rest => {
        this.list = rest.list
        this.total = rest.totalCount
        this.listLoading = false
      }).catch(error => {
        console.log(error)
        this.listLoading = false
      })
    },
    addOrUpdateHandle() {
      this.addOrUpdateVisible = true
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init()
      })
    },
    formatType(row) {
      return this.tagType[row.type]
    },
    formatRankType(row) {
      return this.rankType[row.type]
    }
  }
}
</script>

<style scoped>

</style>
