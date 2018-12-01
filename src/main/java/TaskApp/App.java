package TaskApp;

import TaskApp.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
