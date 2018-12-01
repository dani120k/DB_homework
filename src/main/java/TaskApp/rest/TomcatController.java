package TaskApp.rest;

import TaskApp.model.Domain;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class TomcatController {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/")
    public String sayHello() {
        return "hello";
    }
}