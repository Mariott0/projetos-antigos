package com.example.demo.controller;

import com.example.demo.models.LeNa_materiais;
import com.example.demo.service.LeNa_materiaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiais")
public class LeNa_materiaisController {
    @Autowired
    private LeNa_materiaisService materiaisService;

    @GetMapping
    public List<LeNa_materiais> listarMateriais() {
        return materiaisService.listarMateriais();
    }

    @PostMapping
    public LeNa_materiais criarMaterial(@RequestBody LeNa_materiais material) {
        return materiaisService.salvarMaterial(material);
    }

}
