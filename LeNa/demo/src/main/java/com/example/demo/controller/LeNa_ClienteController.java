package com.example.demo.controller;

import com.example.demo.models.LeNa_clientes;
import com.example.demo.service.LeNa_ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class LeNa_ClienteController {
    @Autowired
    private LeNa_ClienteService clienteService;

    @GetMapping("/all")
    public List<LeNa_clientes> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public LeNa_clientes criarCliente(@RequestBody LeNa_clientes cliente) {
        return clienteService.salvarCliente(cliente);
    }

}

