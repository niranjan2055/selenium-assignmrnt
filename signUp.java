package com.company;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class signUp {
    public static WebDriver driver;
    public static void main(String[] args) {
        String webpage = "http://automationpractice.com/index.php";
        String newEmail = "tester061@gmail.com";
        String firstName = "Niranjan";
        String lastName = "Yadav";
        String password = "12345";
        String companyName = "TestVagrant";
        String address = "Indiranagar, Bangalore, 56008";
        String phoneNum = "1234567889";
        String cityName = "Bangalore";
        String postalCode = "56098";



        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get(webpage);
        driver.manage().window().maximize();

        //Locating element using it's Class Name.
        driver.findElement(By.className("login")).click();

        //Locating element using it's Id.
        driver.findElement(By.id("email_create")).sendKeys(newEmail);

        driver.findElement(By.id("SubmitCreate")).click();



        WebElement radiobtn = driver.findElement(By.id("id_gender1"));
        radiobtn.click();

        WebElement fristNameField = driver.findElement(By.id("customer_firstname"));
        fristNameField.sendKeys(firstName);

        WebElement lastNameField = driver.findElement(By.id("customer_lastname"));
        lastNameField.sendKeys(lastName);

        driver.findElement(By.id("passwd")).sendKeys(password);

        //Locating element using it's Name
        Select days = new Select(driver.findElement(By.name("days")));
        days.selectByIndex(8);

        Select month = new Select(driver.findElement(By.name("months")));
        month.selectByIndex(6);
        //month.selectByVisibleText("June "); //slower execution

        Select yr = new Select(driver.findElement(By.name("years")));
        yr.selectByValue("2000");


        WebElement newsletter = driver.findElement(By.id("newsletter"));
        newsletter.click();


        WebElement optin = driver.findElement(By.name("optin"));
        optin.click();

        driver.findElement(By.id("company")).sendKeys(companyName);

        driver.findElement(By.name("address1")).sendKeys(address);


        driver.findElement(By.id("city")).sendKeys(cityName);

        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByVisibleText("Texas");

        driver.findElement(By.id("postcode")).sendKeys(postalCode);

        Select country = new Select(driver.findElement(By.name("id_country")));
        country.selectByIndex(1);

        driver.findElement(By.id("phone_mobile")).sendKeys(phoneNum);

        WebElement alias = driver.findElement(By.id("alias"));
        alias.clear();
        alias.sendKeys("same as address");

        driver.findElement(By.id("submitAccount")).click();
        driver.quit();

        System.out.println("SignUp Completed Sucessfully with "+newEmail+" email ID");




    }
}
