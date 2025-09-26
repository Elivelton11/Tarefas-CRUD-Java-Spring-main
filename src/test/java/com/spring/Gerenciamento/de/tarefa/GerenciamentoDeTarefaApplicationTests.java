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

	@Test
	void contextLoads() {
	}

}
