package loja.roupa.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI bookstoreOpenAPI() {

        return new OpenAPI()
                .info(new Info()

                        .title("Artificium API")
                        // Nome que aparece no topo do Swagger UI

                        .description("""
                                API REST para gerenciamento de uma Loja de roupas.
                                Permite criar, buscar, atualizar e remover rpupas do catálogo.
                                Construída com Java 17 + Spring Boot + PostgreSQL.
                                """)


                        .version("v1.0.0")


                        .contact(new Contact()
                                .name("Time Artificium")
                                .email("api@artificium.com")
                                .url("https://artificium.com"))
                        // Quem mantém a API — aparece na documentação
                        // Útil para que consumidores saibam quem contatar

                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0"))
                        // Licença de uso da API — padrão em APIs públicas
                );
    }
}
