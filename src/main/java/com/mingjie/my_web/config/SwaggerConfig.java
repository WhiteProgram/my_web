package com.mingjie.my_web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {
    /**
     * UI页面显示信息
     */
    //前台
    private final String SWAGGER2_API_BASEPACKAGE_FRONT = "com.mingjie.my_web.controller.front";
    private final String SWAGGER2_API_TITLE_FRONT = "前台接口";
    private final String SWAGGER2_API_DESCRIPTION_FRONT = "前台页面的接口";
    private final String SWAGGER2_API_CONTACT_URL_FRONT = "http://www.baidu.com";
    private final String SWAGGER2_API_CONTACT_FRONT = "汕职院学生";
    private final String SWAGGER2_API_VERSION_FRONT = "1.0";



    //后台
    private final String SWAGGER2_API_BASEPACKAGE = "com.mingjie.my_web.controller.admin";
    private final String SWAGGER2_API_TITLE = "后台接口";
    private final String SWAGGER2_API_DESCRIPTION = "后台后台管理页面的接口";
    private final String SWAGGER2_API_CONTACT_URL = "http://www.baidu.com";
    private final String SWAGGER2_API_CONTACT = "汕职院学生";
    private final String SWAGGER2_API_VERSION = "1.0";



    @Bean
    public Docket frontApi() {


        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("frontApi")
                .genericModelSubstitutes(DeferredResult.class)
//              .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .apiInfo(frontApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER2_API_BASEPACKAGE_FRONT))
                .paths(PathSelectors.any())//过滤的接口
                .build();

    }
    @Bean
    public Docket adminApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("managerApi")
                .genericModelSubstitutes(DeferredResult.class)
//              .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER2_API_BASEPACKAGE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(managerInfo());
    }

    //前台接口信息配置
    private ApiInfo frontApiInfo() {
        return new ApiInfoBuilder()
                .title(SWAGGER2_API_TITLE_FRONT)//大标题
                .description(SWAGGER2_API_DESCRIPTION_FRONT)//详细描述
                .version(SWAGGER2_API_VERSION_FRONT)//版本
                .contact(new Contact(SWAGGER2_API_CONTACT_FRONT, SWAGGER2_API_CONTACT_URL_FRONT, ""))//作者
                .build();
    }

    //后台接口信息配置
    private ApiInfo managerInfo(){
        return new ApiInfoBuilder()
                .title(SWAGGER2_API_TITLE)
                .contact(new Contact(SWAGGER2_API_CONTACT, SWAGGER2_API_CONTACT_URL, ""))
                .version(SWAGGER2_API_VERSION)
                .description(SWAGGER2_API_DESCRIPTION)
                .build();
    }

    /**
     * createRestApi
     *
     * @return
     */
//    路径配置，远程也可以看接口文档
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/").setCachePeriod(0);
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/","/static", "/public");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
