package com.example.task.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.task.task.model.Task;
import com.example.task.task.repositary.TaskRepositary;

@Service
public class TaskService {
 
    @Autowired
    private TaskRepositary taskRepositary;

    public void save(Task task){
        this.taskRepositary.save(task);
    }

    public List<Task> findAll(){
        return this.taskRepositary.findAll();
    }

    public void deleteAll(){
        this.taskRepositary.deleteAll();;
    }

    public void deleteById(Long id){
        taskRepositary.deleteById(id);
    }
}
