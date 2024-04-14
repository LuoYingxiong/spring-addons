package com.c4_soft.springaddons.security.oidc.starter.properties.condition.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.NoneNestedConditions;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;

/**
 * 默认的 认证失败处理器条件
 *
 * @author luoyingxiong
 */
public class DefaultAuthenticationFailureHandlerCondition extends NoneNestedConditions {

    public DefaultAuthenticationFailureHandlerCondition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    /**
     * Servlet容器的 认证失败处理器保护条件
     */
    @ConditionalOnBean(AuthenticationFailureHandler.class)
    static class AuthenticationFailureHandlerProvidedCondition {
    }

    /**
     * Netty运行时的 认证失败处理器保护条件
     */
    @ConditionalOnBean(ServerAuthenticationFailureHandler.class)
    static class ServerAuthenticationFailureHandlerProvidedCondition {
    }

}
