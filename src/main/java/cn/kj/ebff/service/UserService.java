package cn.kj.ebff.service;

import cn.kj.ebff.domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.service
 * User: 25414
 * Date: 2020/4/4
 * Time: 11:07
 * Description:
 */
public interface UserService {
    /**
     * 根据用户名查询用户信息
     *
     * @return
     */
    User SelectUserByName(String username);

    /**
     * 根据ID查询用户信息
     *
     * @return
     */
    User SelectUserById(Long userId);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> SelectUserList();


    /**
     * 添加用户
     *
     */
    void saveUser(User user) throws Exception;


    /**
     * 修改用户
     *
     */
    void updateUser(User user);


    /**
     * 根据用户Id删除用户
     *
     */
    void deleteUser(Long userId);
}
