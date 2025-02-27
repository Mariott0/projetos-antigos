package com.example.demo.employee;

import jakarta.persistence.*; // Importa as anotações de persistência JPA
import lombok.Getter; // Importa a anotação Getter do Lombok para gerar automaticamente os métodos getter
import lombok.Setter; // Importa a anotação Setter do Lombok para gerar automaticamente os métodos setter

@Getter // Gera automaticamente os métodos getter para todos os campos da classe
@Setter // Gera automaticamente os métodos setter para todos os campos da classe
@Table(name = "employees") // Especifica o nome da tabela no banco de dados que esta entidade mapeia
@Entity // Indica que esta classe é uma entidade JPA
public class Employee {

    @Id // Indica que este campo é a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.UUID) // Especifica que o valor do campo será gerado automaticamente usando UUID
    @Column(name = "id") // Especifica o nome da coluna no banco de dados que mapeia este campo
    private String id;

    @Column(name = "name") // Especifica o nome da coluna no banco de dados que mapeia este campo
    private String name;

    @Column(name = "email") // Especifica o nome da coluna no banco de dados que mapeia este campo
    private String email;

    @Column(name = "phone") // Especifica o nome da coluna no banco de dados que mapeia este campo
    private String phone;
}

