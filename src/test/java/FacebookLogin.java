import org.openqa.selenium.WebElement;

public class FacebookLogin extends BaseClassLearn{
	
	public static void main(String[] args) {
		
		browserLaunch("https://www.facebook.com/");
		FacebookLocators a = new FacebookLocators();
		WebElement username = a.getUsername();
		username.sendKeys("adavan");
		driver.navigate().refresh();
		String attribute = username.getAttribute("id");
		System.out.println(attribute);
		a.getPassword().sendKeys("12345");
		
		
	}
	
	

}
