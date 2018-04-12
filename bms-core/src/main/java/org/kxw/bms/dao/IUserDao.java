package org.kxw.bms.dao;

import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.ReturnGeneratedId;
import org.jfaster.mango.annotation.SQL;
import org.kxw.bms.entity.UserDO;
import org.springframework.stereotype.Repository;

/**
 * Create by kangxiongwei on 2018/2/5 21:18.
 */
@Repository
@DB(name = "bms", table = "t_user")
public interface IUserDao {

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    @ReturnGeneratedId
    @SQL("INSERT INTO #table (username, password, nickname, email, phone, status, create_time) VALUES" +
            " (:1.username, :1.password, :1.nickname, :1.email, :1.phone, :1.status, :1.createTime)")
    Long addUser(UserDO user);

    /**
     * 根据用户名和密码查询用户
     *
     * @param username
     * @param password
     * @return
     */
    @SQL("select * from #table where username = :1 and password = :2")
    UserDO getUser(String username, String password);
}
