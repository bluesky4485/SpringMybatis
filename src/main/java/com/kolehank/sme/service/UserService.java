package com.kolehank.sme.service;

import com.kolehank.sme.model.User;

/**
 * Created by huangke on 2015/8/29.
 */
public interface UserService {
    public User getByID(Long userID);

    public int add(User u);
    public void testTransaction(User user1, User user2);
}
