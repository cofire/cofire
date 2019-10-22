<template>
    <div class="wrapper">
        <v-head></v-head>
        <v-sidebar></v-sidebar>
        <div class="content-box" :class="{'content-collapse':collapse}">
            <v-tags></v-tags>
            <div class="content">
                <el-row class="crumbs" v-if="pathNavFull.length > 0">
                    <el-breadcrumb separator="/">
                        <el-breadcrumb-item>
                            <i class="el-icon-lx-calendar"></i>
                            {{ $t('common.route.R' + parentPath.id) }}
                        </el-breadcrumb-item>
                        <el-breadcrumb-item
                            v-for="item in pathNav"
                            :key="item.id"
                        >{{ $t('common.route.R' + item.id) }}</el-breadcrumb-item>
                    </el-breadcrumb>
                </el-row>
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
import { CurrentUserStore } from "../store/common/CurrentUserStore";

export default {
  data() {
    return {
      tagsList: [],
      menuList: CurrentUserStore.state.menuList,
      collapse: false,
      pathNavFull: [],
      pathNav: [],
      parentPath: ""
    };
  },
  components: {
    vHead,
    vSidebar,
    vTags
  },
  methods: {
    getMenuParents(menuList, path) {
      var parents = [];
      menuList.some(menu => {
        if (path == menu.url) {
          parents.push(menu);
          return parents;
        }
        if (path != menu.url && menu.subMenu) {
          var subParents = this.getMenuParents(menu.subMenu, path);
          if (subParents.length > 0) {
            parents.push(menu);
            for (var i = 0; i < subParents.length; i++) {
              parents.push(subParents[i]);
            }
            return parents;
          }
        }
      });
      return parents;
    }
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
  watch: {
    $route(newValue, oldValue) {
      const path = newValue.fullPath;
      this.pathNavFull = this.getMenuParents(this.menuList, path);
      if (this.pathNavFull.length > 0) {
        this.parentPath = this.pathNavFull[0];
        this.pathNav = this.pathNavFull.slice(1);
      }
    }
  },
  mounted() {
    const path = this.$route.fullPath;
    this.pathNavFull = this.getMenuParents(this.menuList, path);
    console.log(this.pathNavFull)
    if (this.pathNavFull.length > 0) {
      this.parentPath = this.pathNavFull[0];
      this.pathNav = this.pathNavFull.slice(1);
    }
    console.log(this.pathNav);
  }
};
</script>
