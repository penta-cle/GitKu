package com.pentacle.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean (3.)
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加Shiro 的内置过滤器
        /*
        * anon: 无需认证就可以访问
        * authc：必须认证了才能访问
        * user：必须拥有 记住我 功能才能访问
        * perms：拥有对某个资源的权限才能访问
        * role: 拥有某个角色权限才能访问
        * */
        Map<String,String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/user/add","authc");
//        filterMap.put("/user/update","authc");
        filterMap.put("/user/*","authc");
        bean.setFilterChainDefinitionMap(filterMap);
        bean.setLoginUrl("/toLogin"); //定义跳转的登录页面
        return bean;
    }

    //DafaultWebSecurityManager (2.) @Qualifier spring 自动装载时 指定指定名称，防止方法名重复报错 https://zhuanlan.zhihu.com/p/100371910?from_voters_page=true
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager GetDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建 realm 对象，需要自定义类 (1.)
    @Bean(name = "userRealm")
    public UserRealm userRealm() {
        return new UserRealm();
    }
}
