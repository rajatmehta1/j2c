package j2c.utils.search;

import com.google.gson.Gson;
import j2c.pojos.Question;
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

public class SearchDocuments {

    public static ArrayList<Question> searchDocument(String srch) throws Exception {
        ArrayList<Question> result = new ArrayList<>();
        TransportClient client =
                new PreBuiltTransportClient(Settings.EMPTY).addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));

        QueryBuilder qbr = QueryBuilders.termQuery("qsTxt", srch);
        SearchResponse response = client.prepareSearch().setQuery(qbr).execute().actionGet();
        SearchHit[] results = response.getHits().getHits();

        System.out.println("Current results :" + results.length);

        for(SearchHit hit: results) {
            System.out.println("------------------------------------------------");
                System.out.println(hit.getSourceAsString());
            System.out.println("------------------------------------------------");

            Gson gson = new Gson();
            Question q = gson.fromJson(hit.getSourceAsString(), Question.class);
                q.setAnsList(new ArrayList<>());

            System.out.println("\n\n ---------------------------\n\n");
            System.out.println("qid ----------------------> " + q.getId());
            System.out.println("Question txt --------------> " + q.getQsTxt());

                result.add(q);
        }

        return result;
    }


}
