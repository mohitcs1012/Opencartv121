package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

//	Defining constructor
	public HomePage(WebDriver driver) {
		
		super(driver);
	}
	
//	Defining Locators
	
@FindBy(xpath="//span[normalize-space()='My Account']") 
WebElement lnkAccount;
@FindBy(xpath="//a[normalize-space()='Register']") 
WebElement lnkRegister;
@FindBy(xpath="//a[normalize-space()='Login']") 
WebElement lnkLogin;

//Action
public void clickAccount()
{
	lnkAccount.click();
}

public void clickRegister()
{
	lnkRegister.click();
}

public void clickLogin()
{
	lnkLogin.click();
}

}
