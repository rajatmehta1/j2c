package j2c.utils.lang;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;

public class LangConverter {
    private String sourceLang;
    private ArrayList<String> destLangs;
    private static final String CHROME_WEB_DRIVER = "C:\\mystuff\\j2c_infra\\chrome\\chromedriver.exe";
    private static HashMap<String, String> urlMap = new HashMap<>();
    private static ArrayList<String> defaultConvLangList = new ArrayList<>();

    public LangConverter() {
        System.setProperty("webdriver.chrome.driver",CHROME_WEB_DRIVER);
    }

    public LangConverter(String sourceLang, ArrayList<String> tgts) {
        this();
        this.sourceLang = sourceLang;
        this.destLangs = tgts;
    }


    static {
        urlMap.put("en","https://translate.google.com/#auto/en");
        urlMap.put("hi","https://translate.google.com/#auto/hi");
        urlMap.put("bn","https://translate.google.com/#auto/bn"); //bengali
        urlMap.put("gu","https://translate.google.com/#auto/gu"); //gujarati
        urlMap.put("ml","https://translate.google.com/#auto/ml"); //malayam
        urlMap.put("mr","https://translate.google.com/#auto/mr"); //marathi
        urlMap.put("pa","https://translate.google.com/#auto/pa"); //punjabi
        urlMap.put("ta","https://translate.google.com/#auto/ta"); //tamil
        urlMap.put("te","https://translate.google.com/#auto/te"); //tamil

        defaultConvLangList.add("en");defaultConvLangList.add("hi"); defaultConvLangList.add("bn"); defaultConvLangList.add("gu"); defaultConvLangList.add("ml");
        defaultConvLangList.add("mr"); defaultConvLangList.add("pa"); defaultConvLangList.add("ta"); defaultConvLangList.add("te");
    }



    //Convert text from one language to another
    public String convertText(String sourceLang, String destLang, String text) throws Exception {
        ArrayList<String> lngList = new ArrayList<>();
                lngList.add(destLang);
        HashMap<String, String> results =
                this.translate(text, lngList);
        return results.get(destLang);
    }



    public HashMap<String, String> translate(String sourceText, ArrayList<String> toTransLangList) throws Exception {
        HashMap<String, String> results = new HashMap<>();
        WebDriver driver = new ChromeDriver();

        for (String transLang: toTransLangList) {
            String baseUrl = urlMap.get(transLang);
            String actualTitle = "";

            driver.get(baseUrl);
            WebElement src = driver.findElement(By.id("source"));
                src.sendKeys(sourceText);
                Thread.sleep(2000);

            WebElement tgt = driver.findElement(By.className("result-shield-container"));
            Thread.sleep(2000);

            System.out.println("----------> " +  tgt.getText() + " \n");
            results.put(transLang, tgt.getText());
        }

        driver.close();
        return results;
    }


    public static void main(String[] args) throws Exception {
        LangConverter lc = new LangConverter();
          String result = lc.convertText("en","hi","this is a test message");
          System.out.println("result : " + result);
    }


}
