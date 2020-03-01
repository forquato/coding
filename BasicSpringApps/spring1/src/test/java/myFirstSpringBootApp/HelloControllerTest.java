package myFirstSpringBootApp;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by dimas on 12.07.2017.
 */

// create an integration test

// Spring Boot automatically tries to locate the main application class of your
// application in either case, but you can override it, or narrow it down, if you want to build
// something different.


@RunWith(SpringRunner.class)
@SpringBootTest         // create whole ApplicationContext
@AutoConfigureMockMvc   // Note the use of the @AutoConfigureMockMvc together with @SpringBootTest to inject a MockMvc instance.
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;  // comes from Spring Test and allows to send HTTP Requests and make Assertions

    @Test
    public void getHello() throws Exception
    {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from SpringBoot!")));
    }

}
