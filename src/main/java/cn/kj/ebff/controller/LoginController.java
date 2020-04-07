package cn.kj.ebff.controller;

import cn.kj.ebff.enum_.AuthEnum;
import cn.kj.ebff.enum_.ResultEnum;
import cn.kj.ebff.utils.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.controller
 * User: 25414
 * Date: 2020/4/4
 * Time: 10:47
 * Description:
 */
@Slf4j
@RestController
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) throws Exception {
        log.info("username = {}, password = {}", username, password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
            return JSONResult.returnJSONString(ResultEnum.FAILED.getCode(), AuthEnum.UNKNOW_ACCOUNT.getMsg());
        } catch (IncorrectCredentialsException ice) {
            return JSONResult.returnJSONString(ResultEnum.FAILED.getCode(), AuthEnum.INCORRECT_CREDENTIALS.getMsg());
        }

        if (subject.isAuthenticated()) {
            //强制调用doGetAuthorizationInfo
            subject.hasRole("");
            return JSONResult.returnJSONString(AuthEnum.SUCCESS.getCode(), AuthEnum.SUCCESS.getMsg(), subject.getSession().getAttribute("userInfo"));
        } else {
            token.clear();
            return JSONResult.returnJSONString(ResultEnum.FAILED.getCode(), AuthEnum.FAILED.getMsg());
        }
    }

    /**
     * 登出并清空缓存
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() throws Exception {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return JSONResult.returnJSONString(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg());
    }
}
