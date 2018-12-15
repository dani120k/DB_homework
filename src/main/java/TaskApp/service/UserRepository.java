package TaskApp.service;

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
}