#!/usr/bin/env bash

gradle clean build -x test --stacktrace -i
gradle deploy
java -jar build/target/bms-web-1.0.0.jar --spring.profiles.active=prod

echo "检查服务是否启动成功"
curl -o /dev/null -s -w %{http_code} 'http://localhost:8088/check'