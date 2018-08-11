package org.kxw.bms.auth.dao;

import org.apache.ibatis.annotations.Param;
import org.kxw.bms.auth.entity.AuthUserEntity;

import java.util.List;

/**
 * Create by kangxiongwei on 2018/8/11 上午11:23
 */
public interface AuthUserDao {

    Long saveUser(@Param("entity") AuthUserEntity user);

    List<AuthUserEntity> listAuthUsers();


}
