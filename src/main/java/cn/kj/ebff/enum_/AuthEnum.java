package cn.kj.ebff.enum_;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.enum_
 * User: 25414
 * Date: 2020/4/5
 * Time: 16:30
 * Description:登录认证枚举类
 */
public enum AuthEnum {
    SUCCESS(0, "登录成功！"),
    FAILED(-1, "登陆失败！"),
    UNKNOW_ACCOUNT(-2, "未知账户！"),
    INCORRECT_CREDENTIALS(-3,"密码不正确！"),
    WAIT_LOGIN(-4,"请登录！"),
    NO_AUTH(-5,"未授权！");

    private Integer code;
    private String msg;

    AuthEnum() {
    }

    AuthEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
