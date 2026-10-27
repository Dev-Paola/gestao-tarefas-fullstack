package com.example.tarefas_api.repository;

import com.example.tarefas_api.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

@SuppressWarnings("ALL")
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}