package cn.goodman.business.user.service;

import cn.goodman.db.user.dao.UserMapper;
import cn.goodman.db.user.dto.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shaun on 2017/1/18.
 */
@Service
public class UserService {
    Log logger = LogFactory.getLog(UserService.class);

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 使用Cacheable表示启用缓存
     * 注意缓存的对象必须是字符串或可序列化的对象。以此为例User对象必须实现Serializable接口
     * @param id
     * @return
     */
    @Cacheable("user")
    public User getUserInfo(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }

    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }
}
