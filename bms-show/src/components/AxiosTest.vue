<template>
    <div id="container">
        <el-button @click="getData" type="primary">切换</el-button>
        {{data}}
    </div>
</template>

<script>
    import axios from "axios"

    export default {
        data() {
            return {
                data: 'axios测试'
            }
        },
        methods: {
            getData() {
                console.log("点击事件");
                axios.jsonp("http://www.baidu.com", {}, {
                    headers: {},
                    emulateJSON: true
                }).then(response => {
                    this.data = response;
                });
                return res;
            }
        }
    };
</script>
