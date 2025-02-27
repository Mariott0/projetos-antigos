package com.example.demo.academicos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Entity
public class Academico {
    @Id
    long id;
    String nome;

    public long getId() {
        return id;
    }

    public Academico setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Academico setNome(String nome) {
        this.nome = nome;
        return this;
    }
}

@Repository
interface AcademicoRepository extends JpaRepository<Academico, Long> {

}

@Service
class AcademicoService {
    AcademicoRepository academicoRepository;

    public AcademicoService(AcademicoRepository academicoRepository) {
        this.academicoRepository = academicoRepository;
    }

    public List<Academico> listar() {
        return academicoRepository.findAll();
    }
}

@RestController
@RequestMapping("/XERECA")
class AcademicoController {
    AcademicoService academicoService;

    public AcademicoController(AcademicoService academicoService){
        this.academicoService = academicoService;
    }

    @GetMapping
    public List<Academico> listarTodos(){
        return academicoService.listar();
    }
}
