package br.com.fabiokusaba.place_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

import br.com.fabiokusaba.place_service.domain.PlaceRepository;
import br.com.fabiokusaba.place_service.domain.PlaceService;

// Classe de configuração do container de injeção do Spring
@Configuration
@EnableR2dbcAuditing
public class PlaceConfig {

    // Criação do Bean que vai nos retornar um PlaceService e aqui eu monto qual seria a configuração do PlaceService
    // Se dermos uma olhada ele recebe o PlaceRepository então também vamos precisar injetá-lo e podemos fazer isso
    // passando ele como parâmetro do método e o Spring fica encarregado de injetá-lo
    // Desta forma, temos o nosso PlaceService configurado para injeção
    @Bean
    PlaceService placeService(PlaceRepository placeRepository){
        return new PlaceService(placeRepository);
    }
}
