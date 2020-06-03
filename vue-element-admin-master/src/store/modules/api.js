const baseUrl = process.env.VUE_APP_BASE_API
const api = {
  state: {
    imagesUploadApi: baseUrl + '/admin/common/file/upload'
  }
}

export default api
