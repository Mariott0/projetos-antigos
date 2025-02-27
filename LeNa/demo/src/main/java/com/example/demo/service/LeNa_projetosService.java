package com.example.demo.service;

import com.example.demo.models.LeNa_projetos;
import com.example.demo.repository.LeNa_projetosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeNa_projetosService {
    @Autowired
    private LeNa_projetosRepository projetosRepository;

    public List<LeNa_projetos> listarProjetos() {
        return projetosRepository.findAll();
    }

    public LeNa_projetos salvarProjeto(LeNa_projetos projeto) {
        return projetosRepository.save(projeto);
    }
}
