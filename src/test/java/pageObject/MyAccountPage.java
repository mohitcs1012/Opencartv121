package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
//Defining constructor
	public  MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") 
	WebElement labelAccount;
	

	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") 
	WebElement btnLogout;
	
	public boolean IsMyAccountPageExists()
	{
		try {
			return(labelAccount.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void ClickLogout()
	{
		btnLogout.click();
	}

}
