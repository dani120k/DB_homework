package TaskApp.service;

import TaskApp.model.Domain;
import TaskApp.model.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository<P> extends CrudRepository<UserInfo, Long> {

}