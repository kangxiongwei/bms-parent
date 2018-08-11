package org.kxw.bms.auth.service.impl;

import org.kxw.bms.auth.converter.AuthUserConverter;
import org.kxw.bms.auth.dao.AuthUserDao;
import org.kxw.bms.auth.entity.AuthUserEntity;
import org.kxw.bms.auth.service.IAuthUserService;
import org.kxw.bms.auth.view.AuthUserView;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by kangxiongwei on 2018/8/11 下午12:09
 */
@Service
public class AuthUserService implements IAuthUserService {

    @Resource
    private AuthUserDao authUserDao;

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @Override
    public Long saveUser(AuthUserView user) {
        AuthUserEntity entity = AuthUserConverter.convertToEntity(user);
        return this.authUserDao.saveUser(entity);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<AuthUserView> listAuthUsers() {
        List<AuthUserEntity> entities = this.authUserDao.listAuthUsers();
        return CollectionUtils.isEmpty(entities)
                ? new ArrayList<>()
                : entities.stream().map(AuthUserConverter::covertToView).collect(Collectors.toList());
    }
}
