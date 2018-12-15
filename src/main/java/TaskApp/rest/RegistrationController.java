package TaskApp.rest;

import TaskApp.ApplicationConfig;
import TaskApp.handlers.UserHandler;
import TaskApp.model.User;
import TaskApp.service.UserService;
import TaskApp.utils.ErrorWrapper;
import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    static UserService userService = applicationContext.getBean(UserService.class);
    static UserHandler userHandler = new UserHandler();

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/getAllUsers", method = RequestMethod.GET)
    public String test(){
        List<User> userList = userService.getAllUsers();
        return new Gson().toJson(userList);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/auth", method = RequestMethod.POST)
    public String tryToAuth(@RequestBody User user){
        System.out.println(user.toString());
        return new Gson().toJson(userHandler.checkLogin(user));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/register", method =  RequestMethod.POST)
    public String registration(@RequestBody User user){
        try {
            userService.addUser(user);
            return new Gson().toJson("auth");
        }
        catch (Exception ex){
            return new Gson().toJson("error");
        }
    }
}
