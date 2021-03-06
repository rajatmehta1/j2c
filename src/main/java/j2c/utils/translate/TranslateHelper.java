package j2c.utils.translate;


import j2c.pojos.Answer;
import j2c.pojos.Question;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;


public class TranslateHelper {

    private static HashMap<String, String> urlMap = new HashMap<>();
    private static ArrayList<String> urlList = new ArrayList<>();
    private String lang = "en";

    public static Question translate(String sourceLang, String destLang, Question q) throws Exception {

        Question newQuestion = new Question();
        System.setProperty("webdriver.chrome.driver","C:\\mystuff\\j2c_infra\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        for (String surl: urlList) {
            String baseUrl = urlMap.get(surl);
            String actualTitle = "";

            driver.get(baseUrl);
            WebElement src = driver.findElement(By.id("source"));

                    src.sendKeys(q.getQsTxt());
                    Thread.sleep(2000);

                WebElement tgt = driver.findElement(By.className("result-shield-container"));
            Thread.sleep(2000);

            System.out.println("----------> " +  tgt.getText() + " \n");

            newQuestion.setQsTxt(tgt.getText());

            //Answers
            for (Answer a: q.getAnsList()) {
                src.sendKeys(a.getAnsTxt());Thread.sleep(2000);
                System.out.println("Answer ==> " + tgt.getText());
                Answer newAns = new Answer();
                    newAns.setAnsTxt(tgt.getText());
                    newQuestion.getAnsList().add(newAns);
            }

        }

        //close Fire fox
        driver.close();
        return newQuestion;
    }

//    public static void toHindi(String s) throws Exception{
//
//        System.setProperty("webdriver.chrome.driver","C:\\mystuff\\j2c_infra\\chrome\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//        String baseUrl = "https://translate.google.com/#view=home&op=translate&sl=auto&tl=hi&text=Septic shock is a serious medical condition which results when our body tries to respond against bacterial, viral or fungal infections but fails. The presentation is always severe i.e unstable vitals (severely low blood pressure, tachy/bradycardia) and the patients are typically treated in ICU (intensive care unit).\n" +
//                "\n" +
//                "Exact pathophysiology is unknown, but what happens is, there is vasodilation of arteries in our bodies which decrease the blood pressure (BP) in our body; due to this low BP enough blood (low blood flow) doesn’t reach at the periphery and end-organs. Low blood flow leads to hypoxia (decrease oxygen delivery to tissues) and eventually organ death.\n" +
//                "\n" +
//                "For the treatment, we give loads of fluids and try to figure out the cause and TREAT the cause.";
//        String expectedTitle = "Welcome: Mercury Tours";
//        String actualTitle = "";
//
//        // launch Fire fox and direct it to the Base URL
//        driver.get(baseUrl);
//
//
//
//
////
////        aOn.
//
////        WebElement trnsBtn = driver.findElement(By.id("gt-submit"));
////            trnsBtn.click();
//
////        WebElement tgt = driver.findElement(By.id("result_box"));
//        Thread.sleep(20000);
//        // get the actual value of the title
//        //actualTitle = tgt.getTagName() + " , " + tgt.getText() + "," + tgt.toString();
//
//
//        System.out.println("--> completed");
//
//
//        //close Fire fox
//        driver.close();
//    }


    public static void toHindi(String s) throws Exception{

        System.setProperty("webdriver.chrome.driver","C:\\mystuff\\j2c_infra\\chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String baseUrl = "https://translate.google.com/#auto/hi";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);


        WebElement aOn = driver.findElement(By.id("gt-otf-switch"));
            aOn.click();
            aOn.click();

        WebElement src = driver.findElement(By.id("source"));
        src.sendKeys("life is beautiful");

//        WebElement trnsBtn = driver.findElement(By.id("gt-submit"));
//            trnsBtn.click();

        WebElement tgt = driver.findElement(By.id("result_box"));
        Thread.sleep(10000);
        // get the actual value of the title
        actualTitle = tgt.getTagName() + " , " + tgt.getText() + "," + tgt.toString();


        System.out.println("--> " +  tgt.getText());


        //close Fire fox
        driver.close();

    }



}
