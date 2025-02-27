package com.example.demo.service;

import com.example.demo.models.LeNa_funcionarios;
import com.example.demo.repository.LeNa_funcionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeNa_FuncionariosService {
    @Autowired
    private LeNa_funcionariosRepository funcionarioRepository;

    public List<LeNa_funcionarios> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public LeNa_funcionarios salvarFuncionario(LeNa_funcionarios funcionario) {
        return funcionarioRepository.save(funcionario);
    }
    
}
