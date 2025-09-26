package com.spring.Gerenciamento.de.tarefa.service;

import com.spring.Gerenciamento.de.tarefa.entity.Tarefa;
import com.spring.Gerenciamento.de.tarefa.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de serviço que contém a lógica de negócio para gerenciamento de tarefas.
 * Responsável por intermediar entre o Controller e o Repository.
 */
@Service
public class ApplicationService {

    /**
     * Injeção de dependência do TodoRepository.
     * @Autowired: Spring automaticamente injeta uma instância do TodoRepository
     */
    @Autowired
    private ApplicationRepository applicationRepository;

    /**
     * Cria uma nova tarefa no sistema.
     * @param tarefa Objeto Todo com os dados da tarefa
     * @return Lista atualizada de todas as tarefas após a criação
     */
    public Tarefa create(Tarefa tarefa){
        return applicationRepository.save(tarefa);

    }

    /**
     * Lista todas as tarefas ordenadas por prioridade (decrescente) e nome (crescente).
     * @return Lista de tarefas ordenadas
     */
    public List<Tarefa> list(){
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
        return applicationRepository.findAll(sort);
    }

    /**
     * Atualiza uma tarefa existente.
     * @param tarefa Objeto Todo com os dados atualizados
     * @return Lista atualizada de todas as tarefas após a atualização
     */
    public List<Tarefa> update(Tarefa tarefa){
        applicationRepository.save(tarefa);
        return list();
    }
    
    /**
     * Remove uma tarefa do sistema pelo ID.
     * @param id ID da tarefa a ser removida
     * @return Lista atualizada de todas as tarefas após a remoção
     */
    public List<Tarefa> delete(Long id){
        applicationRepository.deleteById(id);
        return list();
    }


}
