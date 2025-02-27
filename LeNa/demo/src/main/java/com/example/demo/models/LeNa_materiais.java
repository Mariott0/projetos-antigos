package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class LeNa_materiais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long material_id;

    private String nome_material;
    private int qtd_material;
    private float preco_material;

    public long material_id() {
        return material_id;
    }

    public LeNa_materiais setMaterial_id(long material_id) {
        this.material_id = material_id;
        return this;
    }

    public String nome_material() {
        return nome_material;
    }

    public LeNa_materiais setNome_material(String nome_material) {
        this.nome_material = nome_material;
        return this;
    }

    public int qtd_material() {
        return qtd_material;
    }

    public LeNa_materiais setQtd_material(int qtd_material) {
        this.qtd_material = qtd_material;
        return this;
    }

    public float preco_material() {
        return preco_material;
    }

    public LeNa_materiais setPreco_material(float preco_material) {
        this.preco_material = preco_material;
        return this;
    }
}
