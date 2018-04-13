import Vue from 'vue'
import Router from 'vue-router'
import UserList from '../components/UserList.vue'
import HelloWorld from '../components/HelloWorld.vue'

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/1-1',
            name: '用户管理',
            component: HelloWorld
        },
        {
            path: '/1-2',
            name: '主页',
            component: UserList
        }
    ]
})
