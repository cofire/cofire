<template>
    <div class="sidebar">
        <el-menu class="sidebar-el-menu" :default-active="onRoutes" :collapse="collapse" background-color="#333333"
            text-color="#bfcbd9" active-text-color="#20a0ff" unique-opened router>
            <template v-for="item in menuList">
                <template v-if="item.subMenu">
                    <el-submenu :index="item.url" :key="item.url">
                        <template slot="title">
                            <i :class="item.icon"></i><span slot="title">{{ $t('common.route.R' + item.id) }}</span>
                        </template>
                        <template v-for="subItem in item.subMenu">
                            <el-submenu v-if="subItem.subMenu" :index="subItem.url" :key="subItem.url">
                                <template slot="title">{{ $t('common.route.R' + subItem.id) }}</template>
                                <el-menu-item v-for="(threeItem,i) in subItem.subMenu" :key="i" :index="threeItem.url">
                                    {{ $t('common.route.R' + threeItem.id) }}
                                </el-menu-item>
                            </el-submenu>
                            <el-menu-item v-else :index="subItem.url" :key="subItem.url">
                                {{$t('common.route.R' + subItem.id) }}
                            </el-menu-item>
                        </template>
                    </el-submenu>
                </template>
                <template v-else>
                    <el-menu-item :index="item.url" :key="item.url">
                        <i :class="item.icon"></i><span slot="title">{{ $t('common.route.R' + item.id) }}</span>
                    </el-menu-item>
                </template>
            </template>
        </el-menu>
    </div>
</template>

<script>
    import bus from '../common/bus';
    import {CurrentUserStore} from '../store/common/CurrentUserStore';
    export default {
        data() {
            return {
                collapse: false
            }
        },
        computed:{
            onRoutes(){
                return this.$route.path;
            },
            menuList(){
                let menuList = CurrentUserStore.state.menuList;
                return menuList;
            }
        },
        created(){
            // 通过 Event Bus 进行组件间通信，来折叠侧边栏
            bus.$on('collapse', msg => {
                this.collapse = msg;
            })
        }
    }
</script>

<style scoped>
    .sidebar{
        display: block;
        position: absolute;
        left: 0;
        top: 70px;
        bottom:0;
        overflow-y: scroll;
    }
    .sidebar::-webkit-scrollbar{
        width: 0;
    }
    .sidebar-el-menu:not(.el-menu--collapse){
        width: 250px;
    }
    .sidebar > ul {
        height:100%;
    }
</style>
