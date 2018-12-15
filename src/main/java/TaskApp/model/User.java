package TaskApp.model;

import com.google.gson.Gson;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "login_time")
    private Date login_time;

    @Column(name="org_unit_id")
    private Long orgUnitId;

    @Override
    public boolean equals(Object input){
        try {
            User user = (User) input;
            if (user.login.equals(this.login) && user.password.equals(this.password))
                return true;
            else
                return false;
        } catch (Exception ex){
            return false;
        }
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
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

    public Long getOrgUnitId() {
        return orgUnitId;
    }

    public void setOrgUnitId(Long orgUnitId) {
        this.orgUnitId = orgUnitId;
    }

    @Override
    public String toString(){
        return new Gson().toJson(this);
    }
}
