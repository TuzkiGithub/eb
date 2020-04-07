package cn.kj.ebff.controller;

import cn.kj.ebff.enum_.AuthEnum;
import cn.kj.ebff.utils.JSONResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.controller
 * User: 25414
 * Date: 2020/4/4
 * Time: 9:48
 * Description:
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String defaultLogin() throws Exception {
        return JSONResult.returnJSONString(AuthEnum.WAIT_LOGIN.getCode(), AuthEnum.WAIT_LOGIN.getMsg());
    }

    @RequestMapping(value = "noAuth")
    public String noAuth() throws Exception {
        return JSONResult.returnJSONString(AuthEnum.NO_AUTH.getCode(), AuthEnum.NO_AUTH.getMsg());
    }

}
