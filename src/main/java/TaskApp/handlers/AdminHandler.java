package TaskApp.handlers;

import TaskApp.ApplicationConfig;
import TaskApp.model.Domain;
import TaskApp.service.DomainService;
import TaskApp.service.OrgUnitService;
import TaskApp.service.UserService;
import TaskApp.utils.ErrorWrapper;
import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AdminHandler {
    private static ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    private static DomainService domainService = ctx.getBean(DomainService.class);
    private static OrgUnitService orgUnitService = ctx.getBean(OrgUnitService.class);
    private static UserService userService = ctx.getBean(UserService.class);

    public String addDomain(Domain domain){
        try{
            domainService.addDomain(domain);
            ErrorWrapper errorWrapper = new ErrorWrapper(0L, "Successfull");
            return new Gson().toJson(errorWrapper);
        } catch (Exception ex){
            ErrorWrapper errorWrapper = new ErrorWrapper(1L, "Error while adding domain");
            return new Gson().toJson(errorWrapper);
        }
    }
}
