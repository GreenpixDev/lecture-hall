package ru.hits.lecturehosting.hall.config;

import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenApiCustomizer healthOpenApiCustomizer() {
        return openApi -> {
            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
                ApiResponses apiResponses = operation.getResponses();
                addApiResponse(apiResponses, "400", "Bad Request");
                addApiResponse(apiResponses, "401", "Unauthorized");
                addApiResponse(apiResponses, "500", "Internal Server Error");
            }));
        };
    }

    private void addApiResponse(ApiResponses apiResponses, String code, String description) {
        ApiResponse apiResponse = new ApiResponse().description(description).content(null);
        apiResponses.addApiResponse(code, apiResponse);
    }
}
