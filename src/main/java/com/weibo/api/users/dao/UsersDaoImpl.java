package com.weibo.api.users.dao;

import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.weibo.api.users.model.User;


public class UsersDaoImpl implements UsersDao {
    
    private UserMapper userMapper;
    
    public void init() {
        try {
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
            SqlSession sqlSession = sessionFactory.openSession(true);
            this.userMapper = sqlSession.getMapper(UserMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public boolean add(long id, String name, int age, String gender) {
        return userMapper.insert(id, name, age, gender);
    }

    @Override
    public boolean delete(long id) {
        return userMapper.delete(id);
    }

    @Override
    public boolean update(long id, String name, int age, String gender) {
        return userMapper.update(id, name, age, gender);
    }

    @Override
    public User show(long id) {
        return userMapper.select(id);
    }

}
