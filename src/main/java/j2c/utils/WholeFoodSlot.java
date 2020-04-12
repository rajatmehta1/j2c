package j2c.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;


public class WholeFoodSlot {


    public static void main(String[] args) throws Exception {
        //generate in all languages
      //  toHindi("i love to read");

        findWholeFoodSlot();
    }

    public static void findWholeFoodSlot() throws Exception {

        System.setProperty("webdriver.chrome.driver","C:\\mystuff\\j2c_infra\\chrome\\72\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
            options.addArguments("user-data-dir=C:/Users/hmeht/AppData/Local/Google/Chrome/User Data/Default");
        WebDriver driver = new ChromeDriver(options);



            driver.get("https://www.amazon.com/gp/buy/shipoptionselect/handlers/display.html?hasWorkingJavascript=1");


    }


}
