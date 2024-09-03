package br.com.fabiokusaba.place_service.api;

import java.time.LocalDateTime;

// DTOs -> ao invés de você pegar um objeto de domínio e cruzar a aplicação inteira com ele, ou seja, a camada web
// a camada de serviço, a camada de repositório, você cria um DTO para conter apenas as propriedades que você quer
// expor para o mundo exterior
public record PlaceRequest(
    String name,
    String slug,
    String state,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {

}
