<style>
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
                        <i-sider hide-trigger :style="{background: '#fff'}">
                            <i-menu active-name="1-2" theme="light" width="auto" :open-names="['1']"
                                    @on-select="changeMenu">
                                <i-submenu name="1">
                                    <template slot="title">
                                        <Icon type="ios-navigate"></Icon>
                                        权限管理
                                    </template>
                                    <i-menu-item name="auth-user">用户管理</i-menu-item>
                                    <i-menu-item name="auth-group">分组管理</i-menu-item>
                                    <i-menu-item name="auth-rule">角色管理</i-menu-item>
                                </i-submenu>
                                <i-submenu name="2">
                                    <template slot="title">
                                        <Icon type="ios-keypad"></Icon>
                                        Item 2
                                    </template>
                                    <i-menu-item name="2-1">Option 1</i-menu-item>
                                    <i-menu-item name="2-2">Option 2</i-menu-item>
                                </i-submenu>
                                <i-submenu name="3">
                                    <template slot="title">
                                        <Icon type="ios-analytics"></Icon>
                                        Item 3
                                    </template>
                                    <i-menu-item name="3-1">Option 1</i-menu-item>
                                    <i-menu-item name="3-2">Option 2</i-menu-item>
                                </i-submenu>
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
        }
    }
</script>
