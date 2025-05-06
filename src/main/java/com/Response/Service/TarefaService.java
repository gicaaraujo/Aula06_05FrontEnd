package com.Response.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Response.Entity.Tarefas;
import com.Response.Repository.TarefaRepository;

@Service
public class TarefaService {
	private final TarefaRepository tarefaRepository;
	
	  @Autowired
	    public TarefaService(TarefaRepository tarefaRepository) {
	        this.tarefaRepository = tarefaRepository;
	    }

	    public List<Tarefas> getAllTarefas() {
	        return tarefaRepository.findAll();
	    }
	    
	  
	    public List<Tarefas> buscarTarefaPorNome(String nome) {
	    	return tarefaRepository.findByNome(nome);
	    }
	    
	    public List<Tarefas> buscarTarefaPorDescricao(String descricao) {
	    	return tarefaRepository.findByDescricao(descricao);
	    }
	    
	    public Tarefas getTarefaById(Long id) {
	        Optional<Tarefas> aluno = tarefaRepository.findById(id);
	        return aluno.orElse(null);
	    }
	    

	    public Tarefas salvarTarefa(Tarefas tarefa) {
	        return tarefaRepository.save(tarefa);
	    }

	    public Tarefas updateTarefa(Long id, Tarefas updatedTarefa) {
	        Optional<Tarefas> existingTarefa = tarefaRepository.findById(id);
	        if (existingTarefa.isPresent()) {
	            return tarefaRepository.save(updatedTarefa);
	        }
	        return null;
	    }

	    public boolean deleteTarefa(Long id) {
	        Optional<Tarefas> existingTarefa = tarefaRepository.findById(id);
	        if (existingTarefa.isPresent()) {
	        	tarefaRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	}

