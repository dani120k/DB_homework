package TaskApp.service;

import TaskApp.model.Domain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreRegisterRepository<P> extends CrudRepository<Domain, Long> {

}