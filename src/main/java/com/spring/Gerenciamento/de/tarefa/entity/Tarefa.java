package com.spring.Gerenciamento.de.tarefa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidade Todo representa uma tarefa no sistema de gerenciamento.
 * Mapeada para a tabela 'todos' no banco de dados.
 */

@Entity
@Table(name="Tarefa")
public class Tarefa {
    private int id;
    private String nome;
    private String descricao;
    private boolean realizado;
    private int prioridade;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }


    // Construtor padrão sem argumentos necessário para o JPA

    public Tarefa(String nome, String descricao, boolean realizado, int prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.realizado = realizado;
        this.prioridade = prioridade;
    }

    public Tarefa(){}


    // OBS: O Lombok (@Getter/@Setter) cuida dos métodos get/set.
    // O método isRealizado() será gerado automaticamente pelo Lombok.
}



