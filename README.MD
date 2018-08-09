#一、后台管理系统

##环境搭建
```markdown
1.安装NodeJS,在MacOS中，使用pkg安装。NodeJS网站：https://nodejs.org/en/
2.安装angular-ui-grid，命令：npm install angular-ui-grid
```

##主要技术
```markdown
1.语言
java8，spring，spring-boot，vue，iViewUI
2.构建
gradle
3.数据库
mysql
4.缓存
redis
```

##目录结构
```markdown
.
├── README.MD
├── bms-auth                 权限控制模块
│   ├── README.MD
│   ├── build.gradle
│   └── src
├── bms-commons              通用模块
│   ├── build
│   ├── build.gradle
│   └── src
├── bms-core                 核心模块
│   ├── build
│   ├── build.gradle
│   ├── out
│   └── src
├── bms-order                订单模块
│   ├── build
│   └── build.gradle
├── bms-shiro                权限模块
│   ├── build
│   ├── build.gradle
│   └── src
├── bms-stat                 统计模块
│   ├── build
│   ├── build.gradle
│   ├── out
│   ├── src
│   └── target
├── bms-view                 视图模块 
│   ├── build.gradle
│   └── src
├── bms-web                  前后端交互
│   ├── build.gradle
│   └── src
├── build.gradle             父模块的gradle文件
└── settings.gradle          组织所有模块
```


