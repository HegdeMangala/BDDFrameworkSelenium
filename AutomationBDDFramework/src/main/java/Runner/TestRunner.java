package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\LOOKMYPC\\eclipse-workspace\\AutomationPracticeBDDFramework\\src\\main\\java\\Features" ,//the path of the feature files
		glue= {"StepDefinations"} //the path of the step definition files
		)

public class TestRunner {
	
			
}
