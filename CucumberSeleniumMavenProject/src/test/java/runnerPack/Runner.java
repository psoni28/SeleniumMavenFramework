package runnerPack;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import configPack.ConfigFileReader;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
features = "src\\main\\resources\\features",
glue = "stepsDefinationPack", 
dryRun = false, monochrome = true, tags = "@endtoend2")
public class Runner {

	
	@AfterClass
	public static void writeExtentReport() {
		String path=ConfigFileReader.getReportConfigPath();
		Reporter.loadXMLConfig(new File(path));
	}
}
