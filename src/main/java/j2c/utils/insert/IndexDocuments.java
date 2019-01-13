package j2c.utils.insert;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;

public class IndexDocuments {

    public void indexDoc(String jsonObject) throws Exception {
        TransportClient client =
                new PreBuiltTransportClient(Settings.EMPTY)
                        .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));

        IndexResponse response = client.prepareIndex("j2c","question").setSource(jsonObject, XContentType.JSON).get();

        String id = response.getId();
        String index = response.getIndex();
        String type = response.getType();
        long version = response.getVersion();

        System.out.println("----------------------> " + response.getResult());
        System.out.println("version ---> " + version);
        System.out.println("people : " + index);
        System.out.println("Doe : " + type);
    }

}
