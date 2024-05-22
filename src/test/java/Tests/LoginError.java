package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;

public class LoginError extends BaseTest{
	
	@Test(dataProvider="getData")
	
	public void loginError(HashMap<String,String> input) throws InterruptedException
	{
				landingpage.loginApplication(input.get("email"), input.get("password"));
				Assert.assertEquals("There an error in the email or password", landingpage.errorPopup());
	}

	
	@DataProvider
	public Object[][] getData() throws IOException
	{		
		List<HashMap<String, String>> data = getJsonDataToMap
				(System.getProperty
						("user.dir")+"\\src\\test\\java\\Data\\LoginCredentials.json");
		return new Object[][] {{data.get(1)}};
	}
}
