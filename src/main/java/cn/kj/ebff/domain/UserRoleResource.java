package cn.kj.ebff.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.domain
 * User: 25414
 * Date: 2020/4/5
 * Time: 16:12
 * Description:shiro认证后返回给前端的实体
 */
@Data
@Accessors(chain = true)
public class UserRoleResource {
    private Long userId;
    private String username;
    private Set<String> role;
    private TreeSet<String> resource;
}
