package TaskApp;

import TaskApp.model.Domain;
import TaskApp.model.OrgUnit;
import TaskApp.model.User;
import TaskApp.service.DomainService;
import TaskApp.service.OrgUnitService;
import TaskApp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        DomainService domainService = ctx.getBean(DomainService.class);
        Domain testDomain = new Domain();
        testDomain.setId(1L);
        testDomain.setDomainName("test_domain");
        //testDomain.setOrgUnitList(new ArrayList<OrgUnit>());
        domainService.addDomain(testDomain);
        OrgUnit orgUnit = new OrgUnit();
        orgUnit.setId(1L);
        orgUnit.setDomain_id(1L);
        orgUnit.setOrgUnitDescription("desc");
        orgUnit.setUsers(new ArrayList<>());
        orgUnit.setOrgUnitName("org");
        OrgUnitService orgUnitService = ctx.getBean(OrgUnitService.class);
        orgUnitService.addOrgUnit(orgUnit);

        User user = new User();
        user.setId(1L);
        user.setEmail("forolymp120@gmail.com");
        user.setOrgUnitId(1L);
        user.setFirst_name("danil");
        user.setSecond_name("sokolov");
        UserService userService = ctx.getBean(UserService.class);
        userService.addUser(user);
        System.out.println( domainService.getAllDomains().get(0).toString() );
    }
}
