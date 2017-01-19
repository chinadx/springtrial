package cn.goodman.business.user.controller;

import cn.goodman.business.user.service.UserService;
import cn.goodman.db.user.dto.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Shaun on 2017/1/18.
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    private Log logger = LogFactory.getLog(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 列出所有用户信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = userService.getAllUsers();
        return users;
    }

    /**
     * 根据ID查找用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserInfo(@PathVariable int id) {
        User user = userService.getUserInfo(id);
        return user;
    }

    /**
     * 增加一个用户
     * @param record json格式形如 {"name":"黄鹤大舅","age":85,"password":"123456"}
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User setUserInfo(@RequestBody User record) {
        userService.addUser(record);
        return record;
    }
}
