package com.todo.todo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.todo.todo.domain.Todo;
import com.todo.todo.services.TodoServices;

@CrossOrigin("*")
@RestController
@RequestMapping (value = "/todos")
public class TodoController {

	@Autowired
	TodoServices todoService;
	
	@GetMapping("/{Id}")
	public ResponseEntity<Todo>FindById(@PathVariable Integer Id )
	{
		
		Todo Result = todoService.FindById(Id);
		return ResponseEntity.ok().body(Result);
		
	}
	
	
	@GetMapping
	public ResponseEntity<List<Todo>> FindAll()
	{
		
	   List<Todo>Result = todoService.FindAll();
	   return ResponseEntity.ok().body(Result);
		
	}
		
	
	
	@GetMapping("/notFinished")
	public ResponseEntity<List<Todo>>NotFinished()
	{
	
	   List<Todo> Result = todoService.Notfinished();
	   return ResponseEntity.ok().body(Result);
		
	}
	
	@GetMapping("/Finished")
	public ResponseEntity<List<Todo>>Finished()
	{
		
		List<Todo> Result = todoService.finished();
		return ResponseEntity.ok().body(Result);
		
	}
	
    @PostMapping
	public ResponseEntity<Todo>Created(@RequestBody Todo todo)
	
	{
    	
    	 todo = todoService.Created(todo);
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(todo.getID()).toUri();   	
    	 return ResponseEntity.created(uri).body(todo);
    	 
    	 
	}

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> Deleted(@PathVariable Integer id)
    {
    	
    	todoService.Deleted(id);
    	return ResponseEntity.noContent().build();
    	
    	
    	
    }
    
    
}
	
	

