package br.com.fabiokusaba.place_service.api;

import java.time.LocalDateTime;

public record PlaceResponse(
    String name,
    String slug,
    String state,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {

}
