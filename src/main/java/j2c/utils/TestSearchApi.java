package j2c.utils;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

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

    }

    public static void searchDocument() throws Exception {

    }
}
