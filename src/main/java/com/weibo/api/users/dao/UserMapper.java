package com.weibo.api.users.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.weibo.api.users.model.User;

public interface UserMapper {

    @Insert("insert into users.207617 (id, name, age, gender) VALUES (#{id}, #{name}, #{age}, #{gender})")
    boolean insert(@Param("id")long id, @Param("name")String name,  @Param("age")int age, @Param("gender")String gender);

    @Delete("delete from users.207617 where id=#{id}")
    boolean delete(long id);

    @Update("update users.207617 set name = #{name}, age = #{age}, gender = #{gender} where id = #{id}")
    boolean update(@Param("id")long id, @Param("name")String name, @Param("age")int age, @Param("gender")String gender);

    @Select("select * from users.207617 where id=#{id}")
    User select(long id);
}
