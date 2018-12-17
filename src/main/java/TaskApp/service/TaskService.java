package TaskApp.service;

import TaskApp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskRepository<Task> repository;

    @Transactional("jpaTransactionManager")
    public List<Task> getAllTasks() {
        return (List<Task>) repository.findAll();
    }

    @Transactional("jpaTransactionManager")
    public void addTask(Task task) {
        repository.save(task);
    }

    @Transactional("jpaTransactionManager")
    public void deleteTask(Task task) {
        repository.delete(task);
    }

    @Transactional("jpaTransactionManager")
    public void updateTask(Task task) {
        repository.save(task);
    }

    @Transactional("jpaTransactionManager")
    public List<Task> getLastMonthTask(){
        return (List<Task>) repository.getLastMonthTask();
    }
}
