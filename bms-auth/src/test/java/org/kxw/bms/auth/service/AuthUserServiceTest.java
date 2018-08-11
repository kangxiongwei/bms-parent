package org.kxw.bms.auth.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kxw.bms.auth.view.AuthUserView;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by kangxiongwei on 2018/8/11 下午12:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthUserServiceTest {

    @Resource
    private IAuthUserService authUserService;

    @Test
    public void testSaveUser() {
        AuthUserView view = new AuthUserView();
        view.setUsername("kangxiongwei");
        view.setPassword("kxw672015");
        view.setNickname("亢雄伟");
        view.setMobile("18810632665");
        view.setEmail("kangxiongwei@163.com");
        view.setHeadImg("https://raw.githubusercontent.com/iview/iview/master/assets/logo.png");
        Long id = authUserService.saveUser(view);
        System.out.println("添加成功，用户ID为" + id);
    }

    @Test
    public void testListUsers() {
        List<AuthUserView> list = this.authUserService.listAuthUsers();
        list.forEach(System.out::println);
    }


}
