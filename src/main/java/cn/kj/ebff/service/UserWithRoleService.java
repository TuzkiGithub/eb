package cn.kj.ebff.service;

import cn.kj.ebff.domain.UserWithRole;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.service
 * User: 25414
 * Date: 2020/4/5
 * Time: 14:09
 * Description:
 */
public interface UserWithRoleService {

    /**
     * 根据用户ID查询角色
     * @param userId
     * @return
     */
    List<UserWithRole> findRoleByUserId(Long userId);
}
