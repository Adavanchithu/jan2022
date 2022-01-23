import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassLearn {
	
	public static WebDriver driver;
	

	public static void browserLaunch(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}
	
//	public WebElement elementLocator(String locatorType, String value) {
//		
//		if (locatorType.equals("id")) {
//			WebElement findElement = driver.findElement(By.id(value));
//			return findElement;
//		}
//		
//		else if(locatorType.equals("name")) {
//			WebElement findElement = driver.findElement(By.name(value));
//			return findElement;
//			
//		}
//		
//		else {
//			WebElement findElement = driver.findElement(By.xpath(value));
//			return findElement;
//		}
		
	
//	}
	public void mouseOverActions(WebElement element) {
		Actions a = new Actions (driver);
		a.moveToElement(element).perform();

	}
	public void select(WebElement element, int value) {
		Select s = new Select(element);
		s.selectByIndex(value);

		
	}
	
	public void enterText(WebElement element, String text) {
		element.sendKeys(text);
			
	}
	public void click(WebElement element) {
		element.click();

	}
	public String gettingTitle() {

		String title = driver.getTitle();
		return title;
	}
	
	

	public void navigate(String value) {

		driver.navigate().to(value);
	}
	
	public void scroll(String value) {

		JavascriptExecutor j =(JavascriptExecutor)driver; 
		j.executeScript(value);
	}
	
	
	
	public String excelRead(String sheetName, int rowNo, int cellnum) throws IOException {
		
		File f = new File("F:\\databaseforadactin.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellnum);
		int cellType = cell.getCellType();
		if (cellType==1) {
			String stringCellValue = cell.getStringCellValue();
			return stringCellValue;
		}
		
		else if(DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat("MM/dd/yyyy");
			String format = s.format(dateCellValue);
			return format;
			
		}
		
		else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long)numericCellValue;
			//to convert long into String
			
			String valueOf = String.valueOf(l);
			return valueOf;
			
		}
		
	}
	

	public void excelWrite(String path, String sheetName, int rownum, int column, String value) throws IOException {
		File f = new File(path);
		Workbook w = new XSSFWorkbook();
		Sheet createSheet = w.createSheet(sheetName);
		Row createRow = createSheet.createRow(rownum);
		Cell createCell = createRow.createCell(column);
		createCell.setCellValue(value);
		FileOutputStream stream = new FileOutputStream(f);
		w.write(stream);
		
}
}
