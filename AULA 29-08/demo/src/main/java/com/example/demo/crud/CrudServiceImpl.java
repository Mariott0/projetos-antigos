package com.example.demo.crud; // Define o pacote onde esta classe está localizada

import org.springframework.data.repository.CrudRepository; // Importa a interface CrudRepository do Spring Data

import java.util.Optional; // Importa a classe Optional, que é usada para representar um valor que pode ou não estar presente

// Define uma classe abstrata que implementa a interface CrudService
public abstract class CrudServiceImpl<T, ID> implements CrudService<T, ID> {

    private final CrudRepository<T, ID> repository; // Declara uma variável de instância para o repositório CRUD

    // Construtor que inicializa o repositório CRUD
    public CrudServiceImpl(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }

    // Implementa o método getAll() da interface CrudService para retornar todos os objetos do tipo T
    @Override
    public Iterable<T> getAll() {
        return repository.findAll();
    }

    // Implementa o método existsById(ID id) da interface CrudService para verificar se um objeto com o ID especificado existe
    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    // Implementa o método getById(ID id) da interface CrudService para retornar um objeto do tipo T pelo seu ID
    @Override
    public Optional<T> getById(ID id) {
        return repository.findById(id);
    }

    // Implementa o método create(T entity) da interface CrudService para criar um novo objeto do tipo T
    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    // Implementa o método update(ID id, T entity) da interface CrudService para atualizar um objeto existente identificado pelo ID
    @Override
    public T update(ID id, T entity) {
        if (!repository.existsById(id)) { // Verifica se o objeto com o ID especificado existe
            throw new RuntimeException("Resource not found with id: " + id); // Lança uma exceção se o objeto não for encontrado
        }
        return repository.save(entity); // Salva e retorna o objeto atualizado
    }

    // Implementa o método delete(ID id) da interface CrudService para deletar um objeto identificado pelo ID
    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}
