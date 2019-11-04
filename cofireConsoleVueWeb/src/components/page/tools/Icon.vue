<template>
  <div>
    <div class="container">
      <h2>使用方法</h2>
      <p style="line-height: 50px;">直接通过设置类名为 el-icon-lx-iconName 来使用即可。例如：（共{{iconList.length}}个图标）</p>
      <p class="example-p">
        <i class="el-icon-lx-redpacket_fill" style="font-size: 30px;color: #ff5900"></i>
        <span>&lt;i class=&quot;el-icon-lx-redpacket_fill&quot;&gt;&lt;/i&gt;</span>
      </p>
      <p class="example-p">
        <i class="el-icon-lx-weibo" style="font-size: 30px;color:#fd5656"></i>
        <span>&lt;i class=&quot;el-icon-lx-weibo&quot;&gt;&lt;/i&gt;</span>
      </p>
      <p class="example-p">
        <i class="el-icon-lx-emojifill" style="font-size: 30px;color: #ffc300"></i>
        <span>&lt;i class=&quot;el-icon-lx-emojifill&quot;&gt;&lt;/i&gt;</span>
      </p>
      <br>
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
export default {
  name: "Icon",
  data: function() {
    return {
      keyword: "",
      iconList: [
        "el-icon-ice-cream-round",
        "el-icon-ice-cream-square",
        "el-icon-lollipop",
        "el-icon-potato-strips",
        "el-icon-milk-tea",
        "el-icon-ice-drink",
        "el-icon-ice-tea",
        "el-icon-coffee",
        "el-icon-orange",
        "el-icon-pear",
        "el-icon-apple",
        "el-icon-cherry",
        "el-icon-watermelon",
        "el-icon-grape",
        "el-icon-refrigerator",
        "el-icon-goblet-square-full",
        "el-icon-goblet-square",
        "el-icon-goblet-full",
        "el-icon-goblet",
        "el-icon-cold-drink",
        "el-icon-coffee-cup",
        "el-icon-water-cup",
        "el-icon-hot-water",
        "el-icon-ice-cream",
        "el-icon-dessert",
        "el-icon-sugar",
        "el-icon-tableware",
        "el-icon-burger",
        "el-icon-knife-fork",
        "el-icon-fork-spoon",
        "el-icon-chicken",
        "el-icon-food",
        "el-icon-dish-1",
        "el-icon-dish",
        "el-icon-moon-night",
        "el-icon-moon",
        "el-icon-cloudy-and-sunny",
        "el-icon-partly-cloudy",
        "el-icon-cloudy",
        "el-icon-sunny",
        "el-icon-sunset",
        "el-icon-sunrise-1",
        "el-icon-sunrise",
        "el-icon-heavy-rain",
        "el-icon-lightning",
        "el-icon-light-rain",
        "el-icon-wind-power",
        "el-icon-baseball",
        "el-icon-soccer",
        "el-icon-football",
        "el-icon-basketball",
        "el-icon-ship",
        "el-icon-truck",
        "el-icon-bicycle",
        "el-icon-mobile-phone",
        "el-icon-service",
        "el-icon-key",
        "el-icon-unlock",
        "el-icon-lock",
        "el-icon-watch",
        "el-icon-watch-1",
        "el-icon-timer",
        "el-icon-alarm-clock",
        "el-icon-map-location",
        "el-icon-delete-location",
        "el-icon-add-location",
        "el-icon-location-information",
        "el-icon-location-outline",
        "el-icon-location",
        "el-icon-place",
        "el-icon-discover",
        "el-icon-first-aid-kit",
        "el-icon-trophy-1",
        "el-icon-trophy",
        "el-icon-medal",
        "el-icon-medal-1",
        "el-icon-stopwatch",
        "el-icon-mic",
        "el-icon-copy-document",
        "el-icon-full-screen",
        "el-icon-switch-button",
        "el-icon-aim",
        "el-icon-crop",
        "el-icon-odometer",
        "el-icon-time",
        "el-icon-bangzhu",
        "el-icon-close-notification",
        "el-icon-microphone",
        "el-icon-turn-off-microphone",
        "el-icon-position",
        "el-icon-postcard",
        "el-icon-message",
        "el-icon-chat-line-square",
        "el-icon-chat-dot-square",
        "el-icon-chat-dot-round",
        "el-icon-chat-square",
        "el-icon-chat-line-round",
        "el-icon-chat-round",
        "el-icon-set-up",
        "el-icon-turn-off",
        "el-icon-open",
        "el-icon-connection",
        "el-icon-link",
        "el-icon-cpu",
        "el-icon-thumb",
        "el-icon-female",
        "el-icon-male",
        "el-icon-guide",
        "el-icon-news",
        "el-icon-price-tag",
        "el-icon-discount",
        "el-icon-wallet",
        "el-icon-coin",
        "el-icon-money",
        "el-icon-bank-card",
        "el-icon-box",
        "el-icon-present",
        "el-icon-sell",
        "el-icon-sold-out",
        "el-icon-shopping-bag-2",
        "el-icon-shopping-bag-1",
        "el-icon-shopping-cart-2",
        "el-icon-shopping-cart-1",
        "el-icon-shopping-cart-full",
        "el-icon-smoking",
        "el-icon-no-smoking",
        "el-icon-house",
        "el-icon-table-lamp",
        "el-icon-school",
        "el-icon-office-building",
        "el-icon-toilet-paper",
        "el-icon-notebook-2",
        "el-icon-notebook-1",
        "el-icon-files",
        "el-icon-collection",
        "el-icon-receiving",
        "el-icon-suitcase-1",
        "el-icon-suitcase",
        "el-icon-film",
        "el-icon-collection-tag",
        "el-icon-data-analysis",
        "el-icon-pie-chart",
        "el-icon-data-board",
        "el-icon-data-line",
        "el-icon-reading",
        "el-icon-magic-stick",
        "el-icon-coordinate",
        "el-icon-mouse",
        "el-icon-brush",
        "el-icon-headset",
        "el-icon-umbrella",
        "el-icon-scissors",
        "el-icon-mobile",
        "el-icon-attract",
        "el-icon-monitor",
        "el-icon-search",
        "el-icon-takeaway-box",
        "el-icon-paperclip",
        "el-icon-printer",
        "el-icon-document-add",
        "el-icon-document",
        "el-icon-document-checked",
        "el-icon-document-copy",
        "el-icon-document-delete",
        "el-icon-document-remove",
        "el-icon-tickets",
        "el-icon-folder-checked",
        "el-icon-folder-delete",
        "el-icon-folder-remove",
        "el-icon-folder-add",
        "el-icon-folder-opened",
        "el-icon-folder",
        "el-icon-edit-outline",
        "el-icon-edit",
        "el-icon-date",
        "el-icon-c-scale-to-original",
        "el-icon-view",
        "el-icon-loading",
        "el-icon-rank",
        "el-icon-sort-down",
        "el-icon-sort-up",
        "el-icon-sort",
        "el-icon-finished",
        "el-icon-refresh-left",
        "el-icon-refresh-right",
        "el-icon-refresh",
        "el-icon-video-play",
        "el-icon-video-pause",
        "el-icon-d-arrow-right",
        "el-icon-d-arrow-left",
        "el-icon-arrow-up",
        "el-icon-arrow-down",
        "el-icon-arrow-right",
        "el-icon-arrow-left",
        "el-icon-top-right",
        "el-icon-top-left",
        "el-icon-top",
        "el-icon-bottom",
        "el-icon-right",
        "el-icon-back",
        "el-icon-bottom-right",
        "el-icon-bottom-left",
        "el-icon-caret-top",
        "el-icon-caret-bottom",
        "el-icon-caret-right",
        "el-icon-caret-left",
        "el-icon-d-caret",
        "el-icon-share",
        "el-icon-menu",
        "el-icon-s-grid",
        "el-icon-s-check",
        "el-icon-s-data",
        "el-icon-s-opportunity",
        "el-icon-s-custom",
        "el-icon-s-claim",
        "el-icon-s-finance",
        "el-icon-s-comment",
        "el-icon-s-flag",
        "el-icon-s-marketing",
        "el-icon-s-shop",
        "el-icon-s-open",
        "el-icon-s-management",
        "el-icon-s-ticket",
        "el-icon-s-release",
        "el-icon-s-home",
        "el-icon-s-promotion",
        "el-icon-s-operation",
        "el-icon-s-unfold",
        "el-icon-s-fold",
        "el-icon-s-platform",
        "el-icon-s-order",
        "el-icon-s-cooperation",
        "el-icon-bell",
        "el-icon-message-solid",
        "el-icon-video-camera",
        "el-icon-video-camera-solid",
        "el-icon-camera",
        "el-icon-camera-solid",
        "el-icon-download",
        "el-icon-upload2",
        "el-icon-upload",
        "el-icon-picture-outline-round",
        "el-icon-picture-outline",
        "el-icon-picture",
        "el-icon-close",
        "el-icon-check",
        "el-icon-plus",
        "el-icon-minus",
        "el-icon-help",
        "el-icon-s-help",
        "el-icon-circle-close",
        "el-icon-circle-check",
        "el-icon-circle-plus-outline",
        "el-icon-remove-outline",
        "el-icon-zoom-out",
        "el-icon-zoom-in",
        "el-icon-error",
        "el-icon-success",
        "el-icon-circle-plus",
        "el-icon-remove",
        "el-icon-info",
        "el-icon-question",
        "el-icon-warning-outline",
        "el-icon-warning",
        "el-icon-goods",
        "el-icon-s-goods",
        "el-icon-star-off",
        "el-icon-star-on",
        "el-icon-more-outline",
        "el-icon-more",
        "el-icon-phone-outline",
        "el-icon-phone",
        "el-icon-user",
        "el-icon-user-solid",
        "el-icon-setting",
        "el-icon-s-tools",
        "el-icon-delete",
        "el-icon-delete-solid",
        "el-icon-eleme",
        "el-icon-platform-eleme",
        "el-icon-loading"
      ]
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