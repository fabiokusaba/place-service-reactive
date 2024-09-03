package br.com.fabiokusaba.place_service.domain;

import br.com.fabiokusaba.place_service.api.PlaceRequest;
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
    public Mono<Place> create(PlaceRequest placeRequest){
        // Criando uma variável place com as propriedades que vieram da minha request
        var place = new Place(null, placeRequest.name(), placeRequest.slug(), placeRequest.state(), placeRequest.createdAt(), placeRequest.updatedAt());
        
        // Ao final, salvamos no banco de dados
        return placeRepository.save(place);
    }
}
