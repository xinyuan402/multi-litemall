package com.lcwork.multimall.core.config;

import com.lcwork.multimall.core.shiro.AdminAuthorizingRealm;
import com.lcwork.multimall.core.shiro.AdminWebSessionManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public static DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public Realm realm() {
        return new AdminAuthorizingRealm();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        filterChainDefinitionMap.put("/admin/auth/login", "anon");
        filterChainDefinitionMap.put("/admin/auth/401", "anon");
        filterChainDefinitionMap.put("/admin/auth/index", "anon");
        filterChainDefinitionMap.put("/admin/auth/403", "anon");
        filterChainDefinitionMap.put("/admin/index/index", "anon");
        filterChainDefinitionMap.put("/admin/**", "authc");

        filterChainDefinitionMap.put("/sysadmin/auth/login", "anon");
        filterChainDefinitionMap.put("/sysadmin/auth/401", "anon");
        filterChainDefinitionMap.put("/sysadmin/auth/index", "anon");
        filterChainDefinitionMap.put("/sysadmin/auth/403", "anon");
        filterChainDefinitionMap.put("/sysadmin/index/index", "anon");
        filterChainDefinitionMap.put("/sysadmin/**", "authc");

        shiroFilterFactoryBean.setLoginUrl("/admin/auth/401");
        shiroFilterFactoryBean.setSuccessUrl("/admin/auth/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/admin/auth/403");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SessionManager sessionManager() {

        return new AdminWebSessionManager();
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm());
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor =
                new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
