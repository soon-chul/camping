package camping.common;


import camping.RentalvendorApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { RentalvendorApplication.class })
public class CucumberSpingConfiguration {
    
}
