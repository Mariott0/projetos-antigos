package com.example.demo.crud; // Define o pacote onde esta interface está localizada

import java.util.Optional; // Importa a classe Optional, que é usada para representar um valor que pode ou não estar presente

// Define uma interface genérica para operações CRUD (Create, Read, Update, Delete)
public interface CrudService<T, ID> {

    // Retorna todos os objetos do tipo T
    Iterable<T> getAll();

    // Retorna um objeto do tipo T pelo seu ID, encapsulado em um Optional para lidar com a possibilidade de não encontrar o objeto
    Optional<T> getById(ID id);

    // Verifica se um objeto com o ID especificado existe
    boolean existsById(ID id);

    // Cria um novo objeto do tipo T e o retorna
    T create(T entity);

    // Atualiza um objeto existente identificado pelo ID e retorna o objeto atualizado
    T update(ID id, T entity);

    // Deleta um objeto identificado pelo ID
    void delete(ID id);
}
