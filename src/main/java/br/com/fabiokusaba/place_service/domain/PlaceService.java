package br.com.fabiokusaba.place_service.domain;

import com.github.slugify.Slugify;

import br.com.fabiokusaba.place_service.api.PlaceRequest;
import reactor.core.publisher.Mono;

// Responsável pelas regras de negócio da aplicação, o seu papel é usar o repositório que a gente tem
public class PlaceService {
    private PlaceRepository placeRepository;

    // Vamos fazer uma melhoria na nossa API que tem a ver com o Slug, a ideia do Slug é gerar uma espécie de identificador pra
    // esse name do Place então se o nome for New Place o slug seria new-place e é esse o comportamento que se espera do slug e
    // obviamente se eu deixo o meu cliente da API passar essa informação eu posso ter inconsistência, posso ter um slug que não
    // corresponde ao nome e a gente não quer isso, faz parte das boas práticas de criação de API prevenir o erro se eu controlo
    // o código de criação do slug eu garanto que o usuário não informe algo inconsistente
    // Para a gente gerar esse slug a partir do nome que for dado ao Place nós vamos utilizar uma biblioteca, lembre-se todo o
    // tipo de funcionalidade que é muito comum provavelmente já foi implementado, vamos utilizar a biblioteca Slugify
    private Slugify slg;

    // Injeção de dependência via construtor
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
        this.slg = Slugify.builder().build();
    }

    // Operação de criação, como estamos trabalhando com API reativa a gente nunca retorna a entidade direta a gente retorna o
    // Mono dela
    public Mono<Place> create(PlaceRequest placeRequest){
        // Criando uma variável place com as propriedades que vieram da minha request
        var place = new Place(null, placeRequest.name(), slg.slugify(placeRequest.name()), placeRequest.state(), placeRequest.createdAt(), placeRequest.updatedAt());
        
        // Ao final, salvamos no banco de dados
        return placeRepository.save(place);
    }
}
