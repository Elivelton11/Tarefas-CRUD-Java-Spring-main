package com.spring.Gerenciamento.de.tarefa;

import com.spring.Gerenciamento.de.tarefa.entity.Tarefa;
import com.spring.Gerenciamento.de.tarefa.repository.ApplicationRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.transaction.TestTransaction;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class GerenciamentoDeTarefaApplicationTests {
    @Autowired
    private WebTestClient webTestClient;


    @Test
    void testCreateSucess(){
        var tarefa = new Tarefa("Relatório 1", "Relatório Financeiro",true,3);

        webTestClient
                .post()
                .uri("/Tarefas")
                .bodyValue(tarefa)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.nome").isEqualTo(tarefa.getNome())
                .jsonPath("$.descricao").isEqualTo(tarefa.getDescricao())
                .jsonPath("$.realizado").isEqualTo(tarefa.isRealizado())
                .jsonPath("$.prioridade").isEqualTo(tarefa.getPrioridade());


    }


    @Test
    void testCreateFailure(){

        webTestClient
                .post()
                .uri("/Tarefas")
                .bodyValue(new Tarefa("","",false,0))
                .exchange()
                .expectStatus().isBadRequest();



    }


	@Test
	void contextLoads() {
	}

}
