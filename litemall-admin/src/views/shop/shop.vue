<template>
  <div class="app-container">

    <!-- 查询和其他操作 -->
    <div class="filter-container">
      <el-input v-model="listQuery.name" clearable class="filter-item" style="width: 200px;" placeholder="请输入商铺名称" />
      <el-button v-permission="['GET /admin/shop/list']" class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">查找</el-button>
      <el-button v-permission="['POST /admin/shop/create']" class="filter-item" type="primary" icon="el-icon-edit" @click="handleCreate">添加</el-button>
      <el-button :loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download" @click="handleDownload">导出</el-button>
    </div>

    <!-- 查询结果 -->
    <el-table v-loading="listLoading" :data="list" element-loading-text="正在查询中。。。" border fit highlight-current-row>
      <el-table-column align="center" label="商铺ID" prop="id" sortable />

      <el-table-column align="center" label="商铺名称" prop="name" />

      <el-table-column align="center" label="状态">
        <template slot-scope="scope">
          {{ displayStatus(scope.row.status) }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="商铺地址">
        <template slot-scope="scope">
          {{ scope.row.country + scope.row.province + scope.row.city + scope.row.district + scope.row.address }}
        </template>
      </el-table-column>

      <el-table-column align="center" label="logo" prop="logo">
        <template slot-scope="scope">
          <img v-if="scope.row.logo" :src="scope.row.logo" width="40">
        </template>
      </el-table-column>

      <el-table-column align="center" label="操作" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button v-permission="['POST /admin/shop/update']" type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <el-button v-permission="['POST /admin/shop/delete']" type="danger" size="mini" @click="handleDelete(scope.row)">删除</el-button>

          <el-button v-permission="['POST /admin/shop/changeStatus']" type="danger" size="mini" @click="handleChangeStatus(scope.row, 'NORMAL')">审核通过</el-button>
          <el-button v-permission="['POST /admin/shop/changeStatus']" type="danger" size="mini" @click="handleChangeStatus(scope.row, 'FREEZE')">冻结</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />

    <!-- 添加或修改对话框 -->
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form ref="dataForm" :rules="rules" :model="dataForm" status-icon label-position="left" label-width="100px" style="width: 400px; margin-left:50px;">
        <el-form-item label="商铺名称" prop="name">
          <el-input v-model="dataForm.name" />
        </el-form-item>
        <el-form-item label="所在国家" prop="country">
          <el-input v-model="dataForm.country" type="text" />
        </el-form-item>
        <el-form-item label="所在省份" prop="province">
          <el-input v-model="dataForm.province" type="text" />
        </el-form-item>
        <el-form-item label="所在城市" prop="city">
          <el-input v-model="dataForm.city" type="text" />
        </el-form-item>
        <el-form-item label="所在区" prop="district">
          <el-input v-model="dataForm.district" type="text" />
        </el-form-item>
        <el-form-item label="详细地址" prop="address">
          <el-input v-model="dataForm.address" type="text" />
        </el-form-item>
        <el-form-item label="商铺logo" prop="logo">
          <el-upload
            :headers="headers"
            :action="uploadPath"
            :show-file-list="false"
            :on-success="uploadLogo"
            class="logo-uploader"
            accept=".jpg,.jpeg,.png,.gif"
          >
            <img v-if="dataForm.logo" :src="dataForm.logo" class="logo">
            <i v-else class="el-icon-plus logo-uploader-icon" />
          </el-upload>
        </el-form-item>
        <el-form-item label="详细地址" prop="intro">
          <el-input v-model="dataForm.intro" type="textarea" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button v-if="dialogStatus=='create'" type="primary" @click="createData">确定</el-button>
        <el-button v-else type="primary" @click="updateData">确定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<style>
.logo-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.logo-uploader .el-upload:hover {
  border-color: #20a0ff;
}
.logo-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 120px;
  height: 120px;
  line-height: 120px;
  text-align: center;
}
.logo {
  width: 145px;
  height: 145px;
  display: block;
}
</style>

<script>
import { listShop, createShop, updateShop, deleteShop, changeStatus } from '@/api/shop'
import { roleOptions } from '@/api/role'
import { uploadPath } from '@/api/storage'
import { getToken } from '@/utils/auth'
import Pagination from '@/components/Pagination' // Secondary package based on el-pagination

