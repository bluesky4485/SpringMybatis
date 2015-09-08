package com.kolehank.sme.service;

import com.kolehank.sme.mapper.UserMapper;
import com.kolehank.sme.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by huangke on 2015/8/29.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper user;

    public User getByID(Long userID) {
        return user.selectByPrimaryKey(userID);
    }

    public int add(User u) {
        return user.insert(u);
    }

    @Transactional
    public void testTransaction(User user1, User user2) {
        int ret = user.insert(user1);
        System.out.println(ret);
        String at = null;
        at.charAt(0);

        user.insert(user2);
    }
}
