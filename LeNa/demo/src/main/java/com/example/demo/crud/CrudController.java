package com.example.demo.crud;

/*
acessar documentacao api
http://localhost:8080/swagger-ui/index.html
 */
import org.springframework.http.HttpStatus; // Importa a enumeração HttpStatus para representar os códigos de status HTTP
import org.springframework.http.ResponseEntity; // Importa a classe ResponseEntity para representar respostas HTTP
import org.springframework.web.bind.annotation.*; // Importa anotações do Spring para mapeamento de endpoints
import io.swagger.v3.oas.annotations.Operation; // Importa a anotação Operation do Swagger
import io.swagger.v3.oas.annotations.responses.ApiResponse; // Importa a anotação ApiResponse do Swagger
import io.swagger.v3.oas.annotations.responses.ApiResponses; // Importa a anotação ApiResponses do Swagger

import java.util.Optional; // Importa a classe Optional, que é usada para representar um valor que pode ou não estar presente

// Define uma classe abstrata para operações CRUD (Create, Read, Update, Delete) com suporte a endpoints RESTful
public abstract class CrudController<T, ID> {

    private final CrudService<T, ID> service; // Declara uma variável de instância para o serviço CRUD

    // Construtor protegido que inicializa o serviço CRUD
    protected CrudController(CrudService<T, ID> service) {
        this.service = service;
    }

    // Mapeia o endpoint GET "/all" para retornar todos os objetos do tipo T
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/all")
    public Iterable<T> getAll() {
        return service.getAll();
    }

    // Mapeia o endpoint GET "/{id}" para retornar um objeto do tipo T pelo seu ID
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "404", description = "Objeto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<T> getById(@PathVariable ID id) {
        Optional<T> optionalEntity = service.getById(id);
        return optionalEntity.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Mapeia o endpoint POST para criar um novo objeto do tipo T
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Objeto criado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping
    public T create(@RequestBody T entity) {
        return service.create(entity);
    }

    // Mapeia o endpoint PUT "/{id}" para atualizar um objeto existente identificado pelo ID
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objeto atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Objeto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<T> update(@PathVariable ID id, @RequestBody T entity) {
        service.update(id, entity);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    // Mapeia o endpoint PATCH "/{id}" para atualizar parcialmente um objeto existente identificado pelo ID
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objeto atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Objeto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PatchMapping("/{id}")
    public ResponseEntity<T> partialUpdate(@PathVariable ID id, @RequestBody T updates) {
        return service.getById(id)
                .map(entity -> {
                    // Aplica atualizações parciais ao objeto aqui
                    service.update(id, entity);
                    return new ResponseEntity<>(entity, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Mapeia o endpoint DELETE "/{id}" para deletar um objeto identificado pelo ID
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Objeto deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Objeto não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        if (!service.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
