package cn.kj.ebff.service.Impl;

import cn.kj.ebff.domain.User;
import cn.kj.ebff.mapper.UserMapper;
import cn.kj.ebff.service.UserService;
import cn.kj.ebff.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.service
 * User: 25414
 * Date: 2020/4/4
 * Time: 11:08
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return
     */
    @Override
    public User SelectUserByName(String username) {
        User record = new User()
                .setName(username);
        return userMapper.selectOne(record);
    }

    /**
     * 根据ID查询用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public User SelectUserById(Long userId) {
        User record = new User()
                .setId(userId);
        return userMapper.selectOne(record);
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> SelectUserList() {
        return userMapper.selectAll();
    }

    /**
     * 添加用户
     *
     * @param user
     */
    @Override
    public void saveUser(User user) throws Exception {
        user.setPassword(MD5Utils.encode(user.getPassword()));
        userMapper.insert(user);
    }

    /**
     * 修改用户
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 根据用户Id删除用户
     *
     * @param userId
     */
    @Override
    public void deleteUser(Long userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

}
