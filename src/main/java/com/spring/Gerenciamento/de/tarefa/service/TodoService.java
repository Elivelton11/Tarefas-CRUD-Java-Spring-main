package com.spring.Gerenciamento.de.tarefa.service;

import com.spring.Gerenciamento.de.tarefa.entity.Todo;
import com.spring.Gerenciamento.de.tarefa.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de serviço que contém a lógica de negócio para gerenciamento de tarefas.
 * Responsável por intermediar entre o Controller e o Repository.
 */
@Service
public class TodoService {

    /**
     * Injeção de dependência do TodoRepository.
     * @Autowired: Spring automaticamente injeta uma instância do TodoRepository
     */
    @Autowired
    private TodoRepository todoRepository;

    /**
     * Cria uma nova tarefa no sistema.
     * @param todo Objeto Todo com os dados da tarefa
     * @return Lista atualizada de todas as tarefas após a criação
     */
    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    /**
     * Lista todas as tarefas ordenadas por prioridade (decrescente) e nome (crescente).
     * @return Lista de tarefas ordenadas
     */
    public List<Todo> list(){
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
        return todoRepository.findAll(sort);
    }

    /**
     * Atualiza uma tarefa existente.
     * @param todo Objeto Todo com os dados atualizados
     * @return Lista atualizada de todas as tarefas após a atualização
     */
    public List<Todo> update(Todo todo){
        todoRepository.save(todo);
        return list();
    }
    
    /**
     * Remove uma tarefa do sistema pelo ID.
     * @param id ID da tarefa a ser removida
     * @return Lista atualizada de todas as tarefas após a remoção
     */
    public List<Todo> delete(Long id){
        todoRepository.deleteById(id);
        return list();
    }


}
