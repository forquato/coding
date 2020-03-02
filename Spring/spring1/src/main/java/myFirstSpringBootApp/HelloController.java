package myFirstSpringBootApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dimas on 12.07.2017.
 */

@RestController                     // ready for use by Spring MVC to handle web requests
                                    // combines @Controller and @ResponseBody, two
                                    // annotations that results in web requests returning data rather than a view.
public class HelloController {

    @RequestMapping("/")            // maps "/" to the index() method
    public String index(){
        return "Greetings from SpringBoot!";
    }

}
