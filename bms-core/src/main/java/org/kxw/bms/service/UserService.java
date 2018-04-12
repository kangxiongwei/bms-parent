package org.kxw.bms.service;

import org.kxw.bms.commons.util.SecurityUtil;
import org.kxw.bms.dao.IUserDao;
import org.kxw.bms.entity.UserDO;
import org.kxw.bms.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Create by kangxiongwei on 2018/2/6 14:49.
 */
@Service
public class UserService {

    @Resource
    private IUserDao userDao;

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    public Long addUser(User user) {
        UserDO entity = new UserDO();
        BeanUtils.copyProperties(user, entity);
        entity.setPassword(SecurityUtil.md5(user.getUsername(), user.getPassword()));
        entity.setStatus(1);
        entity.setCreateTime(new Date());
        return userDao.addUser(entity);
    }

    /**
     * 用户登陆
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        String pwd = SecurityUtil.md5(username, password);
        UserDO entity = this.userDao.getUser(username, pwd);
        if (entity == null) return null;
        User user = new User();
        BeanUtils.copyProperties(entity, user);
        return user;
    }

}
