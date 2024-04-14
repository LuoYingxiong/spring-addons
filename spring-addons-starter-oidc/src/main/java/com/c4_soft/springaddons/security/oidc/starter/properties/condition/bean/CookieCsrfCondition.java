package com.c4_soft.springaddons.security.oidc.starter.properties.condition.bean;

import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * Cookie 防CSRF配置
 *
 * @author luoyingxiong
 */
public class CookieCsrfCondition extends AnyNestedCondition {

    public CookieCsrfCondition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    /**
     * 望文生义是 OAuth2.0客户端的防CSRF配置
     */
    @ConditionalOnProperty(name = "com.c4-soft.springaddons.oidc.client.csrf", havingValue = "cookie-accessible-from-js")
    static class ClientCookieAccessibleFromJsCondition {
    }

    /**
     * 望文生义是 OAuth2.0资源服务器的防CSRF配置
     */
    @ConditionalOnProperty(name = "com.c4-soft.springaddons.oidc.resourceserver.csrf", havingValue = "cookie-accessible-from-js")
    static class ResourceServerCookieAccessibleFromJsCondition {
    }

}