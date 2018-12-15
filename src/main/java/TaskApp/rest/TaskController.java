package TaskApp.rest;

import TaskApp.ApplicationConfig;
import TaskApp.service.TaskService;
import com.google.gson.Gson;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/tasks")
public class TaskController {
    static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    static TaskService taskService = applicationContext.getBean(TaskService.class);


    @RequestMapping(value="/getAllTask", method = RequestMethod.GET)
    public String getAllTasks(){
        return new Gson().toJson(taskService.getAllTasks());
    }
}
