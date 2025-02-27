package com.example.demo.service;

import com.example.demo.models.LeNa_tarefas;
import com.example.demo.repository.LeNa_tarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeNa_tarefasService {

    @Autowired
    private LeNa_tarefasRepository tarefasRepository;

    public List<LeNa_tarefas> listarTarefas() {
        return tarefasRepository.findAll();
    }

    public LeNa_tarefas salvarTarefa(LeNa_tarefas tarefa) {
        return tarefasRepository.save(tarefa);
    }
}
