
package com.gullysports;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration.
 * 
 * @author nitesh.sharma
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Base package for the apis.
     */
    private static final String BASE_PACKAGE = "com.gullysports";

    /**
     * Swagger2 configuration.
     * 
     * @return Docket instance of Docket Bean
     */
    @Bean
    public Docket productApi() {

        return new Docket(DocumentationType.SWAGGER_2).select().apis(
            RequestHandlerSelectors.basePackage(BASE_PACKAGE)).paths(PathSelectors.any()).build();

    }
}
