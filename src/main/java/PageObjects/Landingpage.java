package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FMC.Nx2me.AbstractComponents.AbstractComponent;
import FMC.Nx2me.PageObjects.LoginPagePopup;

public class Landingpage extends AbstractComponent{
	
	WebDriver driver;

	public Landingpage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement emailfield;
	
	@FindBy(id="userpass")
	WebElement passwordfield;
	
	@FindBy(id="submitBtn")
	WebElement submit;
	
	@FindBy(xpath="//strong")
	WebElement errorPop;
	
	public void goTo()
	{
		driver.get("https://charybui-t.tms.fmcgds-np.com/test_n2me");
	}
	
	public LoginPagePopup loginApplication(String email, String password)
	{
		emailfield.sendKeys(email);
		passwordfield.sendKeys(password);
		submit.click();
		LoginPagePopup loginPagePopup = new LoginPagePopup(driver);
		return loginPagePopup;
	}
	
	public String errorPopup() throws InterruptedException
	{
		sleep1();
		return errorPop.getText();
	}


}
