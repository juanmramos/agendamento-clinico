package br.com.xieba.agendamento.configuration;

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
 * Swagger Configure Class.
 *
 * @author Juan Ramos
 * @see <a href="https://swagger.io/">https://swagger.io/</a>
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    /**
     * Returns a {@link Docket}.
     *
     * @return {@link Docket}
     */
    @Bean
    public Docket swaggerSpringfoxDocket() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("br.com.xieba.agendamento.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo());

        return docket;
    }

    private ApiInfo apiInfo() {

        ApiInfo apiInfo = new ApiInfoBuilder()
            .title("API Agendamento Clínico")
            .description("Agendamento Clínico - API")
            .version("1.0.0")
            .termsOfServiceUrl("API")
            .build();

        return apiInfo;
    }
}
