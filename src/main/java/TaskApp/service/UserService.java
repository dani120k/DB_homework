package TaskApp.service;

import TaskApp.model.CurrUser;
import TaskApp.model.Task;
import TaskApp.model.User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository<User> repository;

    @Transactional("jpaTransactionManager")
    public List<User> getAllUsers() {
        return (List<User>) repository.findAll();

    }

    @Transactional("jpaTransactionManager")
    public void addUser(User user) {
        repository.save(user);
    }

    @Transactional("jpaTransactionManager")
    public void deleteUser(User user) {
        repository.delete(user);
    }

    @Transactional("jpaTransactionManager")
    public void updateUser(User user) {
        repository.save(user);
    }

    @Transactional("jpaTransactionManager")
    public List<User> getLastLogin(){
        return (List<User>) repository.getLastLogin();
    }






}
