package cn.goodman.business.user.service;

import cn.goodman.db.user.dao.UserMapper;
import cn.goodman.db.user.dto.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shaun on 2017/1/18.
 */
@Service
public class UserService {
    Log logger = LogFactory.getLog(UserService.class);

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }
}
