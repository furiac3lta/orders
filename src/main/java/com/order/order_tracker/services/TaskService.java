package com.order.order_tracker.services;

import com.order.order_tracker.entities.TaskEntity;

import java.util.List;

public interface TaskService {
    TaskEntity save(TaskEntity task) ;
    TaskEntity update(TaskEntity task, Long id);
    List<TaskEntity> findAll();
    TaskEntity findById(Long id);
    String delete(Long id);
}
