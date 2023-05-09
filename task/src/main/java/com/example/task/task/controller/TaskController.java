package com.example.task.task.controller;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.task.task.model.Task;

import com.example.task.task.service.TaskService;

import jakarta.validation.Valid;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;



    @GetMapping("/tasks")
    public ModelAndView book(){
        ModelAndView mv = new ModelAndView("tasks");
        List<Task> taskslist = this.taskService.findAll();
        mv.addObject("taskslist", taskslist);
        return mv;
    }


    @PostMapping("/tasks")
    public String addTask(@Valid Task task, BindingResult result, RedirectAttributes redirect) {
        if(result.hasErrors()){
            redirect.addFlashAttribute("mensagem", "Verifique todos os campos!");
            return "redirect:/tasks";
        }
        task.setDate(LocalDate.now());
        this.taskService.save(task);
        return "redirect:/tasks";
    }
    
    @DeleteMapping("/tasks/delete")
    public ResponseEntity<Void> deleteAllTasks() {
        taskService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tasks/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        this.taskService.deleteById(id);
        return "redirect:/tasks";
}
  
}
