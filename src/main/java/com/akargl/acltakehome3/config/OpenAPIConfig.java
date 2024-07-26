package com.akargl.acltakehome3.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
  @Bean
  public OpenAPI orderOpenAPI() {
    return new OpenAPI()
        .info(new Info().title("ACL Takehome3"));
  }

  @Bean
  public GroupedOpenApi ordersV1Api() {
    return GroupedOpenApi.builder()
        .group("orders-api-v1")
        .pathsToMatch("/orders/**")
        .build();
  }

  @Bean
  public GroupedOpenApi ordersV2Api() {
    return GroupedOpenApi.builder()
        .group("orders-api-v2")
        .pathsToMatch("/v2/**")
        .build();
  }
}
