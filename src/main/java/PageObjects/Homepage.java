package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Homepage {
	
	final static String HEADER_TEXT	= ".container-fluid div:nth-of-type(1) h1";
	final static String INFO_LINK = ".container-fluid div:nth-of-type(2) .btn-default";
	final static String NUMBER_LINK = ".container-fluid div:nth-of-type(2) .btn-primary";
	final static String INSTRUCTIONS_HEADLINE = ".info h2";
	final static String DIALOG_WINDOW = ".modal-dialog";
	final static String INSTRUCTIONS = ".info ul";
	final static String BACK_TO_MAIN = ".info .up-current";
	final static String GENERATOR_HEADING = ".row h1";
	
	
	
	protected static String getHeaderText(WebDriver driver)
	{
		String headerText= driver.findElement(By.cssSelector(HEADER_TEXT)).getText();
		return headerText;
	}

	protected static WebElement getInfoLink(WebDriver driver)
	{
		WebElement info= driver.findElement(By.cssSelector(INFO_LINK));
		return info;
	}
	protected static WebElement getNumberLink(WebDriver driver)
	{
		WebElement numberLink= driver.findElement(By.cssSelector(NUMBER_LINK));
		return numberLink;
	}
	protected static WebElement getDialogWindow(WebDriver driver)
	{
		WebElement element;
		element= driver.findElement(By.cssSelector(DIALOG_WINDOW));	
		return element;
	}
	protected static WebElement getInstructionsHeadline(WebDriver driver)
	{
		WebElement headline = driver.findElement(By.cssSelector(INSTRUCTIONS_HEADLINE));
		return headline;
	}
	protected static List<WebElement> getListOfSteps(WebDriver driver)
	{
		List<WebElement> element = driver.findElements(By.cssSelector(INSTRUCTIONS));
		return element;
		
	}
	public static WebElement getBackToMain(WebDriver driver)
	{
		WebElement element = driver.findElement(By.cssSelector(BACK_TO_MAIN));
		return element;
		
	}
	
	
	
}
