const routers = [
    {
        path: '/',
        meta: {
            title: ''
        },
        component: (resolve) => require(['../views/index.vue'], resolve)
    },
    {
        path: '/home',
        component: (resolve) => require(['../views/layout/Layout.vue'], resolve)
    },
    {
        path: '/auth',
        component: (resolve) => require(['../views/layout/Layout.vue'], resolve),
        children: [
            {
                path: '/auth-user',
                component: (resolve) => require(['../views/auth/AuthUser.vue'], resolve)
            },
            {
                path: '/auth-group',
                component: (resolve) => require(['../views/auth/AuthGroup.vue'], resolve)
            },
            {
                path: '/auth-rule',
                component: (resolve) => require(['../views/auth/AuthRule.vue'], resolve)
            }
        ]
    }

];
export default routers;