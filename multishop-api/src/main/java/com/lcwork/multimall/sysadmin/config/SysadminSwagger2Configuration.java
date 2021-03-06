package com.lcwork.multimall.sysadmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger在线文档配置<br>
 * 项目启动后可通过地址：http://host:ip/swagger-ui.html 查看在线文档
 *
 * @author enilu
 * @version 2018-07-24
 */

@Configuration
@EnableSwagger2
public class SysadminSwagger2Configuration {
    @Bean
    public Docket sysadminDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("sysadmin")
                .apiInfo(adminApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lcwork.multimall.sysadmin.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("litemall-sysadmin API")
                .description("litemall 系统管理后台API")
                .termsOfServiceUrl("https://github.com/dannyZhou/multi-litemall")
                .contact("https://github.com/dannyZhou/multi-litemall")
                .version("1.0")
                .build();
    }
}
