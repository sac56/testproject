package com.sac.tasks.service;

import java.util.List;

import com.sac.tasks.dto.Tasks;


public interface TasksService {

	Tasks insertTask(Tasks task);
	
	List<Tasks> fetchAllTasks();
	
	Tasks updateTask(int id,Tasks task);
	
	boolean deleteTask(int id);
	
	boolean CompletedTask(int id);
}
