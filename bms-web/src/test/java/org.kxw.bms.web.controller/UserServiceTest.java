package org.kxw.bms.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kxw.bms.auth.service.IAuthUserService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by kangxiongwei on 2018/8/11 下午2:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    private IAuthUserService authUserService;

    @Test
    public void testList() {
        List list = this.authUserService.listAuthUsers();
        System.out.println(list.size());
    }

}
