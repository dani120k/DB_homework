package TaskApp.service;

import TaskApp.model.OrgUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrgUnitService {
    @Autowired
    OrgUnitRepository<OrgUnit> repository;

    @Transactional("jpaTransactionManager")
    public List<OrgUnit> getAllOrgUnit() {
        return (List<OrgUnit>) repository.findAll();

    }

    @Transactional("jpaTransactionManager")
    public void addOrgUnit(OrgUnit orgUnit) {
        repository.save(orgUnit);
    }

    @Transactional("jpaTransactionManager")
    public void deleteOrgUnit(OrgUnit orgUnit) {
        repository.delete(orgUnit);
    }

    @Transactional("jpaTransactionManager")
    public void updateOrgUnit(OrgUnit orgUnit) {
        repository.save(orgUnit);
    }
}