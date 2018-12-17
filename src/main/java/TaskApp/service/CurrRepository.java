package TaskApp.service;

import TaskApp.model.CurrUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CurrRepository<P> extends CrudRepository<CurrUser, Long> {
    @Query(value =
            "select users.id, login, password, login_time, org_unit_id, COUNT(task.id), user_info.cartoon from users\n" +
                    "INNER JOIN task ON users.id = task.creator_user_id\n" +
                    "INNER JOIN user_info ON users.user_info_id = user_info.id\n" +
                    "GROUP BY (users.id, user_info.cartoon)\n" +
                    "ORDER BY COUNT(task.id) DESC", nativeQuery = true)
    List<CurrUser> getStatsOfUser();
}