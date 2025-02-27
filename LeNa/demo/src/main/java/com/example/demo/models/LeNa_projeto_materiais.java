package com.example.demo.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class LeNa_projeto_materiais {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projeto_id;

   private String mateiral_id;
   private String qtd_material;

    public Long projeto_id() {
        return projeto_id;
    }

    public LeNa_projeto_materiais setProjeto_id(Long projeto_id) {
        this.projeto_id = projeto_id;
        return this;
    }

    public String mateiral_id() {
        return mateiral_id;
    }

    public LeNa_projeto_materiais setMateiral_id(String mateiral_id) {
        this.mateiral_id = mateiral_id;
        return this;
    }

    public String qtd_material() {
        return qtd_material;
    }

    public LeNa_projeto_materiais setQtd_material(String qtd_material) {
        this.qtd_material = qtd_material;
        return this;
    }
}