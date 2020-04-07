package cn.kj.ebff.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.domain
 * User: 25414
 * Date: 2020/4/5
 * Time: 13:38
 * Description:用户角色实体类
 */
@Data
@Accessors(chain = true)
public class UserWithRole {

    private Long id;

    private Long user_id;

    private Long role_id;

    private String user_name;

    private String role_name;

    private String password;

    private String phone;

    private String email;

    private String desc;
}
