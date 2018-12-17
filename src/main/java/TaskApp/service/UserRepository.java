package TaskApp.service;

import TaskApp.model.Task;
import TaskApp.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository<P> extends CrudRepository<User, Long> {

    @Query(value = "SELECT * " +
                   "FROM users " +
                   "ORDER BY users.login_time DESC", nativeQuery = true)
    List<User> getLastLogin();

    @Query(value =
            "SELECT * " +
            "FROM task" +
            "INNER JOIN users ON task.creator_user_id=users.id" +
            "INNER JOIN user_info ON user_info.user_id=users.id" +
            "WHERE creation_time >= date_trunc('Month', Now()) -interval '30days' AND creation_time <= date_trunc('Month', Now()) - interval '1days';", nativeQuery = true)
    List<Task> getLastMonthTask();

    @Query(value =
            "select users.id, login, COUNT(task.id), user_info from users\n" +
                    "INNER JOIN task ON users.id = task.creator_user_id\n" +
                    "INNER JOIN user_info ON users.id = user_info.user_id\n" +
                    "GROUP BY (users.id)\n" +
                    "ORDER BY COUNT(task.id) DESC", nativeQuery = true)
    List<Object> getStatsOfUser();


}