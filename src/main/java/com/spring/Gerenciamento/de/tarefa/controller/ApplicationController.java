package com.spring.Gerenciamento.de.tarefa.controller;

import com.spring.Gerenciamento.de.tarefa.entity.Tarefa;
import com.spring.Gerenciamento.de.tarefa.service.ApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/Tarefas")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    /**
     * POST: Cria uma nova tarefa.
     * Retorna o status 201 Created e a tarefa recém-criada.
     */
    @PostMapping
    public ResponseEntity<Tarefa> create(@RequestBody @Valid Tarefa tarefa) {
        Tarefa createdTarefa = (Tarefa) applicationService.create(tarefa);
        // Retorna 201 Created e a entidade criada
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTarefa);
    }

    /**
     * GET: Lista todas as tarefas.
     */
    @GetMapping
    public ResponseEntity<List<Tarefa>> list() {
        // Retorna 200 OK
        return ResponseEntity.ok(applicationService.list());
    }

    /**
     * PUT: Atualiza uma tarefa existente.
     * Retorna a tarefa atualizada.
     */
    @PutMapping
    public ResponseEntity<Tarefa> update(@RequestBody Tarefa tarefa) {
        // Se a lógica do service lançar erro, será tratado pelo Spring (ex: 500 ou via @ExceptionHandler)
        Tarefa updatedTarefa = (Tarefa) applicationService.update(tarefa);
        // Retorna 200 OK e a entidade atualizada
        return ResponseEntity.ok(updatedTarefa);
    }

    /**
     * DELETE: Deleta uma tarefa pelo ID.
     * Retorna status 204 No Content (padrão para sucesso em DELETE).
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        applicationService.delete(id);
        // Retorna 204 No Content, indicando sucesso e que não há corpo para retornar.
        return ResponseEntity.noContent().build();
    }

}
