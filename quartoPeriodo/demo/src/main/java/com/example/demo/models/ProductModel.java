package com.example.demo.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentatioModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCTS")
public class ProductModel extends  RepresentationModel<ProductModel> implements Serializable {
    private static final  long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProduct;
    private String name;
    private BigDecimal value;

    public UUID getIdProduct(){return idProduct;}
    public void setIdProduct(){this.idProduct = idProduct;}
    public String getName(){return name;}
}

