package TaskApp.service;

import TaskApp.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    UserInfoRepository<UserInfo> repository;

    @Transactional("jpaTransactionManager")
    public List<UserInfo> getAllUserInfo() {
        return (List<UserInfo>) repository.findAll();

    }

    @Transactional("jpaTransactionManager")
    public void addUserInfo(UserInfo domain) {
        repository.save(domain);
    }

    @Transactional("jpaTransactionManager")
    public void deleteUserInfo(UserInfo domain) {
        repository.delete(domain);
    }

    @Transactional("jpaTransactionManager")
    public void updateUserInfo(UserInfo domain) {
        repository.save(domain);
    }
}