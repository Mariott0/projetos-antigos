package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.sql.Date;

@Entity
public class LeNa_projetos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projeto_id;

    private String nome_projeto;
    private String descricao_projeto;
    private Date data_inicio;
    private Date data_fim;

    @ManyToOne
    private LeNa_clientes cliente;

    public long getProjeto_id() {
        return projeto_id;
    }

    public LeNa_projetos setProjeto_id(long projeto_id) {
        this.projeto_id = projeto_id;
        return this;
    }

    public String getNome_projeto() {
        return nome_projeto;
    }

    public LeNa_projetos setNome_projeto(String nome_projeto) {
        this.nome_projeto = nome_projeto;
        return this;
    }

    public String getDescricao_projeto() {
        return descricao_projeto;
    }

    public LeNa_projetos setDescricao_projeto(String descricao_projeto) {
        this.descricao_projeto = descricao_projeto;
        return this;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public LeNa_projetos setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
        return this;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public LeNa_projetos setData_fim(Date data_fim) {
        this.data_fim = data_fim;
        return this;
    }

    public LeNa_clientes getCliente() {
        return cliente;
    }

    public LeNa_projetos setCliente(LeNa_clientes cliente) {
        this.cliente = cliente;
        return this;
    }
}