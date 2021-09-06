package com.todo.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.todo.domain.Todo;
import com.todo.todo.repository.TodoRepository;

@Service
public class TodoServices {

	@Autowired
	private TodoRepository TodoService;
	
	
	public Todo FindById(Integer id) 
	{
		
		Optional<Todo> resultQuery = TodoService.findById(id);
		Todo Result = resultQuery.get();
		return Result;
		
		
	}
	
	public List<Todo>FindAll()
	{
		
		List<Todo>Result = TodoService.findAll();
		return Result;
		
	}
	
	
	public List<Todo> Notfinished()
	{
		
		 List<Todo> result = TodoService.NotFinished();
		 return result;
		 
		
	}

     public List<Todo>finished()
     {
    	 
    	  List<Todo>Result = TodoService.Finished();
    	  return Result;
    	 
     }


     public Todo Created(Todo todo)
     {
    	 Todo Result = TodoService.save(todo);
    	 return Result;
    	 
    	 
     }

     
     public void Deleted(Integer id)
     {
    	 
    	 TodoService.deleteById(id);
    	 
    	 
     }

	public Todo update(Integer id, Todo todo) {
		Optional<Todo> QueryTodo = TodoService.findById(id);
		Todo Result = QueryTodo.get();
		Result.setTitulo(todo.getTitulo());
		Result.setDescricao(todo.getDescricao());
		Result.setDataParaFinalizar(todo.getDataParaFinalizar());
		Result.setFinalizacao(todo.isFinalizacao());
		return Result;
	    
		
		
		
		
	}

     
    
    	 
    	 
     
     
     
}
