package com.weibo.api.users.dao;

import com.weibo.api.users.model.User;

public interface UsersDao {

    boolean add(long id, String name, int age, String gender);
    
    boolean delete(long id);
    
    boolean update(long id, String name, int age, String gender);
    
    User show(long id);
    
}
