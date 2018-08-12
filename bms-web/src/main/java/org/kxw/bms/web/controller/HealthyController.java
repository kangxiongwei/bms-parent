package org.kxw.bms.web.controller;

import org.kxw.bms.web.model.HttpBaseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 检查服务是否健康的接口
 * Create by kangxiongwei on 2018/8/12 下午2:52
 */
@RestController
public class HealthyController {

    @RequestMapping("/check")
    public HttpBaseResult check() {
        return HttpBaseResult.buildSuccess("check success");
    }


}
