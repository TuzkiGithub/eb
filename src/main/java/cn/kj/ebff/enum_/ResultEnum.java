package cn.kj.ebff.enum_;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.spring.ssm.enum_
 * User: 25414
 * Date: 2019/9/18
 * Time: 8:57
 * Description:返回结果枚举类
 */
public enum ResultEnum {
    SUCCESS(0, "success"),
    FAILED(-1, "failed"),
    EXCEPTION(-2, "exception"),
    ROMETE_FAILED(-3,"remote_failed");

    private Integer code;
    private String msg;

    ResultEnum() {
    }

    ResultEnum(Integer code, String msg) {
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
