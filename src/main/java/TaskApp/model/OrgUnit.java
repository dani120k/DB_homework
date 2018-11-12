package TaskApp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "org_units")
public class OrgUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="domain_id")
    private Long domain_id;

    @Column(name = "orgunit_name")
    private String orgUnitName;

    @Column(name = "description")
    private String orgUnitDescription;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="org_unit_id", referencedColumnName="id", updatable = false)
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgUnitName() {
        return orgUnitName;
    }

    public void setOrgUnitName(String orgUnitName) {
        this.orgUnitName = orgUnitName;
    }

    public String getOrgUnitDescription() {
        return orgUnitDescription;
    }

    public void setOrgUnitDescription(String orgUnitDescription) {
        this.orgUnitDescription = orgUnitDescription;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    public Long getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(Long domain_id) {
        this.domain_id = domain_id;
    }
}
