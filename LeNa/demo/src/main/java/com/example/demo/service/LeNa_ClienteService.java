package com.example.demo.service;

import com.example.demo.models.LeNa_clientes;
import com.example.demo.repository.LeNa_clientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeNa_ClienteService {
    @Autowired
    private LeNa_clientesRepository clienteRepository;

    public List<LeNa_clientes> listarClientes() {
        return clienteRepository.findAll();
    }

    public LeNa_clientes salvarCliente(LeNa_clientes cliente) {
        return clienteRepository.save(cliente);
    }
}

