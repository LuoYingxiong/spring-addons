package com.c4_soft.springaddons.security.oidc.starter.properties.condition.bean;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Conditional;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.authentication.ReactiveAuthenticationManagerResolver;

/**
 * 默认的认证管理解析条件
 *
 * @author luoyingxiong
 */
public class DefaultAuthenticationManagerResolverCondition extends AllNestedConditions {

    DefaultAuthenticationManagerResolverCondition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    /**
     * 资源服务器是否使用JWT形式的access token
     */
    @Conditional(IsJwtDecoderResourceServerCondition.class)
    static class IsJwtResourceServer {
    }

    /**
     * Servlet容器的 未提供自定义身份验证管理器解析程序 场景
     */
    @ConditionalOnMissingBean(AuthenticationManagerResolver.class)
    static class CustomAuthenticationManagerResolverNotProvided {
    }

    /**
     * Reactive（Netty运行时）的 未提供自定义身份验证管理器解析程序 场景
     */
    @ConditionalOnMissingBean(ReactiveAuthenticationManagerResolver.class)
    static class CustomReactiveAuthenticationManagerResolverNotProvided {
    }

}