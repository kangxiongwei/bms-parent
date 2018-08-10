import routers from '../../router/router';

const app = {
    state: {
        routers: routers,
        //面包屑数组
        currentPath: [
            {
                path: '',
                name: '系统首页'
            }
        ],
        //菜单列表
        menuList: [],
        //登录用户
        loginUser: {
            userId: null,  //编号
            userName: '',  //姓名
            userEmail: '', //邮箱
            imgUrl: '', //头像地址
        }
    },
    //Vuex的钩子，必须通过这里来修改全局变量
    mutations: {
        //修改currentPath
        setCurrentPath(state, pathArr) {
            state.currentPath = pathArr;
        },
        //更新菜单列表
        setMenuList(state) {
            let menuList = [];
            routers.forEach(item => {
                if (item.children == null || item.children.length === 1) {
                    menuList.push(item);
                } else {
                    let len = menuList.push(item);
                    menuList[len - 1].children = item.children;
                }
            });
            state.menuList = menuList;
        },
        //设置登录用户
        setLoginUser(state, loginUser) {
            state.loginUser.userId = loginUser.id;
            state.loginUser.userName = loginUser.name;
            state.loginUser.userEmail = loginUser.email;
            state.loginUser.imgUrl = loginUser.imgUrl;
        }
    }
};

export default app;