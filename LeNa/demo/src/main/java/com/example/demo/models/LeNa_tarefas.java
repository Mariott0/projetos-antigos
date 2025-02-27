package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.sql.Date;

@Entity
public class LeNa_tarefas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tarefa_id;

    private String nome_tarefa;
    private String descricao_tarefa;
    private Date data_inicio;
    private Date data_fim;

    @ManyToOne
    private LeNa_projetos projeto;

    @ManyToOne
    private LeNa_funcionarios funcionario;

    public long getTarefa_id() {
        return tarefa_id;
    }

    public LeNa_tarefas setTarefa_id(long tarefa_id) {
        this.tarefa_id = tarefa_id;
        return this;
    }

    public String getNome_tarefa() {
        return nome_tarefa;
    }

    public LeNa_tarefas setNome_tarefa(String nome_tarefa) {
        this.nome_tarefa = nome_tarefa;
        return this;
    }

    public String getDescricao_tarefa() {
        return descricao_tarefa;
    }

    public LeNa_tarefas setDescricao_tarefa(String descricao_tarefa) {
        this.descricao_tarefa = descricao_tarefa;
        return this;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public LeNa_tarefas setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
        return this;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public LeNa_tarefas setData_fim(Date data_fim) {
        this.data_fim = data_fim;
        return this;
    }

    public LeNa_projetos getProjeto() {
        return projeto;
    }

    public LeNa_tarefas setProjeto(LeNa_projetos projeto) {
        this.projeto = projeto;
        return this;
    }

    public LeNa_funcionarios getFuncionario() {
        return funcionario;
    }

    public LeNa_tarefas setFuncionario(LeNa_funcionarios funcionario) {
        this.funcionario = funcionario;
        return this;
    }
}