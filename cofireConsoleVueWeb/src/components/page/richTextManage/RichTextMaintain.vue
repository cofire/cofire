<template>
  <el-row>
    <el-row class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item>
          <i class="el-icon-lx-calendar"></i> {{ $t('common.route.R2') }}
        </el-breadcrumb-item>
        <el-breadcrumb-item> {{ $t('common.route.R23') }}</el-breadcrumb-item>
      </el-breadcrumb>
    </el-row>
    <el-row class="query-form">
      <el-form :inline="true" :model="queryRichText" ref="queryForm" >
          <el-form-item :label="$t('richText.label.abbreviation')" prop="abbreviation">
            <el-input :placeholder="$t('richText.label.abbreviation')" v-model="queryRichText.abbreviation"></el-input>
          </el-form-item>
   
      </el-form>
    </el-row>
    <el-row class="table-operations">
      <el-button type="primary" icon="el-icon-lx-search" @click="submitQuery">{{ this.$t('common.button.query')}}</el-button>
      <el-button type="primary" icon="el-icon-lx-attention" @click="detail">{{this.$t('common.button.detail')}}</el-button>
      <el-button type="primary" icon="el-icon-lx-roundadd" @click="add">{{ this.$t('common.button.add') }}</el-button>
      <el-button type="primary" icon="el-icon-lx-edit" @click="edit">{{ this.$t('common.button.edit') }}</el-button>
      <el-button type="primary" icon="el-icon-lx-delete" @click="deleteConfirm">{{this.$t('common.button.delete')}}</el-button>
      <el-button type="primary" icon="el-icon-lx-refresh" @click="reset('queryForm')">{{this.$t('common.button.reset')}}</el-button>
    </el-row>
    <el-row class="table-result">
      <el-table v-loading="loading" ref="tableData" border highlight-current-row :data="tableData" style="width: 100%"
                @current-change="handleCurrentChange" @row-dblclick="handleDblclick">
        <el-table-column type="index" :label="$t('common.label.index')" width="60"></el-table-column>
        <el-table-column property="groupId" :label="$t('richText.table.groupId')" width="120"></el-table-column>
        <el-table-column property="textId" :label="$t('richText.table.textId')" width="120"></el-table-column>
        <el-table-column property="abbreviation" :label="$t('richText.table.abbreviation')" width="120"></el-table-column>
        <el-table-column property="textCn" :label="$t('richText.table.textCn')" width="420" :show-overflow-tooltip="true"></el-table-column>
        <el-table-column property="textEn" :label="$t('richText.table.textEn')" width="420" :show-overflow-tooltip="true"></el-table-column>
      </el-table>
      <el-pagination background @size-change="handleSizeChange" @current-change="handlePageChange"
                     :current-page="queryRichText.page"
                     :page-sizes="pageSizes" :page-size="queryRichText.length"
                     layout="total, sizes, prev, pager, next, jumper" :total="total">
      </el-pagination>
    </el-row>
    <el-row>
      <el-dialog :title="title" :visible.sync="dialogVisible" width="80%" :close-on-click-modal="false">
        <el-form ref="editForm" :rules="rules" :model="richText" label-width="100px" :disabled="formDisabled">
          <el-form-item :label="$t('richText.table.groupId')" prop="groupId">
            <el-input v-model="richText.groupId" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="$t('richText.table.textId')" prop="textId">
            <el-input v-model="richText.textId" :disabled="disabled"></el-input>
          </el-form-item>
          <el-form-item :label="this.$t('richText.table.abbreviation')" prop="abbreviation">
            <el-input v-model="richText.abbreviation"></el-input>
          </el-form-item>
          <el-col :span="12">
            <el-form-item :label="$t('richText.table.textCn')" prop="textCn">
              <quill-editor ref="myTextEditor" v-model="richText.textCn" :config="editorOption"></quill-editor>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item :label="$t('richText.table.textEn')" prop="textEn">
              <quill-editor ref="myTextEditor" v-model="richText.textEn" :config="editorOption"></quill-editor>
            </el-form-item>
          </el-col>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">{{ $t('common.button.cancel') }}</el-button>
          <el-button type="primary" @click="save('editForm')" v-if="isNotDetail">{{ $t('common.button.confirm') }}</el-button>
        </span>
      </el-dialog>
    </el-row>
  </el-row>
