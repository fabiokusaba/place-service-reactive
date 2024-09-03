package br.com.fabiokusaba.place_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.fabiokusaba.place_service.api.PlaceRequest;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PlaceServiceApplicationTests {
	// E para a gente fazer o acesso a rota no teste de integração a gente pode injetar aqui o WebTestClient que é um
	// cliente web reativo para fazer os testes
	@Autowired
	WebTestClient webTestClient;

	// Criando testes para a nossa funcionalidade
	// Vamos criar teste de integração, ou seja, fim a fim
	// Lembrando que a forma como você cria os seus testes vai dizer para os avaliadores se você consegue pensar nas exceções,
	// consegue pensar em todos os cenários então é importante que a gente crie um caso pelo menos de sucesso e pelo menos um
	// de erro para todas as funcionalidades
	@Test
	void testCreatePlaceSuccess(){
		// Dados que vão ser usados para a criação
		var name = "Valid Name";
		var state = "Valid State";
		var slug = "valid-name";

		// Usando WebTestClient para acessar a rota
		webTestClient
			.post()
			.uri("/places")
			.bodyValue(new PlaceRequest(name, state))
			.exchange()
			.expectBody()
			.jsonPath("name").isEqualTo(name)
			.jsonPath("state").isEqualTo(state)
			.jsonPath("slug").isEqualTo(slug)
			.jsonPath("createdAt").isNotEmpty()
			.jsonPath("updatedAt").isNotEmpty();

	}

	// Criando um cenário de falha
	@Test
	void testCreatePlaceFailure(){
		// Considerando o name e state vazios como inválidos
		var name = "";
		var state = "";

		webTestClient
		.post()
		.uri("/places")
		.bodyValue(new PlaceRequest(name, state))
		.exchange()
		.expectStatus().isBadRequest();
	}
}
