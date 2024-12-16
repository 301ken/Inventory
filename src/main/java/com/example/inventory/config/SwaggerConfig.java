//package com.example.inventory.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//
//                .apis(RequestHandlerSelectors.basePackage("com.example.inventory.controller"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(new ApiInfoBuilder()
//                        .title("Inventory Management API")
//                        .description("API documentation for the Inventory Management System")
//                        .version("1.0")
//                        .build());
//    }
//}
