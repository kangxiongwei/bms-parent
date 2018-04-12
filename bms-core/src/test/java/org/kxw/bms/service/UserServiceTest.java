package org.kxw.bms.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kxw.bms.model.User;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Create by kangxiongwei on 2018/2/6 15:13.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:bms-core.xml")
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setNickname("超级管理员");
        user.setEmail("kangxiongwei@163.com");
        user.setPhone("18810632665");
        Long userId = this.userService.addUser(user);
        System.out.println(userId);
    }

    @Test
    public void testLoginUser() {
        User user = this.userService.login("admin", "admin");
        System.out.println(user);
    }

}
