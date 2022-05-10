package com.sac.tasks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sac.tasks.dto.Tasks;
import com.sac.tasks.service.TasksService;

@RestController
public class TasksController {

	@Autowired
	TasksService service;

	@PostMapping("/insert")
	public ResponseEntity<?> isInserted(@RequestBody Tasks task){
		try {
			Tasks t1=service.insertTask(task);
			return new ResponseEntity<String>("Task is inserted",HttpStatus.ACCEPTED);
		}
		catch(NullPointerException e) {
			return new ResponseEntity<String>("Task not inserted",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Tasks>> getAllTasks(){
		
		List<Tasks> l1=service.fetchAllTasks();
		
		if(l1==null) {
			return new ResponseEntity<List<Tasks>>(l1,HttpStatus.GONE);
		}
		else
		return new ResponseEntity<List<Tasks>>(l1,HttpStatus.ACCEPTED);
		
	}
	@PutMapping("/update")
	public ResponseEntity<?> GetUpdated(@RequestBody Tasks task){
		try {
			Tasks task1=service.insertTask(task);
			return new ResponseEntity<Tasks>(task1,HttpStatus.ACCEPTED);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("update failed",HttpStatus.GONE);
		}
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> getDeleted(@PathVariable("id") int id){
		
		if(service.deleteTask(id)) {
			return new ResponseEntity<String>("The Data is been deleted",HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String>("The Data is not deleted",HttpStatus.CONFLICT);
		}
		
	}
	
	@PutMapping("/marking/{id}")
	public ResponseEntity<?> getCompleted(@PathVariable("id") int id){
		
		if(service.CompletedTask(id)) {
			return new ResponseEntity<String>("The Status has been Changed",HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<String>("The Status not been Changed",HttpStatus.CONFLICT);
		}
		
		
		
	}
		
	
	
}
