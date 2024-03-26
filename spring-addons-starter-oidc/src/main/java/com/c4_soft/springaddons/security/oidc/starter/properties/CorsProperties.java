package com.c4_soft.springaddons.security.oidc.starter.properties;

import java.util.List;

import lombok.Data;

@Data
public class CorsProperties {
    /**
     * 路径匹配器，该配置项适用于哪些路径
     */
    private String path = "/**";

    /**
     * 是否允许携带凭证，默认为 null
     */
    private Boolean allowCredentials = null;

    /**
     * 允许的源地址模式列表，默认为 "*"，表示允许所有来源
     */
    private List<String> allowedOriginPatterns = List.of("*");

    /**
     * 允许的请求方法列表，默认为 "*"，表示允许所有方法
     */
    private List<String> allowedMethods = List.of("*");

    /**
     * 允许的请求头列表，默认为 "*"，表示允许所有头部信息
     */
    private List<String> allowedHeaders = List.of("*");

    /**
     * 暴露的响应头列表，默认为 "*"，表示暴露所有响应头
     */
    private List<String> exposedHeaders = List.of("*");

    /**
     * 最大缓存时间，单位为秒，默认为 null
     */
    private Long maxAge = null;

    /**
     * If left to false, OPTIONS requests are added to permit-all for the {@link CorsProperties#path path matchers} of this {@link CorsProperties}
     * 如果设置为 false，则为该 CorsProperties 的路径匹配器添加 OPTIONS 请求以允许所有用户
     */
    private boolean disableAnonymousOptions = false;
}
