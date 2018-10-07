package TaskApp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "domain")
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "domain_name")
    private String domainName;

    /*@OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="domain_id", referencedColumnName="id", updatable = false)
    private List<OrgUnit> orgUnitList;

    public List<OrgUnit> getOrgUnitList() {
        return orgUnitList;
    }

    public void setOrgUnitList(List<OrgUnit> orgUnitList) {
        this.orgUnitList = orgUnitList;
    }*/

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
