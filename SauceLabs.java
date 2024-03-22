package saucelabs;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.google.common.io.Files;
import jxl.Sheet;
import jxl.Workbook;




public class SauceLabs {
	public WebDriver driver;

	
		@BeforeClass
		public void launcWeb()  {
		System.setProperty("webdriver.FireFox", "C:\\Program Files\\Mozilla Firefox\\Firefox.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
		@Test(priority=1)
		public void launchApp() {
		SauceLabsID p = PageFactory.initElements(driver, SauceLabsID.class);
		p.uid.sendKeys("standard_user");
		p.psd.sendKeys("secret_sauce");
		p.btn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
		@Test(priority=2)
		public void selecItem() {
		SauceLabsID p = PageFactory.initElements(driver, SauceLabsID.class);
		//Verifying the Header of application
		System.out.println(p.header.getText());
		//Selecting product	
		p.img.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@Test(priority=3)
		public void addToCart() {
		SauceLabsID p = PageFactory.initElements(driver, SauceLabsID.class);
		System.out.println(p.productname.getText());
		System.out.println(p.productdetails.getText());
		System.out.println(p.productprice.getText());
		p.atc.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		}
		
		@Test(priority=4)
		public void checkOutProcess() throws IOException, Exception {
			SauceLabsID p = PageFactory.initElements(driver, SauceLabsID.class);
			p.atcc.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			p.chk.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//Using excel to read data
			FileInputStream f1 = new FileInputStream("F:\\AutomationTesting\\Assignments\\ProjectSelenium\\Test1.xls");
			Workbook wb = Workbook.getWorkbook(f1); //Input Stream
			Sheet s = wb.getSheet("Sheet1");
			String firstname1 = s.getCell(0, 1).getContents();
			String lastname1 = s.getCell(1, 1).getContents();
			String pincode1 = s.getCell(2, 1).getContents();
			p.firstname.sendKeys(firstname1);
			p.lastname.sendKeys(lastname1);
			p.postlcode.sendKeys(pincode1);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			p.cnt.click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(f, new File("F:\\AutomationTesting\\Assignments\\ProjectSelenium\\checkout_overview.png"));
			p.finish.click();
		
		}
		
		@Test(priority=5)
		public void complete() throws Exception {
			SauceLabsID p = PageFactory.initElements(driver, SauceLabsID.class);
			System.out.println(p.message.getText());
			File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(f, new File("F:\\AutomationTesting\\Assignments\\ProjectSelenium\\confirm_order.png"));
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		}
		
		@AfterClass
		public void closeApp() {
			driver.quit();
		}
}
