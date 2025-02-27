package com.example.demo.service;

import com.example.demo.models.LeNa_materiais;
import com.example.demo.repository.LeNa_materiaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeNa_materiaisService {
    @Autowired
    private LeNa_materiaisRepository materiaisRepository;

    public List<LeNa_materiais> listarMateriais() {
        return materiaisRepository.findAll();
    }

    public LeNa_materiais salvarMaterial(LeNa_materiais material) {
        return materiaisRepository.save(material);
    }

}