export default {
  name: 'Shop',
  components: { Pagination },
  data() {
    return {
      uploadPath,
      list: null,
      total: 0,
      roleOptions: null,
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 20,
        name: undefined,
        sort: 'add_time',
        order: 'desc'
      },
      dataForm: {
        logo: undefined
      },
      dialogFormVisible: false,
      dialogStatus: '',
      textMap: {
        update: '编辑',
        create: '创建'
      },
      rules: {
        name: [{ required: true, message: '商铺名称不能为空', trigger: 'blur' }],
        address: [{ required: true, message: '地址不能为空', trigger: 'blur' }]
      },
      downloadLoading: false
    }
  },
  computed: {
    headers() {
      return {
        'X-Litemall-Admin-Token': getToken()
      }
    }
  },
  created() {
    this.getList()

    roleOptions()
      .then(response => {
        this.roleOptions = response.data.data.list
      })
  },
  methods: {
    getList() {
      this.listLoading = true
      listShop(this.listQuery)
        .then(response => {
          this.list = response.data.data.list
          this.total = response.data.data.total
          this.listLoading = false
        })
        .catch(() => {
          this.list = []
          this.total = 0
          this.listLoading = false
        })
    },
    displayStatus(status) {
      switch (status) {
        case 'TO_CHECK':
          return '待审核'
        case 'NORMAL':
          return '正常'
        case 'FREEZE':
          return '账户冻结'
      }
    },
    handleFilter() {
      this.listQuery.page = 1
      this.getList()
    },
    resetForm() {
      this.dataForm = {
        logo: undefined
      }
    },
    uploadLogo: function(response) {
      this.dataForm.logo = response.data.url
    },
    handleCreate() {
      this.resetForm()
      this.dialogStatus = 'create'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    createData() {
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          createShop(this.dataForm)
            .then(response => {
              this.list.unshift(response.data.data)
              this.dialogFormVisible = false
              this.$notify.success({
                title: '成功',
                message: '添加商铺成功'
              })
            })
            .catch(response => {
              this.$notify.error({
                title: '失败',
                message: response.data.errmsg
              })
            })
        }
      })
    },
    handleUpdate(row) {
      this.dataForm = Object.assign({}, row)
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    updateData() {
      this.$refs['dataForm'].validate(valid => {
        if (valid) {
          updateShop(this.dataForm)
            .then(() => {
              for (const v of this.list) {
                if (v.id === this.dataForm.id) {
                  const index = this.list.indexOf(v)
                  this.list.splice(index, 1, this.dataForm)
                  break
                }
              }
              this.dialogFormVisible = false
              this.$notify.success({
                title: '成功',
                message: '更新商铺成功'
              })
            })
            .catch(response => {
              this.$notify.error({
                title: '失败',
                message: response.data.errmsg
              })
            })
        }
      })
    },
    handleDelete(row) {
      deleteShop(row)
        .then(response => {
          this.$notify.success({
            title: '成功',
            message: '删除商铺成功'
          })
          const index = this.list.indexOf(row)
          this.list.splice(index, 1)
        })
        .catch(response => {
          this.$notify.error({
            title: '失败',
            message: response.data.errmsg
          })
        })
    },
    handleChangeStatus(row, status) {
      changeStatus({
        id: row.id,
        status
      }).then(response => {
        this.$notify.success({
          title: '成功',
          message: '处理成功'
        })
        this.getList()
      }).catch(response => {
        this.$notify.error({
          title: '失败',
          message: response.data.errmsg
        })
      })
    },
    handleDownload() {
      this.downloadLoading = true
      import('@/vendor/Export2Excel').then(excel => {
        const tHeader = ['商铺ID', '商铺名称', '所在国家', '所在省份', '所在城市', '所在区', '详细地址']
        const filterVal = ['id', 'name', 'country', 'province', 'city', 'district', 'address']
        excel.export_json_to_excel2(
          tHeader,
          this.list,
          filterVal,
          '商铺信息'
        )
        this.downloadLoading = false
      })
    }
  }
}
</script>
