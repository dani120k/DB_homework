package TaskApp.service;

import TaskApp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository<P> extends CrudRepository<User, Long> {

}