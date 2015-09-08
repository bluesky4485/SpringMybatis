package com.kolehank.sme.mapper;

import com.kolehank.sme.model.DemoUser;
import com.kolehank.sme.model.User;
import tk.mybatis.mapper.common.Mapper;

public interface DemoUserMapper extends Mapper<DemoUser> {
    public User testUserOP(Long id);

}