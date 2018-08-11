package org.kxw.bms.auth.service;

import org.kxw.bms.auth.view.AuthUserView;

import java.util.List;

/**
 * Create by kangxiongwei on 2018/8/11 下午12:10
 */
public interface IAuthUserService {

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    Long saveUser(AuthUserView user);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<AuthUserView> listAuthUsers();

}
