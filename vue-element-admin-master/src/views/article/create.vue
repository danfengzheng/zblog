<template>
  <div class="app-container">
    <el-form label-width="120px">
      <el-form-item label="标题">
        <el-col :span="18">
          <el-input v-model="article.title" placeholder="请输入标题" style="width: 700px" />
        </el-col>
      </el-form-item>
      <el-row>
        <el-col :span="6">
          <el-form-item label="博文分类">
            <el-input v-model="article.blogType" placeholder="请填写博文分类" style="width: 100%" />
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="博文标签">
            <el-input v-model="article.tag" placeholder="请填写博文标签" style="width: 100%" />
          </el-form-item>
        </el-col>

        <el-col :span="6">
          <el-form-item label="作者">
            <el-input v-model="article.author" placeholder="请填写作者" style="width: 100%" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="6">
          <el-form-item label="是否推荐">
            <el-radio-group v-model="article.coverType">
              <el-radio value="1" label="是" />
              <el-radio value="0" label="否" />
            </el-radio-group>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item v-model="article.recommend" label="展示类型">
            <el-radio-group>
              <el-radio :value="1" label="大图片" />
              <el-radio :value="2" label="小图片" />
              <el-radio :value="0" label="无图片" />
            </el-radio-group>
          </el-form-item>
        </el-col>
      </el-row>
      <el-form-item label="封面图片">
        <el-col :span="12">
          <el-upload
            drag
            :action="imagesUploadApi"
            list-type="picture"
            :multiple="false"
            :before-upload="beforeUploadHandle"
            :file-list="file"
            :on-remove="handleRemove"
            :on-success="successHandle"
          >
            <i class="el-icon-upload" />
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
            <div slot="tip" class="el-upload__tip">只支持jpg、png、gif格式的图片！</div>
          </el-upload>
        </el-col>
      </el-form-item>

    </el-form>
    <el-button v-loading="loading" style="margin-left: 10px;" type="success">
      发布
    </el-button>
    <el-button v-loading="loading" type="warning">
      草稿
    </el-button>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: 'Markdown',
  data() {
    return {
      height: document.documentElement.clientHeight - 200 + 'px',
      file: [],
      uri: '',
      loading: false,
      article: {
        recommend: false
      }
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
    successHandle() {
      console.log('上传成功')
    },
    handleRemove() {
      console.log('移除')
    },
    beforeUploadHandle() {
      console.log('上传准备')
    },
    uploadImg() {
      console.log('上传图片')
    }
  }
}
</script>

<style scoped>
</style>
