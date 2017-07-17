# 分布式缓存架构基础

* clone作业工程

	```bash
git clone http://git.intra.weibo.com/bootcamp2017/distributed-cache.git
```

* 资源地址

	```bash
mysql：
10.75.0.119:3306
用户名：root 密码：root
memcached：
10.75.0.118:11211
10.75.0.118:11311
10.75.0.118:11411
10.75.0.118:11511
```

* 数据库建表

	```bash
登录mysql，使用users数据库，建立以工号为名字的表
use users;
create table `你的工号` (
`id` bigint not null,
`name` varchar(32) not null,
`age` int not null,
`gender` varchar(10) not null,
primary key (`id`)
);
```

* 进入工程目录, 建立新分支, **分支名必须为邮箱前缀**, **补全代码**并提交

	```bash
cd distributed-cache
git checkout -b 邮箱前缀
# 补全代码
git add .
git commit -m "xxxx"
git push -u origin 分支名称
```

* 根据课上所讲缓存相关知识及作业要求，补全`com/weibo/api/users/controller/Users.java`中的代码空行
    
	```java
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
```
    
* 尝试本地运行代码，并调用接口，验证Cache-DB的逻辑
    
* review代码, 并push到远程仓库
