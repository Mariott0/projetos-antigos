package com.example.demo.controller;

import com.example.demo.models.LeNa_projeto_materiais;
import com.example.demo.service.LeNa_projeto_materiaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projeto-materiais")
public class LeNa_projeto_materiaisController {
    @Autowired
    private LeNa_projeto_materiaisService projetoMateriaisService;

    @GetMapping
    public List<LeNa_projeto_materiais> listarProjetoMateriais() {
        return projetoMateriaisService.listarProjetoMateriais();
    }

    @PostMapping
    public LeNa_projeto_materiais criarProjetoMaterial(@RequestBody LeNa_projeto_materiais projetoMaterial) {
        return projetoMateriaisService.salvarProjetoMaterial(projetoMaterial);
    }
}
