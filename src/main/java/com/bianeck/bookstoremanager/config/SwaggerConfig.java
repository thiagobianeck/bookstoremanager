package com.bianeck.bookstoremanager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class SwaggerConfig {

    @Value("${spring.application.info.basepackage}")
    private String BASE_PACKAGE;
    @Value("${spring.application.info.title}")
    private String TITLE;
    @Value("${spring.application.info.description}")
    private String DESCRIPTION;
    @Value("${spring.application.info.version}")
    private String VERSION;
    @Value("${spring.application.info.contact.name}")
    private String CONTACT_NAME;
    @Value("${spring.application.info.contact.url}")
    private String CONTACT_URL;
    @Value("${spring.application.info.contact.email}")
    private String CONTACT_EMAIL;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build().apiInfo(buildApiInfo());
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .contact(contact())
                .build();
    }

    private Contact contact() {
        return new Contact(CONTACT_NAME, CONTACT_URL, CONTACT_EMAIL);
    }
}
