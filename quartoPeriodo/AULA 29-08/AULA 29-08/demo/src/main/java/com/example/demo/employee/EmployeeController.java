package com.example.demo.employee; // Define o pacote onde esta classe está localizada

import com.example.demo.crud.CrudController; // Importa a classe CrudController do pacote gen.crud
import org.springframework.web.bind.annotation.RequestMapping; // Importa a anotação RequestMapping do Spring
import org.springframework.web.bind.annotation.RestController; // Importa a anotação RestController do Spring

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/employees") // Mapeia as requisições HTTP para o caminho "/employees"
public class EmployeeController extends CrudController<Employee, String> {

    // Construtor que inicializa o serviço EmployeeService e passa para a superclasse CrudController
    public EmployeeController(EmployeeService service) {
        super(service);
    }
}
