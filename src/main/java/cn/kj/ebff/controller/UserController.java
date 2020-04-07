package cn.kj.ebff.controller;

import cn.kj.ebff.domain.User;
import cn.kj.ebff.enum_.ResultEnum;
import cn.kj.ebff.service.UserService;
import cn.kj.ebff.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.controller
 * User: 25414
 * Date: 2020/4/4
 * Time: 11:18
 * Description:
 */
@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 查询用户列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUserList() throws Exception {
        return JSONResult.returnJSONString(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), userService.SelectUserList());
    }


    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String SelectUserByName(String username) throws Exception{
        User user = userService.SelectUserByName(username);
        if(null == user){
            return JSONResult.returnJSONString(ResultEnum.FAILED.getCode(), ResultEnum.FAILED.getMsg());
        }
        return JSONResult.returnJSONString(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), userService.SelectUserByName(username));
    }

    /**
     * 根据Id查询用户详细信息
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public String SelectUserDetail(@PathVariable("userId") Long userId) throws Exception{
        User user = userService.SelectUserById(userId);
        if(null == user){
            return JSONResult.returnJSONString(ResultEnum.FAILED.getCode(), ResultEnum.FAILED.getMsg());
        }
        return JSONResult.returnJSONString(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), userService.SelectUserById(userId));
    }
    /**
     * 添加用户
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(User user) throws Exception {
        userService.saveUser(user);
        return JSONResult.returnJSONString(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg());
    }

    /**
     * 修改用户
     * @param user
     * PS user信息必须携带Id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(User user) throws Exception {
        userService.updateUser(user);
        return JSONResult.returnJSONString(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg());
    }

    /**
     * 根据用户Id删除用户
     * @param userId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String delete(Long userId) throws Exception {
        userService.deleteUser(userId);
        return JSONResult.returnJSONString(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg());
    }
}
