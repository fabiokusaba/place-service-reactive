package br.com.fabiokusaba.place_service.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabiokusaba.place_service.api.PlaceRequest;
import br.com.fabiokusaba.place_service.api.PlaceResponse;
import br.com.fabiokusaba.place_service.domain.Place;
import br.com.fabiokusaba.place_service.domain.PlaceService;
import reactor.core.publisher.Mono;

// Controlador que vai estabelecer os endpoints da nossa API conforme os requisitos estabelecidos
@RestController
@RequestMapping("/places")
public class PlaceController {
    // Serviço responsável pelas regras de negócio da aplicação
    private PlaceService placeService;

    // Injeção de dependência via construtor
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    // Rota de criação
    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create(@RequestBody PlaceRequest request){
        var createdPlace = placeService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlace);
    }
}
