package TaskApp;

import TaskApp.model.Domain;
import TaskApp.model.OrgUnit;
import TaskApp.service.DomainService;
import TaskApp.service.OrgUnitService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
        /*
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        DomainService domainService = ctx.getBean(DomainService.class);
        Domain testDomain = new Domain();
        testDomain.setId(1L);
        testDomain.setDomainName("test_domain");
        //domainService.addDomain(testDomain);
        OrgUnit orgUnit = new OrgUnit();
        orgUnit.setOrgUnitName("orgUnitName_1");
        orgUnit.setDomain_id(1L);
        OrgUnitService orgUnitService = ctx.getBean(OrgUnitService.class);
        orgUnitService.addOrgUnit(orgUnit);
        List<Domain> domain = domainService.getAllDomains();
        for(Domain test : domain){
            System.out.println(test.toString());
        }
        //orgUnitService.addOrgUnit(orgUnit);
        /*Domain testDomain = new Domain();
        testDomain.setId(1L);
        testDomain.setDomainName("test_domain");
        //testDomain.setOrgUnitList(new ArrayList<OrgUnit>());
        domainService.addDomain(testDomain);
        System.out.println( "Hello World!" );*/
    }
}
