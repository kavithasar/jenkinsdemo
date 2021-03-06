package com.boa.kyc.upload.configurations;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.google.common.collect.Lists;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;
@Configuration
@EnableSwagger2WebMvc
@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {
	 public static final String AUTHORIZATION_HEADER = "Authorization";
	 public static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";
    @Bean
    public Docket apiDocketadharCardv10() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("adharcard-api-1.0")
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.boa.kyc.upload"))
                .paths(PathSelectors.regex("/adharcards/v1.0.*"))
                .build()
                .apiInfo(getApiInfo())
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .ignoredParameterTypes(Pageable.class)
                .ignoredParameterTypes(java.sql.Date.class)
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(apiKey()))
                .useDefaultResponseMessages(false);
    }
    @Bean
    public Docket apiDocketadharCardv11() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("adharcard-api-1.1")
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.boa.kyc.upload"))
                .paths(PathSelectors.regex("/adharcards/v1.1.*"))
                .build()
                .apiInfo(getApiInfo())
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .ignoredParameterTypes(Pageable.class)
                .ignoredParameterTypes(java.sql.Date.class)
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(apiKey()))
                .useDefaultResponseMessages(false);
    }
    @Bean
    public Docket apiDocketCustomerv10() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("customer-api-1.0")
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.boa.kyc.upload"))
                .paths(PathSelectors.regex("/customers/v1.0.*"))
                .build()
                .apiInfo(getApiInfo())
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .ignoredParameterTypes(Pageable.class)
                .ignoredParameterTypes(java.sql.Date.class)
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(apiKey()))
                .useDefaultResponseMessages(false);
    }
    @Bean
    public Docket apiDocketCustomerv11() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("customer-api-1.1")
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.boa.kyc.upload"))
                .paths(PathSelectors.regex("/customers/v1.1.*"))
                .build()
                .apiInfo(getApiInfo())
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .ignoredParameterTypes(Pageable.class)
                .ignoredParameterTypes(java.sql.Date.class)
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(apiKey()))
                .useDefaultResponseMessages(false);
    }
    
    
    @Bean
    public Docket apiDocketAccountv10() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("account-api-1.0")
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.boa.kyc.upload"))
                .paths(PathSelectors.regex("/accounts/v1.0.*"))
                .build()
                .apiInfo(getApiInfo())
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .ignoredParameterTypes(Pageable.class)
                .ignoredParameterTypes(java.sql.Date.class)
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(apiKey()))
                .useDefaultResponseMessages(false);
    }
    @Bean
    public Docket apiDocketAccountv11() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.groupName("account-api-1.1")
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.boa.kyc.upload"))
                .paths(PathSelectors.regex("/accounts/v1.1.*"))
                .build()
                .apiInfo(getApiInfo())
                .forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .ignoredParameterTypes(Pageable.class)
                .ignoredParameterTypes(java.sql.Date.class)
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(apiKey()))
                .useDefaultResponseMessages(false);
    }
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Upload API",
                "App to demonstrate API Documentation",
                "0.0.1-SNAPSHOT",
                "Terms of Service",
                new Contact("Parameswari",
                        "https://blog.eswari.in",
                        "parameswaribala@gmail.com"),
                "OSS License",
                "https://blog.eswari.in",
                Collections.emptyList());
    }
    
    private ApiKey apiKey() {
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
            .securityReferences(defaultAuth())
            .forPaths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
            .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
            = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(
            new SecurityReference("JWT", authorizationScopes));
    }
}