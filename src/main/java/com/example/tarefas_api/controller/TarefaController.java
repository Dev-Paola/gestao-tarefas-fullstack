package com.example.tarefas_api.controller;

import com.example.tarefas_api.model.Tarefa;
import com.example.tarefas_api.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/api/tarefas")
@CrossOrigin(origins = "*")
public class TarefaController {

    @Autowired
    private TarefaRepository repository;

    @GetMapping
    public List<Tarefa> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }
    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada){
        return repository.findById(id).map(tarefa -> {
            tarefa.setTitulo(tarefaAtualizada.getTitulo());
            tarefa.setStatus(tarefaAtualizada.getStatus());
            return repository.save(tarefa);
        }).orElseThrow(() -> new RuntimeException("Tarefa nao encontrada!"));
    }
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
    }