package TaskApp.rest;

import TaskApp.handlers.AdminHandler;
import TaskApp.model.Domain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    private AdminHandler adminHandler = new AdminHandler();

    @GetMapping("/admin/create_domain")
    public String createDomain(@RequestParam Domain domain){
        return adminHandler.addDomain(domain);
    }
}
