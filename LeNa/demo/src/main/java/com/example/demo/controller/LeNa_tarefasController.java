package com.example.demo.controller;

import com.example.demo.models.LeNa_tarefas;
import com.example.demo.service.LeNa_tarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class LeNa_tarefasController {

    @Autowired
    private LeNa_tarefasService tarefasService;

    @GetMapping
    public List<LeNa_tarefas> listarTarefas() {
        return tarefasService.listarTarefas();
    }

    @PostMapping
    public LeNa_tarefas criarTarefa(@RequestBody LeNa_tarefas tarefa) {
        return tarefasService.salvarTarefa(tarefa);
    }
}
