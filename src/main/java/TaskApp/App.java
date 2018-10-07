package TaskApp;

import TaskApp.model.Domain;
import TaskApp.model.OrgUnit;
import TaskApp.service.DomainService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

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
        System.out.println( "Hello World!" );
    }
}
