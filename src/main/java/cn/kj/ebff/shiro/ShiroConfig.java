package cn.kj.ebff.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff.shiro
 * User: 25414
 * Date: 2020/4/4
 * Time: 9:37
 * Description:shiro配置类
 */
@Configuration
public class ShiroConfig {


    @Value("${shiro.filter}")
    private String shiro_filter;

    /**
     * shiro过滤器，设置拦截
     *
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //设置拦截器
        /**
         * Shiro内置过滤器
         * anon:无需认证即可登录
         * authc:必须认证才可以登录
         * user:使用rememberMe功能可以直接访问
         * perms:该资源必须得到资源权限才可以访问
         * role:该资源必须得到角色权限才可以访问
         */
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        Map<String, String> filterMap = readFilter();
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;

    }

    /**
     * 安全管理器
     *
     * @param loginRealm
     * @return
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("customRealm") LoginRealm loginRealm) {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(loginRealm);
        return defaultSecurityManager;
    }

    @Bean
    public LoginRealm customRealm() {
        return new LoginRealm();
    }


    /**
     * 读取配置文件中的filter
     */
    private Map<String, String> readFilter() {
        String[] filters = shiro_filter.split(",");
        Map<String, String> filterMap = null;
        if (!StringUtils.isEmpty(filters)) {
            filterMap = new LinkedHashMap<>();
            for (String var : filters) {
                String[] filter = var.split("\\|");
                filterMap.put(filter[0], filter[1]);
            }
        }
        return filterMap;
    }
}
