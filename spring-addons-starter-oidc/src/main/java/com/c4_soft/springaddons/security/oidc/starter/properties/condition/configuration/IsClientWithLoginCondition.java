package com.c4_soft.springaddons.security.oidc.starter.properties.condition.configuration;

import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * 是否为具有登录条件的客户端
 *
 * @author luoyingxiong
 */
public class IsClientWithLoginCondition extends AnyNestedCondition {

    public IsClientWithLoginCondition() {
        super(ConfigurationPhase.PARSE_CONFIGURATION);
    }

    /**
     * Value1
     * 当没有配置 com.c4-soft.springaddons.oidc.client.security-matchers时
     * 或者 com.c4-soft.springaddons.oidc.client.security-matchers的第一个参数值为空
     * <p>
     * T(...) 这种写法是 Spring 的 SpEL（Spring Expression Language）语法的一部分，因此它受 Spring 框架的支持。
     * 在 SpEL 中，T(...) 用于调用静态方法或访问静态字段。
     */
    @ConditionalOnExpression(
            "!(T(org.springframework.util.StringUtils).isEmpty('${com.c4-soft.springaddons.oidc.client.security-matchers:}') && T(org.springframework.util.StringUtils).isEmpty('${com.c4-soft.springaddons.oidc.client.security-matchers[0]:}'))"
    )
    static class Value1Condition {

    }

    /**
     * Value2
     * 读取 com.c4-soft.springaddons.oidc.client.security-matchers的第一个配置值
     */
    @ConditionalOnProperty(name = "com.c4-soft.springaddons.oidc.client.security-matchers[0]")
    static class Value2Condition {

    }

}