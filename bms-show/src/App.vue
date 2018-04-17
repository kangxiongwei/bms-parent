<template>
    <div id="app">
        <el-container style="border: 1px solid #eee">
            <el-header style="text-align: left; font-size: 12px">
                <div style="height: 60px; font-family: 'Microsoft YaHei'; font-size: 20px; font-weight: bold;">
                    <i class="el-icon-time" style="width: 30px"></i>BMS后台管理系统
                </div>
            </el-header>
            <el-container>
                <el-aside width="200px">
                    <el-menu :default-active="defaultActive"
                             router>
                        <el-submenu index="1">
                            <template slot="title">
                                <i class="el-icon-message"></i>
                                <span>权限管理</span>
                            </template>
                            <el-menu-item index="1-1">用户管理</el-menu-item>
                            <el-menu-item index="1-2">角色管理</el-menu-item>
                            <el-menu-item index="1-3">分组管理</el-menu-item>
                            <el-menu-item index="1-4">菜单管理</el-menu-item>
                        </el-submenu>
                        <el-submenu index="2">
                            <template slot="title">
                                <i class="el-icon-menu"></i>
                                <span>订单管理</span>
                            </template>
                            <el-menu-item index="2-1">商品管理</el-menu-item>
                            <el-menu-item index="2-2">订单查询</el-menu-item>
                        </el-submenu>
                        <el-submenu index="3">
                            <template slot="title">
                                <i class="el-icon-menu"></i>
                                <span>统计报表</span>
                            </template>
                            <el-menu-item index="3-1">用户统计</el-menu-item>
                            <el-menu-item index="3-2">角色统计</el-menu-item>
                            <el-menu-item index="3-3">分组统计</el-menu-item>
                            <el-menu-item index="3-4">菜单统计</el-menu-item>
                        </el-submenu>
                    </el-menu>
                </el-aside>
                <el-main>
                    <router-view></router-view>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
    export default {
        name: 'App',
        computed: {
            defaultActive: function () {
                return this.$route.path.replace('/', '');
            }
        }
    }
</script>

<style>
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
    }

    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height: 60px;
    }

</style>
