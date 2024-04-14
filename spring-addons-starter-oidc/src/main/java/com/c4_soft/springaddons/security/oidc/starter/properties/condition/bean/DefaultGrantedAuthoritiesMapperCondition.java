package com.c4_soft.springaddons.security.oidc.starter.properties.condition.bean;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Conditional;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;

import com.c4_soft.springaddons.security.oidc.starter.properties.condition.configuration.IsClientWithLoginCondition;

/**
 * 默认的授权转换条件
 *
 * @author luoyingxiong
 */
public class DefaultGrantedAuthoritiesMapperCondition extends AllNestedConditions {

    DefaultGrantedAuthoritiesMapperCondition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    /**
     * 开启 OIDC客户端（前提为：具有登录条件的客户端）
     */
    @Conditional(IsClientWithLoginCondition.class)
    static class SpringAddonsOidcClientEnabled {
    }

    /**
     * 未支持自定义授权映射
     */
    @ConditionalOnMissingBean(GrantedAuthoritiesMapper.class)
    static class CustomGrantedAuthoritiesMapperNotProvided {
    }
}