package br.com.fabiokusaba.place_service.web;

import br.com.fabiokusaba.place_service.api.PlaceResponse;
import br.com.fabiokusaba.place_service.domain.Place;

// Componente responsável por fazer o mapeamento
public class PlaceMapper {
    public static PlaceResponse fromPlaceToResponse(Place place){
        return new PlaceResponse(place.name(), place.slug(), place.state(), place.createdAt(), place.updatedAt());
    }
}
