package TaskApp.service;

import TaskApp.model.OrgUnit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgUnitRepository<P> extends CrudRepository<OrgUnit, Long> {

}