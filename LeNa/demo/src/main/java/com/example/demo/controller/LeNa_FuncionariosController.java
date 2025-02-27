package com.example.demo.controller;

import com.example.demo.models.LeNa_funcionarios;
import com.example.demo.service.LeNa_FuncionariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class LeNa_FuncionariosController {
    @Autowired
    private LeNa_FuncionariosService funcionarioService;

    @GetMapping
    public List<LeNa_funcionarios> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    @PostMapping
    public LeNa_funcionarios criarFuncionario(@RequestBody LeNa_funcionarios funcionario) {
        return funcionarioService.salvarFuncionario(funcionario);
    }
}