</template>
<script>
  import {richTextModel} from '../../model/richText/richTextModel'
  import {pageSizes, pageSize} from '../../common/global'
  import {queryRichText, saveRichText, deleteRichText} from '../../../api/getData'
  import {copyObject} from '../../common/util'
  import { quillEditor } from "vue-quill-editor"; //引入vue-quill-editor富文本编辑器
  export default {
    name: 'RichTextMaintain',
    components: {
      quillEditor // 声明组件quillEditor
    },
    data () {
      return {
        queryRichText: new richTextModel(),
        richText: new richTextModel(),
        pageSizes: pageSizes,
        total: 0,
        tableData: [],
        dialogVisible: false,
        title: '',
        formDisabled: false,
        disabled: false,
        isNotDetail: true,
        editorOption: {}, //编辑器的配置
        loading: false,
        rules: {
          groupId: [
            {required: true, message: this.$t('richText.rules.groupIdRequired'), trigger: 'blur'},
            { max: 4, message: this.$t('richText.rules.groupIdLength'), trigger: 'blur' }
          ],
          textId: [
            {required: true, message: this.$t('richText.rules.textIdRequired'), trigger: 'blur'},
            { max: 32, message: this.$t('richText.rules.textIdLength'), trigger: 'blur' }
          ],
          abbreviation: [
            {required: true, message: this.$t('richText.rules.abbreviationRequired'), trigger: 'blur'},
            { max: 32, message: this.$t('richText.rules.abbreviationLength'), trigger: 'blur' }
          ]
        },
      }
    },
    mounted () {
      this.search()
    },
    methods: {
      submitQuery() {
        this.queryRichText.page = 1;
        this.search();
      },
      search () {
        this.loading = true;
        queryRichText(this.queryRichText).then(res => {
          if (res.success) {
            if (res.total > 0 && res.data.length == 0){
              this.queryRichText.page--;
              this.search()
            }else{
              this.total = res.total
              this.tableData = res.data
            }
          } else {
            this.$message.error(this.$t('common.code.' + res.code))
          }
          this.loading = false;
        })
      },
      reset (formName) {
        this.$refs[formName].resetFields()
      },
      handleSizeChange (val) {
        this.queryRichText.length = val
        this.search()
      },
      handlePageChange (val) {
        this.queryRichText.page = val
        this.search()
      },
      handleCurrentChange (val) {
        this.currentRow = val
      },
      handleDblclick(){
        this.edit()
      },
      detail(){
        if (this.currentRow == null || this.currentRow == undefined) {
          this.$message.warning(this.$t('richText.mes.pleSelDepart'))
          return
        }
        this.richText = copyObject(this.currentRow, this.richText)
        this.title = this.$t('richText.mes.detail')
        this.dialogVisible = true
        this.isNotDetail = false
        if (this.$refs['editForm'] != undefined) {
          this.$refs['editForm'].clearValidate()
        }
      },
      add () {
        this.richText = new richTextModel()
        this.richText.flag = 'add'
        this.title = this.$t('richText.mes.add')
        this.dialogVisible = true
        this.disabled = false
        this.isNotDetail = true
        if (this.$refs['editForm'] != undefined) {
          this.$refs['editForm'].clearValidate()
        }
      },
      edit () {
        if (this.currentRow == null || this.currentRow == undefined) {
          this.$message.warning(this.$t('richText.mes.pleSelDepart'))
          return
        }
        this.disabled = true
        this.richText = copyObject(this.currentRow, this.richText)
        this.richText.flag = 'mod'
        this.title = this.$t('richText.mes.edit')
        this.dialogVisible = true
        this.isNotDetail = true
        if (this.$refs['editForm'] != undefined) {
          this.$refs['editForm'].clearValidate()
        }
      },
      save (formName) {
        this.$refs[formName].validate(valid => {
          if (valid) {
            saveRichText(this.richText).then(res => {
              if (res.success) {
                this.dialogVisible = false
                this.$message.success(this.$t('common.code.' + res.code))
                this.search()
              } else {
                this.$message.error(this.$t('common.code.' + res.code))
              }
            })
          }
        })
      },
      deleteConfirm () {
        if (this.currentRow == null || this.currentRow == undefined) {
          this.$message.warning(this.$t('richText.mes.pleSelDepart'))
          return
        }
        this.$confirm(this.$t('richText.mes.isDelDepart'), this.$t('richText.mes.tip'), {
          confirmButtonText: this.$t('common.button.confirm'),
          cancelButtonText: this.$t('common.button.cancel'),
          type: 'warning'
        }).then(() => {
          this.richText = copyObject(this.currentRow, this.richText)
          deleteRichText(this.richText).then(res => {
            if (res.success) {
              this.$message.success(this.$t('common.code.' + res.code))
              this.search()
            } else {
              this.$message.error(this.$t('common.code.' + res.code))
            }
          })
        }).catch(() => {
          this.$message.info(this.$t('richText.mes.cancelDel'))
        })
      }
    }
  }
</script>

