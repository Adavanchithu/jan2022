import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class FacebookLocators extends BaseClassLearn {
	
	public FacebookLocators() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBys({ @FindBy(id="email"),@FindBy(xpath="//input[@id='email']") })
	private WebElement username;
	
	@FindAll({ @FindBy(id="12345"),@FindBy(xpath="//input[@id='pass']") })
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement login;


	public WebElement getUsername() {
		return username;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getLogin() {
		return login;
	}
	
	
	
	
	

		
	}


