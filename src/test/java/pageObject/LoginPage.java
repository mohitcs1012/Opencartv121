package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
//	Defining constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
//	Defining the locators
	

@FindBy(xpath="//input[@id='input-email']") 
WebElement txtemail;
@FindBy(xpath="//input[@id='input-password']") 
WebElement txtpassword;
@FindBy(xpath="//input[@value='Login']") 
WebElement btnLogin;

//Actions

public void SetEmail(String email)
{
	txtemail.sendKeys(email);
}

public void SetPassword(String Password)
{
	txtpassword.sendKeys(Password);
}

public void ClickLogin()
{
	btnLogin.click();
}
	

}
