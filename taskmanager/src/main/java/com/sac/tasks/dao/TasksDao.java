package com.sac.tasks.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sac.tasks.dto.Tasks;

@Repository
public interface TasksDao extends JpaRepository<Tasks, Integer>{

}
