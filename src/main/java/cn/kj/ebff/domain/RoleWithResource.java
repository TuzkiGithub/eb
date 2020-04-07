package cn.kj.ebff.domain;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.domain
 * User: 25414
 * Date: 2020/4/5
 * Time: 15:20
 * Description:角色资源关系实体
 */
@Data
@Accessors(chain = true)
public class RoleWithResource {
    private Long id;

    private Long resource_id;

    private Long resource_pid;

    private Long role_id;

    private String resource_name;

    private String role_name;

    private String perms;

    private String resource_desc;

    private String role_desc;

}
