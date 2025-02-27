package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LeNa_funcionarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funcionarios_id;

    private String funcionarios_nome;
    private String cargo_funcionario;
    private double  remuneracao;

    public Long funcionarios_id() {
        return funcionarios_id;
    }

    public LeNa_funcionarios setFuncionarios_id(Long funcionarios_id) {
        this.funcionarios_id = funcionarios_id;
        return this;
    }

    public String funcionarios_nome() {
        return funcionarios_nome;
    }

    public LeNa_funcionarios setFuncionarios_nome(String funcionarios_nome) {
        this.funcionarios_nome = funcionarios_nome;
        return this;
    }

    public String cargo_funcionario() {
        return cargo_funcionario;
    }

    public LeNa_funcionarios setCargo_funcionario(String cargo_funcionario) {
        this.cargo_funcionario = cargo_funcionario;
        return this;
    }

    public double remuneracao() {
        return remuneracao;
    }

    public LeNa_funcionarios setRemuneracao(double remuneracao) {
        this.remuneracao = remuneracao;
        return this;
    }
}
