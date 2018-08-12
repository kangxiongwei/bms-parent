#!/usr/bin/env bash

gradle clean build -x test --stacktrace -i
gradle deploy
java -jar build/target/bms-web-1.0.0.jar