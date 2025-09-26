package com.spring.Gerenciamento.de.tarefa.controller;

import com.spring.Gerenciamento.de.tarefa.entity.Todo;
import com.spring.Gerenciamento.de.tarefa.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST para gerenciamento de tarefas.
 * Expõe endpoints HTTP para operações CRUD de tarefas.
 * 
 * @RestController: Combina @Controller + @ResponseBody
 * @RequestMapping("/todos"): Define o prefixo base para todas as rotas
 */
@RestController
@RequestMapping("/todos")
public class TodoController {

    /**
     * Injeção de dependência do TodoService.
     * @Autowired: Spring automaticamente injeta uma instância do TodoService
     */
    @Autowired
    private TodoService todoService;

    /**
     * Endpoint para criar uma nova tarefa.
     * @PostMapping: Mapeia requisições HTTP POST
     * @param todo Dados da tarefa enviados no corpo da requisição (JSON)
     * @return Lista atualizada de todas as tarefas
     */
    @PostMapping
    List<Todo> create(@RequestBody Todo todo){
        return todoService.create(todo);
    }
    
    /**
     * Endpoint para listar todas as tarefas.
     * @GetMapping: Mapeia requisições HTTP GET
     * @return Lista de todas as tarefas ordenadas
     */
    @GetMapping
    List<Todo> list(){
        return todoService.list();
    }
    
    /**
     * Endpoint para atualizar uma tarefa existente.
     * @PutMapping: Mapeia requisições HTTP PUT
     * @param todo Dados atualizados da tarefa enviados no corpo da requisição (JSON)
     * @return Lista atualizada de todas as tarefas
     */
    @PutMapping
    List<Todo> update(@RequestBody Todo todo){
        return todoService.update(todo);
    }
    
    /**
     * Endpoint para deletar uma tarefa pelo ID.
     * @DeleteMapping("/{id}"): Mapeia requisições HTTP DELETE com parâmetro de caminho
     * @param id ID da tarefa a ser removida (extraído da URL)
     * @return Lista atualizada de todas as tarefas
     */
    @DeleteMapping("/{id}")
    List<Todo> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }

}
