package j2c.utils;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.*;
import com.gargoylesoftware.htmlunit.util.Cookie;
import org.w3c.dom.html.HTMLDivElement;

import java.util.Set;


public class TranslateEngToHindi {

    public static void main(String[] args) throws Exception {
toHindi("test77777777");

//        WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
//        webClient.getOptions().setJavaScriptEnabled(true);
//        webClient.getOptions().setThrowExceptionOnScriptError(false);
//
//        final HtmlPage page1 = webClient.getPage("https://translate.google.com/#auto/hi/what%20is%20the%20cost%20of%20apples");
//    page1.asXml();
////        final HtmlForm inputForm = (HtmlForm) page1.getElementById("gt-form");
////        final HtmlTextArea sourceInput = (HtmlTextArea)page1.getElementById("source");
////        System.out.println("---------------------> " + sourceInput.getNameAttribute());
////
////            sourceInput.setText("Which diabetes machine is good and low priced ?");
//
////        final HtmlSubmitInput submitInput = (HtmlSubmitInput)page1.getElementById("gt-submit");
////
////        final HtmlPage page2 = submitInput.click();
////            page2.asXml();
//        HtmlSpan spnTgt = (HtmlSpan) page1.getElementById("result_box");
//        System.out.println("----------------> " + spnTgt.asXml());
        //final HtmlTextInput sourceInput =
    }

    public static String toHindi(String s) throws Exception{
        WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);

        final HtmlPage page1 = webClient.getPage("https://www.bing.com/translator");
        page1.asXml();
        final HtmlTextArea sourceInput = (HtmlTextArea)page1.getElementById("t_sv");

            sourceInput.setText("What is the cost of the oranges ?");

            page1.asXml();

        final HtmlTextArea tgtInput = (HtmlTextArea)page1.getElementById("t_tv");

        page1.asXml();

//        HtmlSpan spnTgt = (HtmlSpan) page1.getElementById("result_box");
        System.out.println("----------------> " + tgtInput.getText());
        //final HtmlTextInput sourceInput =
        return "Testst";
    }

    public static void testMethod1() throws Exception {
        WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED);
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);

        final HtmlPage page1 = webClient.getPage("https://translate.google.com");
        WebResponse response = page1.getWebResponse();
        String content = response.getContentAsString();

        System.out.println("##################################");
        System.out.println(content);
        System.out.println("##################################");
    }

}
