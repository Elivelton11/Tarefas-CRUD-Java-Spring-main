package com.spring.Gerenciamento.de.tarefa.repository;

import com.spring.Gerenciamento.de.tarefa.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface de repositório para operações de persistência da entidade Todo.
 * Estende JpaRepository fornecendo métodos CRUD básicos automaticamente.
 * 
 * JpaRepository<Todo, Long> significa:
 * - Todo: entidade gerenciada
 * - Long: tipo da chave primária (ID)
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
    // Esta interface herda automaticamente os seguintes métodos do JpaRepository:
    // - save(Todo todo): salva ou atualiza uma tarefa
    // - findById(Long id): busca tarefa por ID
    // - findAll(): lista todas as tarefas
    // - deleteById(Long id): remove tarefa por ID
    // - count(): conta total de tarefas
    // - existsById(Long id): verifica se tarefa existe
    
    // Métodos customizados podem ser adicionados aqui conforme necessário
    // Exemplo: List<Todo> findByRealizado(boolean realizado);
}
