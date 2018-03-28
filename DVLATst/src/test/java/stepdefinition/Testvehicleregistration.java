package stepdefinition;


	import java.io.File;
	import java.io.File.*;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;

	import cucumber.api.java.en.Given;
	import cucumber.api.java.en.Then;
	import cucumber.api.java.en.When;
	import junit.framework.Assert;

	public class Testvehicleregistration {
		
		WebDriver driver;
		
		@Given("^Open FireFox and open the DVLA get vehicle information page$")
		public void open_FireFox_and_open_the_DVLA_get_vehicle_information_page() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			System.setProperty("webdriver.gecko.driver","C:\\Users\\GIRISH\\Downloads\\geckodriver-v0.17.0-win32\\geckodriver.exe");
			//System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\firefox.exe");
			driver=new FirefoxDriver();
			driver.get("https://www.gov.uk/get-vehicle-information-from-dvla ");
		    
		}

		@When("^I enter valid vehicle registration number$")
		public void i_enter_valid_vehicle_registration_number() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			
			driver.findElement(By.xpath("/html/body/div[5]/div[2]/main/div/div[1]/div/section[1]/p/a")).click();
			driver.findElement(By.id("Vrm")).sendKeys("DV53YRA");
			driver.findElement(By.xpath("/html/body/main/form/div/div/div[2]/fieldset/button")).click();
			
		   
		}

		
		@Then("^user should be able to vehicle details$")
		public void user_should_be_able_to_vehicle_details() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			WebElement regnumber= driver.findElement(By.id("Vrm"));
			System.out.println("Vehicle registration number is "+""+regnumber.getText());
		}

		@Then("^user should be able to validate the color of the vehicle$")
		public void user_should_be_able_to_validate_the_color_of_the_vehicle() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			 Sheet s;
			   
			    File fi = new File("C:\\Mydata\\MyData1.xls");
			    Workbook W = Workbook.getWorkbook(fi);

			    s = W.getSheet(0);

			    for(int row = 0;row < s.getRows();row++){

			    String vehnumber = s.getCell(0,row).getContents();
			    System.out.println("vehnumber" +" "+vehnumber);
			    String vehcolor= s.getCell(1, row).getContents();
			    System.out.println("vehcolor" +" "+vehcolor);
			    WebElement vcolor=driver.findElement(By.xpath("/html/body/main/form/div/div/ul/li[3]/span[2]/strong"));
			    assertEquals(vehcolor, vcolor.getText());
			   
			    
			   
		}
		}

	}

}
