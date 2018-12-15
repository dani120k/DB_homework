package TaskApp.handlers;

import TaskApp.ApplicationConfig;
import TaskApp.model.User;
import TaskApp.service.UserService;
import TaskApp.utils.ErrorWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.List;

public class UserHandler {
    private static ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    UserService userService = ctx.getBean(UserService.class);

    public ErrorWrapper checkLogin(User user){
        List<User> users = userService.getAllUsers();
        for(User curr : users){

            if (curr.equals(user)){
                ErrorWrapper errorWrapper = new ErrorWrapper(0L, "ok");
                curr.setLogin_time(new Date());
                userService.updateUser(curr);
                return errorWrapper;
            }
        }
        ErrorWrapper errorWrapper = new ErrorWrapper(1L, "Couldn't find user");
        return errorWrapper;
    }

    public List<User> getLastLoginUsers(){
        return userService.getLastLogin();
    }

}
