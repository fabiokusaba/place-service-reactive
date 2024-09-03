package br.com.fabiokusaba.place_service.domain;

import reactor.core.publisher.Mono;

// Responsável pelas regras de negócio da aplicação, o seu papel é usar o repositório que a gente tem
public class PlaceService {
    private PlaceRepository placeRepository;

    // Injeção de dependência via construtor
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    // Operação de criação, como estamos trabalhando com API reativa a gente nunca retorna a entidade direta a gente retorna o
    // Mono dela
    public Mono<Place> create(Place place){
        return placeRepository.save(place);
    }
}
