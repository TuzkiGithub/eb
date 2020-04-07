package cn.kj.ebff.service.Impl;

import cn.kj.ebff.domain.UserWithRole;
import cn.kj.ebff.mapper.UserWithRoleMapper;
import cn.kj.ebff.service.UserWithRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.service.Impl
 * User: 25414
 * Date: 2020/4/5
 * Time: 14:10
 * Description:
 */
@Service
public class UserWithRoleServiceImpl implements UserWithRoleService {

    @Autowired
    private UserWithRoleMapper userWithRoleMapper;
    /**
     * 根据用户ID查询角色
     *
     * @param userId
     * @return
     */
    @Override
    public List<UserWithRole> findRoleByUserId(Long userId) {
        return userWithRoleMapper.findRoleByUserId(userId);
    }
}
