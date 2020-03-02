package de.dimk;


import de.dimk.repository.AccountRepository;
import de.dimk.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

@Controller
public class WelcomeController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository acctRep;

    @Value("${welcome.message:test}")
    private String message = "Hello world";

    @RequestMapping("/")
    public String welcome (Locale locale, Map model){
        model.put("message",this.message);
        System.out.println("Home Page Requested, locale = "+ locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);

        model.put("servertime", formattedDate);

        return "home";
    }



}
