package org.kxw.bms.auth.converter;

import org.kxw.bms.auth.entity.AuthUserEntity;
import org.kxw.bms.auth.view.AuthUserView;
import org.kxw.bms.commons.util.DateUtil;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * Create by kangxiongwei on 2018/8/11 下午12:12
 */
public class AuthUserConverter {


    public static AuthUserEntity convertToEntity(AuthUserView view) {
        if (view == null) return null;
        AuthUserEntity entity = new AuthUserEntity();
        entity.setId(view.getId());
        entity.setUsername(view.getUsername());
        entity.setNickname(view.getNickname());
        entity.setPassword(view.getPassword());
        entity.setMobile(view.getMobile());
        entity.setEmail(view.getEmail());
        entity.setHeadImg(view.getHeadImg());
        entity.setCreateTime(StringUtils.isEmpty(view.getCreateTime())
                ? new Date()
                : DateUtil.stringToDate(view.getCreateTime()));
        entity.setUpdateTime(new Date());
        return entity;
    }

    public static AuthUserView covertToView(AuthUserEntity entity) {
        if (entity == null) return null;
        AuthUserView view = new AuthUserView();
        view.setId(entity.getId());
        view.setUsername(entity.getUsername());
        view.setNickname(entity.getNickname());
        view.setPassword(entity.getPassword());
        view.setMobile(entity.getMobile());
        view.setEmail(entity.getEmail());
        view.setHeadImg(entity.getHeadImg());
        view.setCreateTime(DateUtil.dateToString(entity.getCreateTime()));
        view.setUpdateTime(DateUtil.dateToString(entity.getUpdateTime()));
        return view;
    }


}
