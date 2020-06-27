<template>
  <div class="app-container">
    <el-table v-loading="listLoading" :data="list" border fit highlight-current-row style="width: 100%">
      <el-table-column align="center" prop="id" label="标号" width="80" />
      <el-table-column label="标题" prop="title" width="120px" align="center" />
      <el-table-column label="作者" prop="author" width="120px" align="center" />
      <el-table-column label="分类" prop="categoryId" width="320px" align="center">
        <template slot-scope="scope">
          <article-category :data-str="scope.row.categoryId" :all-list="categoryList" :disabled="true" />
        </template>
      </el-table-column>
      <el-table-column label="标签" prop="author" width="120px" align="center" />
      <el-table-column label="浏览" prop="readNum" width="120px" align="center" />
      <el-table-column label="喜欢" prop="likeNum" width="120px" align="center" />
      <el-table-column label="推荐" prop="recommend" style="width: 120px; align-content: center">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.recommend"
            active-color="#13ce66"
          />
        </template>
      </el-table-column>
      <el-table-column label="置顶" prop="top" style="width: 120px; align-content: center">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.top"
            active-color="#13ce66"
            @change="changeTop"
          />
        </template>
      </el-table-column>
      <el-table-column label="状态" prop="publish" width="120px" align="center">
        <template slot-scope="scope">
          <el-tooltip v-if="scope.row.publish" class="item" effect="dark" content="点击发布" placement="top">
            <el-button type="info" size="mini">未发布</el-button>
          </el-tooltip>
          <el-tooltip v-if="!scope.row.publish" class="item" effect="dark" content="点击下架" placement="top">
            <el-button type="success" size="mini">已发布</el-button>
          </el-tooltip>
        </template>
      </el-table-column>

      <el-table-column align="center" label="Actions" width="120">
        <template slot-scope="scope">
          <router-link :to="'/article/edit/'+scope.row.id">
            <el-button type="primary" size="small" icon="el-icon-edit">
              Edit
            </el-button>
          </router-link>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />
  </div>
</template>

<script>
import ArticleCurd from '@/api/article/index'
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination
import curdCategory from '@/api/operation/category'
import ArticleCategory from './components/Category'

export default {
  name: 'ArticleList',
  components: { Pagination, ArticleCategory },
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'info',
        deleted: 'danger'
      }
      return statusMap[status]
    }
  },
  data() {
    return {
      list: null,
      total: 0,
      categoryList: [],
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 20
      }
    }
  },
  created() {
    this.getList()
    curdCategory.getTree().then(rest => {
      this.categoryList = rest
    })
  },
  methods: {
    getList() {
      this.listLoading = true
      ArticleCurd.query(this.listQuery).then(response => {
        this.list = response.list
        this.total = response.totalCount
        this.listLoading = false
      })
    },
    changeTop() {
      console.log(`调整置顶`)
    },
    categoryStr(data) {
      const categoreStr = ''
      return categoreStr
    }
  }
}
</script>

<style scoped>
.edit-input {
  padding-right: 100px;
}
.cancel-btn {
  position: absolute;
  right: 15px;
  top: 10px;
}
</style>
