package TaskApp.service;

import TaskApp.model.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PreRegisterService {
    @Autowired
    DomainRepository<Domain> repository;

    @Transactional("jpaTransactionManager")
    public List<Domain> getAllPreRegister() {
        return (List<Domain>) repository.findAll();

    }

    @Transactional("jpaTransactionManager")
    public void addPreRegisterUser(Domain domain) {
        repository.save(domain);
    }

    @Transactional("jpaTransactionManager")
    public void deletePreRegisterUser(Domain domain) {
        repository.delete(domain);
    }

    @Transactional("jpaTransactionManager")
    public void updatePreRegisterUser(Domain domain) {
        repository.save(domain);
    }
}