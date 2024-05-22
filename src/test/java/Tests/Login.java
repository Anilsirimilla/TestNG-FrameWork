package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestComponents.BaseTest;

public class Login extends BaseTest{
	
	@Test(dataProvider="getData")
	
	public void login(HashMap<String,String> input)
	{
				landingpage.loginApplication(input.get("email"), input.get("password"));
	}

	
	@DataProvider
	public Object[][] getData() throws IOException
	{		
		List<HashMap<String, String>> data = getJsonDataToMap
				(System.getProperty
						("user.dir")+"\\src\\test\\java\\Data\\LoginCredentials.json");
		return new Object[][] {{data.get(0)}};
	}
}
