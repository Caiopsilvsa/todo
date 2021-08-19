package com.todo.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.todo.todo.domain.Todo;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

	@Query("SELECT obj FROM Todo obj WHERE obj.finalizacao = false")
	public List<Todo>NotFinished();
	
	
	@Query("SELECT obj FROM Todo obj WHERE obj.finalizacao = true")
	public List<Todo>Finished();
	
}
