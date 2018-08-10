<style scoped>
    .layout {
        border: 1px solid #d7dde4;
        background: #f5f7f9;
        position: relative;
        border-radius: 4px;
        overflow: hidden;
        height: 100%;
    }

    .layout-logo {
        width: 30px;
        height: 30px;
        border-radius: 3px;
        float: left;
        position: relative;
        top: 15px;
        left: 20px;
    }

    .layout-footer-center {
        text-align: center;
    }

    .ivu-layout-footer {
        position: relative;
        margin-top: -70px;
    }

    .ivu-icon {
        width: 14px;
        height: 14px;
    }

</style>
<template>
    <div class="layout">
        <i-layout style="height: 100%">
            <i-header>
                <i-menu mode="horizontal" theme="dark" active-name="1">
                    <img class="layout-logo" src="https://raw.githubusercontent.com/iview/iview/master/assets/logo.png">
                    <p style="color: white; position: relative; left: 30px; float: left; font-size: 24px">BMS管理系统</p>
                </i-menu>
            </i-header>
            <i-layout :style="{padding: '0 50px', height: '100%'}">
                <i-breadcrumb :style="{margin: '16px 0'}">
                    <i-breadcrumb-item>Home</i-breadcrumb-item>
                    <i-breadcrumb-item>Components</i-breadcrumb-item>
                    <i-breadcrumb-item>Layout</i-breadcrumb-item>
                </i-breadcrumb>
                <i-content :style="{padding: '24px 0', minHeight: '100%', background: '#fff'}">
                    <i-layout :style="{height: '100%'}">
                        <!--侧边栏-->
                        <i-sider hide-trigger :style="{background: '#fff'}">
                            <!--所有菜单-->
                            <i-menu theme="light" width="auto" @on-select="changeMenu">
                                <template v-for="item in menuList">
                                    <!--有多个子菜单的菜单-->
                                    <i-submenu v-if="item.children != null && item.children.length > 0"
                                               :name="item.name" :key="item.name">
                                        <template slot="title">
                                            <i-icon v-if="item.icon != null" :type="item.icon"></i-icon>
                                            {{item.title}}
                                        </template>
                                        <i-menu-item v-for="sub in item.children" :name="sub.name">
                                            <i-icon v-if="sub.icon != null" :type="sub.icon"></i-icon>
                                            {{sub.title}}
                                        </i-menu-item>
                                    </i-submenu>
                                </template>
                            </i-menu>
                        </i-sider>
                        <i-content :style="{padding: '24px', minHeight: '100%', background: '#fff'}">
                            <router-view></router-view>
                        </i-content>
                    </i-layout>
                </i-content>
            </i-layout>
            <i-footer class="layout-footer-center">2011-2099 &copy; kangxiongwei@163.com</i-footer>
        </i-layout>
    </div>
</template>
<script>
    export default {
        data() {
            return {}
        },
        methods: {
            changeMenu(name) {
                this.$router.push(name);
            }
        },
        computed: {
            //从路由文件中获取菜单列表
            menuList() {
                return this.$store.state.app.menuList;
            }
        },
        created() {
            this.$store.commit('setMenuList'); //初始化菜单列表
        }
    }
</script>
