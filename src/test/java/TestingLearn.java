import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestingLearn extends BaseClassLearn {
	@Test (dataProvider="data")
	private void tc1(String username, String password, String firstname, String lastname, String address, String ccnum, String cvvnum) {
		browserLaunch("https://adactinhotelapp.com/");
		elementLocator("id", "username").sendKeys(username);
		elementLocator("id", "password").sendKeys(password);
		elementLocator("id", "login").click();
		WebElement txtLocation = elementLocator("id", "location");
		select(txtLocation, 1);
		WebElement txtHotels = elementLocator("id", "hotels");
		select(txtHotels, 2);
		WebElement txtRoom = elementLocator("id", "room_type");
		select(txtRoom, 3);
		WebElement txtNos = elementLocator("id", "room_nos");
		select(txtNos, 3);
		elementLocator("id", "Submit").click();
		elementLocator("id", "radiobutton_0").click();
		elementLocator("id", "continue").click();
		elementLocator("id", "first_name").sendKeys(firstname);
		elementLocator("id", "last_name").sendKeys(lastname);
		elementLocator("id", "address").sendKeys(address);
		elementLocator("id", "cc_num").sendKeys(ccnum);
		WebElement txtCcType = elementLocator("id", "cc_type");
		select(txtCcType, 2);
		WebElement txtExpMonth = elementLocator("id", "cc_exp_month");
		select(txtExpMonth, 2);
		WebElement txtExpYear = elementLocator("id", "cc_exp_year");
		select(txtExpYear, 12);
		elementLocator("id", "cc_cvv").sendKeys(cvvnum);
		elementLocator("id", "book_now").click();	
	}
	@DataProvider(name = "data" )
	private Object [][] dataProviding() throws IOException{
		return new Object [][] {
			{excelRead("Sheet1", 0, 0),excelRead("Sheet1",0,1),excelRead("Sheet1", 3, 0),
			excelRead("Sheet1", 3,1 ),excelRead("Sheet1", 6, 0),excelRead("Sheet1", 7, 0),excelRead("Sheet1", 8, 0)},
			{excelRead("Sheet1", 1, 0),excelRead("Sheet1", 1, 1),excelRead("Sheet1", 4, 0),
			excelRead("Sheet1", 4, 1),excelRead("Sheet1", 6, 1),excelRead("Sheet1", 7, 1),excelRead("Sheet1", 8, 1)},
			{excelRead("Sheet1", 2, 0),excelRead("Sheet1", 2, 1),excelRead("Sheet1", 5, 0),excelRead("Sheet1", 5, 1),
			excelRead("Sheet1", 6, 2),excelRead("Sheet1", 7, 2),excelRead("Sheet1", 8, 2)}
				
			};
			
	}
}






			
			
			
		
		
		
		
		
	
	
	


