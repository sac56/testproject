package com.sac.tasks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sac.tasks.dao.TasksDao;
import com.sac.tasks.dto.Status;
import com.sac.tasks.dto.Tasks;

@Service
public class TasksServiceImpl implements TasksService{

	@Autowired
	public  TasksDao taskDao;
	@Override
	public Tasks insertTask(Tasks task) {
		try {
			taskDao.save(task);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return task;
	}
	@Override
	public List<Tasks> fetchAllTasks() {
		
		List t1=taskDao.findAll();
		return t1;
	}
	@Override
	public Tasks updateTask(int id,Tasks task) {
		
		Optional<Tasks> opt=taskDao.findById(id);
		Tasks current=opt.get();
		
		if(task.getDescription()!=null || task.getDescription()!="") {
			current.setDescription(task.getDescription());
		}
		if(task.getTaskName()!=null || task.getTaskName()!="") {
			current.setTaskName(task.getTaskName());
		}
		if(task.getStatus()!=null) {
	 current.setStatus(task.getStatus());		
		}
		taskDao.save(current);
		return current;
	}
	@Override
	public boolean deleteTask(int id) {
		boolean isFlag=false;
		Tasks task=taskDao.getById(id);
		
	try {
		taskDao.delete(task);
		taskDao.flush();
		isFlag=true;
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		return isFlag;
	}
	@Override
	public boolean CompletedTask(int id) {
		boolean isFlag=false;
		Tasks task=taskDao.getById(id);
		if(task.getStatus()==Status.Submitted) {
			task.setStatus(Status.Completed);
			taskDao.save(task);
			isFlag=true;
		}
		
		return isFlag;
	}

}
