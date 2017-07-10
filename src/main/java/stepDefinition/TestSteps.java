package stepDefinition;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageObjects.Homepage;
import PageObjects.ResultPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestSteps extends Homepage{
	
	WebDriver driver;
	int number;
	
	@Given("^User opens the croove website$")
	public void user_opens_the_croove_website() throws Throwable {
	System.setProperty("webdriver.gecko.driver", "/Users/sakshi.rawal/Downloads/geckodriver");
		driver= new FirefoxDriver();
        driver.get("http://hiring-qa.croove.net");
		driver.manage().window().maximize();
	}

	@Then("^he should see welcome message from croove \"(.*?)\"$")
	public void he_should_see_welcome_message_from_croove(String arg1) throws Throwable {
	    String headerText= Homepage.getHeaderText(driver);
	    Assert.assertEquals(arg1, headerText);
	}

	@Then("^he should see page title \"(.*?)\"$")
	public void he_should_see_page_title(String arg1) throws Throwable {
		String title= driver.getTitle();
		Assert.assertEquals(arg1, title);
		
	}
	
	@Then("^he should see Info link$")
	public void he_should_see_Info_link() throws Throwable {
	    WebElement element= Homepage.getInfoLink(driver);
	    boolean info= element.isDisplayed();
	    Assert.assertTrue( "Info Link is.modal-dialog displayed", info);
	}

	@Then("^he should see a link to number result page$")
	public void he_should_see_a_link_to_number_result_page() throws Throwable {
		WebElement element= Homepage.getNumberLink(driver);
	    boolean numberLink= element.isDisplayed();
	    Assert.assertTrue( "Number Link is displayed", numberLink);
	}

	@When("^he click Info link$")
	public void he_click_Info_link() throws Throwable {
		
		WebElement element= Homepage.getInfoLink(driver);
		element.click();
		Thread.sleep(2000);
	}

	@Then("^he should see a modal dialog wndow$")
	public void he_should_see_a_modal_dialog_wndow() throws Throwable {
		WebElement element = Homepage.getDialogWindow(driver);
	    boolean dialog= element.isDisplayed();
	    Assert.assertTrue("Modal Dialog window is displayed", dialog);
	}

	@Then("^he should see challenge instructions headline \"(.*?)\"$")
	public void he_should_see_challenge_instructions_headline(String arg1) throws Throwable {
		WebElement element = Homepage.getInstructionsHeadline(driver);
		boolean headline= element.isDisplayed();
	    Assert.assertTrue("Modal Dialog window is displayed", headline);
	}
	
	@Then("^he should see list of steps$")
	public void he_should_see_list_of_steps() throws Throwable {
	    List<WebElement> element= Homepage.getListOfSteps(driver);
	    for(WebElement i:element)
	    {
	    	boolean step= i.isDisplayed();
	    	Assert.assertTrue("List of steps is displayed ", step);
	    }
	}

	@Then("^he should see a link back to home page$")
	public void he_should_see_a_link_back_to_home_page() throws Throwable {
	    WebElement element= Homepage.getBackToMain(driver);
	    boolean backMain=element.isDisplayed();
	    Assert.assertTrue(backMain);
	}

	@When("^he click Back to Main link$")
	public void he_click_Back_to_Main_link() throws Throwable {
		 WebElement element= Homepage.getBackToMain(driver);
		 element.click();
	}

	@Then("^he should see HomePage \"(.*?)\"$")
	public void he_should_see_HomePage(String arg1) throws Throwable {
		String headerText= Homepage.getHeaderText(driver);
	    Assert.assertEquals(arg1, headerText);
	   
	}
	
	@When("^he clicks on see a number link$")
	public void he_clicks_on_see_a_number_link() throws Throwable {
		
	    WebElement element=Homepage.getNumberLink(driver);
	    element.click();
	    Thread.sleep(2000);
	   /* WebDriverWait wait = new WebDriverWait(driver, 10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".result")));*/
	}

	@Then("^he should be redirected to the number result page$")
	public void he_should_be_redirected_to_the_number_result_page() throws Throwable {
		String resultUrl = driver.getCurrentUrl();
		Assert.assertEquals(resultUrl, "http://hiring-qa.croove.net/result");

	}

	@Then("^he should see a random number between (\\d+) to (\\d+)$")
	public void he_should_see_a_random_number_between_to(int arg1, int arg2) throws Throwable {
		
		int number= ResultPage.getRandomNumber(driver);
	    boolean result =false;
	    if( number > arg1 && number <arg2)
	    {
	    	result= true;
	    }
	    Assert.assertTrue(result);
	}
	
	@Given("^User is on Result Page$")
	public void user_is_on_Result_Page() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "/Users/sakshi.rawal/Downloads/geckodriver");
		driver= new FirefoxDriver();
        driver.get("http://hiring-qa.croove.net/result");   
	}

	@When("^he clicks on another number link$")
	public void he_clicks_on_another_number_link() throws Throwable {
	    WebElement element= ResultPage.getAnotherNumber(driver);
	    element.click();
	}
	@Then("^he should see another number$")
	public void he_should_see_another_number() throws Throwable {
		int number= ResultPage.getRandomNumber(driver);
		he_clicks_on_another_number_link();
		Thread.sleep(2000);
		int anotherNumber= ResultPage.getRandomNumber(driver);
		boolean anotherNum =false;
		if(number !=anotherNumber)
		{
			anotherNum =true;
		}
		Assert.assertTrue(anotherNum);
		
	}	
	@When("^he clicks back to main link$")
	public void he_clicks_back_to_main_link() throws Throwable {
	   WebElement element= ResultPage.getBackMain(driver);
	   element.click();
	   Thread.sleep(1000);
	}
	@Then("^the driver is closed$")
	public void the_driver_is_closed() throws Throwable {
	    driver.quit();
	}

}
