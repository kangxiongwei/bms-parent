package org.kxw.bms.web.controller.auth;

import org.kxw.bms.auth.service.IAuthUserService;
import org.kxw.bms.auth.view.AuthUserView;
import org.kxw.bms.web.annotation.RestfulApi;
import org.kxw.bms.web.model.HttpBaseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by kangxiongwei on 2018/8/11 下午12:52
 */
@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @Resource
    private IAuthUserService authUserService;

    /**
     * 增加用户接口
     *
     * @return
     */
    @RestfulApi
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public HttpBaseResult saveUser(@RequestBody AuthUserView user) {
        Long id = this.authUserService.saveUser(user);
        return HttpBaseResult.buildSuccess(id);
    }

    /**
     * 获取用户列表接口
     *
     * @return
     */
    @RestfulApi
    @RequestMapping("/user/list")
    public HttpBaseResult listAuthUsers() {
        List<AuthUserView> list = this.authUserService.listAuthUsers();
        return HttpBaseResult.buildSuccess(list);
    }

}
