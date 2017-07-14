package com.weibo.api.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weibo.api.users.dao.UsersDao;

import cn.sina.api.commons.cache.driver.VikaCacheClient;

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
    public String usersAdd(@RequestParam("name") String name, 
                           @RequestParam("age") int age,
                           @RequestParam("gender") String gender) {
        // TODO Auto-generated method stub        
        return null;
    }
    
    @RequestMapping(value = "/delete.json", method = RequestMethod.POST)
    @ResponseBody
    public String usersDelete(@RequestParam("id") long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @RequestMapping(value = "/modify.json", method = RequestMethod.POST)
    @ResponseBody
    public String usersModify(@RequestParam("id") long id,
                              @RequestParam("name") String name, 
                              @RequestParam("age") int age,
                              @RequestParam("gender") String gender) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @RequestMapping(value = "/show.json", method = RequestMethod.GET)
    @ResponseBody
    public String usersShow(@RequestParam("id") long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run("classpath:applicationContext.xml", args);
    }
}
