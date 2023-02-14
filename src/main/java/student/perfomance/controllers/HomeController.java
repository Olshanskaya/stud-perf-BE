package student.perfomance.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @GetMapping("/home")
    public String hello() {
        return "this is a home page";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard content";
    }

}
