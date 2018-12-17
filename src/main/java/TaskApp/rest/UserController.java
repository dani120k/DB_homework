package TaskApp.rest;

import TaskApp.ApplicationConfig;
import TaskApp.model.User;
import TaskApp.service.TaskService;
import TaskApp.service.UserService;
import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {
    static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    static UserService userService = applicationContext.getBean(UserService.class);

    @RequestMapping(value="/getAllUser", method = RequestMethod.GET)
    public String getAllUsers(){
        return new Gson().toJson(userService.getAllUsers());
    }

    @RequestMapping(value = "/getStatsUser", method = RequestMethod.GET)
    public String getStats(){
        return new Gson().toJson(userService.getStatsOfUser());
    }

    @RequestMapping(value = "/getLastLogin", method = RequestMethod.GET)
    public String getLastLogin(){
        List<User> users = userService.getLastLogin();
        for(User curr : users)
            System.out.println(curr.toString());
        return new Gson().toJson(users);
    }
}
