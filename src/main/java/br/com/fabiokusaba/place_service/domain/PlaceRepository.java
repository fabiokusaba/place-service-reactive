package br.com.fabiokusaba.place_service.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

// Para trabalharmos de forma reativa precisamos extender o ReactiveCrudRepository e ele recebe duas informações: o tipo da
// entidade e o tipo do id dela
public interface PlaceRepository extends ReactiveCrudRepository<Place, Long> {

}
