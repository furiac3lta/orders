package com.order.order_tracker.services.impl;

import com.order.order_tracker.entities.TaskEntity;
import com.order.order_tracker.repositories.TaskRepository;
import com.order.order_tracker.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Override
    public TaskEntity save(TaskEntity task) {
        return taskRepository.save(task);
    }

    @Override
    public TaskEntity update(TaskEntity task, Long id) {
        TaskEntity taskEntity = taskRepository.findById(id).get();
        taskEntity.setName(task.getName());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setCompleted(task.getCompleted());
        TaskEntity taskUpdated = taskRepository.save(taskEntity);
        return  taskUpdated;
    }

    @Override
    public List<TaskEntity> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public TaskEntity findById(Long id) {
        return taskRepository.findById(id).get();
    }

    @Override
    public String delete(Long id) {
        taskRepository.deleteById(id);
        return "success delete";
    }
}
