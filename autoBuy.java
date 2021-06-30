package com.company;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class autoBuy {
    public static WebDriver driver;

    public static void main (String [] args){

        String newEmail = "tester061@gmail.com";
        String password = "12345";
        double startPrice = 30;
        double endPrice = 43.1;
        String Url = "http://automationpractice.com/index.php";

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(Url);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.partialLinkText("Sign in")).click();

        driver.findElement(By.id("email")).sendKeys(newEmail);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.cssSelector("i.icon-lock")).click();

        driver.findElement(By.cssSelector("a[title = Women]")).click();

        driver.findElement(By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"categories_block_left\"]/div/ul/li[2]/span")).click();

        driver.findElement(By.id("layered_id_attribute_group_2")).click();

        driver.findElement(By.id("layered_id_feature_5")).click();

        driver.findElement(By.id("layered_id_feature_11")).click();
        driver.findElement(By.id("layered_id_feature_17")).click();
        driver.findElement(By.id("layered_quantity_1")).click();

        //for price range slider
        WebElement leftSlider = driver.findElement(By.xpath("//*[@id=\"layered_price_slider\"]/a[1]"));
        WebElement rightSlider = driver.findElement(By.xpath("//*[@id=\"layered_price_slider\"]/a[2]"));
        WebElement priceText = driver.findElement(By.id("layered_price_range"));
        System.out.println("Price Range before sliding "+priceText.getText());
        double startingRange = Double.parseDouble( priceText.getText().substring(1,6));
        double endingRange = Double.parseDouble(priceText.getText().substring(10,15));

        //moving left slider
        while(startingRange<=startPrice)
        {
            leftSlider.sendKeys(Keys.ARROW_RIGHT);
            startingRange = Double.parseDouble(priceText.getText().substring(1,6));
        }

        //moving right slider
        while (endingRange>=endPrice)
        {
            rightSlider.sendKeys(Keys.ARROW_LEFT);
            endingRange = Double.parseDouble(priceText.getText().substring(10,15));
        }


        System.out.println("Price After sliding "+driver.findElement(By.id("layered_price_range")).getText());

        WebElement product = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[4]/div"));
        WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[4]/div/div[2]/div[2]/a[1]"));

        Actions action = new Actions(driver);
        action.moveToElement(product);
        action.moveToElement(addToCart).click();
        action.build().perform();

        driver.findElement(By.cssSelector("span.cross")).click();
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();

        System.out.println("Total Price including shipping will be "+driver.findElement(By.id("total_price_container")).getText());

        driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
        driver.findElement(By.cssSelector("a.cheque")).click();
        driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();

        driver.quit();
        System.out.println("Ordered Sucessfully");












    }
}
