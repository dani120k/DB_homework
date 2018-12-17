package TaskApp.rest;

import TaskApp.ApplicationConfig;
import TaskApp.model.Task;
import TaskApp.model.User;
import TaskApp.service.CurrUserService;
import TaskApp.service.TaskService;
import TaskApp.service.UserService;
import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {
    static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    static UserService userService = applicationContext.getBean(UserService.class);
    static TaskService taskService = applicationContext.getBean(TaskService.class);
    static CurrUserService currUserService = applicationContext.getBean(CurrUserService.class);

    @RequestMapping(value="/getAllUser", method = RequestMethod.GET)
    public String getAllUsers(){
        return new Gson().toJson(userService.getAllUsers());
    }

    @RequestMapping(value = "/getStatsUser", method = RequestMethod.GET)
    public String getStats(){
        return new Gson().toJson(currUserService.getStatsOfUser());
    }

    @RequestMapping(value = "/getLastLogin", method = RequestMethod.GET)
    public String getLastLogin(){
        List<User> users = userService.getLastLogin();
        for(User curr : users)
        {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date todayWithZeroTime = formatter.parse(formatter.format(curr.getLogin_time()));
                curr.setLogin_time(todayWithZeroTime);
            }catch (Exception ex){ex.printStackTrace();}
        }
        return new Gson().toJson(users);
    }

    @RequestMapping(value = "/getLastMonthTask", method = RequestMethod.GET)
    public String getLastMonthTask(){
        List<Task> tasks = taskService.getLastMonthTask();

        return new Gson().toJson(tasks);
    }
}
