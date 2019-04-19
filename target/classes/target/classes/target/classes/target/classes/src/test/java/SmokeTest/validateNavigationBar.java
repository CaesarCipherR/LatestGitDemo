package SmokeTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.Base;

public class validateNavigationBar extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to the home page");
	}
	
	@Test
	public void validateAppNavigationBar() throws IOException {
	
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		log.info("Successfully validated Navigation Bar");

		
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
}
