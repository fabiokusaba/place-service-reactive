package br.com.fabiokusaba.place_service.domain;

import java.time.LocalDateTime;

// Uma dica é trabalharmos com records porque torna o nosso código menos verboso quando estamos trabalhando com pojos que só
// possuem atributos, getters e setters
// Precisamos analisar a suas limitações já que records são imutáveis o que pode ser bom ou pode ser ruim, mas para o nosso
// caso de uma aplicação CRUD é bem útil
public record Place(
    Long id, String name, String slug, String state, LocalDateTime createdAt, LocalDateTime updatedAt
) {

}
