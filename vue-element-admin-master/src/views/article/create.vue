<template>
  <div class="app-container">
    <el-form ref="article" :rules="rule" :model="article" label-width="120px">
      <el-form-item label="标题" prop="title">
        <el-col :span="18">
          <el-input v-model="article.title" placeholder="请输入标题" style="width: 700px" />
        </el-col>
      </el-form-item>
      <el-row>
        <el-col :span="6">
          <el-form-item label="博文分类" prop="blogType">
            <el-input v-model="article.blogType" placeholder="请填写博文分类" style="width: 100%" />
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="博文标签" prop="tag">
            <el-input v-model="article.tag" placeholder="请填写博文标签" style="width: 100%" />
          </el-form-item>
        </el-col>

        <el-col :span="6">
          <el-form-item label="作者" prop="author">
            <el-input v-model="article.author" placeholder="请填写作者" style="width: 100%" />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="6">
          <el-form-item label="是否推荐">
            <el-radio-group v-model="article.coverType">
              <el-radio :label="1">是</el-radio>
              <el-radio :label="0">否</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="展示类型">
            <el-radio-group v-model="article.recommend">
              <el-radio class="el-radio" :value="1" :label="1">{{ article.recommend }}大图片</el-radio>
              <el-radio :label="2">小图片</el-radio>
              <el-radio :label="0">无图片</el-radio>
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

      <el-form-item label="博文描述" prop="description">
        <el-col :span="12">
          <el-input v-model="article.description" type="textarea" placeholder="博文描述" clearable />
        </el-col>
      </el-form-item>
      <el-form-item label="正文">
        <mavon-editor ref="md" v-model="article.content" style="height: 500px" @imgAdd="imgAdd" />
      </el-form-item>
    </el-form>
    <el-button v-loading="loading" style="margin-left: 10px;" type="success" @click="subArticle">
      发布
    </el-button>
    <el-button v-loading="loading" type="warning">
      草稿
    </el-button>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import ArticleCurd from '@/api/article/index'
export default {
  name: 'Markdown',
  data() {
    return {
      height: document.documentElement.clientHeight - 200 + 'px',
      file: [],
      uri: '',
      loading: false,
      article: {
        coverType: 0,
        recommend: 0
      },
      rule: {
        title: [
          { required: true, message: '请输入标题', trigger: blur }
        ],
        blogType: [
          { required: true, message: '请选择类型', trigger: blur }
        ],
        tag: [
          { required: true, message: '请选择标签', trigger: blur }
        ],
        author: [
          { required: true, message: '请填写作者', trigger: blur() }
        ]
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
    },
    imgAdd() {
      console.log('markdown 图片')
    },
    subArticle() {
      this.$refs.article.validate(valid => {
        if (valid) {
          ArticleCurd.add(this.article)
        } else {
          console.log('表单验证不通过！！')
          return false
        }
      })
    }
  }
}
</script>

<style scoped>
</style>
