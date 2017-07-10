package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {
	
	
	final static String RANDOM_NUMBER	= ".result";
	final static String ANOTHER_NUMBER =	".container-fluid div:nth-of-type(2) .btn-primary";
	final static String BACK_MAIN =	".container-fluid div:nth-of-type(2) .btn-default";
	
	public static int getRandomNumber(WebDriver driver)
	{
		String numberText= driver.findElement(By.cssSelector(RANDOM_NUMBER)).getText();
	    String output = numberText.replaceAll("[^0-9]", "");
	    int number = Integer.parseInt(output);
	    return number;
	}
	public static WebElement getAnotherNumber(WebDriver driver)
	{
		WebElement anotherNumber= driver.findElement(By.cssSelector(ANOTHER_NUMBER));
		return anotherNumber;
	}
	public static WebElement getBackMain(WebDriver driver)
	{
		WebElement backMain= driver.findElement(By.cssSelector(BACK_MAIN));
		return backMain;
	}

}
