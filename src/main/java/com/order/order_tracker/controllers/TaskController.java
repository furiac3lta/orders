package com.order.order_tracker.controllers;


import com.order.order_tracker.entities.TaskEntity;
import com.order.order_tracker.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskEntity>> Tasks(){
        return ResponseEntity.ok(taskService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> findById(@PathVariable("id") Long id){
        TaskEntity task = taskService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }
    @PostMapping
    public ResponseEntity<TaskEntity> save(@RequestBody TaskEntity task){
        return new ResponseEntity<>(taskService.save(task), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaskEntity> update(@RequestBody TaskEntity task, @PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.update(task, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(taskService.delete(id));
    }
}
