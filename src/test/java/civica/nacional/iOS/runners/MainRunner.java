package civica.nacional.iOS.runners;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import civica.nacional.iOS.utilidades.BeforeSuite;
import civica.nacional.iOS.utilidades.DataToFeature;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@RunWith(RunnerPersonalizado.class) 
@CucumberOptions(
features = "src/test/resources/features" 
,glue = "civica.nacional.iOS.definitions"
,tags = "@CP0001M"
,monochrome = true
,snippets = SnippetType.CAMELCASE)
public class MainRunner {
	@BeforeSuite
	public static void test() throws InvalidFormatException, IOException {
		DataToFeature.overrideFeatureFiles("./src/test/resources/features", "./src/test/resources/data/TestData.xlsx");	
	}
}	