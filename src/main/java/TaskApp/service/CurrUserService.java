package TaskApp.service;

import TaskApp.model.CurrUser;
import TaskApp.model.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CurrUserService {
    @Autowired
    CurrRepository<CurrUser> repository;

    @Transactional("jpaTransactionManager")
    public List<CurrUser> getStatsOfUser(){return (List<CurrUser>) repository.getStatsOfUser();}


    @Transactional("jpaTransactionManager")
    public List<CurrUser> getAllDomains() {
        return (List<CurrUser>) repository.findAll();
    }

    @Transactional("jpaTransactionManager")
    public void addDomain(CurrUser domain) {
        repository.save(domain);
    }

    @Transactional("jpaTransactionManager")
    public void deleteDomain(CurrUser domain) {
        repository.delete(domain);
    }

    @Transactional("jpaTransactionManager")
    public void updateDomain(CurrUser domain) {
        repository.save(domain);
    }
}