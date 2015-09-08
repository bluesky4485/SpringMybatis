package com.kolehank.sme.service;

import com.github.pagehelper.PageHelper;
import com.kolehank.sme.mapper.DemoUserMapper;
import com.kolehank.sme.model.DemoUser;
import com.kolehank.sme.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huangke on 2015/9/7.
 */
@Service
public class DemoUserServiceImpl implements DemoUserService {
    @Autowired
    DemoUserMapper mapper;

    public int add(DemoUser user) {
        return mapper.insert(user);
    }

    public DemoUser getDemoUser(Long pKey) {
        return mapper.selectByPrimaryKey(pKey);
    }

    public User getUser(Long pKey) {
        return mapper.testUserOP(pKey);
    }

    public List<DemoUser> getPageList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<DemoUser> list = mapper.select(null);
        return list;
    }
}
