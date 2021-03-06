package j2c.utils.extract;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DiseaseExtractor {

    public static final String BASE_URL = "https://www.onlymyhealth.com/health-diseases_";

    public static final String[] namesList = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    public static void main(String[] args) throws Exception {
        int i = 9;
        for(String path: namesList) {
//            System.out.println(BASE_URL + path.toUpperCase() + ".html");

            Document doc = Jsoup.connect(BASE_URL + path.toUpperCase() + ".html" ).get();
            Elements qlist = doc.select("ul.listAlphatext li");
            for(Element questionElem: qlist) {
//                System.out.println(questionElem.text());
                System.out.println(generateTopicInsert(i++,questionElem.text()));
            }

        }
    }


    public static String generateTopicInsert(int i , String diseaseName) {
        String insrt =
                "insert into topics(topic_id,topic_name,topic_lang) value(" + i + ",\'" + diseaseName + "\',\'en\');";
        return insrt;
    }
}
