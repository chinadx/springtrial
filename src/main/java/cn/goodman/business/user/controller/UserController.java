package cn.goodman.business.user.controller;

import cn.goodman.business.user.service.UserService;
import cn.goodman.db.user.dto.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserInfo(@PathVariable int id) {
        User user = userService.getUserInfo(id);
        return user;
    }
}
