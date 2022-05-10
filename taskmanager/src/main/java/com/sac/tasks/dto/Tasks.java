package com.sac.tasks.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="task_manager")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tasks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="task_id")
	private int taskId;
	@Column(name = "task_name")
	private String taskName;
	@Column(name="task_description")
	private String description;
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status;
	

}
