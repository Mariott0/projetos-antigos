package com.example.demo.controller;

import com.example.demo.models.LeNa_projetos;
import com.example.demo.service.LeNa_projetosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projetos")
public class LeNa_projetosController {

    @Autowired
    private LeNa_projetosService projetosService;

    @GetMapping
    public List<LeNa_projetos> listarProjetos() {
        return projetosService.listarProjetos();
    }

    @PostMapping
    public LeNa_projetos criarProjeto(@RequestBody LeNa_projetos projeto) {
        return projetosService.salvarProjeto(projeto);
    }
}
