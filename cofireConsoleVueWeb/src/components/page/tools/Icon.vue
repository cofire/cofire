<template>
  <div>
    <div class="container">
      <h2>使用方法</h2>
      <p style="line-height: 50px;">直接通过设置类名为 el-icon-iconName 来使用即可。例如：（共{{iconList.length}}个图标）</p>
      <h2>图标</h2>
      <div class="search-box">
        <el-input class="search" size="large" v-model="keyword" clearable placeholder="请输入图标名称"></el-input>
      </div>
      <ul>
        <li class="icon-li" v-for="(item,index) in list" :key="index">
          <div class="icon-li-content">
            <i :class="item"></i>
            <span>{{item}}</span>
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import { IconList } from "../../data/IconList";
export default {
  name: "Icon",
  data: function() {
    return {
      keyword: "",
      iconList: IconList
    };
  },
  computed: {
    list() {
      return this.iconList.filter(item => {
        return item.indexOf(this.keyword) !== -1;
      });
    }
  }
};
</script>

<style scoped>
.example-p {
  height: 45px;
  display: flex;
  align-items: center;
}
.search-box {
  text-align: center;
  margin-top: 10px;
}
.search {
  width: 300px;
}
ul,
li {
  list-style: none;
}
.icon-li {
  display: inline-block;
  padding: 10px;
  width: 120px;
  height: 120px;
}
.icon-li-content {
  display: flex;
  height: 100%;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  cursor: pointer;
}
.icon-li-content i {
  font-size: 36px;
  color: #606266;
}
.icon-li-content span {
  margin-top: 10px;
  color: #787878;
}
</style>