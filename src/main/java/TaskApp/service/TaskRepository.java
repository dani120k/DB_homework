package TaskApp.service;

import TaskApp.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository<P> extends CrudRepository<Task, Long> {

}