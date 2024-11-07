package br.com.dicionariofutebolistico.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI customOpenAPI() {
                return new OpenAPI()
                        .info(new Info()
                                .title("Impact Hub API")
                                .version("1.0.0")
                                .description("API Dicio Futebolistico - Projeto com OpenIA sobre tudo de futebol")
                                .contact(new Contact()
                                        .name("Bruno Ciccio - Desenvolvedor Full Stack")
                                        .email("dev.bruno.ciccio@gmail.com"))
                                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
        }

        @Bean
        public GroupedOpenApi publicApi() {
                return GroupedOpenApi.builder()
                        .group("public")
                        .pathsToMatch(
                        "/cadastro/**", 
                        "/contato/**", 
                        "/documentos/**", 
                        "/endereco/**", 
                        "/login/**"
                        )
                        .build();
        }
        
}