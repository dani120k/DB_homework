package TaskApp.rest;

import TaskApp.ApplicationConfig;
import TaskApp.model.PreregisterUser;
import TaskApp.model.User;
import TaskApp.service.UserService;
import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {
    static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    static UserService userService = applicationContext.getBean(UserService.class);

    @CrossOrigin
    @RequestMapping(value="/preregistration", method=RequestMethod.POST)
    public String doPreRegistration(@RequestBody PreregisterUser user){
        return "";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/getAllUsers", method = RequestMethod.GET)
    public String test(){
        List<User> userList = userService.getAllUsers();
        return new Gson().toJson(userList);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value="/auth", method = RequestMethod.POST)
    public String tryToAuth(@RequestBody User user){
        // System.out.println(userString);
        //User user = new Gson().fromJson(userString, User.class);
        System.out.println(user.toString());
        List<User> userList = userService.getAllUsers();
        boolean check = false;
        for(User us:userList){
            if (us.getEmail().equals(user.getEmail()) && us.getId().equals(user.getId()))
                check=true;
        }
        if (check) {
            return new Gson().toJson("auth");
        } else {
            return new Gson().toJson("error");
        }
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
