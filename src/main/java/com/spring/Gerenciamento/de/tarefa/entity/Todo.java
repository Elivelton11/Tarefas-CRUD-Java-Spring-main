package com.spring.Gerenciamento.de.tarefa.entity;

import jakarta.persistence.*;

/**
 * Entidade Todo representa uma tarefa no sistema de gerenciamento.
 * Mapeada para a tabela 'todos' no banco de dados.
 */
@Entity
@Table(name="todos")
public class Todo {
    
    // Atributos da entidade
    private Long id;           // Identificador único da tarefa
    private String nome;       // Nome/título da tarefa
    private String descricao;  // Descrição detalhada da tarefa
    private boolean realizado; // Status de conclusão da tarefa
    private int prioridade;    // Nível de prioridade (1=alta, 2=média, 3=baixa)

    /**
     * Construtor padrão sem argumentos.
     * Necessário para o JPA/Hibernate instanciar a entidade.
     */
    public Todo() {}

    /**
     * Identificador único da tarefa.
     * @return ID da tarefa
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    /**
     * Define o ID da tarefa.
     * @param id ID da tarefa
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome/título da tarefa.
     * @return Nome da tarefa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome/título da tarefa.
     * @param nome Nome da tarefa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Verifica se a tarefa foi realizada.
     * @return true se realizada, false caso contrário
     */
    public boolean isRealizado() {
        return realizado;
    }

    /**
     * Define o status de realização da tarefa.
     * @param realizado true se realizada, false caso contrário
     */
    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    /**
     * Obtém o nível de prioridade da tarefa.
     * @return Prioridade da tarefa (1=alta, 2=média, 3=baixa)
     */
    public int getPrioridade() {
        return prioridade;
    }

    /**
     * Define o nível de prioridade da tarefa.
     * @param prioridade Prioridade (1=alta, 2=média, 3=baixa)
     */
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    /**
     * Obtém a descrição da tarefa.
     * @return Descrição da tarefa
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição da tarefa.
     * @param descricao Descrição da tarefa
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
