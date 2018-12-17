package TaskApp.service;

import TaskApp.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository<P> extends CrudRepository<Task, Long> {

    @Query(value =
            "select *" +
            " from task" +
            " WHERE creation_time >= date_trunc('Month', Now()) -interval '30days' AND creation_time <= date_trunc('Month', Now()) ORDER BY task.id DESC", nativeQuery = true)
    List<Task> getLastMonthTask();
}