package com.c4_soft.springaddons.security.oidc.starter.properties.condition.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.NoneNestedConditions;

/**
 * 资源服务器 是否有JWT解析器 的条件
 */
public class IsJwtDecoderResourceServerCondition extends NoneNestedConditions {

    IsJwtDecoderResourceServerCondition() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    /**
     * 是否配置了 不透明令牌（Opaque Token）的内省端点（introspection endpoint）的URI
     */
    @ConditionalOnProperty("spring.security.oauth2.resourceserver.opaquetoken.introspection-uri")
    static class IsOpaqueTokenIntrospectionUriDeclared {
    }

}