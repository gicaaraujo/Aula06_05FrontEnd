package com.Response.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Response.Entity.Tarefas;

public interface TarefaRepository extends JpaRepository<Tarefas, Long> {
		List<Tarefas> findByNome(String nome);
		List<Tarefas> findByDescricao(String descricao);

}
