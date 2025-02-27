package com.example.demo.service;

import com.example.demo.models.LeNa_projeto_materiais;
import com.example.demo.repository.LeNa_projeto_materiaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeNa_projeto_materiaisService {
    @Autowired
    private LeNa_projeto_materiaisRepository projetoMateriaisRepository;

    public List<LeNa_projeto_materiais> listarProjetoMateriais() {
        return projetoMateriaisRepository.findAll();
    }

    public LeNa_projeto_materiais salvarProjetoMaterial(LeNa_projeto_materiais projetoMaterial) {
        return projetoMateriaisRepository.save(projetoMaterial);
    }
}
