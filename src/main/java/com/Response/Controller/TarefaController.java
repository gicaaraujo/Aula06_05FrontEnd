package com.Response.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Response.Entity.Tarefas;
import com.Response.Service.TarefaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value ="/tarefa")
public class TarefaController {
	
	 private final TarefaService tarefaService;
	    
	    @Autowired
	    public TarefaController(TarefaService tarefaService) {
	        this.tarefaService = tarefaService;
	    }
	      
	    @GetMapping("/{id}")
	    public ResponseEntity<Tarefas> getProductById(@PathVariable Long id) {
	    	Tarefas tarefa = tarefaService.getTarefaById(id);
	        if (tarefa != null) {
	            return ResponseEntity.ok(tarefa);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @GetMapping
	    public ResponseEntity<List<Tarefas>> getAllTarefas() {
	        List<Tarefas> tarefa = tarefaService.getAllTarefas();
	        return ResponseEntity.ok(tarefa);
	    }
	    
	    
	    @GetMapping("/nome/{nome}")
	    public ResponseEntity<List<Tarefas>> buscarTarefaPorNome(@PathVariable String nome) {
	    	List<Tarefas> tarefa = tarefaService.buscarTarefaPorNome(nome);
	    	return ResponseEntity.ok(tarefa);
	    }
	    
	    @GetMapping("/descricao/{descricao}")
	    public ResponseEntity<List<Tarefas>> buscarTarefaPorDescricao(@PathVariable String descricao) {
	    	List<Tarefas> tarefa = tarefaService.buscarTarefaPorDescricao(descricao);
	    	return ResponseEntity.ok(tarefa);
	    }
	    
	    @PostMapping("/")
	    public ResponseEntity<Tarefas> criarTarefa(@RequestBody @Valid Tarefas tarefa) {
	    	Tarefas criarTarefas = tarefaService.salvarTarefa(tarefa);
	        return ResponseEntity.status(HttpStatus.CREATED).body(criarTarefas);
	    }
	   

	    @PutMapping("/{id}")
	    public ResponseEntity<Tarefas> updateTarefa(@PathVariable Long id, @RequestBody @Valid Tarefas tarefa) {
	    	Tarefas updatedTarefa = tarefaService.updateTarefa(id, tarefa);
	        if (updatedTarefa != null) {
	            return ResponseEntity.ok(updatedTarefa);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Tarefas> deleteTarefa(@PathVariable Long id) {
	        boolean deleted = tarefaService.deleteTarefa(id);
	        if (deleted) {
	        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	       
	 }
	
