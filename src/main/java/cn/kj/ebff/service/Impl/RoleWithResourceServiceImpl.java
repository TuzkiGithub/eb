package cn.kj.ebff.service.Impl;

import cn.kj.ebff.domain.RoleWithResource;
import cn.kj.ebff.mapper.RoleWithResourceMapper;
import cn.kj.ebff.service.RoleWithResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.service.Impl
 * User: 25414
 * Date: 2020/4/5
 * Time: 15:39
 * Description:
 */
@Service
public class RoleWithResourceServiceImpl implements RoleWithResourceService {

    @Autowired
    private RoleWithResourceMapper roleWithResourceMapper;
    /**
     * 根据角色名查询资源
     *
     * @param role
     * @return
     */
    @Override
    public List<RoleWithResource> findResourceByRole(String role) {
        return roleWithResourceMapper.findResourceByRole(role);
    }
}
