package camping.common;


import camping.CampingHistoryApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CampingHistoryApplication.class })
public class CucumberSpingConfiguration {
    
}
