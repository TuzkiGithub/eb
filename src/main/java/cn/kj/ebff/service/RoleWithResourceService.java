package cn.kj.ebff.service;

import cn.kj.ebff.domain.RoleWithResource;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.service
 * User: 25414
 * Date: 2020/4/5
 * Time: 15:38
 * Description:
 */
public interface RoleWithResourceService {
    /**
     * 根据角色名查询资源
     * @param role
     * @return
     */
    List<RoleWithResource> findResourceByRole(String role);
}
