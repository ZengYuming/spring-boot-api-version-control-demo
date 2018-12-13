package com.demo.apiversioncontrol.config;

import com.demo.apiversioncontrol.handlermapping.ApiVersioningRequestMappingHandlerMapping;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootConfiguration
public class WebConfig extends WebMvcConfigurationSupport {
    /**
     * 重写请求过处理的方法
     * @return
     */
    @Override
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        //return super.requestMappingHandlerMapping();
        RequestMappingHandlerMapping handlerMapping = new ApiVersioningRequestMappingHandlerMapping();
        handlerMapping.setOrder(0);
        return handlerMapping;
    }
}
