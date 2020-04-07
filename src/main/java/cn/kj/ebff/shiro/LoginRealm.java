package cn.kj.ebff.shiro;

import cn.kj.ebff.domain.RoleWithResource;
import cn.kj.ebff.domain.User;
import cn.kj.ebff.domain.UserRoleResource;
import cn.kj.ebff.domain.UserWithRole;
import cn.kj.ebff.service.RoleWithResourceService;
import cn.kj.ebff.service.UserService;
import cn.kj.ebff.service.UserWithRoleService;
import cn.kj.ebff.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.shiro
 * User: 25414
 * Date: 2020/4/4
 * Time: 9:44
 * Description:
 */
@Slf4j
public class LoginRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;

    @Autowired
    private UserWithRoleService userWithRoleService;

    @Autowired
    private RoleWithResourceService roleWithResourceService;


    /**
     * 身份认证。即登录通过账号和密码验证登陆人的身份信息
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        log.debug("###Shiro身份认证###");
        String userName = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());

        User user = userService.SelectUserByName(userName);
        if (user == null) {
            return null;
        }

        String encyPassword = null;
        try {
            encyPassword = MD5Utils.encode(userPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assert encyPassword != null;
        token.setPassword(encyPassword.toCharArray());
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }


    /**
     * 权限认证，即登录过后，每个身份不一定，对应的所能看的页面也不一样
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        UserRoleResource userRoleResource = null;
        //根据用户信息查询用户角色
        List<UserWithRole> userWithRole = userWithRoleService.findRoleByUserId(user.getId());

        //根据角色查询权限
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        TreeSet<String> permsSet = new TreeSet<>();
        Set<String> roleSet = new HashSet<>();
        userWithRole.forEach(var1 -> {
            roleSet.add(var1.getRole_name());
            List<RoleWithResource> roleWithResourcesList = roleWithResourceService.findResourceByRole(var1.getRole_name());
            roleWithResourcesList.forEach(var2 -> {
                permsSet.add(var2.getPerms());
            });
        });
        info.setStringPermissions(permsSet);
        userRoleResource = new UserRoleResource();
        userRoleResource.setResource(permsSet)
                .setUserId(user.getId())
                .setUsername(user.getName())
                .setRole(roleSet);
        subject.getSession().setAttribute("userInfo", userRoleResource);
        return info;
    }


}
