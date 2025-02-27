package com.example.demo.employee;

// Importa a interface JpaRepository do Spring Data JPA
import org.springframework.data.jpa.repository.JpaRepository;

// Define a interface EmployeeRepository que estende JpaRepository
// JpaRepository é uma interface do Spring Data JPA que fornece métodos padrão para operações CRUD (Create, Read, Update, Delete)
// Employee é a entidade que será gerenciada pelo repositório
// String é o tipo do identificador (ID) da entidade Employee
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    // Aqui você pode adicionar métodos personalizados, se necessário
    // Por exemplo, você pode definir um método para encontrar um funcionário pelo nome:
    // List<Employee> findByName(String name);
}
