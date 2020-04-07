package cn.kj.ebff;


import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Package: cn.kj.ebff
 * User: 25414
 * Date: 2020/4/6
 * Time: 9:04
 * Description:
 */
public class Test {
    public static void main(String[] args) {
        String shiro_filter = "/login|anno,/user/*|perms[user:*],/admin/*|perms[admin:*],/**|authc";
        String[] filters = shiro_filter.split(",");
        Map<String, String> filterMap = null;
        if (!StringUtils.isEmpty(filters)) {
            filterMap = new LinkedHashMap<>();
            for (String var : filters) {
                String[] filter = var.split("\\|");
                filterMap.put(filter[0], filter[1]);
            }
        }

        System.out.println(filterMap);
    }
}
