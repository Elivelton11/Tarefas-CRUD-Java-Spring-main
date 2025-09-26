package com.spring.Gerenciamento.de.tarefa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Entidade Todo representa uma tarefa no sistema de gerenciamento.
 * Mapeada para a tabela 'todos' no banco de dados.
 */
@Getter
@Setter
@Entity
@Table(name="Tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String nome; // Nome/título da tarefa

    @NotBlank
    private String descricao; // Descrição detalhada

    @Column(nullable = false)
    private boolean realizado; // Status de conclusão

    @Column(nullable = false)
    private int prioridade; // Nível de prioridade (ex: 1=alta, 2=média, 3=baixa)


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



