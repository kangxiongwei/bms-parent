#!/usr/bin/env bash

gradle clean build -x test --stacktrace -i
gradle deploy
java -jar build/target/bms-web-1.0.0.jar --spring.profiles.active=prod &

WAIT_SECONDS=50
k=1
TEST_URL="http://localhost:8088/check"
echo "检查服务是否启动......"
echo "休息10s,等待服务启动"
sleep 10

for k in $(seq 1 ${WAIT_SECONDS})
do
    sleep 1
    STATUS_CODE=`curl -o /dev/null -s -w %{http_code} ${TEST_URL}`
    if [ "$STATUS_CODE" = "200" ]; then
        echo "测试URL:$TEST_URL succeeded!"
        echo "响应CODE:$STATUS_CODE"
        exit 0;
    else
        echo "测试URL:$TEST_URL failed!"
        echo "响应CODE: $STATUS_CODE"
        echo "尝试第${k}次....."
    fi
    if [ ${k} -eq ${WAIT_SECONDS} ]; then
        echo "测试失败"
        echo "服务没有启动"
        exit -1
    fi
done