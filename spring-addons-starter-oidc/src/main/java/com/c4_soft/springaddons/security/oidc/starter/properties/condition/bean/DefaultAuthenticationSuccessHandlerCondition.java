package com.c4_soft.springaddons.security.oidc.starter.properties.condition.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.NoneNestedConditions;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;

/**
 * 默认的认证成功处理器的 条件
 *
 * @author luoyingxiong
 */
public class DefaultAuthenticationSuccessHandlerCondition extends NoneNestedConditions {

    public DefaultAuthenticationSuccessHandlerCondition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    /**
     * Servlet容器的认证成功处理器的 条件
     */
    @ConditionalOnBean(AuthenticationSuccessHandler.class)
    static class AuthenticationSuccessHandlerProvidedCondition {
    }

    /**
     * Reactive（Netty运行时）的认证成功处理器的 条件
     */
    @ConditionalOnBean(ServerAuthenticationSuccessHandler.class)
    static class ServerAuthenticationSuccessHandlerProvidedCondition {
    }
}
