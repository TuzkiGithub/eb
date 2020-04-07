package cn.kj.ebff.mapper;

import cn.kj.ebff.domain.UserWithRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.mapper
 * User: 25414
 * Date: 2020/4/5
 * Time: 13:57
 * Description:
 */
@Mapper
public interface UserWithRoleMapper {

    /**
     * 根据用户ID查询角色
     * @param userId
     * @return
     */
    List<UserWithRole> findRoleByUserId(Long userId);
}
