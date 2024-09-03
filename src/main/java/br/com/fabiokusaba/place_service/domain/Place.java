package br.com.fabiokusaba.place_service.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

// Uma dica é trabalharmos com records porque torna o nosso código menos verboso quando estamos trabalhando com pojos que só
// possuem atributos, getters e setters
// Precisamos analisar a suas limitações já que records são imutáveis o que pode ser bom ou pode ser ruim, mas para o nosso
// caso de uma aplicação CRUD é bem útil
// Essas duas anotações que colocamos CreatedDate e LastModifiedDate vão preencher automaticamente a informação da criação e
// atualização do objeto não vou mais precisar me preocupar com isso porque o Spring vai preencher pra mim, para isso a única
// coisa que vou precisar fazer é nas minhas configurações habilitar o EnableR2dbcAuditing e com essa auditoria vou ter as
// informações preenchidas automaticamente quando eu criar o meu objeto pelo framework
public record Place(
    Long id, String name, String slug, String state, 
    @CreatedDate LocalDateTime createdAt, @LastModifiedDate LocalDateTime updatedAt
) {

}
