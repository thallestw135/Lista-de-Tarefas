package com.example.task.task.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.task.task.model.Task;

public interface TaskRepositary extends JpaRepository<Task, Long> {
    
}
