package Main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String Home() {
        return "<h1>Welcome!!!</h1>";
    }

    @GetMapping("/user")
    public String user() {
        return "<h1>Welcome user!!</h1>";
    }

    @GetMapping("/secured")
    public String secured() {
        return "<h1>Congratulations, You pass the test!!!!</h1>";
    }
}
