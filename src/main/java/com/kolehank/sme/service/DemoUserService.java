package com.kolehank.sme.service;


import com.kolehank.sme.model.DemoUser;
import com.kolehank.sme.model.User;

import java.util.List;

/**
 * Created by huangke on 2015/9/7.
 */
public interface DemoUserService {

    public int add(DemoUser user);

    public DemoUser getDemoUser(Long pKey);

    public User getUser(Long pKey);

    public List<DemoUser> getPageList(int pageNum, int pageSize);
}
