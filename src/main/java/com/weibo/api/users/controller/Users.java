package com.weibo.api.users.controller;

import cn.sina.api.commons.cache.driver.VikaCacheClient;
import cn.sina.api.commons.util.JsonBuilder;
import com.weibo.api.users.dao.UsersDao;
import com.weibo.api.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@RequestMapping("/users")
public class Users {

    @Autowired
    private VikaCacheClient usersCache;
    
    @Autowired
    private UsersDao usersDao;

    public void setUsersCache(VikaCacheClient usersCache) {
        this.usersCache = usersCache;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }
    
    @RequestMapping(value = "/add.json", method = RequestMethod.POST)
    @ResponseBody
    public String usersAdd(@RequestParam("id") long id,
                           @RequestParam("name") String name,
                           @RequestParam("age") int age,
                           @RequestParam("gender") String gender) {
        // TODO Auto-generated method stub
        if (usersShow(id) != null) {
            return "user already exits!";
        }
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setGander(gender);
        JsonBuilder jsonBuilder = new JsonBuilder();
        if (usersDao.add(id, name, age, gender) && usersCache.add(String.valueOf(id), user)) {
            jsonBuilder.append("uid", id)
                       .append("name", name)
                       .append("age", age)
                       .append("gender", gender);
        } else {
            jsonBuilder.append("error", "userAdd fail");
        }
        return jsonBuilder.flip().toString();
    }
    
    @RequestMapping(value = "/delete.json", method = RequestMethod.POST)
    @ResponseBody
    public String usersDelete(@RequestParam("id") long id) {
        // TODO Auto-generated method stub
        if (usersShow(id) == null) {
            return "user not exits!";
        }

        if (usersDao.delete(id) && usersCache.delete(String.valueOf(id))) {
            return "{*true}";
        }
        return "{*false}";
    }
    
    @RequestMapping(value = "/modify.json", method = RequestMethod.POST)
    @ResponseBody
    public String usersModify(@RequestParam("id") long id,
                              @RequestParam("name") String name, 
                              @RequestParam("age") int age,
                              @RequestParam("gender") String gender) {
        // TODO Auto-generated method stub
        if (usersShow(id) == null) {
            return "user not exits!";
        }
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setGander(gender);
        JsonBuilder jsonBuilder = new JsonBuilder();
        if (usersDao.update(id, name, age, gender) && usersCache.set(String.valueOf(String.valueOf(id)), user)) {
            jsonBuilder.append("uid", id)
                       .append("name", name)
                       .append("age", age)
                       .append("gender", gender);
        } else {
            jsonBuilder.append("error", "modify fail");
        }
        return jsonBuilder.flip().toString();
    }
    
    @RequestMapping(value = "/show.json", method = RequestMethod.GET)
    @ResponseBody
    public String usersShow(@RequestParam("id") long id) {
        // TODO Auto-generated method stub
        JsonBuilder jsonBuilder = new JsonBuilder();
        String userString = usersCache.get(String.valueOf("id")).toString();
        User user = null;
        if (userString == null) {
            user = usersDao.show(id);
            if (user == null) {
                return null;
            }
            usersCache.add(String.valueOf(id), user);
        } else {
            return userString;
        }

        jsonBuilder.append("uid", user.getId())
                    .append("name", user.getName())
                    .append("age", user.getAge())
                    .append("gender", user.getGender());
        return jsonBuilder.flip().toString();
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run("classpath:applicationContext.xml", args);
    }
}
