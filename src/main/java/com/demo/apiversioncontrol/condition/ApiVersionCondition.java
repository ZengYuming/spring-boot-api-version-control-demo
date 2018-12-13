package com.demo.apiversioncontrol.condition;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

    // extract the version part from url. example [v0-9]
    // 从url中解析出版本号
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)/");

    private int apiVersion;

    public ApiVersionCondition(int apiVersion) {
        this.apiVersion = apiVersion;
    }

    public ApiVersionCondition combine(ApiVersionCondition other) {
        // latest defined would be take effect, that means, methods definition with
        // override the classes definition
        return new ApiVersionCondition(other.getApiVersion());
    }

    public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {
        Matcher m = VERSION_PREFIX_PATTERN.matcher(request.getRequestURI());
        if (m.find()) {
            Integer version = Integer.valueOf(m.group(1));
            // when applying version number bigger than configuration, then it will take
            // 当请求的版本 >= ApiVersion注解配置的版本号时，那边就用配置的这个版本号，即最大的这个版本号
            if (version >= this.apiVersion)
                // effect
                return this;
        }
        return null;
    }

    public int compareTo(ApiVersionCondition other, HttpServletRequest request) {
        // when more than one configured version number passed the match rule, then only
        // the biggest one will take effect.
        //当超过一个ApiVersion注解配置的版本号时，那么只有最大的这一个会被用到
        return other.getApiVersion() - this.apiVersion;
    }

    public int getApiVersion() {
        return apiVersion;
    }
}