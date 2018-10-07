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
    public static ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

    public static void main( String[] args )
    {
        DomainService domainService = ctx.getBean(DomainService.class);
        Domain testDomain = new Domain();
        testDomain.setId(1L);
        testDomain.setDomainName("test_domain");
        testDomain.setOrgUnitList(new ArrayList<OrgUnit>());
        domainService.addDomain(testDomain);
        System.out.println( "Hello World!" );
    }
}
