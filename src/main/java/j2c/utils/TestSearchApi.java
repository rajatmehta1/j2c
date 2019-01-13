package j2c.utils;

import com.google.gson.Gson;
import j2c.pojos.Question;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Map;

public class TestSearchApi {

    public static void main(String[] args) throws Exception {
        searchDocument();
    }

    public static void searchResponse() throws Exception {
        TransportClient client =
                new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));
        SearchResponse response = client.prepareSearch().get();
        System.out.println(response.toString());
    }

    public static void getQuestionBySrch() throws Exception {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY).
                addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"),9300));

        GetResponse getResponse =
                client.prepareGet("j2c", "question","1").execute().actionGet();

        Map<String, Object> source = getResponse.getSource();

        System.out.println("------------------------------");
        System.out.println("Index: " + getResponse.getIndex());
        System.out.println("Type: " + getResponse.getType());
        System.out.println("Id: " + getResponse.getId());
        System.out.println("Version: " + getResponse.getVersion());
        System.out.println(source);
        System.out.println("------------------------------");

    }

    public static void searchDocument() throws Exception {
        TransportClient client =
                new PreBuiltTransportClient(Settings.EMPTY)
                        .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));

        ArrayList<String> terms = new ArrayList<>();
            terms.add("liver");
            terms.add("hospital");

        QueryBuilder qbr =
                QueryBuilders.termsQuery("qsTxt", terms);

        SearchResponse response =
                client.prepareSearch().setQuery(qbr).execute().actionGet();

        SearchHit[] results = response.getHits().getHits();

        System.out.println("Current results : " + results.length);

        for(SearchHit hit : results) {
            System.out.println(" ---------------------------------------------- ");
            System.out.println(hit.getSourceAsString());
            System.out.println(" ---------------------------------------------- ");

            Gson gson = new Gson();
            Question q = gson.fromJson(hit.getSourceAsString(), Question.class);

            System.out.println("\n\n\n\n -------------------------------");

            System.out.println("qid -------------------------> " + q.getId());

            System.out.println(" Question txt ----------------------------> " + q.getQsTxt());
        }
    }
}
