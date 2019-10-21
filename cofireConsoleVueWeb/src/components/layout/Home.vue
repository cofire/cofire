<template>
    <div class="wrapper">
        <v-head></v-head>
        <v-sidebar></v-sidebar>
        <div class="content-box" :class="{'content-collapse':collapse}">
            <v-tags></v-tags>
            <div class="content">
                <!-- <el-row class="crumbs">
                    <el-breadcrumb separator="/">
                        <el-breadcrumb-item>
                            <i class="el-icon-lx-calendar"></i>
                            {{ $t('common.route.R1') }}
                        </el-breadcrumb-item>
                        <el-breadcrumb-item>{{ $t('common.route.R12') }}</el-breadcrumb-item>
                    </el-breadcrumb>
                </el-row> -->
                <transition name="move" mode="out-in">
                    <keep-alive :include="tagsList">
                        <router-view></router-view>
                    </keep-alive>
                </transition>
            </div>
        </div>
    </div>
</template>

<script>
import vHead from "./Header.vue";
import vSidebar from "./Sidebar.vue";
import vTags from "./Tags.vue";
import bus from "../common/bus";
import {CurrentUserStore} from "../store/common/CurrentUserStore";

export default {
  data() {
    return {
      tagsList: [],
      menuList: CurrentUserStore.state.menuList,
      collapse: false
    };
  },
  components: {
    vHead,
    vSidebar,
    vTags
  },
  created() {
    bus.$on("collapse", msg => {
      this.collapse = msg;
    });

    // 只有在标签页列表里的页面才使用keep-alive，即关闭标签之后就不保存到内存中了。
    bus.$on("tags", msg => {
      let arr = [];
      for (let i = 0, len = msg.length; i < len; i++) {
        msg[i].name && arr.push(msg[i].name);
      }
      this.tagsList = arr;
    });
  },
  mounted() {
      var path = this.$route.fullPath;
      var pathLevel = [];
    //   console.log(this.menuList);
    //   this.menuList.forEach(menu => {
    //       pathLevel.push(menu);
    //       if(path == menu.index){

    //       }
    //   });
  },
};
</script>
