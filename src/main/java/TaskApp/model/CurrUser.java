package TaskApp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrUser{
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="login")
    private String login;


    @Column(name="password")
    private String password;

    @Column(name="login_time")
    private String login_time;

    @Column(name="org_unit_id")
    private Long orgUnitId;

    @Column(name="count")
    private Long count;

    public Long getCartoon() {
        return cartoon;
    }

    public void setCartoon(Long cartoon) {
        this.cartoon = cartoon;
    }

    @Column(name="cartoon")
    private Long cartoon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin_time() {
        return login_time;
    }

    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }

    public Long getOrgUnitId() {
        return orgUnitId;
    }

    public void setOrgUnitId(Long orgUnitId) {
        this.orgUnitId = orgUnitId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }


}