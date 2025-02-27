package com.example.demo.employee;

// Importa a classe CrudServiceImpl do pacote com.example.gen.crud
import com.example.demo.crud.CrudServiceImpl;
import com.example.demo.crud.CrudServiceImpl;
// Importa a anotação Service do Spring Framework
import org.springframework.stereotype.Service;

// Anotação @Service indica que esta classe é um serviço do Spring
@Service
// Define a classe EmployeeService que estende CrudServiceImpl
// CrudServiceImpl é uma implementação genérica de um serviço CRUD
// Employee é a entidade gerenciada pelo serviço
// String é o tipo do identificador (ID) da entidade Employee
public class EmployeeService extends CrudServiceImpl<Employee, String> {

    // Construtor da classe EmployeeService que recebe um repositório EmployeeRepository
    // Chama o construtor da classe pai (CrudServiceImpl) passando o repositório
    public EmployeeService(EmployeeRepository repository) {
        super(repository);
    }
}
