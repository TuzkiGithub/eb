package cn.kj.ebff.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.spring.ssm.util
 * User: 25414
 * Date: 2019/10/24
 * Time: 17:58
 * Description:返回结果处理类
 */

@Data
@Accessors(chain = true)
public class JSONResult<T> {
    private Integer code;
    private String msg;
    private T data;

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private JSONResult() {
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public static String returnJSONString(Integer code, String msg) throws JsonProcessingException {
        return objectMapper.writeValueAsString(new JSONResult<>().setMsg(msg).setCode(code));
    }

    public static <D> String returnJSONString(Integer code, String msg, D data) throws JsonProcessingException {
        return objectMapper.writeValueAsString(new JSONResult<D>().setMsg(msg).setCode(code).setData(data));
    }
}
