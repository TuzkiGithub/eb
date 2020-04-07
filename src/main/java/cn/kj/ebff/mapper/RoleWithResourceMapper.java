package cn.kj.ebff.mapper;

import cn.kj.ebff.domain.RoleWithResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.mapper
 * User: 25414
 * Date: 2020/4/5
 * Time: 15:29
 * Description:
 */
@Mapper
public interface RoleWithResourceMapper {

    /**
     * 根据角色名查询资源
     * @param role
     * @return
     */
    List<RoleWithResource> findResourceByRole(String role);
}
